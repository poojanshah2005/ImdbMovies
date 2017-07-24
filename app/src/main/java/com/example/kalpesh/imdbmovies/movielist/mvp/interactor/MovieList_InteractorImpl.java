package com.example.kalpesh.imdbmovies.movielist.mvp.interactor;

import com.example.kalpesh.imdbmovies.movielist.model.Constants;
import com.example.kalpesh.imdbmovies.movielist.model.MovieListModel;
import com.example.kalpesh.imdbmovies.movielist.service.RequestInterface;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by kalpesh on 13/07/2017.
 */

public class MovieList_InteractorImpl implements IMovieList_Interactor {

RequestInterface requestInterface;
    Retrofit retrofit;
     OkHttpClient okHttpClient;

    public MovieList_InteractorImpl() {

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        okHttpClient= new OkHttpClient.Builder().
                addInterceptor(httpLoggingInterceptor).build();

        retrofit= new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClient)
                .build();

        requestInterface= retrofit.create(RequestInterface.class);

    }

    @Override
    public Observable<MovieListModel> getMoviesSearch(String ApiKey) {
        return requestInterface.getMoviesList(ApiKey);
    }
}

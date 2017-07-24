package com.example.kalpesh.imdbmovies.movielist.mvp.interactor;

import com.example.kalpesh.imdbmovies.movielist.model.MovieListModel;

import io.reactivex.Observable;

/**
 * Created by kalpesh on 13/07/2017.
 */

public interface IMovieList_Interactor {

    Observable<MovieListModel> getMoviesSearch(String ApiKey);

}

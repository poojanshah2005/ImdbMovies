package com.example.kalpesh.imdbmovies.movielist;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kalpesh.imdbmovies.R;
import com.example.kalpesh.imdbmovies.movielist.model.MovieListModel;
import com.example.kalpesh.imdbmovies.movielist.mvp.IMovieListView;
import com.example.kalpesh.imdbmovies.movielist.mvp.Presenter_MovieList;
import com.example.kalpesh.imdbmovies.movielist.mvp.interactor.MovieList_InteractorImpl;

/**
 * A simple {@link Fragment} subclass.
 * create an instance of this fragment.
 */
public class MovieListFragment extends Fragment implements IMovieListView {
    private Presenter_MovieList presenter_movieList;
    private MovieList_InteractorImpl movieList_interactor;

    @Override
    public void onFetchDataStarted() {

    }

    @Override
    public void onFetchDataError(Throwable e) {

    }

    @Override
    public void onFetchDataCompleted() {

    }

    @Override
    public void onFetchDataSucess(MovieListModel movieListModel) {
        Log.i("Movies" , movieListModel.getResults().get(1).getTitle());


    }


    public MovieListFragment() {
        // Required empty public constructor
    }

    public static MovieListFragment  createFragment(){
        return new MovieListFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        setRetainInstance(true);
        // Inflate the layout for this fragment
       // Toast.makeText(getActivity().getApplicationContext(),"LayoutInflater", Toast.LENGTH_LONG).show();
        movieList_interactor= new MovieList_InteractorImpl();
        presenter_movieList= new Presenter_MovieList(movieList_interactor);

        if(presenter_movieList.getView()== null)
        presenter_movieList.attachView(this);
        return inflater.inflate(R.layout.fragment_movie_list, container, false);

    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(presenter_movieList.getView()== null)
            presenter_movieList.attachView(this);

        presenter_movieList.performListSearch();
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter_movieList.detachView();
    }
}

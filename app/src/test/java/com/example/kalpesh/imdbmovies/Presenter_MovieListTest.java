package com.example.kalpesh.imdbmovies;

import com.example.kalpesh.imdbmovies.movielist.model.MovieListModel;
import com.example.kalpesh.imdbmovies.movielist.model.Result;
import com.example.kalpesh.imdbmovies.movielist.mvp.IMovieListView;
import com.example.kalpesh.imdbmovies.movielist.mvp.Presenter_MovieList;
import com.example.kalpesh.imdbmovies.movielist.mvp.interactor.MovieList_InteractorImpl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;

/**
 * Created by shahp on 24/07/2017.
 */

public class Presenter_MovieListTest {

    @Mock
    IMovieListView iMovieListView;

    @Mock
    MovieList_InteractorImpl movieList_interactor;

    @Mock
    Presenter_MovieList presenter_movieList;

    //MODELS
    @Mock
    MovieListModel movieListModel;

    @Mock
    Result result;

    @Mock
    Result result2;

    @Mock
    List<Result> results;


    @Before
    public void setUp() throws Exception {
        /**
         * init all the mocks
         */

        MockitoAnnotations.initMocks(this);

        /**
         * Init the components
         */

        iMovieListView = mock (IMovieListView.class);
        movieList_interactor = new MovieList_InteractorImpl();
        presenter_movieList = new Presenter_MovieList(movieList_interactor);
        movieListModel = new MovieListModel();
        /**
         * mocking data
         */
        result = new Result(null,null, null, "Mine", null,null, null, null, null, null, null, null, null);
        result2 = new Result(null,null, null, "Mine2", null,null, null, null, null, null, null, null, null);

        results = new ArrayList<>();
        results.add(result);
        results.add(result2);

        movieListModel.setResults(results);

    }

    @Test
    public void testPresenter_loadMovieList() throws Exception {
        /**
         * pre-defined steps for init of mvp and observal data from interactor
         */

        presenter_movieList.attachView(iMovieListView);

        when(movieList_interactor.getMoviesSearch(""))
                .thenReturn(Observable.just(movieListModel));

        //Excetion  - interaction of presenter with the view and maximum code coverage.

        presenter_movieList.performListSearch();
        InOrder inOrder = Mockito.inOrder(iMovieListView);

        inOrder.verify(iMovieListView, times(1)).onFetchDataStarted();
        inOrder.verify(iMovieListView, times(1)).onFetchDataSucess(movieListModel);
        inOrder.verify(iMovieListView, times(1)).onFetchDataCompleted();
    }
}

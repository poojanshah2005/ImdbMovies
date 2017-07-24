package com.example.kalpesh.imdbmovies;

import android.support.test.runner.AndroidJUnit4;

import com.example.kalpesh.imdbmovies.movielist.MovieListFragment;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by shahp on 24/07/2017.
 */
@RunWith(AndroidJUnit4.class)
public class MovieListFragmentTest {

    @Rule
    public FragmentTestRule<MovieListFragment> movieListFragmentFragmentTestRule = new FragmentTestRule<>(MovieListFragment.class);


    @Before
    public void setUp() throws Exception {
        movieListFragmentFragmentTestRule.launchActivity(null);

    }

    @Test
    public void test_fragment() throws Exception {
        onView(withId(R.id.container))
                .check(matches(isDisplayed()));
    }


}

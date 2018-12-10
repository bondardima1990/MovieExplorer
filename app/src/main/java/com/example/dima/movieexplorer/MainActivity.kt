package com.example.dima.movieexplorer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.dima.common.App
import com.example.dima.screens.movie_list.DaggerMovieListComponent
import com.example.dima.screens.movie_list.MovieListModule
import com.example.dima.screens.movie_list.MovieListPresenter
import com.example.dima.screens.movie_list.MovieListView
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var presenter: MovieListPresenter
    lateinit var view: MovieListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMovieListComponent.builder()
            .appComponent(App.component)
            .movieListModule(MovieListModule())
            .build()
            .inject(this)
        view = MovieListView(findViewById(R.id.content_frame))
    }

    override fun onStart() {
        super.onStart()
        presenter.start(view)
    }

    override fun onStop() {
        super.onStop()
        presenter.stop()
    }
}

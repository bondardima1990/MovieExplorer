package com.example.dima.screens.movie_list

import android.util.Log
import com.swat_cat.domain.models.Movie
import com.swat_cat.domain.use_cases.MovieListUseCase
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.functions.Function
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class MovieListPresenter @Inject constructor(val movieListUseCase: MovieListUseCase):MovieListContract.Presenter{

    private lateinit var view: MovieListContract.View
    private var subscriptions:CompositeDisposable? = null

    override fun start(view: MovieListContract.View) {
        this.view = view
        subscriptions = CompositeDisposable()
        initActions()
    }

    private fun initActions() {
        subscriptions?.add(
            view.searchChanged()
                .skip(2)
                .debounce(400L, TimeUnit.MILLISECONDS)
                .doOnNext {
                    //view.showProgress(true)
                }
                .map { it -> it.toString().trim() }
                .flatMap {
                    movieListUseCase.searchMovie(it)?.toObservable()
                }
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    run {
                        view.showProgress(false)
                        view.setMovieList(result.orEmpty(), fun(movie: Movie) {
                            movieSelected(movie)
                        })
                        if (result?.isEmpty() == true) {
                            view.showEmptY(true)
                        } else {
                            view.showEmptY(false)
                        }
                    }
                },
                    {
                        Log.e(MovieListPresenter::class.simpleName, it.localizedMessage)
                    }
                )
        )
    }

    private fun movieSelected(movie: Movie?) {
       Log.d(MovieListPresenter::class.simpleName,"Movie clicked ${movie?.title}")
    }

    override fun stop() {
       subscriptions?.dispose()
    }
}
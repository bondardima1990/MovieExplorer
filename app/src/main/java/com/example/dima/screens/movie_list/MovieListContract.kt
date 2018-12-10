package com.example.dima.screens.movie_list

import com.swat_cat.domain.models.Movie
import io.reactivex.Observable

interface MovieListContract{
    interface View{
        fun searchChanged():Observable<CharSequence>
        fun clean(clean:()->Unit)
        fun setMovieList(movies:List<Movie>, itemClicked: (movie:Movie)->Unit)
        fun showProgress(boolean: Boolean)
        fun showEmptY(boolean: Boolean)
    }
    interface Presenter{
        fun start(view:MovieListContract.View)
        fun stop()
    }
}
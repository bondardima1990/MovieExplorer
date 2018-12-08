package com.example.dima.screens.movie_list

import com.swat_cat.domain.models.Movie
import io.reactivex.Observable

interface MovieListContract{
    interface View{
        fun searchChanged():Observable<CharSequence>
        fun clean(clean:()->Unit)
        fun setMovieList(movies:List<Movie>, itemClicked: (movie:Movie)->Unit)
    }
    interface Presenter{

    }
}
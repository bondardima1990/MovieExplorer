package com.swat_cat.domain.repositories

import com.swat_cat.domain.models.Movie
import com.swat_cat.domain.models.MovieDetails
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single

interface MovieRepository{
    fun findMoviesByQuery(query:String?):Single<List<Movie>>
    fun findMovieByImdbId(id:String?):Maybe<MovieDetails>
}
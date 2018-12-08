package com.swat_cat.domain.use_cases

import com.swat_cat.domain.models.MovieDetails
import com.swat_cat.domain.repositories.MovieRepository
import io.reactivex.Maybe

class MovieDetailsUseCase(private val repository: MovieRepository){
    fun getMovieDetails(id:String):Maybe<MovieDetails?> = repository.findMovieByImdbId(id)
}
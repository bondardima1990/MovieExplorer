package com.swat_cat.domain.use_cases

import com.swat_cat.domain.models.Movie
import com.swat_cat.domain.repositories.MovieRepository
import io.reactivex.Single
import sun.reflect.generics.repository.ClassRepository

class MovieListUseCase(private val repository: MovieRepository){
    fun searchMovie(query:String?):Single<List<Movie>> = repository.findMoviesByQuery(query)
}
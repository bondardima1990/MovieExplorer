package com.swat_cat.data.repositories

import com.swat_cat.data.mappers.MovieDetailsMapper
import com.swat_cat.data.mappers.MovieMapper
import com.swat_cat.data.rest.MovieApi
import com.swat_cat.domain.models.Movie
import com.swat_cat.domain.models.MovieDetails
import com.swat_cat.domain.repositories.MovieRepository
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieRepositoryImpl(val restApi:MovieApi, val movieMapper: MovieMapper, val movieDetailsMapper: MovieDetailsMapper): MovieRepository{
   override fun findMoviesByQuery(query: String?): Single<List<Movie>?>? {
        return restApi.search("movie",query)
            .map { result ->  result.search?.map { it -> movieMapper.fromDto(it) }}
            .firstOrError()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    override fun findMovieByImdbId(id: String?): Maybe<MovieDetails?> {
        return  restApi.movieDetails(id)
            .map { it ->  movieDetailsMapper.fromDto(it)}
            .firstElement()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}
package com.example.dima.di

import com.swat_cat.data.dto.MovieDTO
import com.swat_cat.data.dto.MovieDetailsDTO
import com.swat_cat.data.mappers.MovieDetailsMapper
import com.swat_cat.data.mappers.MovieMapper
import com.swat_cat.data.repositories.MovieRepositoryImpl
import com.swat_cat.data.rest.MovieApi
import com.swat_cat.domain.Mapper
import com.swat_cat.domain.models.Movie
import com.swat_cat.domain.models.MovieDetails
import com.swat_cat.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RestDataModule{

    @Singleton
    @Provides
    fun provideMovieMapper(): MovieMapper = MovieMapper()

    @Singleton
    @Provides
    fun provideMovieDetailsMapper():MovieDetailsMapper = MovieDetailsMapper()

    @Singleton
    @Provides
    fun provideMovieRepository(restApi: MovieApi, mapper: MovieMapper, movieDetailsMapper: MovieDetailsMapper):MovieRepository
            = MovieRepositoryImpl(restApi,mapper, movieDetailsMapper)
}
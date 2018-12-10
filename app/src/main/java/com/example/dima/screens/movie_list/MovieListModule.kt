package com.example.dima.screens.movie_list

import com.example.dima.di.PerScreen
import com.swat_cat.domain.repositories.MovieRepository
import com.swat_cat.domain.use_cases.MovieListUseCase
import dagger.Module
import dagger.Provides

@Module
class MovieListModule{

    @PerScreen
    @Provides
    fun provideMovieListUseCase(repository: MovieRepository):MovieListUseCase = MovieListUseCase(repository)

    @PerScreen
    @Provides
    fun provideMovieListPresenter(useCase: MovieListUseCase):MovieListContract.Presenter = MovieListPresenter(useCase)
}
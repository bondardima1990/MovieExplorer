package com.example.dima.screens.movie_list

import com.example.dima.di.AppComponent
import com.example.dima.di.PerScreen
import com.example.dima.movieexplorer.MainActivity
import dagger.Component

@PerScreen
@Component(modules = arrayOf(MovieListModule::class),
    dependencies = arrayOf(AppComponent::class) )
interface MovieListComponent{
    fun inject(actrivity:MainActivity)
}
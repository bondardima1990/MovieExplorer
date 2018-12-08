package com.example.dima.common

import android.app.Application
import com.example.dima.di.AppComponent
import com.example.dima.di.DaggerAppComponent

class App : Application(){

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        lateinit var instance: App
            private set
        lateinit var component: AppComponent
            private set
    }
}
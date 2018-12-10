package com.example.dima.common

import android.app.Application
import android.support.multidex.MultiDexApplication
import com.example.dima.di.AppComponent
import com.example.dima.di.DaggerAppComponent
import com.orhanobut.hawk.Hawk

class App : MultiDexApplication(){

    override fun onCreate() {
        super.onCreate()
        component = DaggerAppComponent.builder()
            .application(this)
            .build()
        Hawk.init(applicationContext).build()
    }

    companion object {
        lateinit var instance: App
            private set
        lateinit var component: AppComponent
            private set
    }
}
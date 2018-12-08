package com.example.dima.di

import android.content.Context
import com.swat_cat.data.rest.MovieApi
import com.swat_cat.data.rest.RestClient
import dagger.Module
import dagger.Provides
import dagger.Reusable

@Module
// Safe here as we are dealing with a Dagger 2 module
class NetworkModule {
    /**
     * Provides the Post service implementation.
     * @param retrofit the Retrofit object used to instantiate the service
     * @return the Post service implementation.
     */
    @Provides
    @Reusable
    internal fun providePostApi(context: Context, retrofit: RestClient): MovieApi {
        return retrofit.createRestService(context)
    }

    /**
     * Provides the Retrofit object.
     * @return the Retrofit object
     */
    @Provides
    @Reusable
    internal fun provideRetrofitInterface(): RestClient {
        return RestClient()
    }
}
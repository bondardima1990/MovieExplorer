package com.swat_cat.data.rest

import com.swat_cat.data.dto.MoviListDTO
import com.swat_cat.data.dto.MovieDetailsDTO
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface MovieApi{
    @GET("?apikey=33d3ea25")
    fun search(@Query("type") type: String, @Query("s") s: String): Observable<MoviListDTO>

    @GET("?apikey=33d3ea25")
    fun movieDetails(@Query("i") id: String): Observable<MovieDetailsDTO>
}
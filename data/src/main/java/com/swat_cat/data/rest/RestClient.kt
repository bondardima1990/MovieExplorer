package com.swat_cat.data.rest


import android.content.Context
import android.content.Intent

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.orhanobut.hawk.Hawk
import com.swat_cat.data.R

import java.io.IOException
import java.net.HttpURLConnection
import java.util.Locale
import java.util.concurrent.TimeUnit

import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.ResponseBody
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber
class RestClient{
    val JSON = MediaType.parse("application/json; charset=utf-8")
    val TOKEN = "TOJELD"

    fun createRestService(context: Context):MovieApi{
        val gson = GsonBuilder() //do we really need such customization?
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create()

        val builder = Retrofit.Builder().addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(context.getString(R.string.base_url))
        val client = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor { chain ->
                val request = chain.request()
                val newBuilder = request.newBuilder()

                val token = Hawk.get(TOKEN, "")
                if (!token.isNullOrEmpty()) {
                    val locale = Locale.getDefault()
                    val country = locale.language
                    val region = locale.country
                    val code = "$country-$region"
                    newBuilder.addHeader("accept-language", country)
                    //newBuilder.addHeader("x-device-id", Tools.getUniquePsuedoID())
                    newBuilder.addHeader("x-auth-token", token)
                    Timber.d("Authorization: Token " + token)
                }
                val locale = Locale.getDefault()
                val country = locale.language
                val region = locale.country
                val code = country + "-" + region
                newBuilder.addHeader("accept-language", country)
                //newBuilder.addHeader("x-api-version", App.instance.context.getString(R.string.version))
                val newRequest = newBuilder
                    .build()
                var response: Response? = null
                var newStringBody = ""
                try {
                    response = chain.proceed(newRequest)
                    when (response!!.code()) {
                        HttpURLConnection.HTTP_UNAUTHORIZED -> {
                            val url = response.request().url().toString()
                            if (url != null) {
                                //TODO admin mode
                            } else {
                                Timber.e("ModifierGroupListDTO without request URL! " + response)
                            }
                        }
                    }
                    val body = response.body()
                    Timber.d("HTTP " + response.code() + " URL=" + response.request().url().toString())
                    val bodyString = body!!.string()
                    Timber.d(bodyString)
                    if (bodyString.startsWith("[")) {
                        newStringBody = "{\"data\":$bodyString}"
                    } else if (bodyString.isNullOrEmpty()) {
                        newStringBody = "{}"
                    } else {
                        newStringBody = bodyString
                    }
                    Timber.d(newStringBody)
                    val newResponse = response.newBuilder()
                        .body(ResponseBody.create(JSON, newStringBody))
                    response = newResponse.build()

                } catch (e: IOException) {
                    e.localizedMessage
                }

                response
            }.build()
        builder.client(client)
        return builder.build().create(MovieApi::class.java)
    }
}
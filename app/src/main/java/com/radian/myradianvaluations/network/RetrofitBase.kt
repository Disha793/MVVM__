package com.radian.myradianvaluations.network

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.radian.myradianvaluations.BuildConfig

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.OkHttpClient
import java.util.concurrent.TimeUnit


object RetrofitBase {
    lateinit var retrofit: Retrofit
    fun getClient(): Retrofit {
        var logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        httpClient.readTimeout(3, TimeUnit.MINUTES)
        httpClient.connectTimeout(3, TimeUnit.MINUTES)
        httpClient.writeTimeout(3, TimeUnit.MINUTES)
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()).baseUrl(BuildConfig.HOST)
            .client(httpClient.build()).build()
        return retrofit
    }
}
package com.radian.myradianvaluations.networking

import android.content.Context
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.constants.Const.CONNECTION_TIMEOUT
import com.radian.myradianvaluations.utils.Pref
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


open class APIClient {
    private lateinit var retrofit: Retrofit
    private var interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor()

    init {
        if (BuildConfig.DEBUG) {
            interceptor.level = HttpLoggingInterceptor.Level.BODY
        } else {
            interceptor.level = HttpLoggingInterceptor.Level.NONE
        }
    }

    fun getClient(): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        httpClient.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        httpClient.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.HOST).client(httpClient.build()).build()
        return retrofit
    }

    fun getClientUrl(url: String): Retrofit {
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(interceptor)
        httpClient.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        httpClient.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        httpClient.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(url.substringBeforeLast("/"))
            .client(httpClient.build()).build()
        return retrofit
    }

    fun getClientWithHeader(mContext: Context): Retrofit {
        val client = OkHttpClient.Builder()
        client.addInterceptor(interceptor)
        client.readTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        client.writeTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.MINUTES)
        //with oAuthKey
        client.addInterceptor(AuthInterceptor(mContext))

        retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.HOST).client(client.build()).build()
        return retrofit
    }

}
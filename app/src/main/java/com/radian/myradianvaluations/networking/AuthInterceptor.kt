package com.radian.myradianvaluations.networking

import android.content.Context
import com.radian.myradianvaluations.utils.Pref
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder().addHeader(
            "oAuthkey",  Pref.getValue(context!!, Pref.AUTH_TOKEN, "")
        ).build()

        return chain.proceed(requestBuilder)
    }
}
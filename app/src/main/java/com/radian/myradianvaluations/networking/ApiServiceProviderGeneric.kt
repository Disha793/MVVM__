package com.radian.myradianvaluations.networking

import android.content.Context
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.utils.LogUtils
import com.sunteckindia.networking.ApiResponseCallBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Url


class ApiServiceProviderGeneric() : APIClient() {
    private val classTag = javaClass.simpleName
    private val job = SupervisorJob()
    private val coroutineScope = CoroutineScope(Dispatchers.IO + job)
    private lateinit var apiResponseCallBack: ApiResponseCallBack

    constructor(apiResponseCallBack: ApiResponseCallBack) : this() {
        this.apiResponseCallBack = apiResponseCallBack
    }

    fun postCall(
        context: Context,
        urlEndPoint: String,
        jsonObj: JsonObject,
        returnType: ReturnType
    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClientWithHeader(context).create(GetCallReference::class.java)
                    .postCall(BuildConfig.HOST + urlEndPoint, jsonObj)
                launch(Dispatchers.Main) {
                    if (call.body() != null && call.isSuccessful) {
                       // LogUtils.logE(classTag, "response : ${call.body() as JsonElement}")
                        apiResponseCallBack.onSuccess(
                            returnType, call.body().toString()
                        )
                    } else {
                        apiResponseCallBack.onError(
                            returnType,
                            context.getString(R.string.please_try_again)
                        )
                    }
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onError(
                        returnType,
                        context.getString(R.string.please_try_again)
                    )
                }
                LogUtils.logE(classTag, e)
            }
        }
    }
fun postCallWithoutHeader(
    context: Context,
    urlEndPoint: String,
    jsonObj: JsonObject,
    returnType: ReturnType
)
{
    coroutineScope.launch {
        try {
            launch(Dispatchers.Main) {
                apiResponseCallBack.onPreExecute(returnType)
            }
            val call = getClient().create(GetCallReference::class.java)
                .postCall(BuildConfig.HOST + urlEndPoint, jsonObj)
            launch(Dispatchers.Main) {
                if (call.body() != null && call.isSuccessful) {
                    // LogUtils.logE(classTag, "response : ${call.body() as JsonElement}")
                    apiResponseCallBack.onSuccess(
                        returnType, call.body().toString()
                    )
                } else {
                    apiResponseCallBack.onError(
                        returnType,
                        context.getString(R.string.please_try_again)
                    )
                }
            }
        } catch (e: Exception) {
            launch(Dispatchers.Main) {
                apiResponseCallBack.onError(
                    returnType,
                    context.getString(R.string.please_try_again)
                )
            }
            LogUtils.logE(classTag, e)
        }
    }
}
    fun postCallUrl(
        context: Context,
        url: String,
        jsonObj: JsonObject,
        returnType: ReturnType
    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClientWithHeader(context).create(GetCallReference::class.java)
                    .postCall(url, jsonObj)
                launch(Dispatchers.Main) {
                    if (call.body() != null && call.isSuccessful) {
                        LogUtils.logD(classTag, "response : ${call.body() as JsonElement}")
                        apiResponseCallBack.onSuccess(
                            returnType, call.body().toString()
                        )
                    } else {
                        apiResponseCallBack.onError(
                            returnType,
                            context.getString(R.string.please_try_again)
                        )
                    }
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onError(
                        returnType,
                        context.getString(R.string.please_try_again)
                    )
                }
                LogUtils.logE(classTag, e)
            }
        }
    }



    internal interface GetCallReference {
        @POST
        suspend fun postCall(
            @Url url: String,
            @Body jsonObject: JsonObject
        ): Response<JsonElement>

        @GET
        suspend fun getCall(
            @Url url: String
        ): Response<JsonElement>
    }
}

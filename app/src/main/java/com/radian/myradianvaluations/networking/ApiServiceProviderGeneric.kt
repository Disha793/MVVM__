package com.radian.myradianvaluations.networking

import android.content.Context
import com.google.gson.JsonElement
import com.radian.myradianvaluations.BuildConfig
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.utils.LogUtils
import com.sunteckindia.networking.ApiResponseCallBack
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import okhttp3.Headers
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*
import java.io.File


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
            returnType: ReturnType,
            map: HashMap<String, Any?>

    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClientWithHeader(context).create(GetCallReference::class.java)
                        .postCall(
                                map,
                                BuildConfig.HOST + urlEndPoint
                        )
                launch(Dispatchers.Main) {
                    if (call.body() != null && call.isSuccessful) {
                        val headerList: Headers = call.headers()
                        LogUtils.logD(
                                classTag,
                                "Header===>" + headerList.get("Authorization").toString()
                        )
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
            map: HashMap<String, Any?>,
            returnType: ReturnType
    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClient().create(GetCallReference::class.java)
                        .postCall(map, BuildConfig.HOST + urlEndPoint)
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

    fun multipartPostCall(
            context: Context,
            urlEndPoint: String,
            image:MultipartBody.Part,
            fileName: RequestBody,
            returnType: ReturnType,
            map: HashMap<String, RequestBody>

    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClientWithHeader(context).create(GetCallReference::class.java)
                        .postCallMultipart(image,fileName,
                                map,
                                BuildConfig.HOST + urlEndPoint
                        )
                launch(Dispatchers.Main) {
                    if (call.body() != null && call.isSuccessful) {
                        // LogUtils.logE(classTag, "response : ${call.body() as JsonElement}")
                        val headerList: Headers = call.headers()
                        LogUtils.logD(
                                classTag,
                                "Header===>" + headerList.get("Authorization").toString()
                        )
                        //  LogUtils.logD(classTag, "response : ${call.body() as JsonElement}")
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

    fun getCall(
            context: Context,
            urlEndPoint: String,
            returnType: ReturnType
    ) {
        coroutineScope.launch {
            try {
                launch(Dispatchers.Main) {
                    apiResponseCallBack.onPreExecute(returnType)
                }
                val call = getClient().create(GetCallReference::class.java)
                        .getCall(BuildConfig.HOST + urlEndPoint)
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

    internal interface GetCallReference {

        @FormUrlEncoded
        @POST
        suspend fun postCall(
                @FieldMap map: HashMap<String, Any?>,
                @Url url: String
        ): Response<JsonElement>

        @POST
        @Multipart
        suspend fun postCallMultipart(
                @Part file: @JvmSuppressWildcards MultipartBody.Part,
                @Part("filename") filename: RequestBody,
                @PartMap values: HashMap<String, RequestBody>,
                @Url url: String
        ): Response<JsonElement>

        @GET
        suspend fun getCall(
                @Url url: String
        ): Response<JsonElement>
    }
}

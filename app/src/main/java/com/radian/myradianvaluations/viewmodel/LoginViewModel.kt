package com.radian.myradianvaluations.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.StatusResponse
import com.sunteckindia.networking.ApiResponseCallBack
import javax.net.ssl.SSLEngineResult

class LoginViewModel(private val applicationContext: Application) :
    AndroidViewModel(applicationContext), ApiResponseCallBack {
    private lateinit var loginRepository: LoginRepository
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    private lateinit var context: Context
    private var mlLoginResponse = MutableLiveData<StatusResponse>()
    val userStatus: LiveData<StatusResponse>
        get() = mlLoginResponse

    fun init(context: Context) {
        this.context = context
        loginRepository = LoginRepository.getInstance(context)
    }

    fun signIn(
        userName: String,
        phoneNumber: String,
        password: String
    ): MutableLiveData<StatusResponse>? {
        mlLoginResponse = loginRepository.callLoginApi(userName, phoneNumber, password)!!
        return mlLoginResponse

    }

    fun getUserStatus(jsonObject: JsonObject) {
        apiServiceProviderGeneric.postCallWithoutHeader(
            applicationContext, ReturnType.POST_GetUserStatus.endPoint,
            jsonObject,
            ReturnType.POST_GetUserStatus
        )
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            if (returnType == ReturnType.POST_GetUserStatus) {
                val responseUsers = Gson().fromJson<StatusResponse>(
                    response,
                    object : TypeToken<StatusResponse>() {}.type
                )
                LogUtils.logD("", "" + responseUsers.status)
                mlLoginResponse?.value = responseUsers
            }
        } catch (e: Exception) {
            LogUtils.logE("", e)
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
    }


}
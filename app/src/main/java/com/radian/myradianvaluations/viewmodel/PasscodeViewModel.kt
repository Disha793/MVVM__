package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.myradianvaluations.repository.OrgInfoRepository
import com.radian.myradianvaluations.repository.PasscodeRepository
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.LoginResponse
import com.radian.vendorbridge.Response.OrgInfoResponse
import com.radian.vendorbridge.Response.OtpResponse
import com.radian.vendorbridge.Response.StatusResponse
import com.sunteckindia.networking.ApiResponseCallBack

class PasscodeViewModel : ViewModel(), ApiResponseCallBack {
    lateinit var passcodeRepository: PasscodeRepository
    private var otpResponse = MutableLiveData<OtpResponse>()
    private var verifyotpResponse = MutableLiveData<OtpResponse>()
    private var loginResponse= MutableLiveData<LoginResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    private lateinit var context: Context
    val generateOtpResponse: LiveData<OtpResponse>
        get() = otpResponse
    val verifyOtpResponseData: LiveData<OtpResponse>
        get() = verifyotpResponse
    val loginResponseData: LiveData<LoginResponse>
        get() = loginResponse

    fun init(context: Context) {
        this.context = context
        passcodeRepository = PasscodeRepository.getInstance(context)
    }

    fun generateOtp(jsonObject: JsonObject): MutableLiveData<OtpResponse>? {
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_GenerateOtp.endPoint,
            jsonObject,
            ReturnType.POST_GenerateOtp
        )
        return otpResponse
    }

    fun verifyOtp(jsonObject: JsonObject): MutableLiveData<OtpResponse>? {
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_VerifyOtp.endPoint,
            jsonObject,
            ReturnType.POST_VerifyOtp
        )
        return otpResponse
    }

    fun callSignIn(jsonObject: JsonObject) {
        //  loginResponse = passcodeRepository.callSignIn(accessCode, fcmToken)
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_SignIn.endPoint,
            jsonObject,
            ReturnType.POST_SignIn
        )

    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)

    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        when (returnType) {
            ReturnType.POST_GenerateOtp -> {
                try {
                    val responseUsers = Gson().fromJson<OtpResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    otpResponse.value = responseUsers

                } catch (e: Exception) {
                    LogUtils.logE("", e)
                }
            }
            ReturnType.POST_VerifyOtp -> {
                try {
                    val responseUsers = Gson().fromJson<OtpResponse>(
                        response,
                        object : TypeToken<OtpResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    verifyotpResponse.value = responseUsers

                } catch (e: Exception) {
                    LogUtils.logE("", e)
                }
            }
            ReturnType.POST_SignIn -> {
                try {
                    val responseUsers = Gson().fromJson<LoginResponse>(
                        response,
                        object : TypeToken<LoginResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    loginResponse.value = responseUsers

                } catch (e: Exception) {
                    LogUtils.logE("", e)
                }
            }
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
    }
}
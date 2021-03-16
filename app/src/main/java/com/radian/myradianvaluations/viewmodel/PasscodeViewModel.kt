package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.LoginResponse
import com.radian.vendorbridge.Response.OtpResponse
import com.radian.vendorbridge.Response.StatusResponse
import com.sunteckindia.networking.ApiResponseCallBack

class PasscodeViewModel : ViewModel(), ApiResponseCallBack {
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
    }

    fun generateOtp(postParam: HashMap<String, Any?>): MutableLiveData<OtpResponse>? {
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_GenerateOtp.endPoint,
                postParam,
            ReturnType.POST_GenerateOtp
        )
        return otpResponse
    }

    fun verifyOtp(postParam: HashMap<String, Any?>): MutableLiveData<OtpResponse>? {
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_VerifyOtp.endPoint,
                postParam,
            ReturnType.POST_VerifyOtp
        )
        return otpResponse
    }

    fun callSignIn(postParam: HashMap<String, Any?>) {
        //  loginResponse = passcodeRepository.callSignIn(accessCode, fcmToken)
        apiServiceProviderGeneric.postCallWithoutHeader(
            context, ReturnType.POST_SignIn.endPoint,
                postParam,
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
        CommonUtils.showOkDialog(
                context!!,
                context.getString(R.string.please_try_again),
                DialogInterface.OnClickListener { _, _ -> },
                context.getString(R.string.ok)
        )    }
}
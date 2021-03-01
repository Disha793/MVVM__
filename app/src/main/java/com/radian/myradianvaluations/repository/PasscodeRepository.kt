package com.radian.myradianvaluations.repository

import android.content.Context
import android.os.Build
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.Pref
import com.radian.vendorbridge.Response.LoginResponse
import com.radian.vendorbridge.Response.OrgInfoResponse
import com.radian.vendorbridge.Response.OtpResponse
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PasscodeRepository(val context: Context) {
    companion object {
        fun getInstance(context: Context): PasscodeRepository {

            return PasscodeRepository(context)
        }
    }

    fun generateOtpAPI(): MutableLiveData<OtpResponse>? {
        val responseData = MutableLiveData<OtpResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .generateOtp(CommonUtils.getDeviceUUID(context), Pref.getValue(context, Pref.PHONE_NUMBER, "")!!)
            responseData.postValue(call.body() as OtpResponse?)


        }
        return responseData

    }
    fun verifyOtpAPI(accessCode:String,fcmToken:String): MutableLiveData<OtpResponse>? {
        val responseData = MutableLiveData<OtpResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .verifyOtp(CommonUtils.getDeviceUUID(context), Pref.getValue(context, Pref.PHONE_NUMBER, "")!!, accessCode,
                    android.os.Build.MODEL,
                    "Android",
                    Build.MANUFACTURER,
                    android.os.Build.VERSION.SDK_INT.toString(),
                    fcmToken)
            responseData.postValue(call.body() as OtpResponse?)

        }
        return responseData

    }
    fun callSignIn(accessCode: String,fcmToken: String):MutableLiveData<LoginResponse>{
        val responseData = MutableLiveData<LoginResponse>()
        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .login(CommonUtils.getDeviceUUID(context), Pref.getValue(context, Pref.PHONE_NUMBER, "")!!, accessCode,

                    fcmToken)
            responseData.postValue(call.body() as LoginResponse?)

        }
        return responseData

    }
}

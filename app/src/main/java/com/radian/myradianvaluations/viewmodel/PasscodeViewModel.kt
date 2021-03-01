package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.myradianvaluations.repository.OrgInfoRepository
import com.radian.myradianvaluations.repository.PasscodeRepository
import com.radian.vendorbridge.Response.LoginResponse
import com.radian.vendorbridge.Response.OrgInfoResponse
import com.radian.vendorbridge.Response.OtpResponse
import com.radian.vendorbridge.Response.StatusResponse

class PasscodeViewModel : ViewModel() {
    lateinit var passcodeRepository: PasscodeRepository
    private var otpResponse: MutableLiveData<OtpResponse>? = null
    private var loginResponse: MutableLiveData<LoginResponse>? = null
    fun init(context: Context) {
        passcodeRepository = PasscodeRepository.getInstance(context)
    }

    fun generateOtp(): MutableLiveData<OtpResponse>? {
        otpResponse = passcodeRepository.generateOtpAPI()
        return otpResponse
    }

    fun verifyOtp(accesscode: String, fcmToken: String): MutableLiveData<OtpResponse>? {
        otpResponse = passcodeRepository.verifyOtpAPI(accesscode, fcmToken)
        return otpResponse
    }

    fun callSignIn(accessCode: String, fcmToken: String): MutableLiveData<LoginResponse>? {
        loginResponse = passcodeRepository.callSignIn(accessCode, fcmToken)
        return loginResponse
    }
}
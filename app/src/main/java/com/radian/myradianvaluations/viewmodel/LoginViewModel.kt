package com.radian.myradianvaluations.viewmodel

import android.app.Application
import android.content.Context
import android.text.TextUtils
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.databinding.ActivityLoginBinding
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.vendorbridge.Response.StatusResponse
import java.util.regex.Pattern
import javax.net.ssl.SSLEngineResult

class LoginViewModel(val applicationContext: Application) : AndroidViewModel(applicationContext) {
    internal lateinit var loginRepository: LoginRepository
    private val PASSWORD_PATTERN = Pattern.compile(
        "^" +
                "(?=.*[0-9])" +         //at least 1 digit
                "(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[@#$%^&+=!()-_])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{8,}" +               //at least 8 characters
                "$"
    )
    private var mlLoginResponse: MutableLiveData<StatusResponse>? = null
    fun init(context: Context) {
        loginRepository = LoginRepository.getInstance(context)
    }

    fun signIn(userName: String, phoneNumber: String, password: String): MutableLiveData<StatusResponse> {
        mlLoginResponse = loginRepository.callLoginApi(userName, phoneNumber, password)
        return mlLoginResponse as MutableLiveData<StatusResponse>

    }

    fun getLoginRepository(): LiveData<StatusResponse?>? {
        return mlLoginResponse
    }

    fun isValid(binding: ActivityLoginBinding): Boolean {
        if (TextUtils.isEmpty(binding.edtPhoneNumber.text)) {
            CommonUtils.hideKeybord(binding.edtPhoneNumber, applicationContext)
            CommonUtils.displayMessage(
                binding.relativeMain,
                applicationContext.getString(R.string.error_login_empty)
            )
            return false
        }
        if (binding.edtPhoneNumber.text.toString().trim().length != 10) {
            CommonUtils.hideKeybord(binding.edtUsername, applicationContext)
            CommonUtils.displayMessage(
                binding.relativeMain,
                applicationContext.getString(R.string.error_login_invalid_number)
            )
            return false
        }
        if (TextUtils.isEmpty(binding.edtUsername.text.toString())) {
            CommonUtils.hideKeybord(binding.edtUsername, applicationContext)
            CommonUtils.displayMessage(
                binding.relativeMain,
                applicationContext.getString(R.string.error_login_empty_username)
            )
            return false
        }


        if (TextUtils.isEmpty(binding.edtPassword.text.toString())) {
            CommonUtils.hideKeybord(binding.edtPhoneNumber, applicationContext)
            CommonUtils.displayMessage(
                binding.relativeMain,
                applicationContext.getString(R.string.error_login_empty_password)
            )
            return false
        }
        if (!PASSWORD_PATTERN.matcher(binding.edtPassword.text.toString()).matches()) {
            CommonUtils.hideKeybord(binding.edtPassword, applicationContext)
            CommonUtils.displayMessage(
                binding.relativeMain,
                applicationContext.getString(R.string.error_login_invalid_password)
            )
            return false
        }
        return true
    }
}
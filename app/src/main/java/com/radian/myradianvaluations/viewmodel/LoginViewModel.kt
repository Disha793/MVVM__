package com.radian.myradianvaluations.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.repository.LoginRepository
import com.radian.vendorbridge.Response.StatusResponse

class LoginViewModel(private val applicationContext: Application) : AndroidViewModel(applicationContext) {
    private lateinit var loginRepository: LoginRepository

    private var mlLoginResponse: MutableLiveData<StatusResponse>? = null
    fun init(context: Context) {
        loginRepository = LoginRepository.getInstance(context)
    }

    fun signIn(userName: String, phoneNumber: String, password: String): MutableLiveData<StatusResponse>? {
        mlLoginResponse = loginRepository.callLoginApi(userName, phoneNumber, password)
        return mlLoginResponse

    }




}
package com.radian.myradianvaluations.repository

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.radian.myradianvaluations.network.APIList
import com.radian.myradianvaluations.network.RetrofitBase
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.vendorbridge.Response.StatusResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginRepository(val context: Context) {


    companion object {
        fun getInstance(context: Context): LoginRepository {

            return LoginRepository(context)
        }
    }

    fun callLoginApi(
        userName: String,
        phoneNumber: String,
        password: String
    ): MutableLiveData<StatusResponse>? {
        val loginResponseData = MutableLiveData<StatusResponse>()

        CoroutineScope(Dispatchers.IO).launch {
            val call = RetrofitBase.getClient().create(APIList::class.java)
                .getUserStatus(CommonUtils.getDeviceUUID(context), phoneNumber, userName, password)
            loginResponseData.postValue(call.body() as StatusResponse?)
        }
        return loginResponseData
    }
    fun login(){

    }
}
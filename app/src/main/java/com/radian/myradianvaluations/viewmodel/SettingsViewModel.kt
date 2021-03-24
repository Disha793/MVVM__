package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.NotiStatusResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.SettingsRepository
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class SettingsViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SettingsViewModel::class.java)) {
            return SettingsViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class SettingsViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    var notiStatusResponse = MutableLiveData<NotiStatusResponse>()
    var saveNotiStatusResponse = MutableLiveData<StatusResponse>()


    fun getNotiStatus(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_GetNotiStatus.endPoint,
            ReturnType.POST_GetNotiStatus,
            postParams
        )
    }


    fun saveNotiStatus(postParams: HashMap<String, Any?>){
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_SaveNotiStatus.endPoint,
            ReturnType.POST_SaveNotiStatus,
            postParams
        )
    }


override fun onPreExecute(returnType: ReturnType) {
    LoadingDialog.show(context)
}

override fun onSuccess(returnType: ReturnType, response: String) {
    LoadingDialog.dismissDialog()
    try {
        when (returnType) {
            ReturnType.POST_GetNotiStatus -> {
                val response = Gson().fromJson<NotiStatusResponse>(
                    response,
                    object : TypeToken<NotiStatusResponse>() {}.type
                )
                LogUtils.logD("", "" + response.status)
                notiStatusResponse.value = response
            }
            ReturnType.POST_SaveNotiStatus->{
                val response = Gson().fromJson<StatusResponse>(
                    response,
                    object : TypeToken<StatusResponse>() {}.type
                )
                LogUtils.logD("", "" + response.status)
                saveNotiStatusResponse.value = response
            }
        }
    } catch (e: Exception) {

    }
}

override fun onError(returnType: ReturnType, error: String) {
    TODO("Not yet implemented")
}

}
package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class CodeofConductModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CodeofConductViewModel::class.java)) {
            return CodeofConductViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class CodeofConductViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    var statusresponse = MutableLiveData<StatusResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    fun saveVendorCompliance(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_SAVECOC.endPoint, ReturnType.POST_SAVECOC, postParams)
    }
    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_SAVECOC -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    statusresponse.value = response
                }
            }
        } catch (e: Exception) {
            LogUtils.logE("", e)
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
        CommonUtils.showOkDialog(
            context!!,
            context.getString(R.string.please_try_again),
            DialogInterface.OnClickListener { _, _ -> },
            context.getString(R.string.ok)
        )
    }
}
package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils


class OutOfficeViewModel : ViewModel(), ApiResponseCallBack {
    private lateinit var context: Context
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    var outOfficeResponse = MutableLiveData<StatusResponse>()

    fun init(context: Context) {
        this.context = context
    }

    fun saveOutOfOffice(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_OutOffice.endPoint, ReturnType.POST_OutOffice, postParams)
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_OutOffice -> {
                    val response = Gson().fromJson<StatusResponse>(
                            response,
                            object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    outOfficeResponse.value = response
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

package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.StatusResponse
import com.sunteckindia.networking.ApiResponseCallBack

class RejectViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RejectOrderViewModel::class.java)) {
            return RejectOrderViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }

}

class RejectOrderViewModel(private var context: Context) : ViewModel(), ApiResponseCallBack {
    var rejectOrderResponse = MutableLiveData<StatusResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)


    fun rejectOrder(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_ConfirmOrder.endPoint, ReturnType.POST_ConfirmOrder, postParams)
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        val response = Gson().fromJson<StatusResponse>(
                response,
                object : TypeToken<StatusResponse>() {}.type
        )
        LogUtils.logD("", "" + response.status)
        rejectOrderResponse.value = response
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
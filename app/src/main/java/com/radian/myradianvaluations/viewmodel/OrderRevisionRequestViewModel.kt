package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.Response.OrderRevisionResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class OrderRevisionRequestViewModelFactory(private val context: Context) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderRevisionRequestViewModel::class.java)) {
            return OrderRevisionRequestViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class OrderRevisionRequestViewModel(private val context: Context) : ViewModel(),
ApiResponseCallBack {
    var orderRevisionResponse = MutableLiveData<OrderRevisionResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    fun getOrderRevisionList(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_OrderRevisionRequest.endPoint,
            ReturnType.POST_OrderRevisionRequest,
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
                ReturnType.POST_OrderRevisionRequest -> {
                    val response = Gson().fromJson<OrderRevisionResponse>(
                        response,
                        object : TypeToken<OrderRevisionResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    orderRevisionResponse.value = response
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
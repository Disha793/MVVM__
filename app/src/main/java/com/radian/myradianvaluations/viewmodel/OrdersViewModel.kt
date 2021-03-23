package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.OrderListResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class OrdersViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrdersViewModel::class.java)) {
            return OrdersViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class OrdersViewModel(private val context: Context) :ViewModel(),ApiResponseCallBack{
     var orderResponse = MutableLiveData<OrderListResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    fun getOrderList(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_OrderList.endPoint, ReturnType.POST_OrderList, postParams)
    }
    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_OrderList -> {
                    val responseUsers = Gson().fromJson<OrderListResponse>(
                            response,
                            object : TypeToken<OrderListResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    orderResponse.value = responseUsers
                }

            }

        } catch (e: Exception) {
            LogUtils.logE("", e)
        }    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
        CommonUtils.showOkDialog(
                context!!,
                context.getString(R.string.please_try_again),
                DialogInterface.OnClickListener { _, _ -> },
                context.getString(R.string.ok)
        )    }
}
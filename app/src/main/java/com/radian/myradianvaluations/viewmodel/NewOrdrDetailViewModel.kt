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
import com.radian.vendorbridge.Response.NewOrderDetailResponse
import com.radian.vendorbridge.Response.StatusResponse
import com.sunteckindia.networking.ApiResponseCallBack
class NewOrdrDetailViewModelFactory(private val context:Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewOrdrDetailViewModel::class.java)) {
            return NewOrdrDetailViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}
class NewOrdrDetailViewModel(private val context:Context) : ViewModel(), ApiResponseCallBack {
    var newOrderDetailResponse = MutableLiveData<NewOrderDetailResponse>()
    var confirmOrderResponse = MutableLiveData<StatusResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    fun getOrderDetail(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_NewOrderDetail.endPoint, ReturnType.POST_NewOrderDetail, postParams)
    }

    fun confirmOrder(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_ConfirmOrder.endPoint, ReturnType.POST_ConfirmOrder, postParams)
    }

//    fun rejectOrder(postParams: HashMap<String, Any?>) {
//        apiServiceProviderGeneric.postCall(context, ReturnType.POST_ConfirmOrder.endPoint, ReturnType.POST_ConfirmOrder, postParams)
//    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        when (returnType) {
            ReturnType.POST_NewOrderDetail -> {
                val response = Gson().fromJson<NewOrderDetailResponse>(
                        response,
                        object : TypeToken<NewOrderDetailResponse>() {}.type
                )
                LogUtils.logD("", "" + response.status)
                newOrderDetailResponse.value = response
            }
            ReturnType.POST_ConfirmOrder -> {
                val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                )
                LogUtils.logD("", "" + response.status)
                confirmOrderResponse.postValue(response)
            }
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
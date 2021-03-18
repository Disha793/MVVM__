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
import com.radian.myradianvaluations.Response.OrderDocResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.DocumentListRepository
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class OrderDocumentListViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(OrderDocumentListViewModel::class.java)) {
            return OrderDocumentListViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}
class OrderDocumentListViewModel(private val context: Context) : ViewModel(),ApiResponseCallBack {
    var orderDocListResponse = MutableLiveData<OrderDocResponse>()
    var docMarkReadResponse = MutableLiveData<StatusResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    fun getOrderDocuments(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_OrderDocListReq.endPoint, ReturnType.POST_OrderDocListReq, postParams)
    }
   fun markAsRead(postParams: HashMap<String, Any?>) {
       apiServiceProviderGeneric.postCall(context, ReturnType.POST_OrderMarkDocReadReq.endPoint, ReturnType.POST_OrderMarkDocReadReq, postParams)
   }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_OrderDocListReq -> {
                    val response = Gson().fromJson<OrderDocResponse>(
                            response,
                            object : TypeToken<OrderDocResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    orderDocListResponse.value = response
                }
                ReturnType.POST_OrderMarkDocReadReq->{
                    val response = Gson().fromJson<StatusResponse>(
                            response,
                            object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    docMarkReadResponse.value = response
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
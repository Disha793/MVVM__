package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.DashboardResponseNew
import com.radian.myradianvaluations.Response.WhatsNewResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.ManageOrderResponse
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils


class DashboardViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DashboardViewModel::class.java)) {
            return DashboardViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class DashboardViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    private var dashboardResponse = MutableLiveData<DashboardResponseNew>()
    var whatsNewResponse = MutableLiveData<WhatsNewResponse>()
    var rejectOrderResponse = MutableLiveData<StatusResponse>()
    var docMarkReadResponse = MutableLiveData<StatusResponse>()
    var revisionMarkReadResponse = MutableLiveData<StatusResponse>()
    var appointmentResponse = MutableLiveData<StatusResponse>()
    var manageOrderResponse = MutableLiveData<ManageOrderResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    val dashboardData: LiveData<DashboardResponseNew>
        get() = dashboardResponse

    fun getDashboardData(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_Dashboard.endPoint,
            ReturnType.POST_Dashboard,
            postParams
        )
    }

    fun getWhatsNewAPI(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_WhatsNew.endPoint,
            ReturnType.POST_WhatsNew,
            postParams
        )
    }

    fun rejectOrder(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_ConfirmOrder.endPoint,
            ReturnType.POST_ConfirmOrder,
            postParams
        )
    }

    fun markAsReadDoc(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_OrderMarkDocReadReq.endPoint,
            ReturnType.POST_OrderMarkDocReadReq,
            postParams
        )
    }

    fun markAsReadRevision(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_Dashboard_MarkReadRevisionReq.endPoint,
            ReturnType.POST_Dashboard_MarkReadRevisionReq,
            postParams
        )
    }

    fun getOrderDetail(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_ManageOrderDetail.endPoint,
            ReturnType.POST_ManageOrderDetail,
            postParams
        )
    }
    fun addAppointment(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_AddAppointment.endPoint,
            ReturnType.POST_AddAppointment,
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
                ReturnType.POST_Dashboard -> {
                    val response = Gson().fromJson<DashboardResponseNew>(
                        response,
                        object : TypeToken<DashboardResponseNew>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    dashboardResponse.value = response
                }
                ReturnType.POST_WhatsNew -> {
                    val response = Gson().fromJson<WhatsNewResponse>(
                        response,
                        object : TypeToken<WhatsNewResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    whatsNewResponse.value = response
                }
                ReturnType.POST_ConfirmOrder -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    rejectOrderResponse.value = response
                }
                ReturnType.POST_OrderMarkDocReadReq -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    docMarkReadResponse.value = response
                }
                ReturnType.POST_Dashboard_MarkReadRevisionReq -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    revisionMarkReadResponse.value = response
                }
                ReturnType.POST_ManageOrderDetail -> {
                    val response = Gson().fromJson<ManageOrderResponse>(
                        response,
                        object : TypeToken<ManageOrderResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    manageOrderResponse.value = response
                }
                ReturnType.POST_AddAppointment -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    appointmentResponse.value = response
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
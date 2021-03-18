package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.LiveData
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
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.WhatsNewResponse
import com.sunteckindia.networking.ApiResponseCallBack

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
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    val dashboardData: LiveData<DashboardResponseNew>
        get() = dashboardResponse

    fun getDashboardData(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_Dashboard.endPoint, ReturnType.POST_Dashboard, postParams)
    }

    fun getWhatsNewAPI(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_WhatsNew.endPoint, ReturnType.POST_WhatsNew, postParams)
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_Dashboard -> {
                    val responseUsers = Gson().fromJson<DashboardResponseNew>(
                            response,
                            object : TypeToken<DashboardResponseNew>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    dashboardResponse.value = responseUsers
                }
                ReturnType.POST_WhatsNew -> {
                    val responseUsers = Gson().fromJson<WhatsNewResponse>(
                            response,
                            object : TypeToken<WhatsNewResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    whatsNewResponse.value = responseUsers
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
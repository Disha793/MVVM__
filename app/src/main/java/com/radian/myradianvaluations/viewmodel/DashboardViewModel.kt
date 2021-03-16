package com.radian.myradianvaluations.viewmodel


import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.DashboardRepository
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.DashboardResponseNew
import com.radian.vendorbridge.Response.WhatsNewResponse
import com.sunteckindia.networking.ApiResponseCallBack

class DashboardViewModel : ViewModel(), ApiResponseCallBack {
    private lateinit var dashboardRepository: DashboardRepository
    private var dashboardResponse = MutableLiveData<DashboardResponseNew>()
    private lateinit var context: Context
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    val dashboardData: LiveData<DashboardResponseNew>
        get() = dashboardResponse

    fun init(context: Context) {
        this.context = context
        dashboardRepository = DashboardRepository.getInstance(context)
    }

    fun getDashboardData(jsonObject: JsonObject) {


    }

    fun getWhatsNewAPI(): MutableLiveData<WhatsNewResponse> {
        return dashboardRepository.whatsNewAPI()
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            if (returnType == ReturnType.POST_Dashboard) {

                val responseUsers = Gson().fromJson<DashboardResponseNew>(
                    response,
                    object : TypeToken<DashboardResponseNew>() {}.type
                )
                LogUtils.logD("", "" + responseUsers.status)
                dashboardResponse?.value = responseUsers
            }
        } catch (e: Exception) {
            LogUtils.logE("", e)
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
    }

}
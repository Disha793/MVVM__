package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.repository.OrgInfoRepository
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.OrgInfoResponse
import com.sunteckindia.networking.ApiResponseCallBack

class HelpTroubleViewModel : ViewModel(), ApiResponseCallBack {
    lateinit var orgInfoRepository: OrgInfoRepository
    var helpTroubleResponse = MutableLiveData<OrgInfoResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    private lateinit var context: Context
    fun init(context: Context) {
        this.context = context
        orgInfoRepository = OrgInfoRepository.getInstance(context)
    }

    fun getInfo(): MutableLiveData<OrgInfoResponse>? {
        helpTroubleResponse = orgInfoRepository.getOrgInfoAPI()
        return helpTroubleResponse
    }

    fun getHelpTroubleData() {
        apiServiceProviderGeneric.getCall(
            context, ReturnType.GET_HELPTROUBLE.endPoint,
            ReturnType.GET_HELPTROUBLE
        )
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            if (returnType == ReturnType.GET_HELPTROUBLE) {
                val response = Gson().fromJson<OrgInfoResponse>(
                    response,
                    object : TypeToken<OrgInfoResponse>() {}.type
                )
                LogUtils.logD("", "" + response.status)
                helpTroubleResponse.value = response
            }
        } catch (e: Exception) {
            LogUtils.logE("", e)
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        LoadingDialog.dismissDialog()
        CommonUtils.showOkDialog(
            context,
            context.getString(R.string.please_try_again),
            DialogInterface.OnClickListener { _, _ -> },
            context.getString(R.string.ok)
        )
    }

}

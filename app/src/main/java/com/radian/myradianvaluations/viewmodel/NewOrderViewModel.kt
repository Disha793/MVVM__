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
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import com.radian.vendorbridge.Response.NewOrderResponse
import com.sunteckindia.networking.ApiResponseCallBack

class NewOrderViewModel : ViewModel(), ApiResponseCallBack {
    var newOrderResponse = MutableLiveData<NewOrderResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    private lateinit var context: Context

    fun init(context: Context) {
        this.context = context
    }


    fun getNewOrderList(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_NewOrderList.endPoint, ReturnType.POST_NewOrderList, postParams)

    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_NewOrderList -> {
                    val responseUsers = Gson().fromJson<NewOrderResponse>(
                            response,
                            object : TypeToken<NewOrderResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    newOrderResponse.value = responseUsers
                }
            }

        } catch (e: Exception) {

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
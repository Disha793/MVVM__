package com.radian.myradianvaluations.viewmodel

import android.app.Application
import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.*
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
class LoginViewModelFactory(private val context:Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            return LoginViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }

}
class LoginViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    private var mlLoginResponse = MutableLiveData<StatusResponse>()
    val userStatus: LiveData<StatusResponse>
        get() = mlLoginResponse




    fun getUserStatus(postParam: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCallWithoutHeader(
                context, ReturnType.POST_GetUserStatus.endPoint,
                postParam,
                ReturnType.POST_GetUserStatus
        )
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            if (returnType == ReturnType.POST_GetUserStatus) {
                val responseUsers = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                )
                LogUtils.logD("", "" + responseUsers.status)
                mlLoginResponse?.value = responseUsers
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
        )    }


}
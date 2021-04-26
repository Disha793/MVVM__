package com.radian.myradianvaluations.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.NewOrderResponse
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils

class PhotoUploadViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PhotoUploadViewModel::class.java)) {
            return PhotoUploadViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class PhotoUploadViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    var categoryResponse = MutableLiveData<PhotoUploadCategoryResponse>()

    fun getCategoryList(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_CATEGORY_LIST.endPoint,
            ReturnType.POST_CATEGORY_LIST,
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
                ReturnType.POST_CATEGORY_LIST -> {
                    val responseUsers = Gson().fromJson<PhotoUploadCategoryResponse>(
                        response,
                        object : TypeToken<PhotoUploadCategoryResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    categoryResponse.value = responseUsers
                }
            }

        } catch (e: Exception) {
            LogUtils.logE("", e)
        }
    }

    override fun onError(returnType: ReturnType, error: String) {
        TODO("Not yet implemented")
    }

}
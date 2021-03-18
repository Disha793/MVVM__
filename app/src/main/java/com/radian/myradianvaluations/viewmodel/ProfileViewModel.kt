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
import com.radian.vendorbridge.Response.ProfileResponse
import com.radian.vendorbridge.Response.StatusResponse
import com.radian.vendorbridge.Response.UploadImageResponse
import com.sunteckindia.networking.ApiResponseCallBack
import okhttp3.MultipartBody
import okhttp3.RequestBody
class ProfileViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class ProfileViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)
    var saveProfileResponse = MutableLiveData<StatusResponse>()
    var getProfileResponse = MutableLiveData<ProfileResponse>()
    var uploadImageResponse = MutableLiveData<UploadImageResponse>()
    
    fun saveProfileAPI(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_SaveProfile.endPoint, ReturnType.POST_SaveProfile, postParams)
    }

    fun getProfileAPI(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(context, ReturnType.POST_GetProfile.endPoint, ReturnType.POST_GetProfile, postParams)
    }

    fun uploadImage(file: MultipartBody.Part, fileName: RequestBody, postParams: HashMap<String, RequestBody>) {
        apiServiceProviderGeneric.multipartPostCall(context, ReturnType.POST_UploadImage.endPoint,file,fileName, ReturnType.POST_UploadImage, postParams)
    }

    override fun onPreExecute(returnType: ReturnType) {
        LoadingDialog.show(context)
    }

    override fun onSuccess(returnType: ReturnType, response: String) {
        LoadingDialog.dismissDialog()
        try {
            when (returnType) {
                ReturnType.POST_SaveProfile -> {
                    val response = Gson().fromJson<StatusResponse>(
                            response,
                            object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    saveProfileResponse.value = response
                }
                ReturnType.POST_GetProfile -> {
                    val response = Gson().fromJson<ProfileResponse>(
                            response,
                            object : TypeToken<ProfileResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    getProfileResponse.value = response
                }
                ReturnType.POST_UploadImage -> {
                    val response = Gson().fromJson<UploadImageResponse>(
                            response,
                            object : TypeToken<UploadImageResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    uploadImageResponse.value = response
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
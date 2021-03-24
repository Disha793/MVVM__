package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.LicenceMasterModel
import com.radian.myradianvaluations.Response.StatusResponse
import com.radian.myradianvaluations.Response.UploadImageResponse
import com.radian.myradianvaluations.Response.VendorProfileResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import okhttp3.MultipartBody
import okhttp3.RequestBody

class EODocViewModelFactory(private val context: Context) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EODocViewModel::class.java)) {
            return EODocViewModel(context) as T
        }
        throw IllegalArgumentException(context.resources.getString(R.string.unknown_viewmodel))
    }
}

class EODocViewModel(private val context: Context) : ViewModel(), ApiResponseCallBack {
    var uploadImageResponse = MutableLiveData<UploadImageResponse>()
    var vendorProfileResponse = MutableLiveData<VendorProfileResponse>()
    var licenceMasterResponse = MutableLiveData<LicenceMasterModel>()
    var saveLicenceResponse = MutableLiveData<StatusResponse>()
    var saveW9DataResponse = MutableLiveData<StatusResponse>()
    var saveEoDocResponse = MutableLiveData<StatusResponse>()
    private val apiServiceProviderGeneric = ApiServiceProviderGeneric(this)

    fun getVendorProfileDetails(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_VendorProfileDetail.endPoint,
            ReturnType.POST_VendorProfileDetail,
            postParams
        )
    }

    fun getLicenceMaster(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_LicenceMaster.endPoint,
            ReturnType.POST_LicenceMaster,
            postParams
        )
    }

    fun saveLicenceResponse(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_SaveLicence.endPoint,
            ReturnType.POST_SaveLicence,
            postParams
        )
    }

    fun saveW9DataResponse(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_SaveW9Data.endPoint,
            ReturnType.POST_SaveW9Data,
            postParams
        )
    }

    fun saveEoDateResponse(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_SaveEoDocData.endPoint,
            ReturnType.POST_SaveEoDocData,
            postParams
        )
    }

    fun uploadImage(
        file: MultipartBody.Part,
        fileName: RequestBody,
        postParams: HashMap<String, RequestBody>
    ) {
        apiServiceProviderGeneric.multipartPostCall(
            context,
            ReturnType.POST_UploadImage.endPoint,
            file,
            fileName,
            ReturnType.POST_UploadImage,
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
                ReturnType.POST_UploadImage -> {
                    val response = Gson().fromJson<UploadImageResponse>(
                        response,
                        object : TypeToken<UploadImageResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    uploadImageResponse.value = response
                }
                ReturnType.POST_VendorProfileDetail -> {
                    val response = Gson().fromJson<VendorProfileResponse>(
                        response,
                        object : TypeToken<VendorProfileResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    vendorProfileResponse.value = response
                }
                ReturnType.POST_LicenceMaster -> {
                    val response = Gson().fromJson<LicenceMasterModel>(
                        response,
                        object : TypeToken<LicenceMasterModel>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    licenceMasterResponse.value = response
                }
                ReturnType.POST_SaveLicence -> {
                    val response = Gson().fromJson<StatusResponse>(
                        response,
                        object : TypeToken<StatusResponse>() {}.type
                    )
                    LogUtils.logD("", "" + response.status)
                    saveLicenceResponse.value = response
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
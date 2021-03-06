package com.radian.myradianvaluations.viewmodel

import android.content.Context
import android.content.DialogInterface
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.radian.myradianvaluations.R
import com.radian.myradianvaluations.Response.DeletePhotosResponse
import com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse
import com.radian.myradianvaluations.Response.UploadImageResponse
import com.radian.myradianvaluations.networking.ApiResponseCallBack
import com.radian.myradianvaluations.networking.ApiServiceProviderGeneric
import com.radian.myradianvaluations.networking.ReturnType
import com.radian.myradianvaluations.utils.CommonUtils
import com.radian.myradianvaluations.utils.LoadingDialog
import com.radian.myradianvaluations.utils.LogUtils
import okhttp3.MultipartBody
import okhttp3.RequestBody

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
    var deletePhotosResponse = MutableLiveData<DeletePhotosResponse>()
    var uploadPhotosResponse = MutableLiveData<UploadImageResponse>()

    fun getCategoryList(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_CATEGORY_LIST.endPoint,
            ReturnType.POST_CATEGORY_LIST,
            postParams
        )
    }

    fun deletePhotos(postParams: HashMap<String, Any?>) {
        apiServiceProviderGeneric.postCall(
            context,
            ReturnType.POST_PHOTO_DELETE.endPoint,
            ReturnType.POST_PHOTO_DELETE,
            postParams
        )
    }
    fun uploadPhoto(
        file: ArrayList<MultipartBody.Part>,
        postParams: HashMap<String, RequestBody>
    ) {
        apiServiceProviderGeneric.multipartPostPhotoCall(
            context,
            ReturnType.POST_UPLOAD_PHOTO.endPoint,
            file,
            ReturnType.POST_UPLOAD_PHOTO,
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
                ReturnType.POST_PHOTO_DELETE->{
                    val responseUsers = Gson().fromJson<DeletePhotosResponse>(
                        response,
                        object : TypeToken<DeletePhotosResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    deletePhotosResponse.value = responseUsers
                }
                ReturnType.POST_UPLOAD_PHOTO->{
                    val responseUsers = Gson().fromJson<UploadImageResponse>(
                        response,
                        object : TypeToken<UploadImageResponse>() {}.type
                    )
                    LogUtils.logD("", "" + responseUsers.status)
                    uploadPhotosResponse.value = responseUsers
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
        )    }

}
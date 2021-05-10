package com.radian.myradianvaluations.Response

import com.google.gson.annotations.SerializedName

class PhotoUploadCategoryResponse {
    @SerializedName("Data")
    val data = ArrayList<Data>()

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    @SerializedName("Message")
    var message = ""

    class Data {
        @SerializedName("PhotoTypeId")
        var PhotoTypeId = 0

        @SerializedName("Text")
        var text = ""

        @SerializedName("IsSubject")
        var isSubject = 0

        @SerializedName("MobilePhotoList")
        var photoList = ArrayList<PhotoList>()

        var newPhotosId = ArrayList<String>()
    }
    class PhotoList {
        @SerializedName("DeleteUrl")
        var deleteUrl = ""

        @SerializedName("PhotoUrl")
        var photoUrl = ""

        @SerializedName("DocId")
        var docId = 0

        var timeStamp = 0L
        var lat = 0.0
        var long = 0.0
        var isFromDevice = false

    }
}
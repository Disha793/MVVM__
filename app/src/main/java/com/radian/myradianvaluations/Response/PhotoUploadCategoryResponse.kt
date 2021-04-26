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

        @SerializedName("DeleteUrl")
        var deleteUrl = ""

        @SerializedName("PhotoUrl")
        var photoUrl = ""

        @SerializedName("DocId")
        var docId = 0

        @SerializedName("timeStamp")
        var timeStamp = ""


        @SerializedName("lat")
        var lat = 0.0

        @SerializedName("long")
        var long = 0.0
        @SerializedName("isFromDevice")
        var isFromDevice = false

    }
}
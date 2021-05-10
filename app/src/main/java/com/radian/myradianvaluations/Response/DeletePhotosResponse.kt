package com.radian.myradianvaluations.Response

import com.google.gson.annotations.SerializedName

class DeletePhotosResponse {
    @SerializedName("Data")
    var data = Data()

    @SerializedName("Status")
    var status = ""

    @SerializedName("Message")
    var message = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    class Data {
        @SerializedName("Message ")
        var message = ""
    }
}
package com.radian.myradianvaluations.Response

import com.google.gson.annotations.SerializedName
import com.radian.myradianvaluations.Response.ErrorInfo

class UploadImageResponse {
    @SerializedName("Data")
    var data = ""
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
}
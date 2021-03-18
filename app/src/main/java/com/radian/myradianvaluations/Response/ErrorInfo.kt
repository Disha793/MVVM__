package com.radian.myradianvaluations.Response

import com.google.gson.annotations.SerializedName

class ErrorInfo {
    @SerializedName("ErrorMessage")
    var errorMessage: String = ""
    @SerializedName("ErrorCode")
    var errorCode: String = ""
}
package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class ErrorInfo {
    @SerializedName("ErrorMessage")
    var errorMessage: String = ""
    @SerializedName("ErrorCode")
    var errorCode: String = ""
}
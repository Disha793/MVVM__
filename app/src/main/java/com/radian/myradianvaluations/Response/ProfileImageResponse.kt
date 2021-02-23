package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class ProfileImageResponse {
    @SerializedName("Data")
    var data = ""
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
}
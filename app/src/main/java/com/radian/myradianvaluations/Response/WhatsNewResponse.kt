package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class WhatsNewResponse {
    @SerializedName("Data")
    val data = Data()
    @SerializedName("Status")
    val status: String = ""
    @SerializedName("ErrorInfo")
    val errorInfo = ArrayList<ErrorInfo>()

    class Data {
        @SerializedName("WhatsNew")
        val whatsnew: String = ""

    }
}
package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class OtpResponse() {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
    class Data {
        @SerializedName("OTP")
        var otp = ""
        @SerializedName("DeviceStatus")
        var deviceStatus = 0
    }
}
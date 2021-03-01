package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class StatusResponse {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()

    class Data {
        @SerializedName("DeviceStatusDetail")
        var deviceStatusResponse = DeviceStatusResponse()
        @SerializedName("Message")
        var message = ""

        class DeviceStatusResponse {
            @SerializedName("DeviceStatus")
            var deviceStaus: Int = 0
            @SerializedName("Message")
            var message: String = ""
        }
    }
}
package com.radian.vendorbridge.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrganizatnResponse {
    @SerializedName("Data")
    @Expose
    var data: Data? = null
    @SerializedName("Status")
    @Expose
    var status: String? = null
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()
    @SerializedName("Message")
    @Expose
    var message: Any? = null

    inner class Data {

        @SerializedName("ORGLIST")
        @Expose
        var orgList: List<ORGStatus>? = null

    }

    inner class ORGStatus {

        @SerializedName("ValuCode")
        @Expose
        var valuCode: String? = null
        @SerializedName("ValuName")
        @Expose
        var valuName: String? = null
        @SerializedName("ValueImage")
        @Expose
        var valueImage: Any? = null
        @SerializedName("ValueStatus")
        @Expose
        var valueStatus: String? = null

    }
}
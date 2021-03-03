package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName

class LicenceMasterModel() {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
    class Data {
        @SerializedName("NSTATUS")
        var listLicence = ArrayList<Licence>()

        class Licence {

            @SerializedName("ValuCode")
            var valueCode = ""
            @SerializedName("ValuName")
            var valueName = ""

            override fun toString(): String {

                return valueName
            }
        }
    }


}
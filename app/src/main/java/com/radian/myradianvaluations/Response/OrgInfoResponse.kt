package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class OrgInfoResponse {
    @SerializedName("Data")
    val data = Data()

    @SerializedName("Status")
    val status: String = ""

    @SerializedName("ErrorInfo")
    val errorInfo = ArrayList<ErrorInfo>()

    class Data {
        @SerializedName("ContactDetail")
        @Expose
        val contactDetail: ContactDetail? = null

        @SerializedName("ForgotPasswordURL")
        @Expose
        val forgotPasswordURL: String? = null

    }

    class ContactDetail {
        @SerializedName("JoinUsURL")
        @Expose
        val joinUsURL = ""

        @SerializedName("ContactNumber")
        @Expose
        val contactNumber = ""

        @SerializedName("Email")
        @Expose
        val email = ""

        @SerializedName("WorkingDays")
        @Expose
        val workingDays = ""

        @SerializedName("WorkingTime")
        @Expose
        val workingTime = ""
    }
}
package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class OrderListResponse() {
    @SerializedName("Data")
    @Expose
    val data = Data()

    class Data {
        @SerializedName("OrderList")
        val orderDetails = ArrayList<OrderDetail>()

        class OrderDetail() {
            @SerializedName("AppointmentDate")
            @Expose
            val appointmentDate: String? = null

            @SerializedName("OrderGenId")
            @Expose
            val orderGenId: String? = null

            @SerializedName("ItemId")
            @Expose
            val itemId: Int? = null

            @SerializedName("Status")
            @Expose
            val status: Any? = null

            @SerializedName("ItemNoteId")
            @Expose
            val itemNoteId: Int? = null

            @SerializedName("OrgId")
            @Expose
            val orgId: Int? = null

            @SerializedName("ProductName")
            @Expose
            val product: String? = null

            @SerializedName("AppointmentTime")
            @Expose
            val appointmentTime: String? = null

            @SerializedName("NotificationCount")
            @Expose
            val notificationCount: Int? = null

            @SerializedName("DisplayAddressInfo")
            @Expose
            val displayAddInfo: String? = null

            @SerializedName("Message")
            @Expose
            val message: String? = null
        }

    }

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()
}
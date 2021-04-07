package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class NewOrderResponse {
    @SerializedName("Data")
    @Expose
    val mdata: Data? = null

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    public class Data {
        @SerializedName("OrderList")
        @Expose
        val orderList: List<OrderResponse>? = null

        class OrderResponse {
            @SerializedName("OrderGenId")
            val orderGenId = ""

            @SerializedName("ItemId")
            val itemId = 0

            @SerializedName("OrgId")
            val orgId = 0

            @SerializedName("DisplayAddressInfo")
            val displayAddressInfor = ""

            @SerializedName("Product")
            val product = ""

            @SerializedName("ProductName")
            val productName = ""

            @SerializedName("StartTimeSlot")
            val startTimeSlot = ""

            @SerializedName("EndTimeSlot")
            val endTimeSlot = ""

            @SerializedName("AppointmentDate")
            val appointmentDate = ""

            @SerializedName("Message")
            @Expose
            var message = ""

            @SerializedName("ProductDueDate")
            @Expose
            var dueDate = ""

            @SerializedName("IsAssigned")
            @Expose
            var isAssigned = 0
        }
    }
}
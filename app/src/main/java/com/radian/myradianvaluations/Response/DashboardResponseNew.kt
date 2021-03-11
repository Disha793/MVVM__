package com.radian.vendorbridge.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class DashboardResponseNew {
    @SerializedName("Data")
    var data = Data()

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    class Data {
        @SerializedName("DashboardTilesList")
        var dashboardTileList: ArrayList<DashboardTileList>? = null

        @SerializedName("ProfilePicURL")
        @Expose
        var profileImageUrl: String? = ""

        @SerializedName("RewardPoints")
        @Expose
        var rewardsPonits = 0

        @SerializedName("IsUpdateAndroid")
        @Expose
        var isUpdateAndroid = false

        @SerializedName("ProfilePicStatus")
        @Expose
        var profilePicStatus:String? = ""

        @SerializedName("UpComingEventInfo")
        @Expose
        var upcomingAppointment = UpcomingAppointmnt()

        @SerializedName("Name")
        @Expose
        var name: String? = null

        @SerializedName("NewOrderCount")
        @Expose
        var newOrderCount: Int? = null

        @SerializedName("OrderCount")
        @Expose
        var orderCount: Int? = null

        @SerializedName("NotificationCount")
        @Expose
        var notificatnCount: Int? = null


        class DashboardTileList {
            @SerializedName("OrderGenId")
            @Expose
            val orderGenId: String? = null

            @SerializedName("ItemId")
            @Expose
            val itemId: Int? = null

            @SerializedName("UserId")
            @Expose
            val userId: Int? = null

            @SerializedName("ItemNoteId")
            @Expose
            val itemNoteId: Int? = null

            @SerializedName("OrgId")
            @Expose
            val orgId: Int? = null

            @SerializedName("Abbr")
            @Expose
            val abbr: String? = null

            @SerializedName("DisplayAddressInfo")
            @Expose
            val displayAddressInfo: String? = null

            @SerializedName("ProductName")
            @Expose
            val product: String? = null

            @SerializedName("StartTimeSlot")
            @Expose
            val startTimeSlot: String? = null

            @SerializedName("EndTimeSlot")
            @Expose
            val endTimeSlot: String? = null

            @SerializedName("AppointmentDate")
            @Expose
            val appointmentDate: String? = null

            @SerializedName("OrderDate")
            @Expose
            val orderDate: String? = null

            @SerializedName("Message")
            @Expose
            val message: String? = null

            @SerializedName("Documentname")
            @Expose
            val documentname: String? = null

            @SerializedName("DocumentId")
            @Expose
            val documentId: Any? = null

            @SerializedName("AppointmentTime")
            @Expose
            val appointmentTime: Any? = null

            @SerializedName("DocumentURL")
            @Expose
            val documentURL: Any? = null

            @SerializedName("ServiceRequestType")
            @Expose
            val serviceRequestType: Int? = null

            @SerializedName("ItemSrNo")
            @Expose
            val itemSrNo: Int? = null

            @SerializedName("RevisionRequest")
            @Expose
            val revisionRequest: String? = null
            @SerializedName("IsAssigned")
            @Expose
            var isAssigned=0
        }

        class UpcomingAppointmnt {

            @SerializedName("AppointmentTime")
            @Expose
            val appointmentTime: String? = null

            @SerializedName("Address")
            @Expose
            val address: String? = null

            @SerializedName("ItemId")
            @Expose
            val itemId: String? = null

            @SerializedName("OrgId")
            @Expose
            val orgId: String? = null

            @SerializedName("OrderGenId")
            @Expose
            val orderGenId: String? = null

        }
    }
}
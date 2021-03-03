package com.radian.vendorbridge.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class NotificationResponse {

    @SerializedName("Data")
    @Expose
    var data: Datum? = null
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()
}

class Datum {
    @SerializedName("NotificationList")
    var notificationList = ArrayList<NotificationList>()


    class NotificationList {
        @SerializedName("MobileNotificationId")
        @Expose
         var mobileNotificationId=0
        @SerializedName("EntityId")
        @Expose
        private val entityId: Int? = null
        @SerializedName("EntityType")
        @Expose
        private val entityType: Int? = null
        @SerializedName("PushNotificationId")
        @Expose
        private val pushNotificationId: Int? = null
        @SerializedName("OrderGenId")
        @Expose
         val orderGenId: String? = null
        @SerializedName("ItemId")
        @Expose
         val itemId: Int? = null
        @SerializedName("Title")
        @Expose
         val title: String? = null
        @SerializedName("Body")
        @Expose
         val body: String? = null
        @SerializedName("Status")
        @Expose
        private val status: Any? = null
        @SerializedName("NotificationReadFlag")
        @Expose
         var notificationReadFlag: String? = null
        @SerializedName("NotificationReadUserId")
        @Expose
        private val notificationReadUserId: Int? = null
        @SerializedName("NotificationReadDate")
        @Expose
        private val notificationReadDate: Any? = null
        @SerializedName("NotificationCreateDate")
        @Expose
         val notificationCreateDate: String? = null
        @SerializedName("UserId")
        @Expose
         val userId: Int? = null
        @SerializedName("Abbr")
        @Expose
         val abbr: String? = null
        @SerializedName("NotificationReadUserName")
        @Expose
        private val notificationReadUserName: Any? = null
        @SerializedName("OrderCount")
        @Expose
         val orderCount: Int? = null
        @SerializedName("ServiceRequestType")
        @Expose
         val serviceRequestType: String? = null
        @SerializedName("ItemSrNo")
        @Expose
         val itemSrNo: Int? = null
        @SerializedName("OrganizationId")
        @Expose
        private val organizationId: Int? = null



    }
}
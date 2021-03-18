package com.radian.myradianvaluations

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.radian.myradianvaluations.Response.ErrorInfo

class DashboadResponse {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""

    @SerializedName("Message")
    var message: String = ""

    @SerializedName("ErrorInfo")
    var errorInfo=ArrayList<ErrorInfo>()
    class DashboardOutOfOfficeInfo {

        @SerializedName("OnVacation")
        @Expose
        var onVacation: Boolean? = null
        @SerializedName("StartDate")
        @Expose
        var startDate: String? = null
        @SerializedName("EndDate")
        @Expose
        var endDate: String? = null
        @SerializedName("Note")
        @Expose
        var note: Any? = null

    }

    class DashboardTilesList {

        @SerializedName("TileId")
        @Expose
        var tileId: Int? = null
        @SerializedName("Abbr")
        @Expose
        var abbr: String? = null
        @SerializedName("DisplayName")
        @Expose
        var displayName: String? = null
        @SerializedName("Priority")
        @Expose
        var priority: Int? = null
        @SerializedName("TileCount")
        @Expose
        var tileCount: Int? = null
        @SerializedName("Sequence")
        @Expose
        var sequence: Int? = null
        @SerializedName("Color")
        @Expose
        var color: Any? = null

    }

    class Data {

        @SerializedName("DashboardOutOfOfficeInfo")
        @Expose
        var dashboardOutOfOfficeInfo: DashboardOutOfOfficeInfo? = null
        @SerializedName("DashboardTilesList")
        @Expose
        var dashboardTilesList: ArrayList<DashboardTilesList>? = null
        @SerializedName("Name")
        @Expose
        var name: String? = null
        @SerializedName("ProfilePicURL")
        @Expose
        var profileImageUrl:String?=""
        @SerializedName("RewardPoints")
        @Expose
        var rewardsPonits=0
        @SerializedName("IsUpdateAndroid")
        @Expose
        var isUpdateAndroid=false
        @SerializedName("ProfilePicStatus")
        @Expose
        var profilePicStatus=""
        @SerializedName("UpComingEventInfo")
        @Expose
        var upcomingAppointment=UpcomingAppointmnt()

    }
    class  UpcomingAppointmnt{

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
        private val orderGenId: String? = null

    }
}

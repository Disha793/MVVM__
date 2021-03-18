package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class RewardsResponse {
    @SerializedName("Data")
    @Expose
    lateinit var data: Data
    @SerializedName("Status")
    @Expose
    var status: String = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()
    @SerializedName("Message")
    @Expose
    var message = null

    public class Data {

        @SerializedName("Badge")
        @Expose
        var badge:String? = null
        @SerializedName("Points")
        @Expose
        var points = 0
        @SerializedName("Summary")
        @Expose
        lateinit var summary: List<Summary>
    }

    public class Summary {

        @SerializedName("Points")
        @Expose
         var points : Int? = null
        @SerializedName("Date")
        @Expose
        var date :String?= null
        @SerializedName("Task")
        @Expose
        var task:String? = null
    }
}
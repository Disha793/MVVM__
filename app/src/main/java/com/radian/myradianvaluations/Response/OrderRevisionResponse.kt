package com.radian.myradianvaluations.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



class OrderRevisionResponse{

    @SerializedName("Data")
    @Expose
    var data: Data? = null
    @SerializedName("Status")
    @Expose
    var status: String? = null
    @SerializedName("ErrorInfo")
    @Expose
    var errorInfo= ArrayList<ErrorInfo>()
    inner class Data {

        @SerializedName("TileOrderRevision")
        @Expose
        var tileOrderRevision: List<TileOrderRevision>? = null
        @SerializedName("orderdetail")
        @Expose
        var orderDetail:OrderDetailResponse.Orderdetail?=null

    }
    inner class TileOrderRevision {

        @SerializedName("CreatedDate")
        @Expose
        var createdDate: Any? = null
        @SerializedName("CreatedUserName")
        @Expose
        var createdUserName: Any? = null
        @SerializedName("Note")
        @Expose
        var note: Any? = null
        @SerializedName("ProductName")
        @Expose
        var productName: Any? = null
        @SerializedName("DocumentId")
        @Expose
        var documentId: Int? = null
        @SerializedName("DocumentName")
        @Expose
        var documentName: Any? = null
        @SerializedName("ActionFlag")
        @Expose
        var actionFlag: Any? = null
        @SerializedName("UserId")
        @Expose
        var userId: Int? = null
        @SerializedName("SRNo")
        @Expose
        var sRNo: String? = null
        @SerializedName("RejectReason")
        @Expose
        var rejectReason: String? = null
        @SerializedName("RejectNote")
        @Expose
        var rejectNote: String? = null
        @SerializedName("RejectDate")
        @Expose
        var rejectDate: String? = null

    }
}
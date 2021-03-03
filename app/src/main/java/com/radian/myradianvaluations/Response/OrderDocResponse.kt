package com.radian.vendorbridge.Response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class OrderDocResponse {
    @SerializedName("Data")
    @Expose
    var data: Data? = null

    @SerializedName("Status")
    var status = ""

    @SerializedName("ErrorInfo")
    @Expose
    var errorInfo = ArrayList<ErrorInfo>()

    class Data {

        @SerializedName("TileOrderDocuments")
        @Expose
        var tileorderdetails: List<TileOrder>? = null

        @SerializedName("orderdetail")
        @Expose
        var orderDetail: OrderDetailResponse.Orderdetail? = null


    }

    class TileOrder {
        @SerializedName("CreatedDate")
        @Expose
        var createdDate: String? = null

        @SerializedName("CreatedUserName")
        @Expose
        var createdUserName: String? = null

        @SerializedName("Note")
        @Expose
        var note: Any? = null

        @SerializedName("ProductName")
        @Expose
        var productName: String? = null

        @SerializedName("DocumentId")
        @Expose
        var documentId: Int? = null

        @SerializedName("DocumentName")
        @Expose
        var documentName: String? = null

        @SerializedName("ActionFlag")
        @Expose
        var actionFlag: Any? = null

        @SerializedName("UserId")
        @Expose
        var userId: Int? = null

        @SerializedName("SRNo")
        @Expose
        var sRNo: Any? = null

        @SerializedName("RejectReason")
        @Expose
        var rejectReason: Any? = null

        @SerializedName("RejectNote")
        @Expose
        var rejectNote: Any? = null

        @SerializedName("RejectDate")
        @Expose
        var rejectDate: Any? = null

        @SerializedName("DocumentType")
        @Expose
        var documentType: String = ""

        @SerializedName("IsNewDocument")
        @Expose
        var isNewDocument: Int = 0
    }
}
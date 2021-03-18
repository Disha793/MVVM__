package com.radian.myradianvaluations.Response

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class SearchFilterResponse() : Parcelable {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    constructor(parcel: Parcel) : this() {
        this.data = parcel.readParcelable(Data::class.java.classLoader)!!
    }

    class Data() : Parcelable {
        @SerializedName("OrderList")
        var orderList = OrderList()

        constructor(parcel: Parcel) : this() {
            orderList = parcel.readParcelable(OrderList::class.java.classLoader)!!
        }

        class OrderList() : Parcelable {
            @SerializedName("O_LATE")
            var lateList = ArrayList<Order>()
            @SerializedName("O_OPEN")
            var openList = ArrayList<Order>()
            @SerializedName("O_RR")
            var revisionList = ArrayList<Order>()
            @SerializedName("N_MESSAGE")
            var messageList = ArrayList<Order>()
            @SerializedName("N_DOCUMENT")
            var docList = ArrayList<Order>()
            @SerializedName("O_CONFIRM")
            var acceptList = ArrayList<Order>()
            @SerializedName("O_INSP")
            var inspectionList = ArrayList<Order>()

            constructor(parcel: Parcel) : this() {
                lateList = parcel.readArrayList(Order::class.java.classLoader) as ArrayList<Order>
                openList = parcel.readArrayList(Order::class.java.classLoader) as ArrayList<Order>
                revisionList =
                    parcel.readArrayList(Order::class.java.classLoader) as ArrayList<Order>
            }

            class Order() : Parcelable {
                @SerializedName("OrderGenId")
                @Expose
                var orderGenId: String? = null
                @SerializedName("ItemId")
                @Expose
                var itemId: Int? = null
                @SerializedName("UserId")
                @Expose
                var userId: Int? = null
                @SerializedName("ItemNoteId")
                @Expose
                var itemNoteId: Int? = null
                @SerializedName("OrgId")
                @Expose
                var orgId: Int? = null
                @SerializedName("DiplayBorrowerInfo")
                @Expose
                var displayBorrowerInfo: String? = null
                @SerializedName("DisplayAddressInfo")
                @Expose
                var displayAddressInfo: String? = null
                @SerializedName("DisplayLoanInfo")
                @Expose
                var displayLoanInfo: String? = null
                @SerializedName("FHA")
                @Expose
                var fHA: Any? = null
                @SerializedName("Product")
                @Expose
                var product: String? = null
                @SerializedName("AppointmentTime")
                @Expose
                var appointmentTime: Any? = null
                @SerializedName("Message")
                @Expose
                var message: String? = null
                @SerializedName("DueDate")
                @Expose
                var dueDate: String? = null
                @SerializedName("Status")
                @Expose
                var status: String? = null
                @SerializedName("DocumentId")
                @Expose
                var documentId: Int? = null
                @SerializedName("DocumentName")
                @Expose
                var documentName: Any? = null
                @SerializedName("TileAbbr")
                @Expose
                var tileAbbr: String? = null
                @SerializedName("ClientName")
                @Expose
                var clientName: String? = null
                @SerializedName("ClientPhone")
                @Expose
                var clientPhone: Any? = null
                @SerializedName("ClientEmail")
                @Expose
                var clientEmail: Any? = null
                @SerializedName("DocumentURL")
                @Expose
                var documentURL: Any? = null
                @SerializedName("ServiceRequestType")
                @Expose
                var serviceRequestType: Int? = null
                @SerializedName("PaymentRequired")
                @Expose
                var paymentRequired: Any? = null
                @SerializedName("PaymentAmount")
                @Expose
                var paymentAmount: Int? = null
                @SerializedName("CondAcceptance")
                @Expose
                var condAcceptance: Any? = null
                @SerializedName("ItemSrNo")
                @Expose
                var itemSrNo: Int? = null
                @SerializedName("Lat")
                @Expose
                var lat: String? = null
                @SerializedName("Lng")
                @Expose
                var lng: String? = null
                @SerializedName("PropertyDirection")
                @Expose
                var propertyDirection: String = ""
                @SerializedName("Preference1")
                @Expose
                var preference1 = ""
                @SerializedName("AppraiserMessage")
                @Expose
                var appraiserMessage: String? = null
                @SerializedName("ProfileFee")
                @Expose
                var profileFee: String? = null
                @SerializedName("StartTimeSlot")
                @Expose
                var startTimeSlot: String? = null
                @SerializedName("EndTimeSlot")
                @Expose
                var endTimeSlot: String? = null
                @SerializedName("IsAssigned")
                @Expose
                var isAssigned = ""
                @SerializedName("BorrowerPhone")
                @Expose
                var borrowerPhone: String? = null
                @SerializedName("BorrowerEmail")
                @Expose
                var borrowerEmail: String? = null
                @SerializedName("BorrowerName")
                @Expose
                var borrowerName: String? = null
                var tag: String = "0"
                var conditionalDate: String = ""
                var conditionalPrice: String = ""
                var conditionalNote: String = ""


                constructor(parcel: Parcel) : this() {
                    orderGenId = parcel.readString()
                    itemId = parcel.readValue(Int::class.java.classLoader) as? Int
                    userId = parcel.readValue(Int::class.java.classLoader) as? Int
                    itemNoteId = parcel.readValue(Int::class.java.classLoader) as? Int
                    orgId = parcel.readValue(Int::class.java.classLoader) as? Int
                    displayBorrowerInfo = parcel.readString()
                    displayAddressInfo = parcel.readString()
                    displayLoanInfo = parcel.readString()
                    product = parcel.readString()
                    message = parcel.readString()
                    dueDate = parcel.readString()
                    status = parcel.readString()
                    tileAbbr = parcel.readString()
                    clientName = parcel.readString()
                    serviceRequestType = parcel.readValue(Int::class.java.classLoader) as? Int
                    paymentAmount = parcel.readValue(Int::class.java.classLoader) as? Int
                    itemSrNo = parcel.readValue(Int::class.java.classLoader) as? Int
                    lat = parcel.readValue(Int::class.java.classLoader) as? String
                    lng = parcel.readValue(Int::class.java.classLoader) as? String
                    borrowerPhone=parcel.readString()
                    borrowerEmail=parcel.readString()
                    borrowerName=parcel.readString()
                }

                override fun writeToParcel(parcel: Parcel, flags: Int) {
                    parcel.writeString(orderGenId)
                    parcel.writeValue(itemId)
                    parcel.writeValue(userId)
                    parcel.writeValue(itemNoteId)
                    parcel.writeValue(orgId)
                    parcel.writeString(displayBorrowerInfo)
                    parcel.writeString(displayAddressInfo)
                    parcel.writeString(displayLoanInfo)
                    parcel.writeString(product)
                    parcel.writeString(message)
                    parcel.writeString(dueDate)
                    parcel.writeString(status)
                    parcel.writeString(tileAbbr)
                    parcel.writeString(clientName)
                    parcel.writeValue(serviceRequestType)
                    parcel.writeValue(paymentAmount)
                    parcel.writeValue(itemSrNo)
                    parcel.writeValue(lat)
                    parcel.writeValue(lng)
                    parcel.writeString(borrowerPhone)
                    parcel.writeString(borrowerEmail)
                    parcel.writeString(borrowerName)
                }

                override fun describeContents(): Int {
                    return 0
                }

                companion object CREATOR : Parcelable.Creator<Order> {
                    override fun createFromParcel(parcel: Parcel): Order {
                        return Order(parcel)
                    }

                    override fun newArray(size: Int): Array<Order?> {
                        return arrayOfNulls(size)
                    }
                }

            }

            override fun writeToParcel(parcel: Parcel, flags: Int) {
                parcel.writeList(lateList as List<*>?)
                parcel.writeList(openList as List<*>?)
                parcel.writeList(revisionList as List<*>?)
            }

            override fun describeContents(): Int {
                return 0
            }

            companion object CREATOR : Parcelable.Creator<OrderList> {
                override fun createFromParcel(parcel: Parcel): OrderList {
                    return OrderList(parcel)
                }

                override fun newArray(size: Int): Array<OrderList?> {
                    return arrayOfNulls(size)
                }
            }
        }

        override fun writeToParcel(parcel: Parcel, flags: Int) {
            parcel.writeParcelable(orderList, flags)
        }

        override fun describeContents(): Int {
            return 0
        }

        companion object CREATOR : Parcelable.Creator<Data> {
            override fun createFromParcel(parcel: Parcel): Data {
                return Data(parcel)
            }

            override fun newArray(size: Int): Array<Data?> {
                return arrayOfNulls(size)
            }
        }
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(data, flags)

    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SearchFilterResponse> {
        override fun createFromParcel(parcel: Parcel): SearchFilterResponse {
            return SearchFilterResponse(parcel)
        }

        override fun newArray(size: Int): Array<SearchFilterResponse?> {
            return arrayOfNulls(size)
        }
    }
}
package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data;", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class NewOrderDetailResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private final com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data data = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> getErrorInfo() {
        return null;
    }
    
    public final void setErrorInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> p0) {
    }
    
    public NewOrderDetailResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\b"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data;", "", "()V", "orderDetail", "Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail;", "getOrderDetail", "()Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail;", "OrderDetail", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OrderDetail")
        private final com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail orderDetail = null;
        
        @org.jetbrains.annotations.Nullable()
        public final com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail getOrderDetail() {
            return null;
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b>\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 ^2\u00020\u0001:\u0001^B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010Z\u001a\u00020\u001dH\u0016J\u0018\u0010[\u001a\u00020\\2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010]\u001a\u00020\u001dH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR2\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\rj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\t\"\u0004\b\u0015\u0010\u000bR\u001e\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\t\"\u0004\b\u0018\u0010\u000bR\u001e\u0010\u0019\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\t\"\u0004\b\u001b\u0010\u000bR\u001e\u0010\u001c\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\t\"\u0004\b$\u0010\u000bR\u001e\u0010%\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b\'\u0010\u000bR\u001e\u0010(\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\t\"\u0004\b*\u0010\u000bR\u001e\u0010+\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u001f\"\u0004\b,\u0010!R\u001e\u0010-\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001f\"\u0004\b/\u0010!R\u001e\u00100\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u001f\"\u0004\b2\u0010!R\u001e\u00103\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\t\"\u0004\b5\u0010\u000bR\u001e\u00106\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR\u001e\u00109\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\t\"\u0004\b;\u0010\u000bR\u001e\u0010<\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR\u001e\u0010?\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR\u001e\u0010B\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u001f\"\u0004\bD\u0010!R\u001e\u0010E\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\t\"\u0004\bG\u0010\u000bR\u001e\u0010H\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\t\"\u0004\bJ\u0010\u000bR\u001e\u0010K\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\t\"\u0004\bM\u0010\u000bR\u001e\u0010N\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\t\"\u0004\bP\u0010\u000bR\u001e\u0010Q\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u001f\"\u0004\bS\u0010!R\u001e\u0010T\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\t\"\u0004\bV\u0010\u000bR\u001e\u0010W\u001a\u00020\u001d8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u001f\"\u0004\bY\u0010!\u00a8\u0006_"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appointmentDate", "", "getAppointmentDate", "()Ljava/lang/String;", "setAppointmentDate", "(Ljava/lang/String;)V", "appointmentTimedetails", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getAppointmentTimedetails", "()Ljava/util/ArrayList;", "setAppointmentTimedetails", "(Ljava/util/ArrayList;)V", "borrowerEmail", "getBorrowerEmail", "setBorrowerEmail", "borrowerName", "getBorrowerName", "setBorrowerName", "borrowerPhone", "getBorrowerPhone", "setBorrowerPhone", "broadcastcount", "", "getBroadcastcount", "()I", "setBroadcastcount", "(I)V", "clientName", "getClientName", "setClientName", "displayAddressInfo", "getDisplayAddressInfo", "setDisplayAddressInfo", "endTimeSlot", "getEndTimeSlot", "setEndTimeSlot", "isAssigned", "setAssigned", "itemId", "getItemId", "setItemId", "itemSrNo", "getItemSrNo", "setItemSrNo", "lat", "getLat", "setLat", "lng", "getLng", "setLng", "lockbox", "getLockbox", "setLockbox", "message", "getMessage", "setMessage", "orderGenId", "getOrderGenId", "setOrderGenId", "orgId", "getOrgId", "setOrgId", "paymentAmount", "getPaymentAmount", "setPaymentAmount", "product", "getProduct", "setProduct", "productDueDate", "getProductDueDate", "setProductDueDate", "productName", "getProductName", "setProductName", "serviceRequestType", "getServiceRequestType", "setServiceRequestType", "startTimeSlot", "getStartTimeSlot", "setStartTimeSlot", "userId", "getUserId", "setUserId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
        public static final class OrderDetail implements android.os.Parcelable {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderGenId")
            private java.lang.String orderGenId = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemId")
            private int itemId = 0;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrgId")
            private int orgId = 0;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
            private java.lang.String displayAddressInfo = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Product")
            private java.lang.String product = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductName")
            private java.lang.String productName = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lockbox")
            private java.lang.String lockbox = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerPhone")
            private java.lang.String borrowerPhone = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerName")
            private java.lang.String borrowerName = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerEmail")
            private java.lang.String borrowerEmail = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "StartTimeSlot")
            private java.lang.String startTimeSlot = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "EndTimeSlot")
            private java.lang.String endTimeSlot = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
            private java.lang.String appointmentDate = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lat")
            private java.lang.String lat = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lng")
            private java.lang.String lng = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "UserId")
            private int userId = 0;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
            private int itemSrNo = 0;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductDueDate")
            private java.lang.String productDueDate = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ServiceRequestType")
            private int serviceRequestType = 0;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ClientName")
            private java.lang.String clientName = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "PaymentAmount")
            private java.lang.String paymentAmount = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Broadcastcount")
            private int broadcastcount = 0;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentTimedetails")
            private java.util.ArrayList<java.lang.String> appointmentTimedetails;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Message")
            private java.lang.String message = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "IsAssigned")
            private int isAssigned = 0;
            public static final com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail.CREATOR CREATOR = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            public final void setOrderGenId(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int getItemId() {
                return 0;
            }
            
            public final void setItemId(int p0) {
            }
            
            public final int getOrgId() {
                return 0;
            }
            
            public final void setOrgId(int p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getDisplayAddressInfo() {
                return null;
            }
            
            public final void setDisplayAddressInfo(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProduct() {
                return null;
            }
            
            public final void setProduct(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProductName() {
                return null;
            }
            
            public final void setProductName(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getLockbox() {
                return null;
            }
            
            public final void setLockbox(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getBorrowerPhone() {
                return null;
            }
            
            public final void setBorrowerPhone(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getBorrowerName() {
                return null;
            }
            
            public final void setBorrowerName(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getBorrowerEmail() {
                return null;
            }
            
            public final void setBorrowerEmail(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getStartTimeSlot() {
                return null;
            }
            
            public final void setStartTimeSlot(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getEndTimeSlot() {
                return null;
            }
            
            public final void setEndTimeSlot(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getAppointmentDate() {
                return null;
            }
            
            public final void setAppointmentDate(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getLat() {
                return null;
            }
            
            public final void setLat(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getLng() {
                return null;
            }
            
            public final void setLng(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int getUserId() {
                return 0;
            }
            
            public final void setUserId(int p0) {
            }
            
            public final int getItemSrNo() {
                return 0;
            }
            
            public final void setItemSrNo(int p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProductDueDate() {
                return null;
            }
            
            public final void setProductDueDate(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int getServiceRequestType() {
                return 0;
            }
            
            public final void setServiceRequestType(int p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getClientName() {
                return null;
            }
            
            public final void setClientName(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getPaymentAmount() {
                return null;
            }
            
            public final void setPaymentAmount(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int getBroadcastcount() {
                return 0;
            }
            
            public final void setBroadcastcount(int p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.util.ArrayList<java.lang.String> getAppointmentTimedetails() {
                return null;
            }
            
            public final void setAppointmentTimedetails(@org.jetbrains.annotations.Nullable()
            java.util.ArrayList<java.lang.String> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            public final void setMessage(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int isAssigned() {
                return 0;
            }
            
            public final void setAssigned(int p0) {
            }
            
            @java.lang.Override()
            public void writeToParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel, int flags) {
            }
            
            @java.lang.Override()
            public int describeContents() {
                return 0;
            }
            
            public OrderDetail() {
                super();
            }
            
            public OrderDetail(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                super();
            }
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/NewOrderDetailResponse$Data$OrderDetail;", "app_DevDebug"})
            public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail> {
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail createFromParcel(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.NewOrderDetailResponse.Data.OrderDetail[] newArray(int size) {
                    return null;
                }
                
                private CREATOR() {
                    super();
                }
            }
        }
    }
}
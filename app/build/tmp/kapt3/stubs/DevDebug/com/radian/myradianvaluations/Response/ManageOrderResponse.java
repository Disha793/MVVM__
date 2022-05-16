package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/Response/ManageOrderResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class ManageOrderResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.ManageOrderResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.ManageOrderResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.Response.ManageOrderResponse.Data p0) {
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
    
    public ManageOrderResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\tB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\n"}, d2 = {"Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data;", "", "()V", "orderDetail", "Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;", "getOrderDetail", "()Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;", "setOrderDetail", "(Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;)V", "OrderDetail", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "OrderDetail")
        private com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail orderDetail;
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail getOrderDetail() {
            return null;
        }
        
        public final void setOrderDetail(@org.jetbrains.annotations.NotNull()
        com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail p0) {
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\bE\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 {2\u00020\u0001:\u0001{B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010w\u001a\u000203H\u0016J\u0018\u0010x\u001a\u00020y2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010z\u001a\u000203H\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR \u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR \u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR \u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR \u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR \u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR \u0010\'\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR\"\u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010/\u001a\u0004\b*\u0010,\"\u0004\b-\u0010.R\"\u00100\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010/\u001a\u0004\b0\u0010,\"\u0004\b1\u0010.R\"\u00102\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\"\u00109\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\b:\u00105\"\u0004\b;\u00107R \u0010<\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\t\"\u0004\b>\u0010\u000bR \u0010?\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\t\"\u0004\bA\u0010\u000bR \u0010B\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\t\"\u0004\bD\u0010\u000bR\"\u0010E\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\bF\u00105\"\u0004\bG\u00107R\u001e\u0010H\u001a\u00020+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR\"\u0010M\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\bN\u00105\"\u0004\bO\u00107R\u001e\u0010P\u001a\u00020+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bQ\u0010J\"\u0004\bR\u0010LR\"\u0010S\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\bT\u00105\"\u0004\bU\u00107R\u001e\u0010V\u001a\u00020+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bW\u0010J\"\u0004\bX\u0010LR \u0010Y\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010\t\"\u0004\b[\u0010\u000bR \u0010\\\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b]\u0010\t\"\u0004\b^\u0010\u000bR\"\u0010_\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\b`\u00105\"\u0004\ba\u00107R \u0010b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bc\u0010\t\"\u0004\bd\u0010\u000bR \u0010e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bf\u0010\t\"\u0004\bg\u0010\u000bR \u0010h\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bi\u0010\t\"\u0004\bj\u0010\u000bR \u0010k\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bl\u0010\t\"\u0004\bm\u0010\u000bR \u0010n\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bo\u0010\t\"\u0004\bp\u0010\u000bR\"\u0010q\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\br\u00105\"\u0004\bs\u00107R\"\u0010t\u001a\u0004\u0018\u0001038\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u00108\u001a\u0004\bu\u00105\"\u0004\bv\u00107\u00a8\u0006|"}, d2 = {"Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appointmentDate", "", "getAppointmentDate", "()Ljava/lang/String;", "setAppointmentDate", "(Ljava/lang/String;)V", "appointmentStatus", "getAppointmentStatus", "setAppointmentStatus", "appointmentTime", "getAppointmentTime", "setAppointmentTime", "borrowerEmail", "getBorrowerEmail", "setBorrowerEmail", "borrowerName", "getBorrowerName", "setBorrowerName", "borrowerPhone", "getBorrowerPhone", "setBorrowerPhone", "clientName", "getClientName", "setClientName", "displayAddressInfo", "getDisplayAddressInfo", "setDisplayAddressInfo", "displayLoanInfo", "getDisplayLoanInfo", "setDisplayLoanInfo", "dueDate", "getDueDate", "setDueDate", "inspectionComplete", "getInspectionComplete", "setInspectionComplete", "isComplete", "", "()Ljava/lang/Boolean;", "setComplete", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "isNotify", "setNotify", "itemId", "", "getItemId", "()Ljava/lang/Integer;", "setItemId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "itemSrNo", "getItemSrNo", "setItemSrNo", "lat", "getLat", "setLat", "lng", "getLng", "setLng", "lockbox", "getLockbox", "setLockbox", "newDocumentCount", "getNewDocumentCount", "setNewDocumentCount", "newDocumentFlag", "getNewDocumentFlag", "()Z", "setNewDocumentFlag", "(Z)V", "newNoteCount", "getNewNoteCount", "setNewNoteCount", "newNoteCountFlag", "getNewNoteCountFlag", "setNewNoteCountFlag", "newRevisionCount", "getNewRevisionCount", "setNewRevisionCount", "newRevisionFlag", "getNewRevisionFlag", "setNewRevisionFlag", "notifyBorrower", "getNotifyBorrower", "setNotifyBorrower", "orderGenId", "getOrderGenId", "setOrderGenId", "orgId", "getOrgId", "setOrgId", "pointOfContactEmail", "getPointOfContactEmail", "setPointOfContactEmail", "pointOfContactName", "getPointOfContactName", "setPointOfContactName", "pointOfContanctPhone", "getPointOfContanctPhone", "setPointOfContanctPhone", "product", "getProduct", "setProduct", "productName", "getProductName", "setProductName", "serviceRequestType", "getServiceRequestType", "setServiceRequestType", "userId", "getUserId", "setUserId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
        public static final class OrderDetail implements android.os.Parcelable {
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderGenId")
            private java.lang.String orderGenId;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemId")
            private java.lang.Integer itemId;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrgId")
            private java.lang.Integer orgId;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
            private java.lang.String displayAddressInfo;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Product")
            private java.lang.String product;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductName")
            private java.lang.String productName;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lockbox")
            private java.lang.String lockbox;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerPhone")
            private java.lang.String borrowerPhone;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerName")
            private java.lang.String borrowerName;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "BorrowerEmail")
            private java.lang.String borrowerEmail;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentTime")
            private java.lang.String appointmentTime;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentStatus")
            private java.lang.String appointmentStatus;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
            private java.lang.String appointmentDate;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "IsNotify")
            private java.lang.Boolean isNotify;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "IsComplete")
            private java.lang.Boolean isComplete;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotifyBorrower")
            private java.lang.String notifyBorrower;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "InspectionComplete")
            private java.lang.String inspectionComplete;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lat")
            private java.lang.String lat;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Lng")
            private java.lang.String lng;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "UserId")
            private java.lang.Integer userId;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
            private java.lang.Integer itemSrNo;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DueDate")
            private java.lang.String dueDate;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ServiceRequestType")
            private java.lang.Integer serviceRequestType;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ClientName")
            private java.lang.String clientName;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "PointOfContactPhone")
            private java.lang.String pointOfContanctPhone;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "PointOfContactName")
            private java.lang.String pointOfContactName;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "PointOfContactEmail")
            private java.lang.String pointOfContactEmail;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DisplayLoanInfo")
            private java.lang.String displayLoanInfo;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewDocumentCount")
            private java.lang.Integer newDocumentCount;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewDocumentFlag")
            private boolean newDocumentFlag = false;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewRevisionCount")
            private java.lang.Integer newRevisionCount;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewRevisionFlag")
            private boolean newRevisionFlag = false;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewNoteCount")
            private java.lang.Integer newNoteCount;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NewNoteCountFlag")
            private boolean newNoteCountFlag = false;
            public static final com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail.CREATOR CREATOR = null;
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            public final void setOrderGenId(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemId() {
                return null;
            }
            
            public final void setItemId(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getOrgId() {
                return null;
            }
            
            public final void setOrgId(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDisplayAddressInfo() {
                return null;
            }
            
            public final void setDisplayAddressInfo(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getProduct() {
                return null;
            }
            
            public final void setProduct(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getProductName() {
                return null;
            }
            
            public final void setProductName(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getLockbox() {
                return null;
            }
            
            public final void setLockbox(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBorrowerPhone() {
                return null;
            }
            
            public final void setBorrowerPhone(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBorrowerName() {
                return null;
            }
            
            public final void setBorrowerName(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBorrowerEmail() {
                return null;
            }
            
            public final void setBorrowerEmail(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentTime() {
                return null;
            }
            
            public final void setAppointmentTime(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentStatus() {
                return null;
            }
            
            public final void setAppointmentStatus(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentDate() {
                return null;
            }
            
            public final void setAppointmentDate(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean isNotify() {
                return null;
            }
            
            public final void setNotify(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Boolean isComplete() {
                return null;
            }
            
            public final void setComplete(@org.jetbrains.annotations.Nullable()
            java.lang.Boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNotifyBorrower() {
                return null;
            }
            
            public final void setNotifyBorrower(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getInspectionComplete() {
                return null;
            }
            
            public final void setInspectionComplete(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getLat() {
                return null;
            }
            
            public final void setLat(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getLng() {
                return null;
            }
            
            public final void setLng(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getUserId() {
                return null;
            }
            
            public final void setUserId(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemSrNo() {
                return null;
            }
            
            public final void setItemSrNo(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDueDate() {
                return null;
            }
            
            public final void setDueDate(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getServiceRequestType() {
                return null;
            }
            
            public final void setServiceRequestType(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getClientName() {
                return null;
            }
            
            public final void setClientName(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getPointOfContanctPhone() {
                return null;
            }
            
            public final void setPointOfContanctPhone(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getPointOfContactName() {
                return null;
            }
            
            public final void setPointOfContactName(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getPointOfContactEmail() {
                return null;
            }
            
            public final void setPointOfContactEmail(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDisplayLoanInfo() {
                return null;
            }
            
            public final void setDisplayLoanInfo(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getNewDocumentCount() {
                return null;
            }
            
            public final void setNewDocumentCount(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            public final boolean getNewDocumentFlag() {
                return false;
            }
            
            public final void setNewDocumentFlag(boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getNewRevisionCount() {
                return null;
            }
            
            public final void setNewRevisionCount(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            public final boolean getNewRevisionFlag() {
                return false;
            }
            
            public final void setNewRevisionFlag(boolean p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getNewNoteCount() {
                return null;
            }
            
            public final void setNewNoteCount(@org.jetbrains.annotations.Nullable()
            java.lang.Integer p0) {
            }
            
            public final boolean getNewNoteCountFlag() {
                return false;
            }
            
            public final void setNewNoteCountFlag(boolean p0) {
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
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/ManageOrderResponse$Data$OrderDetail;", "app_DevDebug"})
            public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail> {
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail createFromParcel(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.ManageOrderResponse.Data.OrderDetail[] newArray(int size) {
                    return null;
                }
                
                private CREATOR() {
                    super();
                }
            }
        }
    }
}
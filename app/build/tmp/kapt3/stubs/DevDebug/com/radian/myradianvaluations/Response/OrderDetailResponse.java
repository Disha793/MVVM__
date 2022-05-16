package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0003$%&B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 H\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0013\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0019\u001a\u0004\u0018\u00010\u001a8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001e\u00a8\u0006\'"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "message", "", "getMessage", "()Ljava/lang/Object;", "setMessage", "(Ljava/lang/Object;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "Data", "Orderdetail", "app_DevDebug"})
public final class OrderDetailResponse implements android.os.Parcelable {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.OrderDetailResponse.Data data;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Message")
    private java.lang.Object message;
    public static final com.radian.myradianvaluations.Response.OrderDetailResponse.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.OrderDetailResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    com.radian.myradianvaluations.Response.OrderDetailResponse.Data p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> getErrorInfo() {
        return null;
    }
    
    public final void setErrorInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.Nullable()
    java.lang.Object p0) {
    }
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public OrderDetailResponse() {
        super();
    }
    
    public OrderDetailResponse(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0012"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "orderdetails", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "getOrderdetails", "()Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "setOrderdetails", "(Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
    public static final class Data implements android.os.Parcelable {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Orderdetails")
        private com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail orderdetails;
        public static final com.radian.myradianvaluations.Response.OrderDetailResponse.Data.CREATOR CREATOR = null;
        
        @org.jetbrains.annotations.Nullable()
        public final com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail getOrderdetails() {
            return null;
        }
        
        public final void setOrderdetails(@org.jetbrains.annotations.Nullable()
        com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail p0) {
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        public Data() {
            super();
        }
        
        public Data(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Data;", "app_DevDebug"})
        public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.OrderDetailResponse.Data> {
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.OrderDetailResponse.Data createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.OrderDetailResponse.Data[] newArray(int size) {
                return null;
            }
            
            private CREATOR() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b1\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 z2\u00020\u0001:\u0001zB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010v\u001a\u00020FH\u0016J\u0018\u0010w\u001a\u00020x2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010y\u001a\u00020FH\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR \u0010\u0012\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\t\"\u0004\b\u0014\u0010\u000bR \u0010\u0015\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR \u0010\u0018\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\t\"\u0004\b\u001a\u0010\u000bR \u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR \u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\t\"\u0004\b \u0010\u000bR \u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR \u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR \u0010\'\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\t\"\u0004\b)\u0010\u000bR \u0010*\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R \u00100\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010-\"\u0004\b2\u0010/R \u00103\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010-\"\u0004\b5\u0010/R \u00106\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\t\"\u0004\b8\u0010\u000bR \u00109\u001a\u0004\u0018\u00010+8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b:\u0010-\"\u0004\b;\u0010/R \u0010<\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001e\u0010>\u001a\u00020?8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b>\u0010@\"\u0004\bA\u0010BR\u001e\u0010C\u001a\u00020?8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bC\u0010@\"\u0004\bD\u0010BR\"\u0010E\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\"\u0010L\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bM\u0010H\"\u0004\bN\u0010JR\"\u0010O\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bP\u0010H\"\u0004\bQ\u0010JR \u0010R\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bS\u0010\t\"\u0004\bT\u0010\u000bR \u0010U\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bV\u0010\t\"\u0004\bW\u0010\u000bR \u0010X\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bY\u0010\t\"\u0004\bZ\u0010\u000bR \u0010[\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010\t\"\u0004\b]\u0010\u000bR\"\u0010^\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\b_\u0010H\"\u0004\b`\u0010JR\"\u0010a\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bb\u0010H\"\u0004\bc\u0010JR \u0010d\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\be\u0010\t\"\u0004\bf\u0010\u000bR \u0010g\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bh\u0010\t\"\u0004\bi\u0010\u000bR\"\u0010j\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bk\u0010H\"\u0004\bl\u0010JR \u0010m\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bn\u0010\t\"\u0004\bo\u0010\u000bR \u0010p\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bq\u0010\t\"\u0004\br\u0010\u000bR\"\u0010s\u001a\u0004\u0018\u00010F8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010K\u001a\u0004\bt\u0010H\"\u0004\bu\u0010J\u00a8\u0006{"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appointmentDate", "", "getAppointmentDate", "()Ljava/lang/String;", "setAppointmentDate", "(Ljava/lang/String;)V", "appointmentTime", "getAppointmentTime", "setAppointmentTime", "borrowerEmail", "getBorrowerEmail", "setBorrowerEmail", "borrowerPhone", "getBorrowerPhone", "setBorrowerPhone", "clientEmail", "getClientEmail", "setClientEmail", "clientName", "getClientName", "setClientName", "clientPhone", "getClientPhone", "setClientPhone", "condAcceptance", "getCondAcceptance", "setCondAcceptance", "diplayBorrowerInfo", "getDiplayBorrowerInfo", "setDiplayBorrowerInfo", "displayAddressInfo", "getDisplayAddressInfo", "setDisplayAddressInfo", "displayLoanInfo", "getDisplayLoanInfo", "setDisplayLoanInfo", "documentId", "", "getDocumentId", "()Ljava/lang/Object;", "setDocumentId", "(Ljava/lang/Object;)V", "documentName", "getDocumentName", "setDocumentName", "documentURL", "getDocumentURL", "setDocumentURL", "dueDate", "getDueDate", "setDueDate", "fHA", "getFHA", "setFHA", "isAllowInspection", "setAllowInspection", "isComplete", "", "()Z", "setComplete", "(Z)V", "isNotify", "setNotify", "itemId", "", "getItemId", "()Ljava/lang/Integer;", "setItemId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "itemNoteId", "getItemNoteId", "setItemNoteId", "itemSrNo", "getItemSrNo", "setItemSrNo", "lat", "getLat", "setLat", "lng", "getLng", "setLng", "message", "getMessage", "setMessage", "orderGenId", "getOrderGenId", "setOrderGenId", "orgId", "getOrgId", "setOrgId", "paymentAmount", "getPaymentAmount", "setPaymentAmount", "paymentRequired", "getPaymentRequired", "setPaymentRequired", "product", "getProduct", "setProduct", "serviceRequestType", "getServiceRequestType", "setServiceRequestType", "status", "getStatus", "setStatus", "tileAbbr", "getTileAbbr", "setTileAbbr", "userId", "getUserId", "setUserId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
    public static final class Orderdetail implements android.os.Parcelable {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsAllowInspection")
        private java.lang.String isAllowInspection;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
        private java.lang.String appointmentDate;
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
        @com.google.gson.annotations.SerializedName(value = "UserId")
        private java.lang.Integer userId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ItemNoteId")
        private java.lang.Integer itemNoteId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OrgId")
        private java.lang.Integer orgId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DiplayBorrowerInfo")
        private java.lang.String diplayBorrowerInfo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
        private java.lang.String displayAddressInfo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DisplayLoanInfo")
        private java.lang.String displayLoanInfo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "FHA")
        private java.lang.Object fHA;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Product")
        private java.lang.String product;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "AppointmentTime")
        private java.lang.String appointmentTime;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Message")
        private java.lang.String message;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DueDate")
        private java.lang.String dueDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Status")
        private java.lang.String status;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentId")
        private java.lang.Object documentId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentName")
        private java.lang.Object documentName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TileAbbr")
        private java.lang.String tileAbbr;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ClientName")
        private java.lang.String clientName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ClientPhone")
        private java.lang.String clientPhone;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ClientEmail")
        private java.lang.String clientEmail;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentURL")
        private java.lang.Object documentURL;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ServiceRequestType")
        private java.lang.Integer serviceRequestType;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "PaymentRequired")
        private java.lang.String paymentRequired;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "PaymentAmount")
        private java.lang.Integer paymentAmount;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CondAcceptance")
        private java.lang.String condAcceptance;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
        private java.lang.Integer itemSrNo;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsNotify")
        private boolean isNotify = false;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsComplete")
        private boolean isComplete = false;
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
        @com.google.gson.annotations.SerializedName(value = "BorrowerPhone")
        private java.lang.String borrowerPhone;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "BorrowerEmail")
        private java.lang.String borrowerEmail;
        public static final com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail.CREATOR CREATOR = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String isAllowInspection() {
            return null;
        }
        
        public final void setAllowInspection(@org.jetbrains.annotations.Nullable()
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
        public final java.lang.Integer getUserId() {
            return null;
        }
        
        public final void setUserId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getItemNoteId() {
            return null;
        }
        
        public final void setItemNoteId(@org.jetbrains.annotations.Nullable()
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
        public final java.lang.String getDiplayBorrowerInfo() {
            return null;
        }
        
        public final void setDiplayBorrowerInfo(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDisplayAddressInfo() {
            return null;
        }
        
        public final void setDisplayAddressInfo(@org.jetbrains.annotations.Nullable()
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
        public final java.lang.Object getFHA() {
            return null;
        }
        
        public final void setFHA(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProduct() {
            return null;
        }
        
        public final void setProduct(@org.jetbrains.annotations.Nullable()
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
        public final java.lang.String getMessage() {
            return null;
        }
        
        public final void setMessage(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDueDate() {
            return null;
        }
        
        public final void setDueDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStatus() {
            return null;
        }
        
        public final void setStatus(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getDocumentId() {
            return null;
        }
        
        public final void setDocumentId(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getDocumentName() {
            return null;
        }
        
        public final void setDocumentName(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getTileAbbr() {
            return null;
        }
        
        public final void setTileAbbr(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getClientName() {
            return null;
        }
        
        public final void setClientName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getClientPhone() {
            return null;
        }
        
        public final void setClientPhone(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getClientEmail() {
            return null;
        }
        
        public final void setClientEmail(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getDocumentURL() {
            return null;
        }
        
        public final void setDocumentURL(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getServiceRequestType() {
            return null;
        }
        
        public final void setServiceRequestType(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getPaymentRequired() {
            return null;
        }
        
        public final void setPaymentRequired(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getPaymentAmount() {
            return null;
        }
        
        public final void setPaymentAmount(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCondAcceptance() {
            return null;
        }
        
        public final void setCondAcceptance(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getItemSrNo() {
            return null;
        }
        
        public final void setItemSrNo(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        public final boolean isNotify() {
            return false;
        }
        
        public final void setNotify(boolean p0) {
        }
        
        public final boolean isComplete() {
            return false;
        }
        
        public final void setComplete(boolean p0) {
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
        public final java.lang.String getBorrowerPhone() {
            return null;
        }
        
        public final void setBorrowerPhone(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBorrowerEmail() {
            return null;
        }
        
        public final void setBorrowerEmail(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @java.lang.Override()
        public void writeToParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel, int flags) {
        }
        
        @java.lang.Override()
        public int describeContents() {
            return 0;
        }
        
        public Orderdetail() {
            super();
        }
        
        public Orderdetail(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "app_DevDebug"})
        public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail> {
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail[] newArray(int size) {
                return null;
            }
            
            private CREATOR() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDetailResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/OrderDetailResponse;", "app_DevDebug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.OrderDetailResponse> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.OrderDetailResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.OrderDetailResponse[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}
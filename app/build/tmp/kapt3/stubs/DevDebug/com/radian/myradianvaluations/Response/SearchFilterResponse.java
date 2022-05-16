package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "Data", "app_DevDebug"})
public final class SearchFilterResponse implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.SearchFilterResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    public static final com.radian.myradianvaluations.Response.SearchFilterResponse.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.SearchFilterResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.Response.SearchFilterResponse.Data p0) {
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
    
    @java.lang.Override()
    public void writeToParcel(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel, int flags) {
    }
    
    @java.lang.Override()
    public int describeContents() {
        return 0;
    }
    
    public SearchFilterResponse() {
        super();
    }
    
    public SearchFilterResponse(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\rH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b\u00a8\u0006\u0013"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "orderList", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;", "getOrderList", "()Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;", "setOrderList", "(Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "OrderList", "app_DevDebug"})
    public static final class Data implements android.os.Parcelable {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "OrderList")
        private com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList orderList;
        public static final com.radian.myradianvaluations.Response.SearchFilterResponse.Data.CREATOR CREATOR = null;
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList getOrderList() {
            return null;
        }
        
        public final void setOrderList(@org.jetbrains.annotations.NotNull()
        com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList p0) {
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
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 $2\u00020\u0001:\u0002$%B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001f\u001a\u00020 H\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010#\u001a\u00020 H\u0016R$\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR$\u0010\r\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\n\"\u0004\b\u000f\u0010\fR$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\n\"\u0004\b\u0012\u0010\fR$\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\n\"\u0004\b\u0015\u0010\fR$\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\n\"\u0004\b\u0018\u0010\fR$\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\n\"\u0004\b\u001b\u0010\fR$\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\b0\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\n\"\u0004\b\u001e\u0010\f\u00a8\u0006&"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "acceptList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order;", "getAcceptList", "()Ljava/util/ArrayList;", "setAcceptList", "(Ljava/util/ArrayList;)V", "docList", "getDocList", "setDocList", "inspectionList", "getInspectionList", "setInspectionList", "lateList", "getLateList", "setLateList", "messageList", "getMessageList", "setMessageList", "openList", "getOpenList", "setOpenList", "revisionList", "getRevisionList", "setRevisionList", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "Order", "app_DevDebug"})
        public static final class OrderList implements android.os.Parcelable {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "O_LATE")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> lateList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "O_OPEN")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> openList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "O_RR")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> revisionList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "N_MESSAGE")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> messageList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "N_DOCUMENT")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> docList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "O_CONFIRM")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> acceptList;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "O_INSP")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> inspectionList;
            public static final com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.CREATOR CREATOR = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getLateList() {
                return null;
            }
            
            public final void setLateList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getOpenList() {
                return null;
            }
            
            public final void setOpenList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getRevisionList() {
                return null;
            }
            
            public final void setRevisionList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getMessageList() {
                return null;
            }
            
            public final void setMessageList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getDocList() {
                return null;
            }
            
            public final void setDocList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getAcceptList() {
                return null;
            }
            
            public final void setAcceptList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> getInspectionList() {
                return null;
            }
            
            public final void setInspectionList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> p0) {
            }
            
            @java.lang.Override()
            public void writeToParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel, int flags) {
            }
            
            @java.lang.Override()
            public int describeContents() {
                return 0;
            }
            
            public OrderList() {
                super();
            }
            
            public OrderList(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                super();
            }
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b,\n\u0002\u0010\b\n\u0002\bT\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u0091\u00012\u00020\u0001:\u0002\u0091\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\t\u0010\u008d\u0001\u001a\u00020:H\u0016J\u001b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0007\u0010\u0090\u0001\u001a\u00020:H\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R \u0010\u0015\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011R \u0010\u0018\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000f\"\u0004\b\u001a\u0010\u0011R \u0010\u001b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR \u0010\u001e\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u000f\"\u0004\b \u0010\u0011R \u0010!\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010\u000bR \u0010$\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\t\"\u0004\b&\u0010\u000bR\u001a\u0010\'\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u001a\u0010*\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010\u000f\"\u0004\b,\u0010\u0011R\u001a\u0010-\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u000f\"\u0004\b/\u0010\u0011R \u00100\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u000f\"\u0004\b2\u0010\u0011R \u00103\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b4\u0010\u000f\"\u0004\b5\u0010\u0011R \u00106\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b7\u0010\u000f\"\u0004\b8\u0010\u0011R\"\u00109\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R \u0010@\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\t\"\u0004\bB\u0010\u000bR \u0010C\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bD\u0010\t\"\u0004\bE\u0010\u000bR \u0010F\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bG\u0010\u000f\"\u0004\bH\u0010\u0011R \u0010I\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u000f\"\u0004\bK\u0010\u0011R \u0010L\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bM\u0010\t\"\u0004\bN\u0010\u000bR\u001e\u0010O\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bO\u0010\u000f\"\u0004\bP\u0010\u0011R\"\u0010Q\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\bR\u0010<\"\u0004\bS\u0010>R\"\u0010T\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\bU\u0010<\"\u0004\bV\u0010>R\"\u0010W\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\bX\u0010<\"\u0004\bY\u0010>R \u0010Z\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b[\u0010\u000f\"\u0004\b\\\u0010\u0011R \u0010]\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b^\u0010\u000f\"\u0004\b_\u0010\u0011R \u0010`\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\ba\u0010\u000f\"\u0004\bb\u0010\u0011R \u0010c\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bd\u0010\u000f\"\u0004\be\u0010\u0011R\"\u0010f\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\bg\u0010<\"\u0004\bh\u0010>R\"\u0010i\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\bj\u0010<\"\u0004\bk\u0010>R \u0010l\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bm\u0010\t\"\u0004\bn\u0010\u000bR\u001e\u0010o\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bp\u0010\u000f\"\u0004\bq\u0010\u0011R \u0010r\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bs\u0010\u000f\"\u0004\bt\u0010\u0011R \u0010u\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\bv\u0010\u000f\"\u0004\bw\u0010\u0011R\u001e\u0010x\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\by\u0010\u000f\"\u0004\bz\u0010\u0011R\"\u0010{\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010?\u001a\u0004\b|\u0010<\"\u0004\b}\u0010>R!\u0010~\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000f\n\u0000\u001a\u0004\b\u007f\u0010\u000f\"\u0005\b\u0080\u0001\u0010\u0011R#\u0010\u0081\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0082\u0001\u0010\u000f\"\u0005\b\u0083\u0001\u0010\u0011R\u001d\u0010\u0084\u0001\u001a\u00020\rX\u0086\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0085\u0001\u0010\u000f\"\u0005\b\u0086\u0001\u0010\u0011R#\u0010\u0087\u0001\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0000\u001a\u0005\b\u0088\u0001\u0010\u000f\"\u0005\b\u0089\u0001\u0010\u0011R%\u0010\u008a\u0001\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0012\n\u0002\u0010?\u001a\u0005\b\u008b\u0001\u0010<\"\u0005\b\u008c\u0001\u0010>\u00a8\u0006\u0092\u0001"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "appointmentTime", "", "getAppointmentTime", "()Ljava/lang/Object;", "setAppointmentTime", "(Ljava/lang/Object;)V", "appraiserMessage", "", "getAppraiserMessage", "()Ljava/lang/String;", "setAppraiserMessage", "(Ljava/lang/String;)V", "borrowerEmail", "getBorrowerEmail", "setBorrowerEmail", "borrowerName", "getBorrowerName", "setBorrowerName", "borrowerPhone", "getBorrowerPhone", "setBorrowerPhone", "clientEmail", "getClientEmail", "setClientEmail", "clientName", "getClientName", "setClientName", "clientPhone", "getClientPhone", "setClientPhone", "condAcceptance", "getCondAcceptance", "setCondAcceptance", "conditionalDate", "getConditionalDate", "setConditionalDate", "conditionalNote", "getConditionalNote", "setConditionalNote", "conditionalPrice", "getConditionalPrice", "setConditionalPrice", "displayAddressInfo", "getDisplayAddressInfo", "setDisplayAddressInfo", "displayBorrowerInfo", "getDisplayBorrowerInfo", "setDisplayBorrowerInfo", "displayLoanInfo", "getDisplayLoanInfo", "setDisplayLoanInfo", "documentId", "", "getDocumentId", "()Ljava/lang/Integer;", "setDocumentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "documentName", "getDocumentName", "setDocumentName", "documentURL", "getDocumentURL", "setDocumentURL", "dueDate", "getDueDate", "setDueDate", "endTimeSlot", "getEndTimeSlot", "setEndTimeSlot", "fHA", "getFHA", "setFHA", "isAssigned", "setAssigned", "itemId", "getItemId", "setItemId", "itemNoteId", "getItemNoteId", "setItemNoteId", "itemSrNo", "getItemSrNo", "setItemSrNo", "lat", "getLat", "setLat", "lng", "getLng", "setLng", "message", "getMessage", "setMessage", "orderGenId", "getOrderGenId", "setOrderGenId", "orgId", "getOrgId", "setOrgId", "paymentAmount", "getPaymentAmount", "setPaymentAmount", "paymentRequired", "getPaymentRequired", "setPaymentRequired", "preference1", "getPreference1", "setPreference1", "product", "getProduct", "setProduct", "profileFee", "getProfileFee", "setProfileFee", "propertyDirection", "getPropertyDirection", "setPropertyDirection", "serviceRequestType", "getServiceRequestType", "setServiceRequestType", "startTimeSlot", "getStartTimeSlot", "setStartTimeSlot", "status", "getStatus", "setStatus", "tag", "getTag", "setTag", "tileAbbr", "getTileAbbr", "setTileAbbr", "userId", "getUserId", "setUserId", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
            public static final class Order implements android.os.Parcelable {
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
                private java.lang.String displayBorrowerInfo;
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
                private java.lang.Object appointmentTime;
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
                private java.lang.Integer documentId;
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
                private java.lang.Object clientPhone;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "ClientEmail")
                private java.lang.Object clientEmail;
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
                private java.lang.Object paymentRequired;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "PaymentAmount")
                private java.lang.Integer paymentAmount;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "CondAcceptance")
                private java.lang.Object condAcceptance;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
                private java.lang.Integer itemSrNo;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "Lat")
                private java.lang.String lat;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "Lng")
                private java.lang.String lng;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "PropertyDirection")
                private java.lang.String propertyDirection = "";
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "Preference1")
                private java.lang.String preference1 = "";
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "AppraiserMessage")
                private java.lang.String appraiserMessage;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "ProfileFee")
                private java.lang.String profileFee;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "StartTimeSlot")
                private java.lang.String startTimeSlot;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "EndTimeSlot")
                private java.lang.String endTimeSlot;
                @org.jetbrains.annotations.NotNull()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "IsAssigned")
                private java.lang.String isAssigned = "";
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "BorrowerPhone")
                private java.lang.String borrowerPhone;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "BorrowerEmail")
                private java.lang.String borrowerEmail;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.Expose()
                @com.google.gson.annotations.SerializedName(value = "BorrowerName")
                private java.lang.String borrowerName;
                @org.jetbrains.annotations.NotNull()
                private java.lang.String tag = "0";
                @org.jetbrains.annotations.NotNull()
                private java.lang.String conditionalDate = "";
                @org.jetbrains.annotations.NotNull()
                private java.lang.String conditionalPrice = "";
                @org.jetbrains.annotations.NotNull()
                private java.lang.String conditionalNote = "";
                public static final com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order.CREATOR CREATOR = null;
                
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
                public final java.lang.String getDisplayBorrowerInfo() {
                    return null;
                }
                
                public final void setDisplayBorrowerInfo(@org.jetbrains.annotations.Nullable()
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
                public final java.lang.Object getAppointmentTime() {
                    return null;
                }
                
                public final void setAppointmentTime(@org.jetbrains.annotations.Nullable()
                java.lang.Object p0) {
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
                public final java.lang.Integer getDocumentId() {
                    return null;
                }
                
                public final void setDocumentId(@org.jetbrains.annotations.Nullable()
                java.lang.Integer p0) {
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
                public final java.lang.Object getClientPhone() {
                    return null;
                }
                
                public final void setClientPhone(@org.jetbrains.annotations.Nullable()
                java.lang.Object p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.Object getClientEmail() {
                    return null;
                }
                
                public final void setClientEmail(@org.jetbrains.annotations.Nullable()
                java.lang.Object p0) {
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
                public final java.lang.Object getPaymentRequired() {
                    return null;
                }
                
                public final void setPaymentRequired(@org.jetbrains.annotations.Nullable()
                java.lang.Object p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.Integer getPaymentAmount() {
                    return null;
                }
                
                public final void setPaymentAmount(@org.jetbrains.annotations.Nullable()
                java.lang.Integer p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.Object getCondAcceptance() {
                    return null;
                }
                
                public final void setCondAcceptance(@org.jetbrains.annotations.Nullable()
                java.lang.Object p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.Integer getItemSrNo() {
                    return null;
                }
                
                public final void setItemSrNo(@org.jetbrains.annotations.Nullable()
                java.lang.Integer p0) {
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
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPropertyDirection() {
                    return null;
                }
                
                public final void setPropertyDirection(@org.jetbrains.annotations.NotNull()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getPreference1() {
                    return null;
                }
                
                public final void setPreference1(@org.jetbrains.annotations.NotNull()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getAppraiserMessage() {
                    return null;
                }
                
                public final void setAppraiserMessage(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getProfileFee() {
                    return null;
                }
                
                public final void setProfileFee(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getStartTimeSlot() {
                    return null;
                }
                
                public final void setStartTimeSlot(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getEndTimeSlot() {
                    return null;
                }
                
                public final void setEndTimeSlot(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String isAssigned() {
                    return null;
                }
                
                public final void setAssigned(@org.jetbrains.annotations.NotNull()
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
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getBorrowerName() {
                    return null;
                }
                
                public final void setBorrowerName(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getTag() {
                    return null;
                }
                
                public final void setTag(@org.jetbrains.annotations.NotNull()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getConditionalDate() {
                    return null;
                }
                
                public final void setConditionalDate(@org.jetbrains.annotations.NotNull()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getConditionalPrice() {
                    return null;
                }
                
                public final void setConditionalPrice(@org.jetbrains.annotations.NotNull()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.NotNull()
                public final java.lang.String getConditionalNote() {
                    return null;
                }
                
                public final void setConditionalNote(@org.jetbrains.annotations.NotNull()
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
                
                public Order() {
                    super();
                }
                
                public Order(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    super();
                }
                
                @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$Order;", "app_DevDebug"})
                public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order> {
                    
                    @org.jetbrains.annotations.NotNull()
                    @java.lang.Override()
                    public com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order createFromParcel(@org.jetbrains.annotations.NotNull()
                    android.os.Parcel parcel) {
                        return null;
                    }
                    
                    @org.jetbrains.annotations.NotNull()
                    @java.lang.Override()
                    public com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList.Order[] newArray(int size) {
                        return null;
                    }
                    
                    private CREATOR() {
                        super();
                    }
                }
            }
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$OrderList;", "app_DevDebug"})
            public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList> {
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList createFromParcel(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.SearchFilterResponse.Data.OrderList[] newArray(int size) {
                    return null;
                }
                
                private CREATOR() {
                    super();
                }
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/SearchFilterResponse$Data;", "app_DevDebug"})
        public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.SearchFilterResponse.Data> {
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.SearchFilterResponse.Data createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.SearchFilterResponse.Data[] newArray(int size) {
                return null;
            }
            
            private CREATOR() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/SearchFilterResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/SearchFilterResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/SearchFilterResponse;", "app_DevDebug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.SearchFilterResponse> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.SearchFilterResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.SearchFilterResponse[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}
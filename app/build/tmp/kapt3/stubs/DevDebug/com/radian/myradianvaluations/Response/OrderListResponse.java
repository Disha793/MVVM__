package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R$\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderListResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/OrderListResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/OrderListResponse$Data;", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class OrderListResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private final com.radian.myradianvaluations.Response.OrderListResponse.Data data = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.OrderListResponse.Data getData() {
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
    
    public OrderListResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderListResponse$Data;", "", "()V", "orderDetails", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/OrderListResponse$Data$OrderDetail;", "getOrderDetails", "()Ljava/util/ArrayList;", "OrderDetail", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "OrderList")
        private final java.util.ArrayList<com.radian.myradianvaluations.Response.OrderListResponse.Data.OrderDetail> orderDetails = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.radian.myradianvaluations.Response.OrderListResponse.Data.OrderDetail> getOrderDetails() {
            return null;
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0011\u0010\u000eR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u001a\u0010\u0014\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0015\u0010\u000eR\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u001a\u0010\u0018\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\u000eR\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0006R\u0018\u0010\u001c\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006\u001f"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderListResponse$Data$OrderDetail;", "", "()V", "appointmentDate", "", "getAppointmentDate", "()Ljava/lang/String;", "appointmentTime", "getAppointmentTime", "displayAddInfo", "getDisplayAddInfo", "itemId", "", "getItemId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "itemNoteId", "getItemNoteId", "message", "getMessage", "notificationCount", "getNotificationCount", "orderGenId", "getOrderGenId", "orgId", "getOrgId", "product", "getProduct", "status", "getStatus", "()Ljava/lang/Object;", "app_DevDebug"})
        public static final class OrderDetail {
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
            private final java.lang.String appointmentDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderGenId")
            private final java.lang.String orderGenId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemId")
            private final java.lang.Integer itemId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Status")
            private final java.lang.Object status = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemNoteId")
            private final java.lang.Integer itemNoteId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrgId")
            private final java.lang.Integer orgId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductName")
            private final java.lang.String product = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentTime")
            private final java.lang.String appointmentTime = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationCount")
            private final java.lang.Integer notificationCount = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
            private final java.lang.String displayAddInfo = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Message")
            private final java.lang.String message = null;
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentDate() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Object getStatus() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemNoteId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getOrgId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getProduct() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentTime() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getNotificationCount() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDisplayAddInfo() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getMessage() {
                return null;
            }
            
            public OrderDetail() {
                super();
            }
        }
    }
}
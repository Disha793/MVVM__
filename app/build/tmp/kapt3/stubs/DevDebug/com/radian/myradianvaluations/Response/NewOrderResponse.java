package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0014B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0018\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0015"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderResponse;", "", "()V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "mdata", "Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data;", "getMdata", "()Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data;", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class NewOrderResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private final com.radian.myradianvaluations.Response.NewOrderResponse.Data mdata = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.NewOrderResponse.Data getMdata() {
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
    
    public NewOrderResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\bB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u00a8\u0006\t"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data;", "", "()V", "orderList", "", "Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data$OrderResponse;", "getOrderList", "()Ljava/util/List;", "OrderResponse", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OrderList")
        private final java.util.List<com.radian.myradianvaluations.Response.NewOrderResponse.Data.OrderResponse> orderList = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.radian.myradianvaluations.Response.NewOrderResponse.Data.OrderResponse> getOrderList() {
            return null;
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u001e\u0010\u000f\u001a\u00020\u00108\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u00020\u00108\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0016\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\fR\u0016\u0010\u0019\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0016\u0010\u001b\u001a\u00020\u00108\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0011R\u0016\u0010\u001d\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0016\u0010\u001f\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0016\u0010!\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006\u00a8\u0006#"}, d2 = {"Lcom/radian/myradianvaluations/Response/NewOrderResponse$Data$OrderResponse;", "", "()V", "appointmentDate", "", "getAppointmentDate", "()Ljava/lang/String;", "displayAddressInfor", "getDisplayAddressInfor", "dueDate", "getDueDate", "setDueDate", "(Ljava/lang/String;)V", "endTimeSlot", "getEndTimeSlot", "isAssigned", "", "()I", "setAssigned", "(I)V", "itemId", "getItemId", "message", "getMessage", "setMessage", "orderGenId", "getOrderGenId", "orgId", "getOrgId", "product", "getProduct", "productName", "getProductName", "startTimeSlot", "getStartTimeSlot", "app_DevDebug"})
        public static final class OrderResponse {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "OrderGenId")
            private final java.lang.String orderGenId = "";
            @com.google.gson.annotations.SerializedName(value = "ItemId")
            private final int itemId = 0;
            @com.google.gson.annotations.SerializedName(value = "OrgId")
            private final int orgId = 0;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
            private final java.lang.String displayAddressInfor = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "Product")
            private final java.lang.String product = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "ProductName")
            private final java.lang.String productName = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "StartTimeSlot")
            private final java.lang.String startTimeSlot = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "EndTimeSlot")
            private final java.lang.String endTimeSlot = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
            private final java.lang.String appointmentDate = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Message")
            private java.lang.String message = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductDueDate")
            private java.lang.String dueDate = "";
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "IsAssigned")
            private int isAssigned = 0;
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            public final int getItemId() {
                return 0;
            }
            
            public final int getOrgId() {
                return 0;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getDisplayAddressInfor() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProduct() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProductName() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getStartTimeSlot() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getEndTimeSlot() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getAppointmentDate() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getMessage() {
                return null;
            }
            
            public final void setMessage(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getDueDate() {
                return null;
            }
            
            public final void setDueDate(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            public final int isAssigned() {
                return 0;
            }
            
            public final void setAssigned(int p0) {
            }
            
            public OrderResponse() {
                super();
            }
        }
    }
}
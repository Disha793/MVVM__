package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/Response/NotificationResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum;", "getData", "()Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum;", "setData", "(Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Datum", "app_DevDebug"})
public final class NotificationResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.NotificationResponse.Datum data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.NotificationResponse.Datum getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    com.radian.myradianvaluations.Response.NotificationResponse.Datum p0) {
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
    
    public NotificationResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum;", "", "()V", "notificationList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum$NotificationList;", "getNotificationList", "()Ljava/util/ArrayList;", "setNotificationList", "(Ljava/util/ArrayList;)V", "NotificationList", "app_DevDebug"})
    public static final class Datum {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "NotificationList")
        private java.util.ArrayList<com.radian.myradianvaluations.Response.NotificationResponse.Datum.NotificationList> notificationList;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.radian.myradianvaluations.Response.NotificationResponse.Datum.NotificationList> getNotificationList() {
            return null;
        }
        
        public final void setNotificationList(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.radian.myradianvaluations.Response.NotificationResponse.Datum.NotificationList> p0) {
        }
        
        public Datum() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b#\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010\f\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u001a\u0010\r\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\u0011\u0010\u000fR\u001e\u0010\u0012\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R \u0010\u001a\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0006\"\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010 \u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b!\u0010\u000fR\u0018\u0010\"\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0006R\u0014\u0010$\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0014\u0010%\u001a\u0004\u0018\u00010\n8\u0002X\u0083\u0004\u00a2\u0006\u0004\n\u0002\u0010\u000bR\u0018\u0010&\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u0006R\u0012\u0010(\u001a\u0004\u0018\u00010\u00018\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u001a\u0010+\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b,\u0010\u000f\u00a8\u0006-"}, d2 = {"Lcom/radian/myradianvaluations/Response/NotificationResponse$Datum$NotificationList;", "", "()V", "abbr", "", "getAbbr", "()Ljava/lang/String;", "body", "getBody", "entityId", "", "Ljava/lang/Integer;", "entityType", "itemId", "getItemId", "()Ljava/lang/Integer;", "itemSrNo", "getItemSrNo", "mobileNotificationId", "getMobileNotificationId", "()I", "setMobileNotificationId", "(I)V", "notificationCreateDate", "getNotificationCreateDate", "notificationReadDate", "notificationReadFlag", "getNotificationReadFlag", "setNotificationReadFlag", "(Ljava/lang/String;)V", "notificationReadUserId", "notificationReadUserName", "orderCount", "getOrderCount", "orderGenId", "getOrderGenId", "organizationId", "pushNotificationId", "serviceRequestType", "getServiceRequestType", "status", "title", "getTitle", "userId", "getUserId", "app_DevDebug"})
        public static final class NotificationList {
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "MobileNotificationId")
            private int mobileNotificationId = 0;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "EntityId")
            private final java.lang.Integer entityId = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "EntityType")
            private final java.lang.Integer entityType = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "PushNotificationId")
            private final java.lang.Integer pushNotificationId = null;
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
            @com.google.gson.annotations.SerializedName(value = "Title")
            private final java.lang.String title = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Body")
            private final java.lang.String body = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Status")
            private final java.lang.Object status = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationReadFlag")
            private java.lang.String notificationReadFlag;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationReadUserId")
            private final java.lang.Integer notificationReadUserId = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationReadDate")
            private final java.lang.Object notificationReadDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationCreateDate")
            private final java.lang.String notificationCreateDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "UserId")
            private final java.lang.Integer userId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Abbr")
            private final java.lang.String abbr = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "NotificationReadUserName")
            private final java.lang.Object notificationReadUserName = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderCount")
            private final java.lang.Integer orderCount = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ServiceRequestType")
            private final java.lang.String serviceRequestType = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
            private final java.lang.Integer itemSrNo = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrganizationId")
            private final java.lang.Integer organizationId = null;
            
            public final int getMobileNotificationId() {
                return 0;
            }
            
            public final void setMobileNotificationId(int p0) {
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
            public final java.lang.String getTitle() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getBody() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNotificationReadFlag() {
                return null;
            }
            
            public final void setNotificationReadFlag(@org.jetbrains.annotations.Nullable()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getNotificationCreateDate() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getUserId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAbbr() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getOrderCount() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getServiceRequestType() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemSrNo() {
                return null;
            }
            
            public NotificationList() {
                super();
            }
        }
    }
}
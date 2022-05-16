package com.radian.myradianvaluations;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/DashboardResponseNew;", "", "()V", "data", "Lcom/radian/myradianvaluations/DashboardResponseNew$Data;", "getData", "()Lcom/radian/myradianvaluations/DashboardResponseNew$Data;", "setData", "(Lcom/radian/myradianvaluations/DashboardResponseNew$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class DashboardResponseNew {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.DashboardResponseNew.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.DashboardResponseNew.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.DashboardResponseNew.Data p0) {
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
    
    public DashboardResponseNew() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u000245B\u0005\u00a2\u0006\u0002\u0010\u0002R2\u0010\u0003\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u00068\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\"\u0010\u001d\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u001e\u0010\u0019\"\u0004\b\u001f\u0010\u001bR\"\u0010 \u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b!\u0010\u0019\"\u0004\b\"\u0010\u001bR \u0010#\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0013\"\u0004\b%\u0010\u0015R \u0010&\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\'\u0010\u0013\"\u0004\b(\u0010\u0015R\u001e\u0010)\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010.\u001a\u00020/8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103\u00a8\u00066"}, d2 = {"Lcom/radian/myradianvaluations/DashboardResponseNew$Data;", "", "()V", "dashboardTileList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/DashboardResponseNew$Data$DashboardTileList;", "Lkotlin/collections/ArrayList;", "getDashboardTileList", "()Ljava/util/ArrayList;", "setDashboardTileList", "(Ljava/util/ArrayList;)V", "isUpdateAndroid", "", "()Z", "setUpdateAndroid", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "newOrderCount", "", "getNewOrderCount", "()Ljava/lang/Integer;", "setNewOrderCount", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "notificatnCount", "getNotificatnCount", "setNotificatnCount", "orderCount", "getOrderCount", "setOrderCount", "profileImageUrl", "getProfileImageUrl", "setProfileImageUrl", "profilePicStatus", "getProfilePicStatus", "setProfilePicStatus", "rewardsPonits", "getRewardsPonits", "()I", "setRewardsPonits", "(I)V", "upcomingAppointment", "Lcom/radian/myradianvaluations/DashboardResponseNew$Data$UpcomingAppointmnt;", "getUpcomingAppointment", "()Lcom/radian/myradianvaluations/DashboardResponseNew$Data$UpcomingAppointmnt;", "setUpcomingAppointment", "(Lcom/radian/myradianvaluations/DashboardResponseNew$Data$UpcomingAppointmnt;)V", "DashboardTileList", "UpcomingAppointmnt", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.SerializedName(value = "DashboardTilesList")
        private java.util.ArrayList<com.radian.myradianvaluations.DashboardResponseNew.Data.DashboardTileList> dashboardTileList;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProfilePicURL")
        private java.lang.String profileImageUrl = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RewardPoints")
        private int rewardsPonits = 0;
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsUpdateAndroid")
        private boolean isUpdateAndroid = false;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProfilePicStatus")
        private java.lang.String profilePicStatus = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "UpComingEventInfo")
        private com.radian.myradianvaluations.DashboardResponseNew.Data.UpcomingAppointmnt upcomingAppointment;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Name")
        private java.lang.String name;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "NewOrderCount")
        private java.lang.Integer newOrderCount;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OrderCount")
        private java.lang.Integer orderCount;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "NotificationCount")
        private java.lang.Integer notificatnCount;
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.ArrayList<com.radian.myradianvaluations.DashboardResponseNew.Data.DashboardTileList> getDashboardTileList() {
            return null;
        }
        
        public final void setDashboardTileList(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.radian.myradianvaluations.DashboardResponseNew.Data.DashboardTileList> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProfileImageUrl() {
            return null;
        }
        
        public final void setProfileImageUrl(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public final int getRewardsPonits() {
            return 0;
        }
        
        public final void setRewardsPonits(int p0) {
        }
        
        public final boolean isUpdateAndroid() {
            return false;
        }
        
        public final void setUpdateAndroid(boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProfilePicStatus() {
            return null;
        }
        
        public final void setProfilePicStatus(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.DashboardResponseNew.Data.UpcomingAppointmnt getUpcomingAppointment() {
            return null;
        }
        
        public final void setUpcomingAppointment(@org.jetbrains.annotations.NotNull()
        com.radian.myradianvaluations.DashboardResponseNew.Data.UpcomingAppointmnt p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getNewOrderCount() {
            return null;
        }
        
        public final void setNewOrderCount(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getOrderCount() {
            return null;
        }
        
        public final void setOrderCount(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getNotificatnCount() {
            return null;
        }
        
        public final void setNotificatnCount(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0002\b \u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006R\u0018\u0010\u000e\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u0018\u0010\u0012\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0006R\u0018\u0010\u0014\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0006R\u0018\u0010\u0016\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0006R\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0006R\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b$\u0010!R\u001a\u0010%\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b&\u0010!R\u0018\u0010\'\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u001a\u0010-\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b.\u0010!R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0016\u00101\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u001a\u00105\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b6\u0010!R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u001a\u00109\u001a\u0004\u0018\u00010\u001b8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b:\u0010!\u00a8\u0006;"}, d2 = {"Lcom/radian/myradianvaluations/DashboardResponseNew$Data$DashboardTileList;", "", "()V", "abbr", "", "getAbbr", "()Ljava/lang/String;", "appointmentDate", "getAppointmentDate", "appointmentTime", "getAppointmentTime", "()Ljava/lang/Object;", "displayAddressInfo", "getDisplayAddressInfo", "documentId", "getDocumentId", "documentURL", "getDocumentURL", "documentname", "getDocumentname", "dueDate", "getDueDate", "endTimeSlot", "getEndTimeSlot", "fee", "getFee", "isAssigned", "", "()I", "setAssigned", "(I)V", "itemId", "getItemId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "itemNoteId", "getItemNoteId", "itemSrNo", "getItemSrNo", "message", "getMessage", "orderDate", "getOrderDate", "orderGenId", "getOrderGenId", "orgId", "getOrgId", "product", "getProduct", "proximity", "getProximity", "revisionRequest", "getRevisionRequest", "serviceRequestType", "getServiceRequestType", "startTimeSlot", "getStartTimeSlot", "userId", "getUserId", "app_DevDebug"})
        public static final class DashboardTileList {
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
            @com.google.gson.annotations.SerializedName(value = "UserId")
            private final java.lang.Integer userId = null;
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
            @com.google.gson.annotations.SerializedName(value = "Abbr")
            private final java.lang.String abbr = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DisplayAddressInfo")
            private final java.lang.String displayAddressInfo = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductDueDate")
            private final java.lang.String dueDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "VendorFee")
            private final java.lang.String fee = null;
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Proximity")
            private final java.lang.String proximity = "";
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ProductName")
            private final java.lang.String product = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "StartTimeSlot")
            private final java.lang.String startTimeSlot = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "EndTimeSlot")
            private final java.lang.String endTimeSlot = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentDate")
            private final java.lang.String appointmentDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderDate")
            private final java.lang.String orderDate = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Message")
            private final java.lang.String message = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Documentname")
            private final java.lang.String documentname = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DocumentId")
            private final java.lang.Object documentId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentTime")
            private final java.lang.Object appointmentTime = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "DocumentURL")
            private final java.lang.Object documentURL = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ServiceRequestType")
            private final java.lang.Integer serviceRequestType = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemSrNo")
            private final java.lang.Integer itemSrNo = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "RevisionRequest")
            private final java.lang.String revisionRequest = null;
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "IsAssigned")
            private int isAssigned = 0;
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getUserId() {
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
            public final java.lang.String getAbbr() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDisplayAddressInfo() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDueDate() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getFee() {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getProximity() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getProduct() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getStartTimeSlot() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getEndTimeSlot() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentDate() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrderDate() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getMessage() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getDocumentname() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Object getDocumentId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Object getAppointmentTime() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Object getDocumentURL() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getServiceRequestType() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.Integer getItemSrNo() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getRevisionRequest() {
                return null;
            }
            
            public final int isAssigned() {
                return 0;
            }
            
            public final void setAssigned(int p0) {
            }
            
            public DashboardTileList() {
                super();
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/radian/myradianvaluations/DashboardResponseNew$Data$UpcomingAppointmnt;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "appointmentTime", "getAppointmentTime", "itemId", "getItemId", "orderGenId", "getOrderGenId", "orgId", "getOrgId", "app_DevDebug"})
        public static final class UpcomingAppointmnt {
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "AppointmentTime")
            private final java.lang.String appointmentTime = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "Address")
            private final java.lang.String address = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "ItemId")
            private final java.lang.String itemId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrgId")
            private final java.lang.String orgId = null;
            @org.jetbrains.annotations.Nullable()
            @com.google.gson.annotations.Expose()
            @com.google.gson.annotations.SerializedName(value = "OrderGenId")
            private final java.lang.String orderGenId = null;
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAppointmentTime() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getAddress() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getItemId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrgId() {
                return null;
            }
            
            @org.jetbrains.annotations.Nullable()
            public final java.lang.String getOrderGenId() {
                return null;
            }
            
            public UpcomingAppointmnt() {
                super();
            }
        }
    }
}
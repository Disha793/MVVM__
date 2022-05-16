package com.radian.myradianvaluations;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0004\u0019\u001a\u001b\u001cB\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0016\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0013\"\u0004\b\u0018\u0010\u0015\u00a8\u0006\u001d"}, d2 = {"Lcom/radian/myradianvaluations/DashboadResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/DashboadResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/DashboadResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/DashboadResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "DashboardOutOfOfficeInfo", "DashboardTilesList", "Data", "UpcomingAppointmnt", "app_DevDebug"})
public final class DashboadResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.DashboadResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Message")
    private java.lang.String message = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.DashboadResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.DashboadResponse.Data p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    public final void setStatus(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> getErrorInfo() {
        return null;
    }
    
    public final void setErrorInfo(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> p0) {
    }
    
    public DashboadResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\b\u00a8\u0006\u0018"}, d2 = {"Lcom/radian/myradianvaluations/DashboadResponse$DashboardOutOfOfficeInfo;", "", "()V", "endDate", "", "getEndDate", "()Ljava/lang/String;", "setEndDate", "(Ljava/lang/String;)V", "note", "getNote", "()Ljava/lang/Object;", "setNote", "(Ljava/lang/Object;)V", "onVacation", "", "getOnVacation", "()Ljava/lang/Boolean;", "setOnVacation", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "startDate", "getStartDate", "setStartDate", "app_DevDebug"})
    public static final class DashboardOutOfOfficeInfo {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "OnVacation")
        private java.lang.Boolean onVacation;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "StartDate")
        private java.lang.String startDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EndDate")
        private java.lang.String endDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Note")
        private java.lang.Object note;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Boolean getOnVacation() {
            return null;
        }
        
        public final void setOnVacation(@org.jetbrains.annotations.Nullable()
        java.lang.Boolean p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getStartDate() {
            return null;
        }
        
        public final void setStartDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEndDate() {
            return null;
        }
        
        public final void setEndDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        public DashboardOutOfOfficeInfo() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0006\"\u0004\b\u0010\u0010\bR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\"\u0010\u0018\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0019\u0010\u0014\"\u0004\b\u001a\u0010\u0016R\"\u0010\u001b\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001c\u0010\u0014\"\u0004\b\u001d\u0010\u0016R\"\u0010\u001e\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u001f\u0010\u0014\"\u0004\b \u0010\u0016\u00a8\u0006!"}, d2 = {"Lcom/radian/myradianvaluations/DashboadResponse$DashboardTilesList;", "", "()V", "abbr", "", "getAbbr", "()Ljava/lang/String;", "setAbbr", "(Ljava/lang/String;)V", "color", "getColor", "()Ljava/lang/Object;", "setColor", "(Ljava/lang/Object;)V", "displayName", "getDisplayName", "setDisplayName", "priority", "", "getPriority", "()Ljava/lang/Integer;", "setPriority", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "sequence", "getSequence", "setSequence", "tileCount", "getTileCount", "setTileCount", "tileId", "getTileId", "setTileId", "app_DevDebug"})
    public static final class DashboardTilesList {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TileId")
        private java.lang.Integer tileId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Abbr")
        private java.lang.String abbr;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DisplayName")
        private java.lang.String displayName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Priority")
        private java.lang.Integer priority;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TileCount")
        private java.lang.Integer tileCount;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Sequence")
        private java.lang.Integer sequence;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Color")
        private java.lang.Object color;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getTileId() {
            return null;
        }
        
        public final void setTileId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getAbbr() {
            return null;
        }
        
        public final void setAbbr(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDisplayName() {
            return null;
        }
        
        public final void setDisplayName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getPriority() {
            return null;
        }
        
        public final void setPriority(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getTileCount() {
            return null;
        }
        
        public final void setTileCount(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getSequence() {
            return null;
        }
        
        public final void setSequence(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getColor() {
            return null;
        }
        
        public final void setColor(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        public DashboardTilesList() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR2\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nj\n\u0012\u0004\u0012\u00020\u000b\u0018\u0001`\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0013\"\u0004\b\u0014\u0010\u0015R \u0010\u0016\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR \u0010\u001c\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0019\"\u0004\b\u001e\u0010\u001bR\u001e\u0010\u001f\u001a\u00020\u00178\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\u001bR\u001e\u0010\"\u001a\u00020#8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010\'R\u001e\u0010(\u001a\u00020)8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-\u00a8\u0006."}, d2 = {"Lcom/radian/myradianvaluations/DashboadResponse$Data;", "", "()V", "dashboardOutOfOfficeInfo", "Lcom/radian/myradianvaluations/DashboadResponse$DashboardOutOfOfficeInfo;", "getDashboardOutOfOfficeInfo", "()Lcom/radian/myradianvaluations/DashboadResponse$DashboardOutOfOfficeInfo;", "setDashboardOutOfOfficeInfo", "(Lcom/radian/myradianvaluations/DashboadResponse$DashboardOutOfOfficeInfo;)V", "dashboardTilesList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/DashboadResponse$DashboardTilesList;", "Lkotlin/collections/ArrayList;", "getDashboardTilesList", "()Ljava/util/ArrayList;", "setDashboardTilesList", "(Ljava/util/ArrayList;)V", "isUpdateAndroid", "", "()Z", "setUpdateAndroid", "(Z)V", "name", "", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "profileImageUrl", "getProfileImageUrl", "setProfileImageUrl", "profilePicStatus", "getProfilePicStatus", "setProfilePicStatus", "rewardsPonits", "", "getRewardsPonits", "()I", "setRewardsPonits", "(I)V", "upcomingAppointment", "Lcom/radian/myradianvaluations/DashboadResponse$UpcomingAppointmnt;", "getUpcomingAppointment", "()Lcom/radian/myradianvaluations/DashboadResponse$UpcomingAppointmnt;", "setUpcomingAppointment", "(Lcom/radian/myradianvaluations/DashboadResponse$UpcomingAppointmnt;)V", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DashboardOutOfOfficeInfo")
        private com.radian.myradianvaluations.DashboadResponse.DashboardOutOfOfficeInfo dashboardOutOfOfficeInfo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DashboardTilesList")
        private java.util.ArrayList<com.radian.myradianvaluations.DashboadResponse.DashboardTilesList> dashboardTilesList;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Name")
        private java.lang.String name;
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
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProfilePicStatus")
        private java.lang.String profilePicStatus = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "UpComingEventInfo")
        private com.radian.myradianvaluations.DashboadResponse.UpcomingAppointmnt upcomingAppointment;
        
        @org.jetbrains.annotations.Nullable()
        public final com.radian.myradianvaluations.DashboadResponse.DashboardOutOfOfficeInfo getDashboardOutOfOfficeInfo() {
            return null;
        }
        
        public final void setDashboardOutOfOfficeInfo(@org.jetbrains.annotations.Nullable()
        com.radian.myradianvaluations.DashboadResponse.DashboardOutOfOfficeInfo p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.ArrayList<com.radian.myradianvaluations.DashboadResponse.DashboardTilesList> getDashboardTilesList() {
            return null;
        }
        
        public final void setDashboardTilesList(@org.jetbrains.annotations.Nullable()
        java.util.ArrayList<com.radian.myradianvaluations.DashboadResponse.DashboardTilesList> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getName() {
            return null;
        }
        
        public final void setName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
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
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getProfilePicStatus() {
            return null;
        }
        
        public final void setProfilePicStatus(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.DashboadResponse.UpcomingAppointmnt getUpcomingAppointment() {
            return null;
        }
        
        public final void setUpcomingAppointment(@org.jetbrains.annotations.NotNull()
        com.radian.myradianvaluations.DashboadResponse.UpcomingAppointmnt p0) {
        }
        
        public Data() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0002X\u0083\u0004\u00a2\u0006\u0002\n\u0000R\u0018\u0010\f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0006\u00a8\u0006\u000e"}, d2 = {"Lcom/radian/myradianvaluations/DashboadResponse$UpcomingAppointmnt;", "", "()V", "address", "", "getAddress", "()Ljava/lang/String;", "appointmentTime", "getAppointmentTime", "itemId", "getItemId", "orderGenId", "orgId", "getOrgId", "app_DevDebug"})
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
        
        public UpcomingAppointmnt() {
            super();
        }
    }
}
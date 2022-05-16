package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0010\u0011B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\f\u001a\u00020\r8\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0012"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrgInfoResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/OrgInfoResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/OrgInfoResponse$Data;", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "status", "", "getStatus", "()Ljava/lang/String;", "ContactDetail", "Data", "app_DevDebug"})
public final class OrgInfoResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private final com.radian.myradianvaluations.Response.OrgInfoResponse.Data data = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private final java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.OrgInfoResponse.Data getData() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getStatus() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> getErrorInfo() {
        return null;
    }
    
    public OrgInfoResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrgInfoResponse$Data;", "", "()V", "contactDetail", "Lcom/radian/myradianvaluations/Response/OrgInfoResponse$ContactDetail;", "getContactDetail", "()Lcom/radian/myradianvaluations/Response/OrgInfoResponse$ContactDetail;", "forgotPasswordURL", "", "getForgotPasswordURL", "()Ljava/lang/String;", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ContactDetail")
        private final com.radian.myradianvaluations.Response.OrgInfoResponse.ContactDetail contactDetail = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ForgotPasswordURL")
        private final java.lang.String forgotPasswordURL = null;
        
        @org.jetbrains.annotations.Nullable()
        public final com.radian.myradianvaluations.Response.OrgInfoResponse.ContactDetail getContactDetail() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getForgotPasswordURL() {
            return null;
        }
        
        public Data() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0016\u0010\u0007\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0016\u0010\t\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0016\u0010\u000b\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0016\u0010\r\u001a\u00020\u00048\u0006X\u0087D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006\u00a8\u0006\u000f"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrgInfoResponse$ContactDetail;", "", "()V", "contactNumber", "", "getContactNumber", "()Ljava/lang/String;", "email", "getEmail", "joinUsURL", "getJoinUsURL", "workingDays", "getWorkingDays", "workingTime", "getWorkingTime", "app_DevDebug"})
    public static final class ContactDetail {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "JoinUsURL")
        private final java.lang.String joinUsURL = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ContactNumber")
        private final java.lang.String contactNumber = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Email")
        private final java.lang.String email = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "WorkingDays")
        private final java.lang.String workingDays = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "WorkingTime")
        private final java.lang.String workingTime = "";
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getJoinUsURL() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getContactNumber() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getEmail() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getWorkingDays() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getWorkingTime() {
            return null;
        }
        
        public ContactDetail() {
            super();
        }
    }
}
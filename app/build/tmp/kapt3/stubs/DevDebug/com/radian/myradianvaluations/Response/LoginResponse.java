package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001e2\u00020\u0001:\u0002\u001e\u001fB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u00148\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006 "}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "data", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/LoginResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/LoginResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "describeContents", "", "writeToParcel", "", "flags", "CREATOR", "Data", "app_DevDebug"})
public final class LoginResponse implements android.os.Parcelable {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.LoginResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    public static final com.radian.myradianvaluations.Response.LoginResponse.CREATOR CREATOR = null;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.LoginResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.Response.LoginResponse.Data p0) {
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
    
    public LoginResponse() {
        super();
    }
    
    public LoginResponse(@org.jetbrains.annotations.NotNull()
    android.os.Parcel parcel) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \"2\u00020\u0001:\u0002\"#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010!\u001a\u00020\rH\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R\u001e\u0010\u0015\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\t\"\u0004\b\u0017\u0010\u000bR\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d\u00a8\u0006$"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "authToken", "", "getAuthToken", "()Ljava/lang/String;", "setAuthToken", "(Ljava/lang/String;)V", "deviceStatus", "", "getDeviceStatus", "()I", "setDeviceStatus", "(I)V", "mobileUserId", "getMobileUserId", "setMobileUserId", "phoneNumber", "getPhoneNumber", "setPhoneNumber", "userDetailJson", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;", "getUserDetailJson", "()Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;", "setUserDetailJson", "(Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "UserDetailJson", "app_DevDebug"})
    public static final class Data implements android.os.Parcelable {
        @com.google.gson.annotations.SerializedName(value = "DeviceStatus")
        private int deviceStatus = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "PhoneNumber")
        private java.lang.String phoneNumber = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "AuthToken")
        private java.lang.String authToken = "";
        @com.google.gson.annotations.SerializedName(value = "MobileUserId")
        private int mobileUserId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "UserDetailsJson")
        private com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson userDetailJson;
        public static final com.radian.myradianvaluations.Response.LoginResponse.Data.CREATOR CREATOR = null;
        
        public final int getDeviceStatus() {
            return 0;
        }
        
        public final void setDeviceStatus(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhoneNumber() {
            return null;
        }
        
        public final void setPhoneNumber(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getAuthToken() {
            return null;
        }
        
        public final void setAuthToken(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getMobileUserId() {
            return 0;
        }
        
        public final void setMobileUserId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson getUserDetailJson() {
            return null;
        }
        
        public final void setUserDetailJson(@org.jetbrains.annotations.NotNull()
        com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson p0) {
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
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0002\u001d\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0019\u001a\u00020\u0007H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0007H\u0016R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018\u00a8\u0006\u001f"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "btnCount", "", "getBtnCount", "()I", "setBtnCount", "(I)V", "cocFlag", "", "getCocFlag", "()Z", "setCocFlag", "(Z)V", "userList", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$User;", "getUserList", "()Ljava/util/ArrayList;", "setUserList", "(Ljava/util/ArrayList;)V", "describeContents", "writeToParcel", "", "flags", "CREATOR", "User", "app_DevDebug"})
        public static final class UserDetailJson implements android.os.Parcelable {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "Users")
            private java.util.ArrayList<com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User> userList;
            @com.google.gson.annotations.SerializedName(value = "CocFlag")
            private boolean cocFlag = false;
            @com.google.gson.annotations.SerializedName(value = "BtnCount")
            private int btnCount = 0;
            public static final com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.CREATOR CREATOR = null;
            
            @org.jetbrains.annotations.NotNull()
            public final java.util.ArrayList<com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User> getUserList() {
                return null;
            }
            
            public final void setUserList(@org.jetbrains.annotations.NotNull()
            java.util.ArrayList<com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User> p0) {
            }
            
            public final boolean getCocFlag() {
                return false;
            }
            
            public final void setCocFlag(boolean p0) {
            }
            
            public final int getBtnCount() {
                return 0;
            }
            
            public final void setBtnCount(int p0) {
            }
            
            @java.lang.Override()
            public void writeToParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel, int flags) {
            }
            
            @java.lang.Override()
            public int describeContents() {
                return 0;
            }
            
            public UserDetailJson() {
                super();
            }
            
            public UserDetailJson(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                super();
            }
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u0018\u001a\u00020\rH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\rH\u0016R \u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\"\u0010\u0012\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016\u00a8\u0006\u001d"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$User;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "loginId", "", "getLoginId", "()Ljava/lang/String;", "setLoginId", "(Ljava/lang/String;)V", "orgId", "", "getOrgId", "()I", "setOrgId", "(I)V", "userId", "getUserId", "()Ljava/lang/Integer;", "setUserId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "describeContents", "writeToParcel", "", "flags", "CREATOR", "app_DevDebug"})
            public static final class User implements android.os.Parcelable {
                @com.google.gson.annotations.SerializedName(value = "OrgId")
                private int orgId = 0;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.SerializedName(value = "LoginId")
                private java.lang.String loginId;
                @org.jetbrains.annotations.Nullable()
                @com.google.gson.annotations.SerializedName(value = "UserId")
                private java.lang.Integer userId;
                public static final com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User.CREATOR CREATOR = null;
                
                public final int getOrgId() {
                    return 0;
                }
                
                public final void setOrgId(int p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.String getLoginId() {
                    return null;
                }
                
                public final void setLoginId(@org.jetbrains.annotations.Nullable()
                java.lang.String p0) {
                }
                
                @org.jetbrains.annotations.Nullable()
                public final java.lang.Integer getUserId() {
                    return null;
                }
                
                public final void setUserId(@org.jetbrains.annotations.Nullable()
                java.lang.Integer p0) {
                }
                
                @java.lang.Override()
                public void writeToParcel(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel, int flags) {
                }
                
                @java.lang.Override()
                public int describeContents() {
                    return 0;
                }
                
                public User(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    super();
                }
                
                public User() {
                    super();
                }
                
                @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$User$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$User;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$User;", "app_DevDebug"})
                public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User> {
                    
                    @org.jetbrains.annotations.NotNull()
                    @java.lang.Override()
                    public com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User createFromParcel(@org.jetbrains.annotations.NotNull()
                    android.os.Parcel parcel) {
                        return null;
                    }
                    
                    @org.jetbrains.annotations.NotNull()
                    @java.lang.Override()
                    public com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson.User[] newArray(int size) {
                        return null;
                    }
                    
                    private CREATOR() {
                        super();
                    }
                }
            }
            
            @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/LoginResponse$Data$UserDetailJson;", "app_DevDebug"})
            public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson> {
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson createFromParcel(@org.jetbrains.annotations.NotNull()
                android.os.Parcel parcel) {
                    return null;
                }
                
                @org.jetbrains.annotations.NotNull()
                @java.lang.Override()
                public com.radian.myradianvaluations.Response.LoginResponse.Data.UserDetailJson[] newArray(int size) {
                    return null;
                }
                
                private CREATOR() {
                    super();
                }
            }
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$Data$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/LoginResponse$Data;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/LoginResponse$Data;", "app_DevDebug"})
        public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.LoginResponse.Data> {
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.LoginResponse.Data createFromParcel(@org.jetbrains.annotations.NotNull()
            android.os.Parcel parcel) {
                return null;
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public com.radian.myradianvaluations.Response.LoginResponse.Data[] newArray(int size) {
                return null;
            }
            
            private CREATOR() {
                super();
            }
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001d\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/radian/myradianvaluations/Response/LoginResponse$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/radian/myradianvaluations/Response/LoginResponse;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/radian/myradianvaluations/Response/LoginResponse;", "app_DevDebug"})
    public static final class CREATOR implements android.os.Parcelable.Creator<com.radian.myradianvaluations.Response.LoginResponse> {
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.LoginResponse createFromParcel(@org.jetbrains.annotations.NotNull()
        android.os.Parcel parcel) {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public com.radian.myradianvaluations.Response.LoginResponse[] newArray(int size) {
            return null;
        }
        
        private CREATOR() {
            super();
        }
    }
}
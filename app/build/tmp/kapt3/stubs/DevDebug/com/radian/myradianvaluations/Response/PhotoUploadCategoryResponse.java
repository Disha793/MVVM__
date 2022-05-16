package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R$\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\fR\u001e\u0010\r\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\u000e8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012\u00a8\u0006\u0018"}, d2 = {"Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse;", "", "()V", "data", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$Data;", "getData", "()Ljava/util/ArrayList;", "errorInfo", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "setErrorInfo", "(Ljava/util/ArrayList;)V", "message", "", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "status", "getStatus", "setStatus", "Data", "PhotoList", "app_DevDebug"})
public final class PhotoUploadCategoryResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private final java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> data = null;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Message")
    private java.lang.String message = "";
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.Data> getData() {
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
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMessage() {
        return null;
    }
    
    public final void setMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public PhotoUploadCategoryResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0006\"\u0004\b\n\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001e\u0010\u0016\u001a\u00020\r8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u00a8\u0006\u001b"}, d2 = {"Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$Data;", "", "()V", "PhotoTypeId", "", "getPhotoTypeId", "()I", "setPhotoTypeId", "(I)V", "isSubject", "setSubject", "newPhotosId", "Ljava/util/ArrayList;", "", "getNewPhotosId", "()Ljava/util/ArrayList;", "setNewPhotosId", "(Ljava/util/ArrayList;)V", "photoList", "Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$PhotoList;", "getPhotoList", "setPhotoList", "text", "getText", "()Ljava/lang/String;", "setText", "(Ljava/lang/String;)V", "app_DevDebug"})
    public static final class Data {
        @com.google.gson.annotations.SerializedName(value = "PhotoTypeId")
        private int PhotoTypeId = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "Text")
        private java.lang.String text = "";
        @com.google.gson.annotations.SerializedName(value = "IsSubject")
        private int isSubject = 0;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "MobilePhotoList")
        private java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.PhotoList> photoList;
        @org.jetbrains.annotations.NotNull()
        private java.util.ArrayList<java.lang.String> newPhotosId;
        
        public final int getPhotoTypeId() {
            return 0;
        }
        
        public final void setPhotoTypeId(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getText() {
            return null;
        }
        
        public final void setText(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int isSubject() {
            return 0;
        }
        
        public final void setSubject(int p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.PhotoList> getPhotoList() {
            return null;
        }
        
        public final void setPhotoList(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.radian.myradianvaluations.Response.PhotoUploadCategoryResponse.PhotoList> p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<java.lang.String> getNewPhotosId() {
            return null;
        }
        
        public final void setNewPhotosId(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<java.lang.String> p0) {
        }
        
        public Data() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u0015X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0017\"\u0004\b\u001c\u0010\u0019R\u001e\u0010\u001d\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0006\"\u0004\b\u001f\u0010\bR\u001a\u0010 \u001a\u00020!X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u00a8\u0006&"}, d2 = {"Lcom/radian/myradianvaluations/Response/PhotoUploadCategoryResponse$PhotoList;", "", "()V", "deleteUrl", "", "getDeleteUrl", "()Ljava/lang/String;", "setDeleteUrl", "(Ljava/lang/String;)V", "docId", "", "getDocId", "()I", "setDocId", "(I)V", "isFromDevice", "", "()Z", "setFromDevice", "(Z)V", "lat", "", "getLat", "()D", "setLat", "(D)V", "long", "getLong", "setLong", "photoUrl", "getPhotoUrl", "setPhotoUrl", "timeStamp", "", "getTimeStamp", "()J", "setTimeStamp", "(J)V", "app_DevDebug"})
    public static final class PhotoList {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "DeleteUrl")
        private java.lang.String deleteUrl = "";
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "PhotoUrl")
        private java.lang.String photoUrl = "";
        @com.google.gson.annotations.SerializedName(value = "DocId")
        private int docId = 0;
        private long timeStamp = 0L;
        private double lat = 0.0;
        private boolean isFromDevice = false;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDeleteUrl() {
            return null;
        }
        
        public final void setDeleteUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getPhotoUrl() {
            return null;
        }
        
        public final void setPhotoUrl(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int getDocId() {
            return 0;
        }
        
        public final void setDocId(int p0) {
        }
        
        public final long getTimeStamp() {
            return 0L;
        }
        
        public final void setTimeStamp(long p0) {
        }
        
        public final double getLat() {
            return 0.0;
        }
        
        public final void setLat(double p0) {
        }
        
        public final double getLong() {
            return 0.0;
        }
        
        public final void setLong(double p0) {
        }
        
        public final boolean isFromDevice() {
            return false;
        }
        
        public final void setFromDevice(boolean p0) {
        }
        
        public PhotoList() {
            super();
        }
    }
}
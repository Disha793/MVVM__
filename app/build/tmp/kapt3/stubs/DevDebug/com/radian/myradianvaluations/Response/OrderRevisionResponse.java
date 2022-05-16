package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u00008\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR \u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderRevisionResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "TileOrderRevision", "app_DevDebug"})
public final class OrderRevisionResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.OrderRevisionResponse.Data data;
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.OrderRevisionResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    com.radian.myradianvaluations.Response.OrderRevisionResponse.Data p0) {
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
    
    public OrderRevisionResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR*\u0010\t\u001a\u000e\u0012\b\u0012\u00060\u000bR\u00020\f\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u00a8\u0006\u0011"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$Data;", "", "(Lcom/radian/myradianvaluations/Response/OrderRevisionResponse;)V", "orderDetail", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "getOrderDetail", "()Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "setOrderDetail", "(Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;)V", "tileOrderRevision", "", "Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$TileOrderRevision;", "Lcom/radian/myradianvaluations/Response/OrderRevisionResponse;", "getTileOrderRevision", "()Ljava/util/List;", "setTileOrderRevision", "(Ljava/util/List;)V", "app_DevDebug"})
    public final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TileOrderRevision")
        private java.util.List<com.radian.myradianvaluations.Response.OrderRevisionResponse.TileOrderRevision> tileOrderRevision;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "orderdetail")
        private com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail orderDetail;
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.radian.myradianvaluations.Response.OrderRevisionResponse.TileOrderRevision> getTileOrderRevision() {
            return null;
        }
        
        public final void setTileOrderRevision(@org.jetbrains.annotations.Nullable()
        java.util.List<com.radian.myradianvaluations.Response.OrderRevisionResponse.TileOrderRevision> p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail getOrderDetail() {
            return null;
        }
        
        public final void setOrderDetail(@org.jetbrains.annotations.Nullable()
        com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail p0) {
        }
        
        public Data() {
            super();
        }
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R \u0010\u000b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007R\"\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0005\"\u0004\b\u0017\u0010\u0007R \u0010\u0018\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0005\"\u0004\b\u001a\u0010\u0007R \u0010\u001b\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0005\"\u0004\b\u001d\u0010\u0007R \u0010\u001e\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R \u0010$\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b%\u0010!\"\u0004\b&\u0010#R \u0010\'\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b(\u0010!\"\u0004\b)\u0010#R \u0010*\u001a\u0004\u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b+\u0010!\"\u0004\b,\u0010#R\"\u0010-\u001a\u0004\u0018\u00010\u000f8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b.\u0010\u0011\"\u0004\b/\u0010\u0013\u00a8\u00060"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderRevisionResponse$TileOrderRevision;", "", "(Lcom/radian/myradianvaluations/Response/OrderRevisionResponse;)V", "actionFlag", "getActionFlag", "()Ljava/lang/Object;", "setActionFlag", "(Ljava/lang/Object;)V", "createdDate", "getCreatedDate", "setCreatedDate", "createdUserName", "getCreatedUserName", "setCreatedUserName", "documentId", "", "getDocumentId", "()Ljava/lang/Integer;", "setDocumentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "documentName", "getDocumentName", "setDocumentName", "note", "getNote", "setNote", "productName", "getProductName", "setProductName", "rejectDate", "", "getRejectDate", "()Ljava/lang/String;", "setRejectDate", "(Ljava/lang/String;)V", "rejectNote", "getRejectNote", "setRejectNote", "rejectReason", "getRejectReason", "setRejectReason", "sRNo", "getSRNo", "setSRNo", "userId", "getUserId", "setUserId", "app_DevDebug"})
    public final class TileOrderRevision {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CreatedDate")
        private java.lang.Object createdDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CreatedUserName")
        private java.lang.Object createdUserName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Note")
        private java.lang.Object note;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProductName")
        private java.lang.Object productName;
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
        @com.google.gson.annotations.SerializedName(value = "ActionFlag")
        private java.lang.Object actionFlag;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "UserId")
        private java.lang.Integer userId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "SRNo")
        private java.lang.String sRNo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectReason")
        private java.lang.String rejectReason;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectNote")
        private java.lang.String rejectNote;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectDate")
        private java.lang.String rejectDate;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getCreatedDate() {
            return null;
        }
        
        public final void setCreatedDate(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getCreatedUserName() {
            return null;
        }
        
        public final void setCreatedUserName(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getProductName() {
            return null;
        }
        
        public final void setProductName(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
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
        public final java.lang.Object getActionFlag() {
            return null;
        }
        
        public final void setActionFlag(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Integer getUserId() {
            return null;
        }
        
        public final void setUserId(@org.jetbrains.annotations.Nullable()
        java.lang.Integer p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSRNo() {
            return null;
        }
        
        public final void setSRNo(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRejectReason() {
            return null;
        }
        
        public final void setRejectReason(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRejectNote() {
            return null;
        }
        
        public final void setRejectNote(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getRejectDate() {
            return null;
        }
        
        public final void setRejectDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        public TileOrderRevision() {
            super();
        }
    }
}
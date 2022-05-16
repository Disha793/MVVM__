package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0016\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0018"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDocResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/OrderDocResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/OrderDocResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/OrderDocResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "TileOrder", "app_DevDebug"})
public final class OrderDocResponse {
    @org.jetbrains.annotations.Nullable()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.OrderDocResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.Expose()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.Nullable()
    public final com.radian.myradianvaluations.Response.OrderDocResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.Nullable()
    com.radian.myradianvaluations.Response.OrderDocResponse.Data p0) {
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
    
    public OrderDocResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR&\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\u00a8\u0006\u0010"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDocResponse$Data;", "", "()V", "orderDetail", "Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "getOrderDetail", "()Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;", "setOrderDetail", "(Lcom/radian/myradianvaluations/Response/OrderDetailResponse$Orderdetail;)V", "tileorderdetails", "", "Lcom/radian/myradianvaluations/Response/OrderDocResponse$TileOrder;", "getTileorderdetails", "()Ljava/util/List;", "setTileorderdetails", "(Ljava/util/List;)V", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "TileOrderDocuments")
        private java.util.List<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> tileorderdetails;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "orderdetail")
        private com.radian.myradianvaluations.Response.OrderDetailResponse.Orderdetail orderDetail;
        
        @org.jetbrains.annotations.Nullable()
        public final java.util.List<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> getTileorderdetails() {
            return null;
        }
        
        public final void setTileorderdetails(@org.jetbrains.annotations.Nullable()
        java.util.List<com.radian.myradianvaluations.Response.OrderDocResponse.TileOrder> p0) {
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
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b%\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R \u0010\b\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\"\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R \u0010\u0018\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u000b\"\u0004\b\u001a\u0010\rR\u001e\u0010\u001b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000b\"\u0004\b\u001d\u0010\rR\u001e\u0010\u001e\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R \u0010\"\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0005\"\u0004\b$\u0010\u0007R \u0010%\u001a\u0004\u0018\u00010\t8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u000b\"\u0004\b\'\u0010\rR \u0010(\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0005\"\u0004\b*\u0010\u0007R \u0010+\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u0005\"\u0004\b-\u0010\u0007R \u0010.\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b/\u0010\u0005\"\u0004\b0\u0010\u0007R \u00101\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b2\u0010\u0005\"\u0004\b3\u0010\u0007R\"\u00104\u001a\u0004\u0018\u00010\u00128\u0006@\u0006X\u0087\u000e\u00a2\u0006\u0010\n\u0002\u0010\u0017\u001a\u0004\b5\u0010\u0014\"\u0004\b6\u0010\u0016\u00a8\u00067"}, d2 = {"Lcom/radian/myradianvaluations/Response/OrderDocResponse$TileOrder;", "", "()V", "actionFlag", "getActionFlag", "()Ljava/lang/Object;", "setActionFlag", "(Ljava/lang/Object;)V", "createdDate", "", "getCreatedDate", "()Ljava/lang/String;", "setCreatedDate", "(Ljava/lang/String;)V", "createdUserName", "getCreatedUserName", "setCreatedUserName", "documentId", "", "getDocumentId", "()Ljava/lang/Integer;", "setDocumentId", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "documentName", "getDocumentName", "setDocumentName", "documentType", "getDocumentType", "setDocumentType", "isNewDocument", "()I", "setNewDocument", "(I)V", "note", "getNote", "setNote", "productName", "getProductName", "setProductName", "rejectDate", "getRejectDate", "setRejectDate", "rejectNote", "getRejectNote", "setRejectNote", "rejectReason", "getRejectReason", "setRejectReason", "sRNo", "getSRNo", "setSRNo", "userId", "getUserId", "setUserId", "app_DevDebug"})
    public static final class TileOrder {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CreatedDate")
        private java.lang.String createdDate;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CreatedUserName")
        private java.lang.String createdUserName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "Note")
        private java.lang.Object note;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ProductName")
        private java.lang.String productName;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentId")
        private java.lang.Integer documentId;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentName")
        private java.lang.String documentName;
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
        private java.lang.Object sRNo;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectReason")
        private java.lang.Object rejectReason;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectNote")
        private java.lang.Object rejectNote;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "RejectDate")
        private java.lang.Object rejectDate;
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DocumentType")
        private java.lang.String documentType = "";
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "IsNewDocument")
        private int isNewDocument = 0;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCreatedDate() {
            return null;
        }
        
        public final void setCreatedDate(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCreatedUserName() {
            return null;
        }
        
        public final void setCreatedUserName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getNote() {
            return null;
        }
        
        public final void setNote(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getProductName() {
            return null;
        }
        
        public final void setProductName(@org.jetbrains.annotations.Nullable()
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
        public final java.lang.String getDocumentName() {
            return null;
        }
        
        public final void setDocumentName(@org.jetbrains.annotations.Nullable()
        java.lang.String p0) {
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
        public final java.lang.Object getSRNo() {
            return null;
        }
        
        public final void setSRNo(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getRejectReason() {
            return null;
        }
        
        public final void setRejectReason(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getRejectNote() {
            return null;
        }
        
        public final void setRejectNote(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.Object getRejectDate() {
            return null;
        }
        
        public final void setRejectDate(@org.jetbrains.annotations.Nullable()
        java.lang.Object p0) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getDocumentType() {
            return null;
        }
        
        public final void setDocumentType(@org.jetbrains.annotations.NotNull()
        java.lang.String p0) {
        }
        
        public final int isNewDocument() {
            return 0;
        }
        
        public final void setNewDocument(int p0) {
        }
        
        public TileOrder() {
            super();
        }
    }
}
package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/Response/LicenceMasterModel;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class LicenceMasterModel {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.LicenceMasterModel.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.LicenceMasterModel.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.Response.LicenceMasterModel.Data p0) {
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
    
    public LicenceMasterModel() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002R$\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t\u00a8\u0006\u000b"}, d2 = {"Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data;", "", "()V", "listLicence", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data$Licence;", "getListLicence", "()Ljava/util/ArrayList;", "setListLicence", "(Ljava/util/ArrayList;)V", "Licence", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.NotNull()
        @com.google.gson.annotations.SerializedName(value = "NSTATUS")
        private java.util.ArrayList<com.radian.myradianvaluations.Response.LicenceMasterModel.Data.Licence> listLicence;
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.ArrayList<com.radian.myradianvaluations.Response.LicenceMasterModel.Data.Licence> getListLicence() {
            return null;
        }
        
        public final void setListLicence(@org.jetbrains.annotations.NotNull()
        java.util.ArrayList<com.radian.myradianvaluations.Response.LicenceMasterModel.Data.Licence> p0) {
        }
        
        public Data() {
            super();
        }
        
        @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\f\u001a\u00020\u0004H\u0016R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b\u00a8\u0006\r"}, d2 = {"Lcom/radian/myradianvaluations/Response/LicenceMasterModel$Data$Licence;", "", "()V", "valueCode", "", "getValueCode", "()Ljava/lang/String;", "setValueCode", "(Ljava/lang/String;)V", "valueName", "getValueName", "setValueName", "toString", "app_DevDebug"})
        public static final class Licence {
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "ValuCode")
            private java.lang.String valueCode = "";
            @org.jetbrains.annotations.NotNull()
            @com.google.gson.annotations.SerializedName(value = "ValuName")
            private java.lang.String valueName = "";
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getValueCode() {
                return null;
            }
            
            public final void setValueCode(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            public final java.lang.String getValueName() {
                return null;
            }
            
            public final void setValueName(@org.jetbrains.annotations.NotNull()
            java.lang.String p0) {
            }
            
            @org.jetbrains.annotations.NotNull()
            @java.lang.Override()
            public java.lang.String toString() {
                return null;
            }
            
            public Licence() {
                super();
            }
        }
    }
}
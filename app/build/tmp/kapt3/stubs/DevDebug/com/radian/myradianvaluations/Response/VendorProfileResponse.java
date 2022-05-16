package com.radian.myradianvaluations.Response;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u0016B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n8\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u0017"}, d2 = {"Lcom/radian/myradianvaluations/Response/VendorProfileResponse;", "", "()V", "data", "Lcom/radian/myradianvaluations/Response/VendorProfileResponse$Data;", "getData", "()Lcom/radian/myradianvaluations/Response/VendorProfileResponse$Data;", "setData", "(Lcom/radian/myradianvaluations/Response/VendorProfileResponse$Data;)V", "errorInfo", "Ljava/util/ArrayList;", "Lcom/radian/myradianvaluations/Response/ErrorInfo;", "getErrorInfo", "()Ljava/util/ArrayList;", "setErrorInfo", "(Ljava/util/ArrayList;)V", "status", "", "getStatus", "()Ljava/lang/String;", "setStatus", "(Ljava/lang/String;)V", "Data", "app_DevDebug"})
public final class VendorProfileResponse {
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Data")
    private com.radian.myradianvaluations.Response.VendorProfileResponse.Data data;
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "Status")
    private java.lang.String status = "";
    @org.jetbrains.annotations.NotNull()
    @com.google.gson.annotations.SerializedName(value = "ErrorInfo")
    private java.util.ArrayList<com.radian.myradianvaluations.Response.ErrorInfo> errorInfo;
    
    @org.jetbrains.annotations.NotNull()
    public final com.radian.myradianvaluations.Response.VendorProfileResponse.Data getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    com.radian.myradianvaluations.Response.VendorProfileResponse.Data p0) {
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
    
    public VendorProfileResponse() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b?\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u0018\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0006R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0006R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0006R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0006R\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0006R\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0006R\u0018\u0010\u0017\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0006R\u0018\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0006R\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0006R\u0018\u0010\u001d\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0006R\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0006R\u0018\u0010!\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0006R\u0018\u0010#\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0006R\u0018\u0010%\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0006R\u0018\u0010\'\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u0006R\u0018\u0010)\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0006R\u0018\u0010+\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0006R\u0018\u0010-\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0006R\u0018\u0010/\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010\u0006R\u0018\u00101\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010\u0006R\u0018\u00103\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u0010\u0006R\u0018\u00105\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010\u0006R\u0018\u00107\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0006R\u0018\u00109\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010\u0006R\u0018\u0010;\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\u0006R\u0018\u0010=\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010\u0006R\u0018\u0010?\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010\u0006R\u0018\u0010A\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010\u0006\u00a8\u0006C"}, d2 = {"Lcom/radian/myradianvaluations/Response/VendorProfileResponse$Data;", "", "()V", "aDDRESSID", "", "getADDRESSID", "()Ljava/lang/String;", "aDDRESSLINE1", "getADDRESSLINE1", "aDDRESSLINE2", "getADDRESSLINE2", "aSCVERIFIED", "getASCVERIFIED", "aSCVERIFIEDDATE", "getASCVERIFIEDDATE", "bAFLAG", "getBAFLAG", "cITY", "getCITY", "cOUNTY", "getCOUNTY", "cOUNTYCODE", "getCOUNTYCODE", "dOCDESCRIPTION", "getDOCDESCRIPTION", "dOCGROUP", "getDOCGROUP", "dOCID", "getDOCID", "dOCIDABBR", "getDOCIDABBR", "eOAMOUNT", "getEOAMOUNT", "eOCARRIER", "getEOCARRIER", "eOFLAG", "getEOFLAG", "eOPOLICYNO", "getEOPOLICYNO", "eXPIRYDATE", "getEXPIRYDATE", "eXPIRYDATE1", "getEXPIRYDATE1", "lICENSE", "getLICENSE", "lICENSEFLAG", "getLICENSEFLAG", "lICENSESTATE", "getLICENSESTATE", "lICENSETYPEID", "getLICENSETYPEID", "lICSTATUS", "getLICSTATUS", "sTATE", "getSTATE", "vENDORGROUPID", "getVENDORGROUPID", "vENDORID", "getVENDORID", "vENDORIDW9", "getVENDORIDW9", "vENDORNAME", "getVENDORNAME", "vPCATEGORY", "getVPCATEGORY", "zIP", "getZIP", "app_DevDebug"})
    public static final class Data {
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LICENSE")
        private final java.lang.String lICENSE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LICENSETYPEID")
        private final java.lang.String lICENSETYPEID = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LICSTATUS")
        private final java.lang.String lICSTATUS = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LICENSESTATE")
        private final java.lang.String lICENSESTATE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ASCVERIFIED")
        private final java.lang.String aSCVERIFIED = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ASCVERIFIEDDATE")
        private final java.lang.String aSCVERIFIEDDATE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "LICENSEFLAG")
        private final java.lang.String lICENSEFLAG = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.SerializedName(value = "VENDORGROUPID")
        private final java.lang.String vENDORGROUPID = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VPCATEGORY")
        private final java.lang.String vPCATEGORY = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EXPIRYDATE")
        private final java.lang.String eXPIRYDATE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOFLAG")
        private final java.lang.String eOFLAG = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOAMOUNT")
        private final java.lang.String eOAMOUNT = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOPOLICYNO")
        private final java.lang.String eOPOLICYNO = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EOCARRIER")
        private final java.lang.String eOCARRIER = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "EXPIRYDATE1")
        private final java.lang.String eXPIRYDATE1 = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VENDORID")
        private final java.lang.String vENDORID = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VENDOR_ID")
        private final java.lang.String vENDORIDW9 = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "VENDORNAME")
        private final java.lang.String vENDORNAME = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ADDRESSID")
        private final java.lang.String aDDRESSID = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "BAFLAG")
        private final java.lang.String bAFLAG = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ADDRESSLINE1")
        private final java.lang.String aDDRESSLINE1 = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ADDRESSLINE2")
        private final java.lang.String aDDRESSLINE2 = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "CITY")
        private final java.lang.String cITY = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "STATE")
        private final java.lang.String sTATE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "ZIP")
        private final java.lang.String zIP = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "COUNTY")
        private final java.lang.String cOUNTY = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "COUNTYCODE")
        private final java.lang.String cOUNTYCODE = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DOCGROUP")
        private final java.lang.String dOCGROUP = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DOCID")
        private final java.lang.String dOCID = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DOCDESCRIPTION")
        private final java.lang.String dOCDESCRIPTION = null;
        @org.jetbrains.annotations.Nullable()
        @com.google.gson.annotations.Expose()
        @com.google.gson.annotations.SerializedName(value = "DOCIDABBR")
        private final java.lang.String dOCIDABBR = null;
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLICENSE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLICENSETYPEID() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLICSTATUS() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLICENSESTATE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getASCVERIFIED() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getASCVERIFIEDDATE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getLICENSEFLAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVENDORGROUPID() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVPCATEGORY() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEXPIRYDATE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEOFLAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEOAMOUNT() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEOPOLICYNO() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEOCARRIER() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getEXPIRYDATE1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVENDORID() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVENDORIDW9() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getVENDORNAME() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getADDRESSID() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getBAFLAG() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getADDRESSLINE1() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getADDRESSLINE2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCITY() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getSTATE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getZIP() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCOUNTY() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCOUNTYCODE() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDOCGROUP() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDOCID() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDOCDESCRIPTION() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getDOCIDABBR() {
            return null;
        }
        
        public Data() {
            super();
        }
    }
}
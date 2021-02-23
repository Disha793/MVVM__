package com.radian.vendorbridge.Response

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose


class VendorProfileResponse {
    @SerializedName("Data")
    var data = Data()
    @SerializedName("Status")
    var status = ""
    @SerializedName("ErrorInfo")
    var errorInfo = ArrayList<ErrorInfo>()

    class Data {
        //For Licence
        @SerializedName("LICENSE")
        @Expose
        val lICENSE: String? = null
        @SerializedName("LICENSETYPEID")
        @Expose
        val lICENSETYPEID: String? = null
        @SerializedName("LICSTATUS")
        @Expose
        val lICSTATUS: String? = null
        @SerializedName("LICENSESTATE")
        @Expose
        val lICENSESTATE: String? = null
        @SerializedName("ASCVERIFIED")
        @Expose
        val aSCVERIFIED: String? = null
        @SerializedName("ASCVERIFIEDDATE")
        @Expose
        val aSCVERIFIEDDATE: String? = null

        @SerializedName("LICENSEFLAG")
        @Expose
        val lICENSEFLAG: String? = null
        //For EO
        @SerializedName("VENDORGROUPID")
        val vENDORGROUPID: String? = null
        @SerializedName("VPCATEGORY")
        @Expose
        val vPCATEGORY: String? = null
        @SerializedName("EXPIRYDATE")
        @Expose
        val eXPIRYDATE: String? = null
        @SerializedName("EOFLAG")
        @Expose
        val eOFLAG: String? = null
        @SerializedName("EOAMOUNT")
        @Expose
        val eOAMOUNT: String? = null
        @SerializedName("EOPOLICYNO")
        @Expose
        val eOPOLICYNO: String? = null
        @SerializedName("EOCARRIER")
        @Expose
        val eOCARRIER: String? = null
        @SerializedName("EXPIRYDATE1")
        @Expose
        val eXPIRYDATE1: String? = null
        //For W9
        @SerializedName("VENDORID")
        @Expose
        val vENDORID: String? = null
        @SerializedName("VENDOR_ID")
        @Expose
        val vENDORIDW9: String? = null

        @SerializedName("VENDORNAME")
        @Expose
        val vENDORNAME: String? = null
        @SerializedName("ADDRESSID")
        @Expose
        val aDDRESSID: String? = null
        @SerializedName("BAFLAG")
        @Expose
        val bAFLAG: String? = null
        @SerializedName("ADDRESSLINE1")
        @Expose
        val aDDRESSLINE1: String? = null
        @SerializedName("ADDRESSLINE2")
        @Expose
        val aDDRESSLINE2: String? = null
        @SerializedName("CITY")
        @Expose
        val cITY: String? = null
        @SerializedName("STATE")
        @Expose
        val sTATE: String? = null
        @SerializedName("ZIP")
        @Expose
        val zIP: String? = null
        @SerializedName("COUNTY")
        @Expose
        val cOUNTY: String? = null
        @SerializedName("COUNTYCODE")
        @Expose
        val cOUNTYCODE: String? = null
        @SerializedName("DOCGROUP")
        @Expose
        val dOCGROUP: String? = null
        @SerializedName("DOCID")
        @Expose
        val dOCID: String? = null
        @SerializedName("DOCDESCRIPTION")
        @Expose
        val dOCDESCRIPTION: String? = null
        @SerializedName("DOCIDABBR")
        @Expose
        val dOCIDABBR: String? = null

    }
}
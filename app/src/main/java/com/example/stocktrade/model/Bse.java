package com.example.stocktrade.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bse {

    @SerializedName("astCls")
    @Expose
    private String astCls;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("change")
    @Expose
    private String change;
    @SerializedName("changePer")
    @Expose
    private String changePer;
    @SerializedName("close")
    @Expose
    private String close;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("divider")
    @Expose
    private String divider;
    @SerializedName("exchName")
    @Expose
    private String exchName;
    @SerializedName("isinCode")
    @Expose
    private String isinCode;
    @SerializedName("ltp")
    @Expose
    private String ltp;
    @SerializedName("mktSegID")
    @Expose
    private String mktSegID;
    @SerializedName("precsn")
    @Expose
    private String precsn;
    @SerializedName("series")
    @Expose
    private String series;
    @SerializedName("symbolName")
    @Expose
    private String symbolName;
    @SerializedName("tokenID")
    @Expose
    private String tokenID;
    @SerializedName("value")
    @Expose
    private String value;
    @SerializedName("volume")
    @Expose
    private String volume;

    public String getAstCls() {
        return astCls;
    }

    public void setAstCls(String astCls) {
        this.astCls = astCls;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getChange() {
        return change;
    }

    public void setChange(String change) {
        this.change = change;
    }

    public String getChangePer() {
        return changePer;
    }

    public void setChangePer(String changePer) {
        this.changePer = changePer;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDivider() {
        return divider;
    }

    public void setDivider(String divider) {
        this.divider = divider;
    }

    public String getExchName() {
        return exchName;
    }

    public void setExchName(String exchName) {
        this.exchName = exchName;
    }

    public String getIsinCode() {
        return isinCode;
    }

    public void setIsinCode(String isinCode) {
        this.isinCode = isinCode;
    }

    public String getLtp() {
        return ltp;
    }

    public void setLtp(String ltp) {
        this.ltp = ltp;
    }

    public String getMktSegID() {
        return mktSegID;
    }

    public void setMktSegID(String mktSegID) {
        this.mktSegID = mktSegID;
    }

    public String getPrecsn() {
        return precsn;
    }

    public void setPrecsn(String precsn) {
        this.precsn = precsn;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public void setSymbolName(String symbolName) {
        this.symbolName = symbolName;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

}
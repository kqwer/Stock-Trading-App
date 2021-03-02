package com.example.stocktrade.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("appID")
    @Expose
    private String appID;
    @SerializedName("data")
    @Expose
    private Data data;
    @SerializedName("infoID")
    @Expose
    private String infoID;
    @SerializedName("msgID")
    @Expose
    private String msgID;
    @SerializedName("serverTime")
    @Expose
    private String serverTime;
    @SerializedName("svcGroup")
    @Expose
    private String svcGroup;
    @SerializedName("svcName")
    @Expose
    private String svcName;

    public String getAppID() {
        return appID;
    }

    public void setAppID(String appID) {
        this.appID = appID;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getInfoID() {
        return infoID;
    }

    public void setInfoID(String infoID) {
        this.infoID = infoID;
    }

    public String getMsgID() {
        return msgID;
    }

    public void setMsgID(String msgID) {
        this.msgID = msgID;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }

    public String getSvcGroup() {
        return svcGroup;
    }

    public void setSvcGroup(String svcGroup) {
        this.svcGroup = svcGroup;
    }

    public String getSvcName() {
        return svcName;
    }

    public void setSvcName(String svcName) {
        this.svcName = svcName;
    }

}

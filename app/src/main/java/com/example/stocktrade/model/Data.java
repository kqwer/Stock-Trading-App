package com.example.stocktrade.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    @SerializedName("bse")
    @Expose
    private List<Bse> bse = null;
    @SerializedName("bseLstUpdteTme")
    @Expose
    private String bseLstUpdteTme;
    @SerializedName("nse")
    @Expose
    private List<Nse> nse = null;
    @SerializedName("nseLstUpdteTme")
    @Expose
    private String nseLstUpdteTme;

    public List<Bse> getBse() {
        return bse;
    }

    public void setBse(List<Bse> bse) {
        this.bse = bse;
    }

    public String getBseLstUpdteTme() {
        return bseLstUpdteTme;
    }

    public void setBseLstUpdteTme(String bseLstUpdteTme) {
        this.bseLstUpdteTme = bseLstUpdteTme;
    }

    public List<Nse> getNse() {
        return nse;
    }

    public void setNse(List<Nse> nse) {
        this.nse = nse;
    }

    public String getNseLstUpdteTme() {
        return nseLstUpdteTme;
    }

    public void setNseLstUpdteTme(String nseLstUpdteTme) {
        this.nseLstUpdteTme = nseLstUpdteTme;
    }

}

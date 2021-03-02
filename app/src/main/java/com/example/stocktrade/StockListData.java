package com.example.stocktrade;

public class StockListData {
    private String id;
    private  String name;
    private String details;
    private  String ltp;
    private  String changeper;
    private  String changeprice;
    private  String quantity;
    private String price;

    public StockListData(String id, String name , String details, String ltp, String changeper, String changeprice, String quantity, String price) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.ltp = ltp;
        this.changeper = changeper;
        this.changeprice = changeprice;
        this.quantity = quantity;
        this.price = price;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLtp() {
        return ltp;
    }

    public void setLtp(String ltp) {
        this.ltp = ltp;
    }

    public String getChangeper() {
        return changeper;
    }

    public void setChangeper(String changeper) {
        this.changeper = changeper;
    }

    public String getChangeprice() {
        return changeprice;
    }

    public void setChangeprice(String changeprice) {
        this.changeprice = changeprice;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}

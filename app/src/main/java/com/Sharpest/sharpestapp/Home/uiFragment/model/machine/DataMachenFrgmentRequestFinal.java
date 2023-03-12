package com.Sharpest.sharpestapp.Home.uiFragment.model.machine;

public class DataMachenFrgmentRequestFinal {


    private Integer id;
    private String itemNameAr;

    private String bannarImagePath;

    private String orderDate;

    private String orderStatusNameAr;

    private Double couponValue;


    public DataMachenFrgmentRequestFinal() {
    }

    public DataMachenFrgmentRequestFinal(Integer id, String itemNameAr, String bannarImagePath, String orderDate, String orderStatusNameAr, Double couponValue) {
        this.id = id;
        this.itemNameAr = itemNameAr;
        this.bannarImagePath = bannarImagePath;
        this.orderDate = orderDate;
        this.orderStatusNameAr = orderStatusNameAr;
        this.couponValue = couponValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemNameAr() {
        return itemNameAr;
    }

    public void setItemNameAr(String itemNameAr) {
        this.itemNameAr = itemNameAr;
    }

    public String getBannarImagePath() {
        return bannarImagePath;
    }

    public void setBannarImagePath(String bannarImagePath) {
        this.bannarImagePath = bannarImagePath;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderStatusNameAr() {
        return orderStatusNameAr;
    }

    public void setOrderStatusNameAr(String orderStatusNameAr) {
        this.orderStatusNameAr = orderStatusNameAr;
    }

    public Double getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Double couponValue) {
        this.couponValue = couponValue;
    }

}


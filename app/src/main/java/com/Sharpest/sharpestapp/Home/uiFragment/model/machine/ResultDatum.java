
package com.Sharpest.sharpestapp.Home.uiFragment.model.machine;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemNameAr")
    @Expose
    private String itemNameAr;
    @SerializedName("bannarImagePath")
    @Expose
    private String bannarImagePath;
    @SerializedName("orderDate")
    @Expose
    private String orderDate;
    @SerializedName("orderStatusNameAr")
    @Expose
    private String orderStatusNameAr;
    @SerializedName("couponValue")
    @Expose
    private Double couponValue=null;

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

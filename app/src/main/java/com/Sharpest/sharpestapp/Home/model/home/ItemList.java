
package com.Sharpest.sharpestapp.Home.model.home;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemNameAr")
    @Expose
    private String itemNameAr;
    @SerializedName("itemNameEn")
    @Expose
    private Object itemNameEn;
    @SerializedName("bannarImagePath")
    @Expose
    private String bannarImagePath;
    @SerializedName("itemPrice")
    @Expose
    private Object itemPrice;

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

    public Object getItemNameEn() {
        return itemNameEn;
    }

    public void setItemNameEn(Object itemNameEn) {
        this.itemNameEn = itemNameEn;
    }

    public String getBannarImagePath() {
        return bannarImagePath;
    }

    public void setBannarImagePath(String bannarImagePath) {
        this.bannarImagePath = bannarImagePath;
    }

    public Object getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Object itemPrice) {
        this.itemPrice = itemPrice;
    }

}

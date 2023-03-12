package com.Sharpest.sharpestapp.Home.model;

public class Data_HomeFavoritesList {

    String id ,itemNameAr,itemNameEn,bannarImagePath;

    public Data_HomeFavoritesList() {
    }

    public Data_HomeFavoritesList(String id, String itemNameAr, String itemNameEn, String bannarImagePath) {
        this.id = id;
        this.itemNameAr = itemNameAr;
        this.itemNameEn = itemNameEn;
        this.bannarImagePath = bannarImagePath;
    }

    public String getItemNameAr() {
        return itemNameAr;
    }

    public void setItemNameAr(String itemNameAr) {
        this.itemNameAr = itemNameAr;
    }

    public String getItemNameEn() {
        return itemNameEn;
    }

    public void setItemNameEn(String itemNameEn) {
        this.itemNameEn = itemNameEn;
    }

    public String getBannarImagePath() {
        return bannarImagePath;
    }

    public void setBannarImagePath(String bannarImagePath) {
        this.bannarImagePath = bannarImagePath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}

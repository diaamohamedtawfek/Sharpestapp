
package com.Sharpest.sharpestapp.model.ProductCategory;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemNameAr")
    @Expose
    private Object itemNameAr;
    @SerializedName("itemNameEn")
    @Expose
    private Object itemNameEn;
    @SerializedName("bannarImagePath")
    @Expose
    private String bannarImagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getItemNameAr() {
        return itemNameAr;
    }

    public void setItemNameAr(Object itemNameAr) {
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

}

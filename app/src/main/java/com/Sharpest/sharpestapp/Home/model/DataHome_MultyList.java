package com.Sharpest.sharpestapp.Home.model;

import com.Sharpest.sharpestapp.Home.model.home.ItemList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataHome_MultyList {

    String id,itemCategoryNameAr;
    @SerializedName("itemList")
    @Expose
    private List<ItemList> itemList = null;

    public DataHome_MultyList(String id, String itemCategoryNameAr, List<ItemList> itemList) {
        this.id = id;
        this.itemCategoryNameAr = itemCategoryNameAr;
        this.itemList = itemList;
    }

    public DataHome_MultyList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemCategoryNameAr() {
        return itemCategoryNameAr;
    }

    public void setItemCategoryNameAr(String itemCategoryNameAr) {
        this.itemCategoryNameAr = itemCategoryNameAr;
    }

    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }
}

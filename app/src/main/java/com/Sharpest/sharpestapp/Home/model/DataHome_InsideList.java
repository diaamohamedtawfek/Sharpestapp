package com.Sharpest.sharpestapp.Home.model;

import com.Sharpest.sharpestapp.Home.model.home.ItemList;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataHome_InsideList {

    @SerializedName("itemList")
    @Expose
    private List<ItemList> itemList = null;

    public DataHome_InsideList(List<ItemList> itemList) {
        this.itemList = itemList;
    }

    public List<ItemList> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemList> itemList) {
        this.itemList = itemList;
    }
}

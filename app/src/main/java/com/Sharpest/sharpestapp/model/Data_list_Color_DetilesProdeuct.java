package com.Sharpest.sharpestapp.model;

import com.Sharpest.sharpestapp.model.DetalsProdect.ItemDetail;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data_list_Color_DetilesProdeuct {

    @SerializedName("itemDetails")
    @Expose
    private List<ItemDetail> itemDetails = null;

    public Data_list_Color_DetilesProdeuct(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public Data_list_Color_DetilesProdeuct() {
    }

    public List<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(List<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }
}

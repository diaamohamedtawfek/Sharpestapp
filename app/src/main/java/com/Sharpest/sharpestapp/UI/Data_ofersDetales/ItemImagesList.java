
package com.Sharpest.sharpestapp.UI.Data_ofersDetales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemImagesList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemImagePath")
    @Expose
    private String itemImagePath;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemImagesList() {
    }

    /**
     * 
     * @param itemImagePath
     * @param id
     */
    public ItemImagesList(Integer id, String itemImagePath) {
        super();
        this.id = id;
        this.itemImagePath = itemImagePath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemImagePath() {
        return itemImagePath;
    }

    public void setItemImagePath(String itemImagePath) {
        this.itemImagePath = itemImagePath;
    }

}

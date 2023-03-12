
package com.Sharpest.sharpestapp.UI.Data_ofersDetales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemColling {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemCollingAr")
    @Expose
    private String itemCollingAr;
    @SerializedName("itemCollingEn")
    @Expose
    private String itemCollingEn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemColling() {
    }

    /**
     * 
     * @param itemCollingEn
     * @param id
     * @param itemCollingAr
     */
    public ItemColling(Integer id, String itemCollingAr, String itemCollingEn) {
        super();
        this.id = id;
        this.itemCollingAr = itemCollingAr;
        this.itemCollingEn = itemCollingEn;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCollingAr() {
        return itemCollingAr;
    }

    public void setItemCollingAr(String itemCollingAr) {
        this.itemCollingAr = itemCollingAr;
    }

    public String getItemCollingEn() {
        return itemCollingEn;
    }

    public void setItemCollingEn(String itemCollingEn) {
        this.itemCollingEn = itemCollingEn;
    }

}


package com.Sharpest.sharpestapp.UI.Data_ofersDetales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemCategory {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("itemCategoryNameAr")
    @Expose
    private String itemCategoryNameAr;
    @SerializedName("itemCategoryNameEn")
    @Expose
    private String itemCategoryNameEn;
    @SerializedName("itemList")
    @Expose
    private Object itemList;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ItemCategory() {
    }

    /**
     * 
     * @param itemCategoryNameEn
     * @param itemList
     * @param id
     * @param itemCategoryNameAr
     */
    public ItemCategory(Integer id, String itemCategoryNameAr, String itemCategoryNameEn, Object itemList) {
        super();
        this.id = id;
        this.itemCategoryNameAr = itemCategoryNameAr;
        this.itemCategoryNameEn = itemCategoryNameEn;
        this.itemList = itemList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemCategoryNameAr() {
        return itemCategoryNameAr;
    }

    public void setItemCategoryNameAr(String itemCategoryNameAr) {
        this.itemCategoryNameAr = itemCategoryNameAr;
    }

    public String getItemCategoryNameEn() {
        return itemCategoryNameEn;
    }

    public void setItemCategoryNameEn(String itemCategoryNameEn) {
        this.itemCategoryNameEn = itemCategoryNameEn;
    }

    public Object getItemList() {
        return itemList;
    }

    public void setItemList(Object itemList) {
        this.itemList = itemList;
    }

}

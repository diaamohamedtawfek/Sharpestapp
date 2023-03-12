
package com.Sharpest.sharpestapp.model.DataResponseBooking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderStatusLookup {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("orderStatusNameAr")
    @Expose
    private Object orderStatusNameAr;
    @SerializedName("orderStatusNameEn")
    @Expose
    private Object orderStatusNameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getOrderStatusNameAr() {
        return orderStatusNameAr;
    }

    public void setOrderStatusNameAr(Object orderStatusNameAr) {
        this.orderStatusNameAr = orderStatusNameAr;
    }

    public Object getOrderStatusNameEn() {
        return orderStatusNameEn;
    }

    public void setOrderStatusNameEn(Object orderStatusNameEn) {
        this.orderStatusNameEn = orderStatusNameEn;
    }

}

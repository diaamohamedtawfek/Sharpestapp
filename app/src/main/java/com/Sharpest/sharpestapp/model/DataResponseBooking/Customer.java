
package com.Sharpest.sharpestapp.model.DataResponseBooking;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("customerNameAr")
    @Expose
    private Object customerNameAr;
    @SerializedName("customerNameEn")
    @Expose
    private Object customerNameEn;
    @SerializedName("customerOrders")
    @Expose
    private Object customerOrders;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCustomerNameAr() {
        return customerNameAr;
    }

    public void setCustomerNameAr(Object customerNameAr) {
        this.customerNameAr = customerNameAr;
    }

    public Object getCustomerNameEn() {
        return customerNameEn;
    }

    public void setCustomerNameEn(Object customerNameEn) {
        this.customerNameEn = customerNameEn;
    }

    public Object getCustomerOrders() {
        return customerOrders;
    }

    public void setCustomerOrders(Object customerOrders) {
        this.customerOrders = customerOrders;
    }

}

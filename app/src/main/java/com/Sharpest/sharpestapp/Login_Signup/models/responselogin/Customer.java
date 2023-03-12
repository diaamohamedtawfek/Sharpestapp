
package com.Sharpest.sharpestapp.Login_Signup.models.responselogin;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Object id;
    @SerializedName("customerNameAr")
    @Expose
    private String customerNameAr;
    @SerializedName("customerNameEn")
    @Expose
    private Object customerNameEn;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("phoneNumber1")
    @Expose
    private String phoneNumber1;
    @SerializedName("phoneNumber2")
    @Expose
    private Object phoneNumber2;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public String getCustomerNameAr() {
        return customerNameAr;
    }

    public void setCustomerNameAr(String customerNameAr) {
        this.customerNameAr = customerNameAr;
    }

    public Object getCustomerNameEn() {
        return customerNameEn;
    }

    public void setCustomerNameEn(Object customerNameEn) {
        this.customerNameEn = customerNameEn;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

    public Object getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(Object phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

}

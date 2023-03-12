
package com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataUpdateProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("address")
    @Expose
    private String address;
    @SerializedName("customerNameAr")
    @Expose
    private String customerNameAr;
    @SerializedName("phoneNumber1")
    @Expose
    private String phoneNumber1;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Customer() {
    }

    /**
     * 
     * @param address
     * @param phoneNumber1
     * @param id
     * @param customerNameAr
     */
    public Customer(Integer id, String address, String customerNameAr, String phoneNumber1) {
        super();
        this.id = id;
        this.address = address;
        this.customerNameAr = customerNameAr;
        this.phoneNumber1 = phoneNumber1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerNameAr() {
        return customerNameAr;
    }

    public void setCustomerNameAr(String customerNameAr) {
        this.customerNameAr = customerNameAr;
    }

    public String getPhoneNumber1() {
        return phoneNumber1;
    }

    public void setPhoneNumber1(String phoneNumber1) {
        this.phoneNumber1 = phoneNumber1;
    }

}

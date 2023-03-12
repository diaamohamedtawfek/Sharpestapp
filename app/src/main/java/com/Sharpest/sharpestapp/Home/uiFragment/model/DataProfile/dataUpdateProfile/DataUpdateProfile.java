
package com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataUpdateProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataUpdateProfile {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("whatsupPhoneNumber")
    @Expose
    private String whatsupPhoneNumber;
    @SerializedName("customer")
    @Expose
    private Customer customer;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataUpdateProfile() {
    }

    /**
     * 
     * @param whatsupPhoneNumber
     * @param id
     * @param customer
     */
    public DataUpdateProfile(Integer id, String whatsupPhoneNumber, Customer customer) {
        super();
        this.id = id;
        this.whatsupPhoneNumber = whatsupPhoneNumber;
        this.customer = customer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWhatsupPhoneNumber() {
        return whatsupPhoneNumber;
    }

    public void setWhatsupPhoneNumber(String whatsupPhoneNumber) {
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

}

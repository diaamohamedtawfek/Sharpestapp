
package com.Sharpest.sharpestapp.model.DataSeana_Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceRequestHeader {

    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerAddress")
    @Expose
    private String customerAddress;
    @SerializedName("customerPhone")
    @Expose
    private String customerPhone;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceRequestHeader() {
    }

    /**
     * 
     * @param customerAddress
     * @param customerPhone
     * @param customerName
     * @param customer
     */
    public ServiceRequestHeader(Customer customer, String customerName, String customerAddress, String customerPhone) {
        super();
        this.customer = customer;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerPhone = customerPhone;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

}

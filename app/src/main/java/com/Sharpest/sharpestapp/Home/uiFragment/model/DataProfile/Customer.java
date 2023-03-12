
package com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdById")
    @Expose
    private Object createdById;
    @SerializedName("createdDate")
    @Expose
    private Object createdDate;
    @SerializedName("lastModifiedById")
    @Expose
    private Object lastModifiedById;
    @SerializedName("lastModifiedDate")
    @Expose
    private Object lastModifiedDate;
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
    private String phoneNumber2;
    @SerializedName("couponValue")
    @Expose
    private Double couponValue;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Customer() {
    }

    /**
     * 
     * @param createdDate
     * @param customerNameEn
     * @param address
     * @param lastModifiedDate
     * @param lastModifiedById
     * @param phoneNumber1
     * @param phoneNumber2
     * @param id
     * @param customerNameAr
     * @param profileImage
     * @param createdById
     * @param couponValue
     */
    public Customer(Integer id, Object createdById, Object createdDate, Object lastModifiedById, Object lastModifiedDate, String customerNameAr, Object customerNameEn, String address, String phoneNumber1, String phoneNumber2, Double couponValue, String profileImage) {
        super();
        this.id = id;
        this.createdById = createdById;
        this.createdDate = createdDate;
        this.lastModifiedById = lastModifiedById;
        this.lastModifiedDate = lastModifiedDate;
        this.customerNameAr = customerNameAr;
        this.customerNameEn = customerNameEn;
        this.address = address;
        this.phoneNumber1 = phoneNumber1;
        this.phoneNumber2 = phoneNumber2;
        this.couponValue = couponValue;
        this.profileImage = profileImage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Object createdById) {
        this.createdById = createdById;
    }

    public Object getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    public Object getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Object lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Object getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Object lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
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

    public String getPhoneNumber2() {
        return phoneNumber2;
    }

    public void setPhoneNumber2(String phoneNumber2) {
        this.phoneNumber2 = phoneNumber2;
    }

    public Double getCouponValue() {
        return couponValue;
    }

    public void setCouponValue(Double couponValue) {
        this.couponValue = couponValue;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

}

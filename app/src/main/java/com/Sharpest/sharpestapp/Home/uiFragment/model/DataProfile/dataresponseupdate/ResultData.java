
package com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile.dataresponseupdate;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("userName")
    @Expose
    private String userName;
    @SerializedName("userActiveFlag")
    @Expose
    private Integer userActiveFlag;
    @SerializedName("jwt")
    @Expose
    private Object jwt;
    @SerializedName("employee")
    @Expose
    private Object employee;
    @SerializedName("securityRole")
    @Expose
    private Object securityRole;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("profileImage")
    @Expose
    private String profileImage;
    @SerializedName("whatsupPhoneNumber")
    @Expose
    private String whatsupPhoneNumber;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultData() {
    }

    /**
     * 
     * @param whatsupPhoneNumber
     * @param jwt
     * @param id
     * @param userActiveFlag
     * @param profileImage
     * @param userName
     * @param employee
     * @param securityRole
     * @param customer
     */
    public ResultData(Integer id, String userName, Integer userActiveFlag, Object jwt, Object employee, Object securityRole, Customer customer, String profileImage, String whatsupPhoneNumber) {
        super();
        this.id = id;
        this.userName = userName;
        this.userActiveFlag = userActiveFlag;
        this.jwt = jwt;
        this.employee = employee;
        this.securityRole = securityRole;
        this.customer = customer;
        this.profileImage = profileImage;
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserActiveFlag() {
        return userActiveFlag;
    }

    public void setUserActiveFlag(Integer userActiveFlag) {
        this.userActiveFlag = userActiveFlag;
    }

    public Object getJwt() {
        return jwt;
    }

    public void setJwt(Object jwt) {
        this.jwt = jwt;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public Object getSecurityRole() {
        return securityRole;
    }

    public void setSecurityRole(Object securityRole) {
        this.securityRole = securityRole;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getWhatsupPhoneNumber() {
        return whatsupPhoneNumber;
    }

    public void setWhatsupPhoneNumber(String whatsupPhoneNumber) {
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }

}

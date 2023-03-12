
package com.Sharpest.sharpestapp.Home.uiFragment.model.DataProfile;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SecurityRole {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("securityRole")
    @Expose
    private String securityRole;
    @SerializedName("securityRoleDescription")
    @Expose
    private String securityRoleDescription;
    @SerializedName("securityRoleCustomerFlag")
    @Expose
    private Integer securityRoleCustomerFlag;
    @SerializedName("userRoleList")
    @Expose
    private Object userRoleList;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SecurityRole() {
    }

    /**
     * 
     * @param securityRoleDescription
     * @param securityRoleCustomerFlag
     * @param id
     * @param securityRole
     * @param userRoleList
     */
    public SecurityRole(Integer id, String securityRole, String securityRoleDescription, Integer securityRoleCustomerFlag, Object userRoleList) {
        super();
        this.id = id;
        this.securityRole = securityRole;
        this.securityRoleDescription = securityRoleDescription;
        this.securityRoleCustomerFlag = securityRoleCustomerFlag;
        this.userRoleList = userRoleList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSecurityRole() {
        return securityRole;
    }

    public void setSecurityRole(String securityRole) {
        this.securityRole = securityRole;
    }

    public String getSecurityRoleDescription() {
        return securityRoleDescription;
    }

    public void setSecurityRoleDescription(String securityRoleDescription) {
        this.securityRoleDescription = securityRoleDescription;
    }

    public Integer getSecurityRoleCustomerFlag() {
        return securityRoleCustomerFlag;
    }

    public void setSecurityRoleCustomerFlag(Integer securityRoleCustomerFlag) {
        this.securityRoleCustomerFlag = securityRoleCustomerFlag;
    }

    public Object getUserRoleList() {
        return userRoleList;
    }

    public void setUserRoleList(Object userRoleList) {
        this.userRoleList = userRoleList;
    }

}

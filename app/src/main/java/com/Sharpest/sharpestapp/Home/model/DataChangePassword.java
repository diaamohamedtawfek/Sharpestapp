
package com.Sharpest.sharpestapp.Home.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataChangePassword {

    @SerializedName("currentPassword")
    @Expose
    private String currentPassword;
    @SerializedName("newPassword")
    @Expose
    private String newPassword;
    @SerializedName("confirmPassword")
    @Expose
    private String confirmPassword;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataChangePassword() {
    }

    /**
     * 
     * @param newPassword
     * @param confirmPassword
     * @param currentPassword
     */
    public DataChangePassword(String currentPassword, String newPassword, String confirmPassword) {
        super();
        this.currentPassword = currentPassword;
        this.newPassword = newPassword;
        this.confirmPassword = confirmPassword;
    }

    public String getCurrentPassword() {
        return currentPassword;
    }

    public void setCurrentPassword(String currentPassword) {
        this.currentPassword = currentPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

}

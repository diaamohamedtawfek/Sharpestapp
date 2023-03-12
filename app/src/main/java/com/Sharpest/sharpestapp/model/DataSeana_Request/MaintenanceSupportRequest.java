
package com.Sharpest.sharpestapp.model.DataSeana_Request;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MaintenanceSupportRequest {

    @SerializedName("customerAddress")
    @Expose
    private String customerAddress;
    @SerializedName("latLocation")
    @Expose
    private Double latLocation;
    @SerializedName("lngLocation")
    @Expose
    private Double lngLocation;
    @SerializedName("machineModel")
    @Expose
    private String machineModel;
    @SerializedName("machineType")
    @Expose
    private String machineType;
    @SerializedName("workingArea")
    @Expose
    private String workingArea;
    @SerializedName("machinePower")
    @Expose
    private String machinePower;
    @SerializedName("requestNote")
    @Expose
    private String requestNote;

    /**
     * No args constructor for use in serialization
     * 
     */
    public MaintenanceSupportRequest() {
    }

    /**
     * 
     * @param customerAddress
     * @param machineModel
     * @param workingArea
     * @param machinePower
     * @param lngLocation
     * @param requestNote
     * @param machineType
     * @param latLocation
     */
    public MaintenanceSupportRequest(String customerAddress, Double latLocation, Double lngLocation, String machineModel, String machineType, String workingArea, String machinePower, String requestNote) {
        super();
        this.customerAddress = customerAddress;
        this.latLocation = latLocation;
        this.lngLocation = lngLocation;
        this.machineModel = machineModel;
        this.machineType = machineType;
        this.workingArea = workingArea;
        this.machinePower = machinePower;
        this.requestNote = requestNote;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getLatLocation() {
        return latLocation;
    }

    public void setLatLocation(Double latLocation) {
        this.latLocation = latLocation;
    }

    public Double getLngLocation() {
        return lngLocation;
    }

    public void setLngLocation(Double lngLocation) {
        this.lngLocation = lngLocation;
    }

    public String getMachineModel() {
        return machineModel;
    }

    public void setMachineModel(String machineModel) {
        this.machineModel = machineModel;
    }

    public String getMachineType() {
        return machineType;
    }

    public void setMachineType(String machineType) {
        this.machineType = machineType;
    }

    public String getWorkingArea() {
        return workingArea;
    }

    public void setWorkingArea(String workingArea) {
        this.workingArea = workingArea;
    }

    public String getMachinePower() {
        return machinePower;
    }

    public void setMachinePower(String machinePower) {
        this.machinePower = machinePower;
    }

    public String getRequestNote() {
        return requestNote;
    }

    public void setRequestNote(String requestNote) {
        this.requestNote = requestNote;
    }

}


package com.Sharpest.sharpestapp.model.DataDedginProgramingRequest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DesignProgramming {

    @SerializedName("requestedDescription")
    @Expose
    private String requestedDescription;
    @SerializedName("designMaterial")
    @Expose
    private String designMaterial;
    @SerializedName("widthHight")
    @Expose
    private String widthHight;
    @SerializedName("usingMachine")
    @Expose
    private String usingMachine;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DesignProgramming() {
    }

    /**
     * 
     * @param widthHight
     * @param designMaterial
     * @param usingMachine
     * @param requestedDescription
     */
    public DesignProgramming(String requestedDescription, String designMaterial, String widthHight, String usingMachine) {
        super();
        this.requestedDescription = requestedDescription;
        this.designMaterial = designMaterial;
        this.widthHight = widthHight;
        this.usingMachine = usingMachine;
    }

    public String getRequestedDescription() {
        return requestedDescription;
    }

    public void setRequestedDescription(String requestedDescription) {
        this.requestedDescription = requestedDescription;
    }

    public String getDesignMaterial() {
        return designMaterial;
    }

    public void setDesignMaterial(String designMaterial) {
        this.designMaterial = designMaterial;
    }

    public String getWidthHight() {
        return widthHight;
    }

    public void setWidthHight(String widthHight) {
        this.widthHight = widthHight;
    }

    public String getUsingMachine() {
        return usingMachine;
    }

    public void setUsingMachine(String usingMachine) {
        this.usingMachine = usingMachine;
    }

}

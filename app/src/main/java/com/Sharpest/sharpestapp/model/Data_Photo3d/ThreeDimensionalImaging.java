
package com.Sharpest.sharpestapp.model.Data_Photo3d;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThreeDimensionalImaging {

    @SerializedName("customerPhoneNumber")
    @Expose
    private String customerPhoneNumber;
    @SerializedName("customerAddress")
    @Expose
    private String customerAddress;
    @SerializedName("printingProduct")
    @Expose
    private String printingProduct;
    @SerializedName("usedMaterial")
    @Expose
    private String usedMaterial;
    @SerializedName("imagingArea")
    @Expose
    private String imagingArea;
    @SerializedName("requestFileExtention")
    @Expose
    private String requestFileExtention;

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPrintingProduct() {
        return printingProduct;
    }

    public void setPrintingProduct(String printingProduct) {
        this.printingProduct = printingProduct;
    }

    public String getUsedMaterial() {
        return usedMaterial;
    }

    public void setUsedMaterial(String usedMaterial) {
        this.usedMaterial = usedMaterial;
    }

    public String getImagingArea() {
        return imagingArea;
    }

    public void setImagingArea(String imagingArea) {
        this.imagingArea = imagingArea;
    }

    public String getRequestFileExtention() {
        return requestFileExtention;
    }

    public void setRequestFileExtention(String requestFileExtention) {
        this.requestFileExtention = requestFileExtention;
    }

}


package com.Sharpest.sharpestapp.UI.service_Responce.modelService.desgnAndPrograming;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceRequestType {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("serviceRequestTypeNameAr")
    @Expose
    private String serviceRequestTypeNameAr;
    @SerializedName("serviceRequestTypeNameEn")
    @Expose
    private String serviceRequestTypeNameEn;
    @SerializedName("imageBannerPath")
    @Expose
    private Object imageBannerPath;
    @SerializedName("serviceRequestActiveFlag")
    @Expose
    private Integer serviceRequestActiveFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getServiceRequestTypeNameAr() {
        return serviceRequestTypeNameAr;
    }

    public void setServiceRequestTypeNameAr(String serviceRequestTypeNameAr) {
        this.serviceRequestTypeNameAr = serviceRequestTypeNameAr;
    }

    public String getServiceRequestTypeNameEn() {
        return serviceRequestTypeNameEn;
    }

    public void setServiceRequestTypeNameEn(String serviceRequestTypeNameEn) {
        this.serviceRequestTypeNameEn = serviceRequestTypeNameEn;
    }

    public Object getImageBannerPath() {
        return imageBannerPath;
    }

    public void setImageBannerPath(Object imageBannerPath) {
        this.imageBannerPath = imageBannerPath;
    }

    public Integer getServiceRequestActiveFlag() {
        return serviceRequestActiveFlag;
    }

    public void setServiceRequestActiveFlag(Integer serviceRequestActiveFlag) {
        this.serviceRequestActiveFlag = serviceRequestActiveFlag;
    }

}

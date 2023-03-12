
package com.Sharpest.sharpestapp.UI.service_Responce.dataResponse_url_offers;

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
    private Object serviceRequestActiveFlag;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceRequestType() {
    }

    /**
     * 
     * @param serviceRequestTypeNameAr
     * @param imageBannerPath
     * @param serviceRequestTypeNameEn
     * @param id
     * @param serviceRequestActiveFlag
     */
    public ServiceRequestType(Integer id, String serviceRequestTypeNameAr, String serviceRequestTypeNameEn, Object imageBannerPath, Object serviceRequestActiveFlag) {
        super();
        this.id = id;
        this.serviceRequestTypeNameAr = serviceRequestTypeNameAr;
        this.serviceRequestTypeNameEn = serviceRequestTypeNameEn;
        this.imageBannerPath = imageBannerPath;
        this.serviceRequestActiveFlag = serviceRequestActiveFlag;
    }

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

    public Object getServiceRequestActiveFlag() {
        return serviceRequestActiveFlag;
    }

    public void setServiceRequestActiveFlag(Object serviceRequestActiveFlag) {
        this.serviceRequestActiveFlag = serviceRequestActiveFlag;
    }

}

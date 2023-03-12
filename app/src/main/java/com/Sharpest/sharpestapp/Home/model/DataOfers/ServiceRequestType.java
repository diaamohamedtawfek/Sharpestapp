package com.Sharpest.sharpestapp.Home.model.DataOfers;

public class ServiceRequestType {
    int id;
    String serviceRequestTypeNameAr, serviceRequestTypeNameEn, imageBannerPath, serviceRequestActiveFlag ;


    public ServiceRequestType(int id, String serviceRequestTypeNameAr, String serviceRequestTypeNameEn, String imageBannerPath, String serviceRequestActiveFlag) {
        this.id = id;
        this.serviceRequestTypeNameAr = serviceRequestTypeNameAr;
        this.serviceRequestTypeNameEn = serviceRequestTypeNameEn;
        this.imageBannerPath = imageBannerPath;
        this.serviceRequestActiveFlag = serviceRequestActiveFlag;
    }


    public ServiceRequestType() {
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public String getImageBannerPath() {
        return imageBannerPath;
    }

    public void setImageBannerPath(String imageBannerPath) {
        this.imageBannerPath = imageBannerPath;
    }

    public String getServiceRequestActiveFlag() {
        return serviceRequestActiveFlag;
    }

    public void setServiceRequestActiveFlag(String serviceRequestActiveFlag) {
        this.serviceRequestActiveFlag = serviceRequestActiveFlag;
    }
}

package com.Sharpest.sharpestapp.Home.uiFragment.model.serviceMyorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataServiceMyorderfrgmentRequestFinal {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("requestDate")
    @Expose
    private String requestDate;
    @SerializedName("serviceRequestTypeNameAr")
    @Expose
    private String serviceRequestTypeNameAr;
    @SerializedName("requestHeaderStatusNameAr")
    @Expose
    private String requestHeaderStatusNameAr;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getServiceRequestTypeNameAr() {
        return serviceRequestTypeNameAr;
    }

    public void setServiceRequestTypeNameAr(String serviceRequestTypeNameAr) {
        this.serviceRequestTypeNameAr = serviceRequestTypeNameAr;
    }

    public String getRequestHeaderStatusNameAr() {
        return requestHeaderStatusNameAr;
    }

    public void setRequestHeaderStatusNameAr(String requestHeaderStatusNameAr) {
        this.requestHeaderStatusNameAr = requestHeaderStatusNameAr;
    }


    public DataServiceMyorderfrgmentRequestFinal() {
    }

    public DataServiceMyorderfrgmentRequestFinal(Integer id, String requestDate, String serviceRequestTypeNameAr, String requestHeaderStatusNameAr) {
        this.id = id;
        this.requestDate = requestDate;
        this.serviceRequestTypeNameAr = serviceRequestTypeNameAr;
        this.requestHeaderStatusNameAr = requestHeaderStatusNameAr;
    }
}



package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffersMobileDto {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("offerExpireDate")
    @Expose
    private String offerExpireDate;
    @SerializedName("offerActiveFlag")
    @Expose
    private Integer offerActiveFlag;
    @SerializedName("offerImagePath")
    @Expose
    private String offerImagePath;
    @SerializedName("offerValue")
    @Expose
    private String offerValue;
    @SerializedName("item")
    @Expose
    private Object item;
    @SerializedName("course")
    @Expose
    private Object course;
    @SerializedName("serviceRequestType")
    @Expose
    private Object serviceRequestType;
//    @SerializedName("serviceRequestHeaderList")
//    @Expose
//    private List<ServiceRequestHeaderList> serviceRequestHeaderList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public OffersMobileDto() {
    }

    /**
     * 
     * @param serviceRequestType
     * @param item
     * @param offerExpireDate
     * @param course
     * @param offerImagePath
     * @param id
     * @param offerActiveFlag
     * @param offerValue
     */
    public OffersMobileDto(Integer id, String offerExpireDate, Integer offerActiveFlag, String offerImagePath, String offerValue, Object item, Object course, Object serviceRequestType) {
        super();
        this.id = id;
        this.offerExpireDate = offerExpireDate;
        this.offerActiveFlag = offerActiveFlag;
        this.offerImagePath = offerImagePath;
        this.offerValue = offerValue;
        this.item = item;
        this.course = course;
        this.serviceRequestType = serviceRequestType;
//        this.serviceRequestHeaderList = serviceRequestHeaderList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfferExpireDate() {
        return offerExpireDate;
    }

    public void setOfferExpireDate(String offerExpireDate) {
        this.offerExpireDate = offerExpireDate;
    }

    public Integer getOfferActiveFlag() {
        return offerActiveFlag;
    }

    public void setOfferActiveFlag(Integer offerActiveFlag) {
        this.offerActiveFlag = offerActiveFlag;
    }

    public String getOfferImagePath() {
        return offerImagePath;
    }

    public void setOfferImagePath(String offerImagePath) {
        this.offerImagePath = offerImagePath;
    }

    public String getOfferValue() {
        return offerValue;
    }

    public void setOfferValue(String offerValue) {
        this.offerValue = offerValue;
    }

    public Object getItem() {
        return item;
    }

    public void setItem(Object item) {
        this.item = item;
    }

    public Object getCourse() {
        return course;
    }

    public void setCourse(Object course) {
        this.course = course;
    }

    public Object getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(Object serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }
//
//    public List<ServiceRequestHeaderList> getServiceRequestHeaderList() {
//        return serviceRequestHeaderList;
//    }
//
//    public void setServiceRequestHeaderList(List<ServiceRequestHeaderList> serviceRequestHeaderList) {
//        this.serviceRequestHeaderList = serviceRequestHeaderList;
//    }

}

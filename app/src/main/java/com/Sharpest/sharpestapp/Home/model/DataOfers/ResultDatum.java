
package com.Sharpest.sharpestapp.Home.model.DataOfers;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDatum {

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
    private Item item;
    @SerializedName("course")
    @Expose
    private Course course;
    @SerializedName("serviceRequestType")
    @Expose
    private ServiceRequestType serviceRequestType;
    @SerializedName("serviceRequestHeaderList")
    @Expose
    private List<Object> serviceRequestHeaderList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultDatum() {
    }

    /**
     * 
     * @param serviceRequestType
     * @param item
     * @param offerExpireDate
     * @param course
     * @param offerImagePath
     * @param serviceRequestHeaderList
     * @param id
     * @param offerActiveFlag
     * @param offerValue
     */
    public ResultDatum(Integer id, String offerExpireDate, Integer offerActiveFlag, String offerImagePath, String offerValue,
                       Item item, Course course, ServiceRequestType serviceRequestType, List<Object> serviceRequestHeaderList) {
        super();
        this.id = id;
        this.offerExpireDate = offerExpireDate;
        this.offerActiveFlag = offerActiveFlag;
        this.offerImagePath = offerImagePath;
        this.offerValue = offerValue;
        this.item = item;
        this.course = course;
        this.serviceRequestType = serviceRequestType;
        this.serviceRequestHeaderList = serviceRequestHeaderList;
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

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public List<Object> getServiceRequestHeaderList() {
        return serviceRequestHeaderList;
    }

    public void setServiceRequestHeaderList(List<Object> serviceRequestHeaderList) {
        this.serviceRequestHeaderList = serviceRequestHeaderList;
    }

}

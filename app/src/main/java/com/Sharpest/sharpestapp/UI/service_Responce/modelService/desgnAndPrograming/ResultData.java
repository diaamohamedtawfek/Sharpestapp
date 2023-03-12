
package com.Sharpest.sharpestapp.UI.service_Responce.modelService.desgnAndPrograming;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("createdById")
    @Expose
    private Object createdById;
    @SerializedName("createdDate")
    @Expose
    private Object createdDate;
    @SerializedName("lastModifiedById")
    @Expose
    private Object lastModifiedById;
    @SerializedName("lastModifiedDate")
    @Expose
    private Object lastModifiedDate;
    @SerializedName("requestDate")
    @Expose
    private String requestDate;
    @SerializedName("requestSeenFlag")
    @Expose
    private Integer requestSeenFlag;
    @SerializedName("requestAssignFlag")
    @Expose
    private Integer requestAssignFlag;
    @SerializedName("customer")
    @Expose
    private Customer customer;
    @SerializedName("customerName")
    @Expose
    private String customerName;
    @SerializedName("customerAddress")
    @Expose
    private String customerAddress;
    @SerializedName("customerPhone")
    @Expose
    private String customerPhone;
    @SerializedName("headerStatusLookup")
    @Expose
    private HeaderStatusLookup headerStatusLookup;
    @SerializedName("employee")
    @Expose
    private Object employee;
    @SerializedName("serviceRequestType")
    @Expose
    private ServiceRequestType serviceRequestType;
    @SerializedName("requestHeaderImagesList")
    @Expose
    private List<Object> requestHeaderImagesList = null;
    @SerializedName("maintenanceSupportRequestList")
    @Expose
    private List<Object> maintenanceSupportRequestList = null;
    @SerializedName("designProgrammingRequestList")
    @Expose
    private List<Object> designProgrammingRequestList = null;
    @SerializedName("threeDimensionalImagingList")
    @Expose
    private List<Object> threeDimensionalImagingList = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCreatedById() {
        return createdById;
    }

    public void setCreatedById(Object createdById) {
        this.createdById = createdById;
    }

    public Object getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Object createdDate) {
        this.createdDate = createdDate;
    }

    public Object getLastModifiedById() {
        return lastModifiedById;
    }

    public void setLastModifiedById(Object lastModifiedById) {
        this.lastModifiedById = lastModifiedById;
    }

    public Object getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Object lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getRequestSeenFlag() {
        return requestSeenFlag;
    }

    public void setRequestSeenFlag(Integer requestSeenFlag) {
        this.requestSeenFlag = requestSeenFlag;
    }

    public Integer getRequestAssignFlag() {
        return requestAssignFlag;
    }

    public void setRequestAssignFlag(Integer requestAssignFlag) {
        this.requestAssignFlag = requestAssignFlag;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public HeaderStatusLookup getHeaderStatusLookup() {
        return headerStatusLookup;
    }

    public void setHeaderStatusLookup(HeaderStatusLookup headerStatusLookup) {
        this.headerStatusLookup = headerStatusLookup;
    }

    public Object getEmployee() {
        return employee;
    }

    public void setEmployee(Object employee) {
        this.employee = employee;
    }

    public ServiceRequestType getServiceRequestType() {
        return serviceRequestType;
    }

    public void setServiceRequestType(ServiceRequestType serviceRequestType) {
        this.serviceRequestType = serviceRequestType;
    }

    public List<Object> getRequestHeaderImagesList() {
        return requestHeaderImagesList;
    }

    public void setRequestHeaderImagesList(List<Object> requestHeaderImagesList) {
        this.requestHeaderImagesList = requestHeaderImagesList;
    }

    public List<Object> getMaintenanceSupportRequestList() {
        return maintenanceSupportRequestList;
    }

    public void setMaintenanceSupportRequestList(List<Object> maintenanceSupportRequestList) {
        this.maintenanceSupportRequestList = maintenanceSupportRequestList;
    }

    public List<Object> getDesignProgrammingRequestList() {
        return designProgrammingRequestList;
    }

    public void setDesignProgrammingRequestList(List<Object> designProgrammingRequestList) {
        this.designProgrammingRequestList = designProgrammingRequestList;
    }

    public List<Object> getThreeDimensionalImagingList() {
        return threeDimensionalImagingList;
    }

    public void setThreeDimensionalImagingList(List<Object> threeDimensionalImagingList) {
        this.threeDimensionalImagingList = threeDimensionalImagingList;
    }

}

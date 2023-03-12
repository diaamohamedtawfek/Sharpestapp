
package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CompanyBranch {

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
    @SerializedName("branchNameAr")
    @Expose
    private String branchNameAr;
    @SerializedName("branchNameEn")
    @Expose
    private String branchNameEn;
    @SerializedName("company")
    @Expose
    private Company company;

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

    public String getBranchNameAr() {
        return branchNameAr;
    }

    public void setBranchNameAr(String branchNameAr) {
        this.branchNameAr = branchNameAr;
    }

    public String getBranchNameEn() {
        return branchNameEn;
    }

    public void setBranchNameEn(String branchNameEn) {
        this.branchNameEn = branchNameEn;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

}

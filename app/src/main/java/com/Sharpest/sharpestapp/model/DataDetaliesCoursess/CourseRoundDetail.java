
package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseRoundDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseDays")
    @Expose
    private String courseDays;
    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("timePeriod")
    @Expose
    private String timePeriod;
    @SerializedName("availableSetsNumber")
    @Expose
    private Integer availableSetsNumber;
    @SerializedName("totalSets")
    @Expose
    private Integer totalSets;
    @SerializedName("companyBranch")
    @Expose
    private CompanyBranch companyBranch;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseDays() {
        return courseDays;
    }

    public void setCourseDays(String courseDays) {
        this.courseDays = courseDays;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public Integer getAvailableSetsNumber() {
        return availableSetsNumber;
    }

    public void setAvailableSetsNumber(Integer availableSetsNumber) {
        this.availableSetsNumber = availableSetsNumber;
    }

    public Integer getTotalSets() {
        return totalSets;
    }

    public void setTotalSets(Integer totalSets) {
        this.totalSets = totalSets;
    }

    public CompanyBranch getCompanyBranch() {
        return companyBranch;
    }

    public void setCompanyBranch(CompanyBranch companyBranch) {
        this.companyBranch = companyBranch;
    }

}

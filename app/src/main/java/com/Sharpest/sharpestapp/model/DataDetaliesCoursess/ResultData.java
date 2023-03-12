
package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseNameAr")
    @Expose
    private String courseNameAr;
    @SerializedName("courseNameEn")
    @Expose
    private String courseNameEn;
    @SerializedName("courseDescription")
    @Expose
    private String courseDescription;
    @SerializedName("imageBanarPath")
    @Expose
    private String imageBanarPath;
    @SerializedName("courseActiveFlag")
    @Expose
    private Integer courseActiveFlag;
    @SerializedName("courseAvailableOnline")
    @Expose
    private Integer courseAvailableOnline;
    @SerializedName("favouriteFlag")
    @Expose
    private Object favouriteFlag;
    @SerializedName("courseReservationList")
    @Expose
    private List<CourseReservationList> courseReservationList = null;
    @SerializedName("courseContents")
    @Expose
    private List<CourseContent> courseContents = null;
    @SerializedName("courseOutlines")
    @Expose
    private List<CourseOutline> courseOutlines = null;
    @SerializedName("courseRoundDetails")
    @Expose
    private List<CourseRoundDetail> courseRoundDetails = null;

    @SerializedName("offersMobileDto")
    @Expose
    private OffersMobileDto offersMobileDto = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseNameAr() {
        return courseNameAr;
    }

    public void setCourseNameAr(String courseNameAr) {
        this.courseNameAr = courseNameAr;
    }

    public String getCourseNameEn() {
        return courseNameEn;
    }

    public void setCourseNameEn(String courseNameEn) {
        this.courseNameEn = courseNameEn;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public String getImageBanarPath() {
        return imageBanarPath;
    }

    public void setImageBanarPath(String imageBanarPath) {
        this.imageBanarPath = imageBanarPath;
    }

    public Integer getCourseActiveFlag() {
        return courseActiveFlag;
    }

    public void setCourseActiveFlag(Integer courseActiveFlag) {
        this.courseActiveFlag = courseActiveFlag;
    }


    public OffersMobileDto getOffersMobileDto() {
        return offersMobileDto;
    }

    public void setOffersMobileDto(OffersMobileDto offersMobileDto) {
        this.offersMobileDto = offersMobileDto;
    }

    public Integer getCourseAvailableOnline() {
        return courseAvailableOnline;
    }

    public void setCourseAvailableOnline(Integer courseAvailableOnline) {
        this.courseAvailableOnline = courseAvailableOnline;
    }

    public Object getFavouriteFlag() {
        return favouriteFlag;
    }

    public void setFavouriteFlag(Object favouriteFlag) {
        this.favouriteFlag = favouriteFlag;
    }

    public List<CourseReservationList> getCourseReservationList() {
        return courseReservationList;
    }

    public void setCourseReservationList(List<CourseReservationList> courseReservationList) {
        this.courseReservationList = courseReservationList;
    }

    public List<CourseContent> getCourseContents() {
        return courseContents;
    }

    public void setCourseContents(List<CourseContent> courseContents) {
        this.courseContents = courseContents;
    }




    public List<CourseOutline> getCourseOutlines() {
        return courseOutlines;
    }

    public void setCourseOutlines(List<CourseOutline> courseOutlines) {
        this.courseOutlines = courseOutlines;
    }

    public List<CourseRoundDetail> getCourseRoundDetails() {
        return courseRoundDetails;
    }

    public void setCourseRoundDetails(List<CourseRoundDetail> courseRoundDetails) {
        this.courseRoundDetails = courseRoundDetails;
    }

}

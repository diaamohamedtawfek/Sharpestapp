
package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseContent {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseContentNameAr")
    @Expose
    private Object courseContentNameAr;
    @SerializedName("courseContentNameEn")
    @Expose
    private String courseContentNameEn;
    @SerializedName("courseContentUrl")
    @Expose
    private Object courseContentUrl;
    @SerializedName("contentOrder")
    @Expose
    private Integer contentOrder;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getCourseContentNameAr() {
        return courseContentNameAr;
    }

    public void setCourseContentNameAr(String courseContentNameAr) {
        this.courseContentNameAr = courseContentNameAr;
    }

    public String getCourseContentNameEn() {
        return courseContentNameEn;
    }

    public void setCourseContentNameEn(String courseContentNameEn) {
        this.courseContentNameEn = courseContentNameEn;
    }

    public Object getCourseContentUrl() {
        return courseContentUrl;
    }

    public void setCourseContentUrl(Object courseContentUrl) {
        this.courseContentUrl = courseContentUrl;
    }

    public Integer getContentOrder() {
        return contentOrder;
    }

    public void setContentOrder(Integer contentOrder) {
        this.contentOrder = contentOrder;
    }

}


package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseOutline {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseOutlineAr")
    @Expose
    private String courseOutlineAr;
    @SerializedName("courseOutlineEn")
    @Expose
    private String courseOutlineEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourseOutlineAr() {
        return courseOutlineAr;
    }

    public void setCourseOutlineAr(String courseOutlineAr) {
        this.courseOutlineAr = courseOutlineAr;
    }

    public String getCourseOutlineEn() {
        return courseOutlineEn;
    }

    public void setCourseOutlineEn(String courseOutlineEn) {
        this.courseOutlineEn = courseOutlineEn;
    }

}

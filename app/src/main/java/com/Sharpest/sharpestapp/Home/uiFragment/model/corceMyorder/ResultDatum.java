
package com.Sharpest.sharpestapp.Home.uiFragment.model.corceMyorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultDatum {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("courseNameAr")
    @Expose
    private String courseNameAr;
    @SerializedName("courseNameEn")
    @Expose
    private String courseNameEn;
    @SerializedName("imageBanarPath")
    @Expose
    private String imageBanarPath;
    @SerializedName("courseAvailableOnline")
    @Expose
    private Integer courseAvailableOnline;

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

    public Object getImageBanarPath() {
        return imageBanarPath;
    }

    public void setImageBanarPath(String imageBanarPath) {
        this.imageBanarPath = imageBanarPath;
    }

    public Integer getCourseAvailableOnline() {
        return courseAvailableOnline;
    }

    public void setCourseAvailableOnline(Integer courseAvailableOnline) {
        this.courseAvailableOnline = courseAvailableOnline;
    }

}

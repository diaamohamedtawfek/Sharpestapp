package com.Sharpest.sharpestapp.Home.model;

public class DataCourssesList {

    String id,courseNameAr,courseNameEn,imageBanarPath;
    Object courseAvailableOnline;

    public DataCourssesList(String id, String courseNameAr, String courseNameEn, String imageBanarPath, String courseAvailableOnline) {
        this.id = id;
        this.courseNameAr = courseNameAr;
        this.courseNameEn = courseNameEn;
        this.imageBanarPath = imageBanarPath;
        this.courseAvailableOnline = courseAvailableOnline;
    }

    public DataCourssesList() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public String getImageBanarPath() {
        return imageBanarPath;
    }

    public void setImageBanarPath(String imageBanarPath) {
        this.imageBanarPath = imageBanarPath;
    }

    public Object getCourseAvailableOnline() {
        return courseAvailableOnline;
    }

    public void setCourseAvailableOnline(String courseAvailableOnline) {
        this.courseAvailableOnline = courseAvailableOnline;
    }
}


package com.Sharpest.sharpestapp.UI.DataCourseSEND;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSendReqestCourse {


    @SerializedName("course")
    @Expose
    private Course course;


    @SerializedName("course")
    @Expose
    private Offers offers;

    @SerializedName("whatsupPhoneNumber")
    @Expose
    private String whatsupPhoneNumber;

    /**
     * No args constructor for use in serialization
     *
     */
    public DataSendReqestCourse() {
    }

    /**
     *
     * @param whatsupPhoneNumber
     * @param course
     */
    public DataSendReqestCourse( Course course, String whatsupPhoneNumber) {
        super();
        this.course = course;
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }


    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public String getWhatsupPhoneNumber() {
        return whatsupPhoneNumber;
    }

    public void setWhatsupPhoneNumber(String whatsupPhoneNumber) {
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }


    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }
}

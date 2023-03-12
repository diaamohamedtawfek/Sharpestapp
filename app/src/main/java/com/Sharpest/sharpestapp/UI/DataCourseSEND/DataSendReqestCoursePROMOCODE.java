
package com.Sharpest.sharpestapp.UI.DataCourseSEND;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSendReqestCoursePROMOCODE {

    @SerializedName("promoCode")
    @Expose
    private String promoCode;
    @SerializedName("course")
    @Expose
    private Course course;

    @SerializedName("offers")
    @Expose
    private Offers offers;

    @SerializedName("whatsupPhoneNumber")
    @Expose
    private String whatsupPhoneNumber;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataSendReqestCoursePROMOCODE() {
    }

    /**
     * 
     * @param whatsupPhoneNumber
     * @param course
     * @param promoCode
     */
    public DataSendReqestCoursePROMOCODE(String promoCode, Course course, String whatsupPhoneNumber) {
        super();
        this.promoCode = promoCode;
        this.course = course;
        this.whatsupPhoneNumber = whatsupPhoneNumber;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
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

}

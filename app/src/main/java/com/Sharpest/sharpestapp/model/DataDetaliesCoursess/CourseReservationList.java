
package com.Sharpest.sharpestapp.model.DataDetaliesCoursess;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CourseReservationList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("reservationDate")
    @Expose
    private String reservationDate;
    @SerializedName("completeReservationFlag")
    @Expose
    private Integer completeReservationFlag;
    @SerializedName("promoCode")
    @Expose
    private String promoCode;
    @SerializedName("promoCodeVaildFlag")
    @Expose
    private Integer promoCodeVaildFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(String reservationDate) {
        this.reservationDate = reservationDate;
    }

    public Integer getCompleteReservationFlag() {
        return completeReservationFlag;
    }

    public void setCompleteReservationFlag(Integer completeReservationFlag) {
        this.completeReservationFlag = completeReservationFlag;
    }

    public String getPromoCode() {
        return promoCode;
    }

    public void setPromoCode(String promoCode) {
        this.promoCode = promoCode;
    }

    public Integer getPromoCodeVaildFlag() {
        return promoCodeVaildFlag;
    }

    public void setPromoCodeVaildFlag(Integer promoCodeVaildFlag) {
        this.promoCodeVaildFlag = promoCodeVaildFlag;
    }

}

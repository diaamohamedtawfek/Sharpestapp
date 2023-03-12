
package com.Sharpest.sharpestapp.Home.model.toatelCouponValur;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("totalCouponValue")
    @Expose
    private Integer totalCouponValue;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultData() {
    }

    /**
     * 
     * @param totalCouponValue
     * @param id
     */
    public ResultData(Integer id, Integer totalCouponValue) {
        super();
        this.id = id;
        this.totalCouponValue = totalCouponValue;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotalCouponValue() {
        return totalCouponValue;
    }

    public void setTotalCouponValue(Integer totalCouponValue) {
        this.totalCouponValue = totalCouponValue;
    }

}

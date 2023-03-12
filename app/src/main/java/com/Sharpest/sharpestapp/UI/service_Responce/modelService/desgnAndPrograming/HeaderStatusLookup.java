
package com.Sharpest.sharpestapp.UI.service_Responce.modelService.desgnAndPrograming;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HeaderStatusLookup {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("requestHeaderStatusNameAr")
    @Expose
    private String requestHeaderStatusNameAr;
    @SerializedName("requestHeaderStatusNameEn")
    @Expose
    private String requestHeaderStatusNameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequestHeaderStatusNameAr() {
        return requestHeaderStatusNameAr;
    }

    public void setRequestHeaderStatusNameAr(String requestHeaderStatusNameAr) {
        this.requestHeaderStatusNameAr = requestHeaderStatusNameAr;
    }

    public String getRequestHeaderStatusNameEn() {
        return requestHeaderStatusNameEn;
    }

    public void setRequestHeaderStatusNameEn(String requestHeaderStatusNameEn) {
        this.requestHeaderStatusNameEn = requestHeaderStatusNameEn;
    }

}

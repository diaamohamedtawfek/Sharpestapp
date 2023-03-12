
package com.Sharpest.sharpestapp.UI.service_Responce.dataResponse_url_offers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ServiceRequestHeaderList {

    @SerializedName("id")
    @Expose
    private Integer id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ServiceRequestHeaderList() {
    }

    /**
     * 
     * @param id
     */
    public ServiceRequestHeaderList(Integer id) {
        super();
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}

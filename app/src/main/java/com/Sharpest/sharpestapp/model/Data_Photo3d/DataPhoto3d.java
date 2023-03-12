
package com.Sharpest.sharpestapp.model.Data_Photo3d;

import com.Sharpest.sharpestapp.model.DataSeana_Request.Offers;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataPhoto3d {

    @SerializedName("serviceRequestHeader")
    @Expose
    private ServiceRequestHeader serviceRequestHeader;
    @SerializedName("threeDimensionalImaging")
    @Expose
    private ThreeDimensionalImaging threeDimensionalImaging;




    @SerializedName("offers")
    @Expose
    private Offers offers;

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public ServiceRequestHeader getServiceRequestHeader() {
        return serviceRequestHeader;
    }

    public void setServiceRequestHeader(ServiceRequestHeader serviceRequestHeader) {
        this.serviceRequestHeader = serviceRequestHeader;
    }

    public ThreeDimensionalImaging getThreeDimensionalImaging() {
        return threeDimensionalImaging;
    }

    public void setThreeDimensionalImaging(ThreeDimensionalImaging threeDimensionalImaging) {
        this.threeDimensionalImaging = threeDimensionalImaging;
    }

}

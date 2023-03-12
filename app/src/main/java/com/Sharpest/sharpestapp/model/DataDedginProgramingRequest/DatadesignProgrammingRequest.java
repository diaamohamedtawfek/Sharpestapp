
package com.Sharpest.sharpestapp.model.DataDedginProgramingRequest;

import com.Sharpest.sharpestapp.model.DataSeana_Request.Offers;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DatadesignProgrammingRequest {

    @SerializedName("serviceRequestHeaderMobile")
    @Expose
    private ServiceRequestHeaderMobile serviceRequestHeaderMobile;
    @SerializedName("designProgramming")
    @Expose
    private DesignProgramming designProgramming;

    @SerializedName("offers")
    @Expose
    private Offers offers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DatadesignProgrammingRequest() {
    }

    /**
     * 
     * @param serviceRequestHeaderMobile
     * @param designProgramming
     */
    public DatadesignProgrammingRequest(ServiceRequestHeaderMobile serviceRequestHeaderMobile, DesignProgramming designProgramming) {
        super();
        this.serviceRequestHeaderMobile = serviceRequestHeaderMobile;
        this.designProgramming = designProgramming;
    }

    public Offers getOffers() {
        return offers;
    }

    public void setOffers(Offers offers) {
        this.offers = offers;
    }

    public ServiceRequestHeaderMobile getServiceRequestHeaderMobile() {
        return serviceRequestHeaderMobile;
    }

    public void setServiceRequestHeaderMobile(ServiceRequestHeaderMobile serviceRequestHeaderMobile) {
        this.serviceRequestHeaderMobile = serviceRequestHeaderMobile;
    }

    public DesignProgramming getDesignProgramming() {
        return designProgramming;
    }

    public void setDesignProgramming(DesignProgramming designProgramming) {
        this.designProgramming = designProgramming;
    }

}

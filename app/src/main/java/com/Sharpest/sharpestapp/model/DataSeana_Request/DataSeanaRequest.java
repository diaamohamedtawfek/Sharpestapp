
package com.Sharpest.sharpestapp.model.DataSeana_Request;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataSeanaRequest {

    @SerializedName("serviceRequestHeader")
    @Expose
    private ServiceRequestHeader serviceRequestHeader;
    @SerializedName("maintenanceSupportRequest")
    @Expose
    private MaintenanceSupportRequest maintenanceSupportRequest;

    @SerializedName("offers")
    @Expose
    private Offers offers;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataSeanaRequest() {
    }

    /**
     * 
     * @param serviceRequestHeader
     * @param maintenanceSupportRequest
     */
    public DataSeanaRequest(ServiceRequestHeader serviceRequestHeader, MaintenanceSupportRequest maintenanceSupportRequest) {
        super();
        this.serviceRequestHeader = serviceRequestHeader;
        this.maintenanceSupportRequest = maintenanceSupportRequest;
    }

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

    public MaintenanceSupportRequest getMaintenanceSupportRequest() {
        return maintenanceSupportRequest;
    }

    public void setMaintenanceSupportRequest(MaintenanceSupportRequest maintenanceSupportRequest) {
        this.maintenanceSupportRequest = maintenanceSupportRequest;
    }

}

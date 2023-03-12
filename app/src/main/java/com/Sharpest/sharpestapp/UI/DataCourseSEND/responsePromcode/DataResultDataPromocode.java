
package com.Sharpest.sharpestapp.UI.DataCourseSEND.responsePromcode;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataResultDataPromocode {

    @SerializedName("errorStatus")
    @Expose
    private Boolean errorStatus;
    @SerializedName("errorResponsePayloadList")
    @Expose
    private List<ErrorResponsePayloadList> errorResponsePayloadList = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataResultDataPromocode() {
    }

    /**
     * 
     * @param errorStatus
     * @param errorResponsePayloadList
     */
    public DataResultDataPromocode(Boolean errorStatus, List<ErrorResponsePayloadList> errorResponsePayloadList) {
        super();
        this.errorStatus = errorStatus;
        this.errorResponsePayloadList = errorResponsePayloadList;
    }

    public Boolean getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public List<ErrorResponsePayloadList> getErrorResponsePayloadList() {
        return errorResponsePayloadList;
    }

    public void setErrorResponsePayloadList(List<ErrorResponsePayloadList> errorResponsePayloadList) {
        this.errorResponsePayloadList = errorResponsePayloadList;
    }

}

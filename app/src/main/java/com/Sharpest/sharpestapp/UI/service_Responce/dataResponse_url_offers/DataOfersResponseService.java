
package com.Sharpest.sharpestapp.UI.service_Responce.dataResponse_url_offers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataOfersResponseService {

    @SerializedName("errorStatus")
    @Expose
    private Boolean errorStatus;
    @SerializedName("resultData")
    @Expose
    private ResultData resultData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataOfersResponseService() {
    }

    /**
     * 
     * @param resultData
     * @param errorStatus
     */
    public DataOfersResponseService(Boolean errorStatus, ResultData resultData) {
        super();
        this.errorStatus = errorStatus;
        this.resultData = resultData;
    }

    public Boolean getErrorStatus() {
        return errorStatus;
    }

    public void setErrorStatus(Boolean errorStatus) {
        this.errorStatus = errorStatus;
    }

    public ResultData getResultData() {
        return resultData;
    }

    public void setResultData(ResultData resultData) {
        this.resultData = resultData;
    }

}


package com.Sharpest.sharpestapp.Home.uiFragment.model.serviceMyorder;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataServiceMyorderfrgmentRequest {

    @SerializedName("errorStatus")
    @Expose
    private Boolean errorStatus;
    @SerializedName("resultData")
    @Expose
    private ResultData resultData;

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

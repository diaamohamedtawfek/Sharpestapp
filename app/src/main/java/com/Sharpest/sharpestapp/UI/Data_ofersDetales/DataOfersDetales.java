
package com.Sharpest.sharpestapp.UI.Data_ofersDetales;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataOfersDetales {

    @SerializedName("errorStatus")
    @Expose
    public Boolean errorStatus;
    @SerializedName("resultData")
    @Expose
    public ResultData resultData;

    /**
     * No args constructor for use in serialization
     * 
     */
    public DataOfersDetales() {
    }

    /**
     * 
     * @param resultData
     * @param errorStatus
     */
    public DataOfersDetales(Boolean errorStatus, ResultData resultData) {
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

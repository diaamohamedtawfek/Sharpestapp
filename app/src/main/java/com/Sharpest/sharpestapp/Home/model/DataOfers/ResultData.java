
package com.Sharpest.sharpestapp.Home.model.DataOfers;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResultData {

    @SerializedName("resultData")
    @Expose
    private List<ResultDatum> resultData = null;
    @SerializedName("totalItemsCount")
    @Expose
    private Integer totalItemsCount;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ResultData() {
    }

    /**
     * 
     * @param totalItemsCount
     * @param resultData
     */
    public ResultData(List<ResultDatum> resultData, Integer totalItemsCount) {
        super();
        this.resultData = resultData;
        this.totalItemsCount = totalItemsCount;
    }

    public List<ResultDatum> getResultData() {
        return resultData;
    }

    public void setResultData(List<ResultDatum> resultData) {
        this.resultData = resultData;
    }

    public Integer getTotalItemsCount() {
        return totalItemsCount;
    }

    public void setTotalItemsCount(Integer totalItemsCount) {
        this.totalItemsCount = totalItemsCount;
    }

}

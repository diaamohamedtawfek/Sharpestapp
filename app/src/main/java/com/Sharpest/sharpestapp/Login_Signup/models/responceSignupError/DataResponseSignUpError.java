
package com.Sharpest.sharpestapp.Login_Signup.models.responceSignupError;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataResponseSignUpError {

    @SerializedName("errorStatus")
    @Expose
    private Boolean errorStatus;
    @SerializedName("errorResponsePayloadList")
    @Expose
    private List<ErrorResponsePayloadList> errorResponsePayloadList = null;

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


package com.Sharpest.sharpestapp.Home.model.response_chamgePassword;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ErrorResponsePayloadList {

    @SerializedName("key")
    @Expose
    private String key;
    @SerializedName("arabicMessage")
    @Expose
    private String arabicMessage;
    @SerializedName("englishMessage")
    @Expose
    private String englishMessage;
    @SerializedName("fixAr")
    @Expose
    private String fixAr;
    @SerializedName("fixEn")
    @Expose
    private String fixEn;

    /**
     * No args constructor for use in serialization
     * 
     */
    public ErrorResponsePayloadList() {
    }

    /**
     * 
     * @param fixEn
     * @param arabicMessage
     * @param fixAr
     * @param englishMessage
     * @param key
     */
    public ErrorResponsePayloadList(String key, String arabicMessage, String englishMessage, String fixAr, String fixEn) {
        super();
        this.key = key;
        this.arabicMessage = arabicMessage;
        this.englishMessage = englishMessage;
        this.fixAr = fixAr;
        this.fixEn = fixEn;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getArabicMessage() {
        return arabicMessage;
    }

    public void setArabicMessage(String arabicMessage) {
        this.arabicMessage = arabicMessage;
    }

    public String getEnglishMessage() {
        return englishMessage;
    }

    public void setEnglishMessage(String englishMessage) {
        this.englishMessage = englishMessage;
    }

    public String getFixAr() {
        return fixAr;
    }

    public void setFixAr(String fixAr) {
        this.fixAr = fixAr;
    }

    public String getFixEn() {
        return fixEn;
    }

    public void setFixEn(String fixEn) {
        this.fixEn = fixEn;
    }

}

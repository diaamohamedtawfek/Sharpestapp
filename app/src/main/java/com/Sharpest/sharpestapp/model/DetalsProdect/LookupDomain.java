
package com.Sharpest.sharpestapp.model.DetalsProdect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LookupDomain {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("lookupDomainNameAr")
    @Expose
    private String lookupDomainNameAr;
    @SerializedName("lookupDomainNameEn")
    @Expose
    private String lookupDomainNameEn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLookupDomainNameAr() {
        return lookupDomainNameAr;
    }

    public void setLookupDomainNameAr(String lookupDomainNameAr) {
        this.lookupDomainNameAr = lookupDomainNameAr;
    }

    public String getLookupDomainNameEn() {
        return lookupDomainNameEn;
    }

    public void setLookupDomainNameEn(String lookupDomainNameEn) {
        this.lookupDomainNameEn = lookupDomainNameEn;
    }

}


package com.Sharpest.sharpestapp.model.DetalsProdect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SubLookupDomain {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("subLookupDomainNameAr")
    @Expose
    private String subLookupDomainNameAr;
    @SerializedName("subLookupDomainNameEn")
    @Expose
    private String subLookupDomainNameEn;
    @SerializedName("lookupDomain")
    @Expose
    private LookupDomain lookupDomain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubLookupDomainNameAr() {
        return subLookupDomainNameAr;
    }

    public void setSubLookupDomainNameAr(String subLookupDomainNameAr) {
        this.subLookupDomainNameAr = subLookupDomainNameAr;
    }

    public String getSubLookupDomainNameEn() {
        return subLookupDomainNameEn;
    }

    public void setSubLookupDomainNameEn(String subLookupDomainNameEn) {
        this.subLookupDomainNameEn = subLookupDomainNameEn;
    }

    public LookupDomain getLookupDomain() {
        return lookupDomain;
    }

    public void setLookupDomain(LookupDomain lookupDomain) {
        this.lookupDomain = lookupDomain;
    }

}

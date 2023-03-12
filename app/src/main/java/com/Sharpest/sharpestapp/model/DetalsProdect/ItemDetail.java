
package com.Sharpest.sharpestapp.model.DetalsProdect;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDetail {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("subLookupDomainValue")
    @Expose
    private String subLookupDomainValue;
    @SerializedName("subLookupDomain")
    @Expose
    private SubLookupDomain subLookupDomain;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSubLookupDomainValue() {
        return subLookupDomainValue;
    }

    public void setSubLookupDomainValue(String subLookupDomainValue) {
        this.subLookupDomainValue = subLookupDomainValue;
    }

    public SubLookupDomain getSubLookupDomain() {
        return subLookupDomain;
    }

    public void setSubLookupDomain(SubLookupDomain subLookupDomain) {
        this.subLookupDomain = subLookupDomain;
    }

}

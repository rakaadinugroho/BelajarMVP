
package com.rakaadinugroho.bookmvpsample.model;

import javax.annotation.Generated;
import com.google.gson.annotations.SerializedName;

@Generated("net.hexar.json2pojo")
@SuppressWarnings("unused")
public class Pdf {

    @SerializedName("acsTokenLink")
    private String mAcsTokenLink;
    @SerializedName("isAvailable")
    private Boolean mIsAvailable;

    public String getAcsTokenLink() {
        return mAcsTokenLink;
    }

    public void setAcsTokenLink(String acsTokenLink) {
        mAcsTokenLink = acsTokenLink;
    }

    public Boolean getIsAvailable() {
        return mIsAvailable;
    }

    public void setIsAvailable(Boolean isAvailable) {
        mIsAvailable = isAvailable;
    }

}

package com.go.gmp.api;

import java.io.Serializable;

/**
 * Created by jiang on 2017/6/15.
 */
public class MerchantReq implements Serializable {

    private static final long serialVersionUID = 7971200180427237331L;

    private String merchantCode;

    private String merchantName;

    private String status;

    private String merchantFullName;

    private String merchantData;

    private String lastAuthor;

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getMerchantFullName() {
        return merchantFullName;
    }

    public void setMerchantFullName(String merchantFullName) {
        this.merchantFullName = merchantFullName;
    }

    public String getMerchantData() {
        return merchantData;
    }

    public void setMerchantData(String merchantData) {
        this.merchantData = merchantData;
    }

    public String getLastAuthor() {
        return lastAuthor;
    }

    public void setLastAuthor(String lastAuthor) {
        this.lastAuthor = lastAuthor;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MerchantReq{");
        sb.append("merchantName='").append(merchantName).append('\'');
        sb.append(", merchantFullName='").append(merchantFullName).append('\'');
        sb.append(", merchantData='").append(merchantData).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

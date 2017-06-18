package com.go.gmp.api;

/**
 * Created by jiang on 2017/6/15.
 */
public class MerchantCreateRsp extends MerchantCommonResp<String> {


    private String merchantCode;

    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

}

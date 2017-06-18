package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public enum MerchantType {
    GENERNAL("01", "普通行业");

    private MerchantType(String code, String text) {
        this.code = code;
        this.text = text;
    }

    private String code;
    private String text;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

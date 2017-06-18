package com.go.gmp.api;

/**
 * Created by jiang on 2017/6/15.
 */
public class MerchantCommonResp<T> {
    private String resCode;

    private String resMsg;

    private T payLoad;

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public T getPayLoad() {
        return payLoad;
    }

    public void setPayLoad(T payLoad) {
        this.payLoad = payLoad;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MerchantCommonResp{");
        sb.append("resCode='").append(resCode).append('\'');
        sb.append(", resMsg='").append(resMsg).append('\'');
        sb.append(", payLoad=").append(payLoad);
        sb.append('}');
        return sb.toString();
    }
}

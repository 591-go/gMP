package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public class BadParamException extends RuntimeException {
    private String errCode;

    private String msg;


    public BadParamException(String errCode, String msg) {
        super(msg);
        this.errCode = errCode;
        this.msg = msg;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

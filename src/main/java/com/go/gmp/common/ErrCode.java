package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public enum ErrCode {
    COMMON_ERR("0001", "系统内部异常"),

    ;


    private ErrCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private String code;
    private String msg;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

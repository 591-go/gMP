package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public class NotFoundException extends RuntimeException {
    private String msg;

    public NotFoundException() {
        super();
    }

    public NotFoundException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

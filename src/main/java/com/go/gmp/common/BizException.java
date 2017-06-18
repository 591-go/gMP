package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public class BizException extends RuntimeException {

    private RespCode errCode;

    public BizException() {
        super();
    }

    public BizException(RespCode errCode) {
        super(errCode.getRetMsg());
        this.errCode = errCode;
    }

    public BizException(RespCode errCode, Throwable cause) {
        super(errCode.getRetMsg(), cause);
        this.errCode = errCode;
    }

    public RespCode getErrCode() {
        return errCode;
    }

    public void setErrCode(RespCode errCode) {
        this.errCode = errCode;
    }
}

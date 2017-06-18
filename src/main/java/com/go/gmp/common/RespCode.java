package com.go.gmp.common;

/**
 * Created by jiang on 2017/6/18.
 */
public enum RespCode {
    SUCCESS("0000", "成功"),
    PARAM_ERR("0001", "参数错误"),
    COMMON_ERR("0002", "系统内部错误"),
    NOT_FOUND("0003", "查询无结果"),
    UPDATE_FAILED("0004", "修改数据失败"),
    SYS_ERR("9999", "系统异常");


    private RespCode(String retCode, String retMsg) {
        this.retCode = retCode;
        this.retMsg = retMsg;
    }


    private String retCode;

    private String retMsg;

    public String getRetCode() {
        return retCode;
    }

    public void setRetCode(String retCode) {
        this.retCode = retCode;
    }

    public String getRetMsg() {
        return retMsg;
    }

    public void setRetMsg(String retMsg) {
        this.retMsg = retMsg;
    }
}

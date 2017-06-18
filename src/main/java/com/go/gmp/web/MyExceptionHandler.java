package com.go.gmp.web;

import com.go.gmp.api.MerchantCommonResp;
import com.go.gmp.common.BadParamException;
import com.go.gmp.common.BizException;
import com.go.gmp.common.NotFoundException;
import com.go.gmp.common.RespCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jiang on 2017/6/18.
 */
public class MyExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(MyExceptionHandler.class);

    @ExceptionHandler(BizException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public MerchantCommonResp handleBizException(BizException e) {
        logger.error(e.getErrCode().getRetMsg(), e);
        MerchantCommonResp resp = new MerchantCommonResp();
        resp.setResCode(e.getErrCode().getRetCode());
        resp.setResMsg(e.getErrCode().getRetMsg());
        return resp;
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MerchantCommonResp handleNotFoundException(NotFoundException e) {
        logger.error(e.getMsg(), e);
        MerchantCommonResp resp = new MerchantCommonResp();
        resp.setResCode(RespCode.NOT_FOUND.getRetCode());
        resp.setResMsg(e.getMsg());
        return resp;
    }

    @ExceptionHandler(BadParamException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public MerchantCommonResp handleBadParamException(BadParamException e) {
        logger.error(e.getMsg(), e);
        MerchantCommonResp resp = new MerchantCommonResp();
        resp.setResCode(RespCode.PARAM_ERR.getRetCode());
        resp.setResMsg(e.getMsg());
        return resp;
    }
}

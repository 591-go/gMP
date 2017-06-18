package com.go.gmp.web;

import com.go.gmp.api.MerchantCommonResp;
import com.go.gmp.api.MerchantCreateRsp;
import com.go.gmp.api.MerchantReq;
import com.go.gmp.api.merchant.MerchantDto;
import com.go.gmp.common.*;
import com.go.gmp.core.MerchantService;
import com.go.gmp.dal.model.MerchantVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jiang on 2017/6/14.
 * 提供商户服务
 */
@RestController
public class MerchantController extends MyExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(MerchantController.class);


    @Autowired
    private MerchantService merchantService;

    @RequestMapping(value = "/merchant/v1.0/", method = RequestMethod.POST, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    public MerchantCreateRsp createMerchant(@RequestBody MerchantReq merchant) {
        logger.info("enter createMerchant,req = {}", ToStringBuilder.reflectionToString(merchant, ToStringStyle.SHORT_PREFIX_STYLE));
        if (StringUtils.isBlank(merchant.getMerchantName()) || StringUtils.isBlank(merchant.getMerchantFullName())) {
            logger.warn("商户名或商户全称为空");
            throw new BadParamException(RespCode.PARAM_ERR.getRetCode(), "商户名或商户全称不能为空");
        }
        String merchantCode;
        try {
            if (StringUtils.isBlank(merchant.getLastAuthor())) {
                merchant.setLastAuthor("sys");
            }

            merchantCode = merchantService.getMerchantCode();
            merchantService.createMerchant(merchantCode, merchant.getMerchantName(), merchant.getMerchantFullName(), "1", merchant.getMerchantData(), merchant.getLastAuthor());
        } catch (InnerException e) {
            logger.error(e.getMsg(), e);
            throw new BizException(RespCode.COMMON_ERR);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BizException(RespCode.SYS_ERR);
        }

        MerchantCreateRsp resp = new MerchantCreateRsp();
        resp.setResCode(RespCode.SUCCESS.getRetCode());
        resp.setResMsg(RespCode.SUCCESS.getRetMsg());
        resp.setMerchantCode(merchantCode);
        logger.info("exit createMerchant,resp = {}", ToStringBuilder.reflectionToString(resp, ToStringStyle.SHORT_PREFIX_STYLE));
        return resp;
    }

    @RequestMapping(value = "/merchant/v1.0/{merchantCode}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    public MerchantCommonResp<MerchantDto> queryMercahntByMerchantCode(@PathVariable String merchantCode) {
        logger.info("enter queryMercahntByMerchantCode ,param = {}", merchantCode);
        if (StringUtils.isBlank(merchantCode)) {
            logger.warn("商户号为空");
            throw new BadParamException(RespCode.PARAM_ERR.getRetCode(), "商户号不能为空");
        }
        MerchantVo merchantVo = null;
        try {
            merchantVo = merchantService.queryMerchantByCode(merchantCode);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BizException(RespCode.SYS_ERR);
        }
        if (null == merchantVo) {
            logger.warn("查询结果为空");
            throw new NotFoundException(merchantCode + ",查询无结果");
        }
        MerchantDto merchantDto = new MerchantDto();
        BeanUtils.copyProperties(merchantVo, merchantDto);

        MerchantCommonResp<MerchantDto> resp = new MerchantCommonResp<MerchantDto>();
        resp.setPayLoad(merchantDto);
        resp.setResCode(RespCode.SUCCESS.getRetCode());
        resp.setResMsg(RespCode.SUCCESS.getRetMsg());
        return resp;
    }


    @RequestMapping(value = "/merchant/v1.0", method = RequestMethod.PUT, consumes = "application/json;charset=utf-8", produces = "application/json;charset=utf-8")
    public MerchantCommonResp modifyMerchantMainInfo(@RequestBody MerchantReq merchantReq) {
        logger.info("enter modifyMerchantMainInfo,param = {}", ToStringBuilder.reflectionToString(merchantReq, ToStringStyle.SHORT_PREFIX_STYLE));
        if (null == merchantReq || StringUtils.isBlank(merchantReq.getMerchantCode())) {
            logger.warn("mercahntCode为空");
            throw new BadParamException(RespCode.PARAM_ERR.getRetCode(), "商户号不能为空");
        }
        MerchantCommonResp resp = new MerchantCommonResp();
        try {
            MerchantVo merchantVo = new MerchantVo();
            BeanUtils.copyProperties(merchantReq, merchantVo);
            if (StringUtils.isBlank(merchantVo.getLastAuthor())) {
                merchantVo.setLastAuthor("sys");
            }
            if (!merchantService.updateMerchantMainInfo(merchantVo)) {
                logger.warn("修改失败,merchantCode = {}", merchantVo.getMerchantCode());
                resp.setResCode(RespCode.UPDATE_FAILED.getRetCode());
                resp.setResMsg(RespCode.UPDATE_FAILED.getRetMsg());
            }
        } catch (InnerException e) {
            logger.error(e.getMsg(), e);
            throw new BizException(RespCode.COMMON_ERR);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new BizException(RespCode.SYS_ERR);
        }
        resp.setResCode(RespCode.SUCCESS.getRetCode());
        resp.setResMsg(RespCode.SUCCESS.getRetMsg());
        logger.info("exit modifyMerchantMainInfo,rep = {}", ToStringBuilder.reflectionToString(resp, ToStringStyle.SHORT_PREFIX_STYLE));
        return resp;
    }
}

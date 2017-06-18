package com.go.gmp.core;

import com.go.gmp.common.InnerException;
import com.go.gmp.common.MerchantType;
import com.go.gmp.dal.mapper.MainMerchantMapper;
import com.go.gmp.dal.mapper.MerchantSerialMapper;
import com.go.gmp.dal.model.MerchantVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by jiang on 2017/6/18.
 */
@Service
public class MerchantService {

    private static final Logger logger = LoggerFactory.getLogger(MerchantService.class);

    @Autowired
    private MainMerchantMapper mainMerchantMapper;

    @Autowired
    private MerchantSerialMapper merchantSerialMapper;

    /**
     * 商户号规则:两位行业代码+yyyyMMDD+LPAD(COUNT,8)
     *
     * @return
     */
    @Transactional
    public String getMerchantCode() {
        merchantSerialMapper.updateMerchantCount();
        String count = merchantSerialMapper.getCount();
        if (StringUtils.isBlank(count)) {
            throw new InnerException("count为空");
        }
        String merchantCode = MerchantType.GENERNAL.getCode() + DateFormatUtils.format(new Date(), "yyyyMMdd") + count;
        return merchantCode;
    }

    /**
     * 新增商户
     *
     * @param merchantCode
     * @param merchantName
     * @param merchantFullName
     * @param merchantData
     */
    public void createMerchant(String merchantCode, String merchantName, String merchantFullName, String status, String merchantData, String lastAuthor) {
        if (StringUtils.isBlank(merchantCode) || StringUtils.isBlank(merchantName) || StringUtils.isBlank(lastAuthor)) {
            logger.warn("createMerchant err param");
            throw new InnerException("新建商户参数错误");
        }
        mainMerchantMapper.addMerchant(merchantCode, merchantName, merchantFullName, status, merchantData, lastAuthor);
    }


    /**
     * 根据商户号查询商户
     *
     * @param merchantCode
     * @return
     */
    public MerchantVo queryMerchantByCode(String merchantCode) {
        if (StringUtils.isBlank(merchantCode)) {
            logger.warn("queryMerchantByCode 商户号为空");
            throw new InnerException("商户号为空");
        }
        return mainMerchantMapper.queryMerchantByCode(merchantCode);
    }

    public boolean updateMerchantMainInfo(MerchantVo merchantVo) {
        if (null == merchantVo || StringUtils.isBlank(merchantVo.getMerchantCode())) {
            logger.warn("updateMerchantMainInfo ，商户号不能为空");
            throw new InnerException("商户号不能为空");
        }
        return 1 == mainMerchantMapper.updateMercahntMainInfo(merchantVo);
    }

}

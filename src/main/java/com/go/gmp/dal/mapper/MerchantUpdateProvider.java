package com.go.gmp.dal.mapper;

import com.go.gmp.dal.model.MerchantVo;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * Created by jiang on 2017/6/18.
 */
public class MerchantUpdateProvider {

    public String update(final MerchantVo merchantVo) {
        return new SQL() {
            {
                UPDATE("T_MERCHANT_MAIN_INFO");

                //通过条件 判断是否需要更新该字段
                if (StringUtils.isNotBlank(merchantVo.getMerchantName())) {
                    SET("MERCHANT_NAME = #{merchantName}");
                }
                if (StringUtils.isNotBlank(merchantVo.getMerchantFullName())) {
                    SET("MERCHANT_FULL_NAME = #{merchantFullName}");
                }
                if (StringUtils.isNotBlank(merchantVo.getMerchantData())) {
                    SET("MERCHANT_DATA = #{merchantData}");
                }
                if (StringUtils.isNotBlank(merchantVo.getLastAuthor())) {
                    SET("LAST_AUTHOR = #{lastAuthor}");
                }
                if (StringUtils.isNotBlank(merchantVo.getStatus())) {
                    SET("STATUS = #{status}");
                }
                WHERE("MERCHANT_CODE = #{merchantCode}");

            }
        }.toString();

    }
}

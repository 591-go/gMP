package com.go.gmp.dal.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by jiang on 2017/6/18.
 * 生成商户计数，用户商户号。商户号规则:两位行业代码+yyyyMMDD+LPAD(COUNT,8)
 */
@Mapper
public interface MerchantSerialMapper {

    @Update("UPDATE T_MERCHANT_SERIAL SET MERCHANT_COUNT=MERCHANT_COUNT+1")
    public int updateMerchantCount();

    @Select("SELECT LPAD(MERCHANT_COUNT,8,0) FROM T_MERCHANT_SERIAL")
    public String getCount();
}


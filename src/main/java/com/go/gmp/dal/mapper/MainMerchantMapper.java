package com.go.gmp.dal.mapper;

import com.go.gmp.dal.model.MerchantVo;
import org.apache.ibatis.annotations.*;

/**
 * Created by jiang on 2017/6/15.
 */
@Mapper
public interface MainMerchantMapper {

    @Insert("INSERT INTO T_MERCHANT_MAIN_INFO(MERCHANT_CODE,MERCHANT_NAME,MERCHANT_FULL_NAME,STATUS,MERCHANT_DATA,LAST_AUTHOR) VALUES(#{merchantCode},#{merchantName},#{merchantFullName},#{status},#{merchantInfo},#{lastAuthor})")
    public void addMerchant(@Param("merchantCode") String merchantCode, @Param("merchantName") String merchantName, @Param("merchantFullName") String merchantFullName, @Param("status") String status, @Param("merchantInfo") String merchantInfo, @Param("lastAuthor") String lastAuthor);


    @Select("SELECT ID,MERCHANT_CODE,MERCHANT_NAME,MERCHANT_FULL_NAME,STATUS,MERCHANT_DATA,LAST_AUTHOR,CREATE_TIME,UPDATE_TIME FROM T_MERCHANT_MAIN_INFO WHERE MERCHANT_CODE=#{merchantCode}")
    @Results({
            @Result(property = "id", column = "ID"),
            @Result(property = "merchantCode", column = "MERCHANT_CODE"),
            @Result(property = "merchantName", column = "MERCHANT_NAME"),
            @Result(property = "merchantFullName", column = "MERCHANT_FULL_NAME"),
            @Result(property = "status",column = "STATUS"),
            @Result(property = "merchantData", column = "MERCHANT_DATA"),
            @Result(property = "lastAuthor", column = "LAST_AUTHOR"),
            @Result(property = "createTime", column = "CREATE_TIME"),
            @Result(property = "updateTime", column = "UPDATE_TIME")
    }
    )
    public MerchantVo queryMerchantByCode(@Param("merchantCode") String merchantCode);


    //    @Update("UPDATE T_MERCHANT_MAIN_INFO " +
//            "SET MERCHANT_NAME=#{merchantName}," +
//            "MERCHANT_FULL_NAME = #{merchantFullName}," +
//            "MERCHANT_DATA = #{merchantData}," +
//            "LAST_AUTHOR = #{lastAuthor}," +
//            "UPDATE_TIME = CURRENT_TIMESTAMP(6)" +
//            "WHERE MERCHANT_CODE = #{merchantCode}")
    @UpdateProvider(type = MerchantUpdateProvider.class, method = "update")
    public int updateMercahntMainInfo(MerchantVo merchantVo);
}

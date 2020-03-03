package com.kezilai.merchant.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.kezilai.merchant.entity.Merchant;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MerchantMapper extends BaseMapper<Merchant> {

    @Insert("INSERT INTO merchant(belong,merchant_name,merchant_forshort,contact_name,phone,application_date,status,child_merchant,weChat_merchant,weChat_rate,weChat_rate_date,alipay_pid,alipay_their,alipay_rate,note) VALUES(#{belong},#{merchantName},#{merchantForshort},#{contactName},#{phone},#{applicationDate},#{status},#{childMerchant},#{wechatMerchant},#{wechatRate},#{wechatRateDate},#{alipayPid},#{alipayTheir},#{alipayRate},#{note})")
    int add(Merchant merchant);

    @Select("SELECT id,belong,merchant_name,merchant_forshort,contact_name,phone,application_date,status,child_merchant,weChat_merchant,weChat_rate,weChat_rate_date,alipay_pid,alipay_their,alipay_rate,note FROM merchant WHERE id=27")
    Merchant select2();

}
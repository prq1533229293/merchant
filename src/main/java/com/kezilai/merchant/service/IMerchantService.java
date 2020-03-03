package com.kezilai.merchant.service;

import com.kezilai.merchant.entity.Merchant;
import org.springframework.ui.ModelMap;

import java.util.List;


public interface IMerchantService {

    int add(Merchant merchant);

    String updateById(int id, String belong, String merchantName, String merchantForshort, String contactName, String phone, String applicationDate, String status, String childMerchant, String wechatMerchant, String wechatRate, String wechatRateDate, String alipayId, String alipayPid, String alipayTheir, String alipayRate, String note);

    List<Merchant> selectByName(String merchantName, ModelMap modelMap);

    List<Merchant> selectByWId(String wechatMerchant, ModelMap modelMap);

    List<Merchant> selectByStatus(String status, ModelMap modelMap);
}

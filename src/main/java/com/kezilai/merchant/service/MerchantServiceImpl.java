package com.kezilai.merchant.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kezilai.merchant.entity.Merchant;
import com.kezilai.merchant.mapper.MerchantMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;

import java.util.List;

@Service
@Transactional
public class MerchantServiceImpl implements IMerchantService {

    @Autowired
    private MerchantMapper merchantMapper;

    @Override
    public int add(Merchant merchant) {
        String info = merchant.getBelong();
        System.out.println("info：" + info);
        merchantMapper.add(merchant);
        return 1;
    }

    //按商户名称进行查询
    public List<Merchant> selectByName(String merchantName, ModelMap modelMap) {
        List<Merchant> merchants =  select("merchant_name", merchantName, modelMap);
        return merchants;
    }

    //按微信商户号进行查询
    public List<Merchant> selectByWId(String wechatMerchant, ModelMap modelMap) {
        List<Merchant> merchants =  select("wechat_merchant", wechatMerchant, modelMap);
        return merchants;
    }

    //按商户状态进行查询
    public List<Merchant> selectByStatus(String status, ModelMap modelMap) {
        List<Merchant> merchants =  select("status",status,modelMap);
        return merchants;
    }

    //按条件执行查询
    public List<Merchant> select(String type, String object, ModelMap modelMap) {
        QueryWrapper<Merchant> wrapper = new QueryWrapper<>();
        wrapper.eq(type, object)
                .orderByDesc("id");//查询条件
        //current页数, size每页条数
        Page<Merchant> page = new Page<>(1, 10);
        IPage<Merchant> iPage = this.merchantMapper.selectPage(page, wrapper);
        //数据总条数
        long total = iPage.getTotal();
        //数据总页数
        long pages = iPage.getPages();
        //当前页数
        long current = iPage.getCurrent();

        List<Merchant> merchants = iPage.getRecords();
        for (Merchant merchant : merchants) {
            System.out.println(merchant);
        }
        modelMap.addAttribute("pages", pages);
        modelMap.addAttribute("current", current);
        modelMap.addAttribute("total", total);
        modelMap.addAttribute("merchants", merchants);
        return merchants;
    }

    public String updateById(int id, String belong, String merchantName, String merchantForshort, String contactName, String phone, String applicationDate, String status, String childMerchant, String wechatMerchant, String wechatRate, String wechatRateDate, String alipayId, String alipayPid, String alipayTheir, String alipayRate, String note) {
        Merchant merchant = new Merchant();
        //条件，根据id更新
        merchant.setId(id);
        //更新的字段
        merchant.setBelong(belong);
        merchant.setMerchantName(merchantName);
        merchant.setMerchantForshort(merchantForshort);
        merchant.setContactName(contactName);
        merchant.setPhone(phone);
        merchant.setApplicationDate(applicationDate);
        merchant.setStatus(status);
        merchant.setChildMerchant(childMerchant);
        merchant.setWechatMerchant(wechatMerchant);
        merchant.setWechatRate(wechatRate);
        if (!wechatRateDate.equals("")) {
            merchant.setWechatRateDate(wechatRateDate);
        }
        merchant.setAlipayId(alipayId);
        merchant.setAlipayPid(alipayPid);
        merchant.setAlipayTheir(alipayTheir);
        merchant.setAlipayRate(alipayRate);
        merchant.setNote(note);
        System.out.println("是多少：" + merchant);


        //执行更新
        int result = this.merchantMapper.updateById(merchant);
        if (result == 1) {
            return "修改成功";
        }

        return "修改失败";
    }

}

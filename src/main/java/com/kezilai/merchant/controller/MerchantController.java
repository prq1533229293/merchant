package com.kezilai.merchant.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kezilai.merchant.entity.Merchant;
import com.kezilai.merchant.mapper.MerchantMapper;
import com.kezilai.merchant.service.IMerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.util.List;

@Controller
public class MerchantController {

    @Autowired
    private IMerchantService merchantService;
    @Autowired
    private MerchantMapper merchantMapper;

    @RequestMapping("/index")
    public String login(@RequestParam(value = "currents", required = false, defaultValue = "1") Integer currents, ModelMap modelMap) {
        //List<Merchant> merchant = merchantService.select();

        QueryWrapper<Merchant> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");//查询条件

        //current页数, size每页条数
        Page<Merchant> page = new Page<>(currents, 10);
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

        System.out.println("OK");

        return "index";
    }

    @ResponseBody
    @RequestMapping("/add")
    public String add(String belong, String merchantName, String merchantForshort, String contactName, String phone, String applicationDate, String status, String childMerchant, String weChatMerchant, String weChatRate, String weChatRateDate, String alipayTheir, String alipayRate, String note) throws ParseException {
        System.out.println(belong + "," + merchantName + "," + merchantForshort + "," + contactName + "," + phone + "," + applicationDate + "," + status + "," + childMerchant + "," + weChatMerchant + "," + weChatRate + "," + weChatRateDate + "," + alipayTheir + "," + alipayRate + "," + note);

        Merchant merchant = new Merchant();

        merchant.setBelong(belong);
        merchant.setMerchantName(merchantName);
        merchant.setMerchantForshort(merchantForshort);
        merchant.setContactName(contactName);
        merchant.setPhone(phone);
        merchant.setApplicationDate(applicationDate);
        merchant.setStatus(status);
        merchant.setChildMerchant(childMerchant);
        merchant.setWechatMerchant(weChatMerchant);
        merchant.setWechatRate(weChatRate);
        merchant.setAlipayTheir(alipayTheir);
        merchant.setAlipayRate(alipayRate);
        merchant.setNote(note);

        int result = merchantService.add(merchant);

        return "添加成功";
    }

    @ResponseBody
    @RequestMapping("/select")
    public Object select(String merchantName, String wechatMerchant, String status, ModelMap modelMap) {
        System.out.println("有数据？" + merchantName + "," + wechatMerchant + "," + status);
        if (!"".equals(merchantName)) {
            List<Merchant> merchants = merchantService.selectByName(merchantName, modelMap);
            return merchants;
        } else if (!"".equals(wechatMerchant)) {
            List<Merchant> merchants = merchantService.selectByWId(wechatMerchant, modelMap);
            return merchants;
        } else if (!"".equals(status)) {
            List<Merchant> merchants = merchantService.selectByStatus(status, modelMap);
            return merchants;
        }
        login(1, modelMap);

        return "index";
    }


    @ResponseBody
    @RequestMapping("/update")
    public String updateById(int id, String belong, String merchantName, String merchantForshort, String contactName, String phone, String applicationDate, String status, String childMerchant, String wechatMerchant, String wechatRate, String wechatRateDate, String alipayId, String alipayPid, String alipayTheir, String alipayRate, String note) {

        return merchantService.updateById(id, belong, merchantName, merchantForshort, contactName, phone, applicationDate, status, childMerchant, wechatMerchant, wechatRate, wechatRateDate, alipayId, alipayPid, alipayTheir, alipayRate, note);
    }

}
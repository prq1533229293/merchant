package com.kezilai.merchant.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable {
    /**
     * Database Column Remarks:
     *   排序ID
     */
    private Integer id;

    /**
     * Database Column Remarks:
     *   所属代理商
     */
    private String belong;

    /**
     * Database Column Remarks:
     *   营业执照名称
     */
    private String merchantName;

    /**
     * Database Column Remarks:
     *   商户简称
     */
    private String merchantForshort;

    /**
     * Database Column Remarks:
     *   联系人姓名
     */
    private String contactName;

    /**
     * Database Column Remarks:
     *   联系电话
     */
    private String phone;

    /**
     * Database Column Remarks:
     *   申请入驻日期
     */
    private String applicationDate;

    /**
     * Database Column Remarks:
     *   入驻状态
     */
    private String status;

    /**
     * Database Column Remarks:
     *   云支付子商户账号
     */
    private String childMerchant;

    /**
     * Database Column Remarks:
     *   微信商户号
     */
    private String wechatMerchant;

    /**
     * Database Column Remarks:
     *   微信费率
     */
    private String wechatRate;

    /**
     * Database Column Remarks:
     *   微信费率生效日期
     */
    private String wechatRateDate;

    /**
     * Database Column Remarks:
     *   支付宝商家PID
     */
    private String alipayId;

    /**
     * Database Column Remarks:
     *   支付宝商家PID
     */
    private String alipayPid;

    /**
     * Database Column Remarks:
     *   支付宝商家名称
     */
    private String alipayTheir;

    /**
     * Database Column Remarks:
     *   支付宝费率
     */
    private String alipayRate;

    /**
     * Database Column Remarks:
     *   备注
     */
    private String note;

    private static final long serialVersionUID = 1L;

}
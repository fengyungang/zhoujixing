package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
//统一收单交易撤销接口
public class AlipayTradeCancel {
    //原支付请求的商户订单号,和支付宝交易号不能同时为空
    private String out_trade_no;
    //支付宝交易号，和商户订单号不能同时为空
    private String trade_no;
}

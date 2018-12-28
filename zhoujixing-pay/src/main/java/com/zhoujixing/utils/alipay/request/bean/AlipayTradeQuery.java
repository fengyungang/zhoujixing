package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
//统一收单线下交易查询
public class AlipayTradeQuery {
    //订单支付时传入的商户订单号,和支付宝交易号不能同时为空。
    //trade_no,out_trade_no如果同时存在优先取trade_no
    private String out_trade_no;
    //支付宝交易号，和商户订单号不能同时为空
    private String trade_no;
    //银行间联模式下有用，其它场景请不要使用；
    //双联通过该参数指定需要查询的交易所属收单机构的pid;
    private String org_pid;
}

package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class SettleDetailInfo {
    //结算收款方的账户类型。
    //cardSerialNo：结算收款方的银行卡编号;
    //userId：表示是支付宝账号对应的支付宝唯一用户号;
    //loginName：表示是支付宝登录号；
    private String trans_in_type;
    //结算收款方。当结算收款方类型是cardSerialNo时，本参数为用户在支付宝绑定的卡编号；结算收款方类型是userId时，本参数为用户的支付宝账号对应的支付宝唯一用户号，以2088开头的纯16位数字；当结算收款方类型是loginName时，本参数为用户的支付宝登录号
    private String trans_in;
    //结算汇总维度，按照这个维度汇总成批次结算，由商户指定。
    //目前需要和结算收款方账户类型为cardSerialNo配合使用
    private String summary_dimension;
    //结算主体标识。当结算主体类型为SecondMerchant时，为二级商户的SecondMerchantID；当结算主体类型为Store时，为门店的外标。
    private String settle_entity_id;
    //结算主体类型。
    //二级商户:SecondMerchant;商户或者直连商户门店:Store
    private String settle_entity_type;
    //结算的金额，单位为元。目前必须和交易金额相同
    private BigDecimal amount;

}

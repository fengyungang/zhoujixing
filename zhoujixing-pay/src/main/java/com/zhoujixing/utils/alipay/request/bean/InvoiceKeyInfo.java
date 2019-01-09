package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
public class InvoiceKeyInfo {
    //该交易是否支持开票
    private Boolean is_support_invoice;
    //开票商户名称：商户品牌简称|商户门店简称
    private String invoice_merchant_name;
    //税号
    private String tax_num;
}

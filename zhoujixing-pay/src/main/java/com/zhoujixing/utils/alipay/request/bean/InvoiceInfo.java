package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
public class InvoiceInfo {
    //开票关键信息
    private InvoiceKeyInfo key_info;
    //开票内容
    //注：json数组格式
    private String details;
}

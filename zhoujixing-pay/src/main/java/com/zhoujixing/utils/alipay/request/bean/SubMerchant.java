package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

@Data
public class SubMerchant {
    //间连受理商户的支付宝商户编号，通过间连商户入驻后得到。间连业务下必传，并且需要按规范传递受理商户编号。
    private String merchant_id;
    //商户id类型，
    private String merchant_type;
}

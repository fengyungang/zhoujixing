package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

import java.util.List;
@Data
public class SettleInfo {
    //结算详细信息，json数组，目前只支持一条。
    private List<SettleDetailInfo> settle_detail_infos;
    //商户id类型，
    private String merchant_type;

}

package com.zhoujixing.utils.alipay.request.bean;

import lombok.Data;

import java.util.List;

@Data
public class RoyaltyInfo {
    //分账类型
    //卖家的分账类型，目前只支持传入ROYALTY（普通分账类型）。
    private String royalty_type;
    //分账明细的信息，可以描述多条分账指令，json数组。
    private List<RoyaltyDetailInfos> royalty_detail_infos;
}

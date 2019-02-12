package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品详情表
 * GoodDetails的model，对应shop_good_details表
 */
@Data
public class GoodDetailsModel {
    private Integer shop_good_details_id;//商品详情表主键id
    private Integer shop_goods_id;//关联外键商品表的主键id
    private String shop_good_details_detail;//商品描述
    private Date shop_good_details_create_time;//创建时间
}

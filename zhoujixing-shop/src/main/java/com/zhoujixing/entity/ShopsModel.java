package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商铺表
 * Shops的model，对应shop_shops表
 */
@Data
public class ShopsModel {
    private Integer shop_shops_id;//商铺表主键id
    private String shop_shops_shopname;//商铺名
    private String shop_shops_shopaddress;//商铺地址
    private String shop_shops_shoptel;//商铺电话
    private Date shop_shops_create_time;//创建时间
}

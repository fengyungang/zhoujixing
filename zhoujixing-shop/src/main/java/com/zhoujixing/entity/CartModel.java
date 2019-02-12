package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 购物车表
 * Cart的model，对应shop_cart表
 */
@Data
public class CartModel {
    private Integer shop_cart_id;//购物车表主键id
    private Integer user_id;//关联外键用户表的主键id
    private Integer shop_goods_id;//关联外键商品表的主键id
    private Integer shop_cart_num;//商品数量
    private String shop_cart_state;//记录状态（0正常，1删除，2禁用）
    private Date shop_cart_create_time;//记录创建时间
    private Date shop_cart_update_time;//记录更新时间

}

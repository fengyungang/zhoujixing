package com.zhoujixing.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单表
 * Order的model，对应shop_order表
 */
@Data
public class OrderModel {
    private Integer shop_order_id;//订单表主键id
    private Integer user_id;//关联外键用户表的主键id
    private Integer shop_goods_id;//关联外键商品表的主键id
    private Integer shop_order_goods_num;//商品数量
    private BigDecimal shop_order_total_money;//总金额
    private String shop_order_state;//订单状态（0下单，1未支付，2支付成功，3已支付，4收货状态，5完成状态）
    private Date shop_order_create_time;//创建时间
}

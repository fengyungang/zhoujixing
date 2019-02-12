package com.zhoujixing.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品表
 * Goods的model，对应shop_goods表
 */
@Data
public class GoodsModel {
    private Integer shop_goods_id;//商品表主键id
    private Integer shop_shops_id;//关联外键商铺表的主键id
    private Integer shop_category_id;//关联外键分类表的主键id
    private String shop_goods_main_title;//商品主标题
    private String shop_goods_sub_title;//商品副标题
    private BigDecimal shop_goods_price;//商品价格
    private BigDecimal shop_goods_old_price;//原价
    private Integer shop_goods_buy;//购买人数
    private String shop_goods_img;//商品图
    private String shop_goods_state;//商品状态（0下架，1上架）
    private String shop_goods_del;//商品删除状态（0未删除，1已删除）
    private Date shop_goods_create_time;//创建时间

}

package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 收藏表
 * Collect的model，对应shop_collect表
 */
@Data
public class CollectModel {
    private Integer shop_collect_id;//收藏表主键id
    private Integer user_id;//关联外键用户表的主键id
    private Integer shop_goods_id;//关联外键商品表的主键id
    private Date shop_collect_create_time;//创建时间
}

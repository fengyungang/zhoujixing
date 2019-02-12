package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 商品评论表
 * Comment的model，对应shop_comment表
 */
@Data
public class CommentModel {
    private Integer shop_comment_id;//商品评论表主键id
    private Integer user_id;//关联外键用户表的主键id
    private Integer shop_goods_id;//关联外键商品表的主键id
    private String shop_comment_content;//评论内容
    private Date shop_comment_create_time;//评论时间（创建时间）
}

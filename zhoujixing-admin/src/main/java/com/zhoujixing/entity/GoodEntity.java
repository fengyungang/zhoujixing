package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 *点赞表
 * Good的model，对应good表
 */
@Data
public class GoodEntity {
    private Integer good_id;//点赞表主键id
    private Integer news_id;//关联的新闻表的主键id
    private Integer user_id;//关联的用户表的主键id
    private Date good_create_time;//点赞时间
}

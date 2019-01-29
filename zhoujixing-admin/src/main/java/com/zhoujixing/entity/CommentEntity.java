package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 评论表
 * Comment的model，对应comment表
 */
@Data
public class CommentEntity {
    private Integer comment_id;//评论表主键id
    private Integer user_id;//关联的用户表的主键id
    private Integer news_id;//关联的新闻表的主键id
    private String comment_content;//评论的内容
    private Date comment_create_time;//评论时间
    private String comment_del;//删除状态（0未删除，1已删除）
}

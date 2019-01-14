package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 *新闻表
 *News的model，对应news表
 */
@Data
public class NewsEntity {
    private Integer news_id;//新闻表主键id
    private Integer user_id;//发布文章作者（关联用户表的主键id）
    private String news_title;//文章标题
    private String news_content;//文章内容
    private String news_type;//文章类型（0企业类型，1行业类型）
    private String news_subordinate;//文章所属（0原创，1转载）
    private String news_route;//转载路径
    private Integer news_browse;//浏览次数
    private Integer news_good;//点赞次数
    private Date news_create_time;//文章发布时间
    private String news_del;//删除状态（0未删除，1已删除）
}

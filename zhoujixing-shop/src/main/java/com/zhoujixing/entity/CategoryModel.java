package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 分类表
 * Category的model，对应shop_category表
 */
@Data
public class CategoryModel {
    private Integer shop_category_id;//分类表主键id
    private Integer shop_category_pid;//父id
    private Integer shop_category_sort;//类型排序
    private String shop_category_cname;//分类名
    private String shop_category_keywords;//分类关键字
    private String shop_category_title;//分类标题
    private String shop_category_description;//分类描述
    private String shop_category_display;//是否显示（0显示，1不显示）
    private Date shop_category_create_time;//创建时间
}

package com.participate.entity;

import lombok.Data;

import java.util.Date;

/**
 * 客户表
 * Customer的model，对应customer表
 */
@Data
public class CustomerModel {
    private Integer customer_id;//客户表主键id
    private Integer salesman_id;//销售人员id（关联外键）
    private String customer_name;//姓名
    private String customer_phone_number;//手机号
    private String customer_sex;//性别
    private String customer_address;//家庭住址
    private Date customer_create_time;//创建时间
    private Integer customer_del;//删除状态（0是未删除，1是已删除）
    private Integer word_book_code;//关联字典表的code标识码
}

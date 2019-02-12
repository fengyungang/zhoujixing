package com.zhoujixing.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息表
 * Userinfo的model，对应shop_userinfo表
 */
@Data
public class UserinfoModel {
    private Integer shop_userinfo_id;//用户信息表主键id
    private Integer user_id;//关联外键用户表的主键id
    private String shop_userinfo_associator;//是否会员（0不是，1是）
    private BigDecimal shop_userinfo_balance;//余额
    private Integer shop_userinfo_integral;//积分
    private Date shop_userinfo;//创建时间

}

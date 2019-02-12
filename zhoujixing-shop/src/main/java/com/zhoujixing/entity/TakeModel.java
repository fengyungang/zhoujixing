package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 收货地址表
 * Take的model，对应shop_take表
 */
@Data
public class TakeModel {
    private Integer shop_take_id;//收货地址表主键id
    private Integer user_id;//关联外键用户表的主键id
    private String shop_take_consignee;//收货人
    private String shop_take_province;//省
    private String shop_take_city;//市
    private String shop_take_county;//县
    private String shop_take_street;//街道地址
    private String shop_take_tel;//电话
    private String shop_take_postcode;//邮编地址
    private Date shop_take_create_time;//创建时间

}

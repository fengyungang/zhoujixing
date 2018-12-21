package com.participate.entity;

import lombok.Data;

import java.util.Date;

/**
 * 销售人员表
 * Salesman的model，对应salesman表
 */
@Data
public class SalesmanModel {
    private Integer salesman_id;//销售人员表主键id
    private Integer salesman_parent_id;//身份标识（可以为空，当为0时是组长，为其他值时是所属组长）
    private String salesman_name;//姓名
    private String salesman_phone_number;//手机号
    private String salesman_password;//密码
    private Date salesman_create_time;//创建时间
}

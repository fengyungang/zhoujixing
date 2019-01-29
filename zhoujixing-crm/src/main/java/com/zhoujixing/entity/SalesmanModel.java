package com.zhoujixing.entity;

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

    public Integer getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(Integer salesman_id) {
        this.salesman_id = salesman_id;
    }

    public Integer getSalesman_parent_id() {
        return salesman_parent_id;
    }

    public void setSalesman_parent_id(Integer salesman_parent_id) {
        this.salesman_parent_id = salesman_parent_id;
    }

    public String getSalesman_name() {
        return salesman_name;
    }

    public void setSalesman_name(String salesman_name) {
        this.salesman_name = salesman_name;
    }

    public String getSalesman_phone_number() {
        return salesman_phone_number;
    }

    public void setSalesman_phone_number(String salesman_phone_number) {
        this.salesman_phone_number = salesman_phone_number;
    }

    public String getSalesman_password() {
        return salesman_password;
    }

    public void setSalesman_password(String salesman_password) {
        this.salesman_password = salesman_password;
    }

    public Date getSalesman_create_time() {
        return salesman_create_time;
    }

    public void setSalesman_create_time(Date salesman_create_time) {
        this.salesman_create_time = salesman_create_time;
    }
}

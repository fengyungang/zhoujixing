package com.zhoujixing.entity;

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

    public Integer getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(Integer customer_id) {
        this.customer_id = customer_id;
    }

    public Integer getSalesman_id() {
        return salesman_id;
    }

    public void setSalesman_id(Integer salesman_id) {
        this.salesman_id = salesman_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_phone_number() {
        return customer_phone_number;
    }

    public void setCustomer_phone_number(String customer_phone_number) {
        this.customer_phone_number = customer_phone_number;
    }

    public String getCustomer_sex() {
        return customer_sex;
    }

    public void setCustomer_sex(String customer_sex) {
        this.customer_sex = customer_sex;
    }

    public String getCustomer_address() {
        return customer_address;
    }

    public void setCustomer_address(String customer_address) {
        this.customer_address = customer_address;
    }

    public Date getCustomer_create_time() {
        return customer_create_time;
    }

    public void setCustomer_create_time(Date customer_create_time) {
        this.customer_create_time = customer_create_time;
    }

    public Integer getCustomer_del() {
        return customer_del;
    }

    public void setCustomer_del(Integer customer_del) {
        this.customer_del = customer_del;
    }

    public Integer getWord_book_code() {
        return word_book_code;
    }

    public void setWord_book_code(Integer word_book_code) {
        this.word_book_code = word_book_code;
    }
}

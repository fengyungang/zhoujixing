package com.participate.entity;

/**
 * 仓库
 * 仓库表
 */
public class CangkuEntity {
    /**
     * 自增主键
     */
    private int cang_id;

    /**
     * 仓库地址
     */
    private  String cang_name;

    /**
     * 仓库名称
     */
    private  String cang_address;


    public int getCang_id() {
        return cang_id;
    }

    public void setCang_id(int cang_id) {
        this.cang_id = cang_id;
    }

    public String getCang_name() {
        return cang_name;
    }

    public void setCang_name(String cang_name) {
        this.cang_name = cang_name;
    }

    public String getCang_address() {
        return cang_address;
    }

    public void setCang_address(String cang_address) {
        this.cang_address = cang_address;
    }
}

package com.participate.entity;

/**
 * 仓库
 * 单位表
 */
public class CompanyEntity {
    /**
     * 自增主键
     */
    private int dan_id;

    /**
     * 类型
     */
    private String dan_name;

    /**
     * 状态
     */
    private int dan_state;

    public int getDan_id() {
        return dan_id;
    }

    public void setDan_id(int dan_id) {
        this.dan_id = dan_id;
    }

    public String getDan_name() {
        return dan_name;
    }

    public void setDan_name(String dan_name) {
        this.dan_name = dan_name;
    }

    public int getDan_state() {
        return dan_state;
    }

    public void setDan_state(int dan_state) {
        this.dan_state = dan_state;
    }
}

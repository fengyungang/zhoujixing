package com.participate.entity;

/**
 * 仓库
 * 类型表
 */
public class TypeEntity {
    /**
     * 自增主键
     */
    private  int by_id;

    /**
     * 名称
     */
    private String by_name;

    /**
     * 状态
     */
    private  String by_state;

    public int getBy_id() {
        return by_id;
    }

    public void setBy_id(int by_id) {
        this.by_id = by_id;
    }

    public String getBy_name() {
        return by_name;
    }

    public void setBy_name(String by_name) {
        this.by_name = by_name;
    }

    public String getBy_state() {
        return by_state;
    }

    public void setBy_state(String by_state) {
        this.by_state = by_state;
    }
}

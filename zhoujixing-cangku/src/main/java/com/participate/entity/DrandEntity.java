package com.participate.entity;

/**
 * 仓库
 * 品牌表
 */
public class DrandEntity {
    /**
     * 自增主键
     */
    private int pin_id;

    /**
     * 名称
     */
    private String  pin_name;

    /**
     * 状态
     */
    private int pin_state;

    public int getPin_id() {
        return pin_id;
    }

    public void setPin_id(int pin_id) {
        this.pin_id  =  pin_id;
    }

    public String getPin_name() {
        return pin_name;
    }

    public void setPin_name(String pin_name) {
        this.pin_name = pin_name;
    }

    public int getPin_state() {
        return pin_state;
    }

    public void setPin_state(int pin_state) {
        this.pin_state = pin_state;
    }
}

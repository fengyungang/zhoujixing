package com.participate.entity;

import java.util.Date;

/**
 * 仓库
 * 物品表
 */
public class WarehouseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 自增主键
     */
    private  int wu_id;

    /**
     * 名称
     */
    private  String wu_name;

    /**
     * 采购单价
     */
     private  int wu_price;

    /**
     * 备注
     */
    private  String wu_remarks;

    /**
     * 创建时间
     */
    private Date wu_foundtime;

    /**
     * 创建人
     */
    private  String  wu_founder;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getWu_id() {
        return wu_id;
    }

    public void setWu_id(int wu_id) {
        this.wu_id = wu_id;
    }

    public String getWu_name() {
        return wu_name;
    }

    public void setWu_name(String wu_name) {
        this.wu_name = wu_name;
    }

    public int getWu_price() {
        return wu_price;
    }

    public void setWu_price(int wu_price) {
        this.wu_price = wu_price;
    }

    public String getWu_remarks() {
        return wu_remarks;
    }

    public void setWu_remarks(String wu_remarks) {
        this.wu_remarks = wu_remarks;
    }

    public Date getWu_foundtime() {
        return wu_foundtime;
    }

    public void setWu_foundtime(Date wu_foundtime) {
        this.wu_foundtime = wu_foundtime;
    }

    public String getWu_founder() {
        return wu_founder;
    }

    public void setWu_founder(String wu_founder) {
        this.wu_founder = wu_founder;
    }
}

package com.participate.entity;

import java.util.Date;

public class CaruEntity {
    /*

     */

    /**
     * 自增主键
     */
    private int cai_id;

    /**
     * 名称
     */
    private String  name;



    /**
     * 地址
     */
    private  String dizhi;

    /**
     * 父id
     */
    private  int fuid;

    /**
     * 排序
     */
    private  int paixu;

    private  int wuid;

    public int getWuid() {
        return wuid;
    }

    public void setWuid(int wuid) {
        this.wuid = wuid;
    }

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

    /*
      物品表里的关联树形表的id
     */
    private int shu_id;

    public int getShu_id() {
        return shu_id;
    }

    public void setShu_id(int shu_id) {
        this.shu_id = shu_id;
    }

    public int getCai_id() {
        return cai_id;
    }

    public void setCai_id(int cai_id) {
        this.cai_id = cai_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDizhi() {
        return dizhi;
    }

    public void setDizhi(String dizhi) {
        this.dizhi = dizhi;
    }

    public int getFuid() {
        return fuid;
    }

    public void setFuid(int fuid) {
        this.fuid = fuid;
    }

    public int getPaixu() {
        return paixu;
    }

    public void setPaixu(int paixu) {
        this.paixu = paixu;
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

    public int getPin_id() {
        return pin_id;
    }

    public void setPin_id(int pin_id) {
        this.pin_id = pin_id;
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

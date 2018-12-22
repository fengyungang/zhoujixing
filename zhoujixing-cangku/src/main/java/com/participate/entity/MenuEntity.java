package com.participate.entity;

import java.io.Serializable;

/**
 * 仓库
 * 树形表
 */
public class MenuEntity implements Serializable {
    private static final long serialVersionUID = 1L;
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

    public int getId() {
        return cai_id;
    }

    public void setId(int cai_id) {
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
}

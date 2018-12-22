package com.participate.entity;

import java.util.Date;

public class ChuruEntity {
   /*
      出入库的实体表
    */
   /*
     仓库表
    */
    private int ru_id;

    private int  ru_wuid;

    private Date ru_ruku;

    private String ru_rukur;

    private String ru_cangid;

    private int ru_rukushu;

    private int ru_leixing;

    private int ru_shijiru;

    private int ru_sunhao;

    private int ru_kucun;

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

    private int wu_kucun;

    private String wu_fenlei;

    private int ru_shuid;

    public String getQidate() {
        return qidate;
    }

    public void setQidate(String qidate) {
        this.qidate = qidate;
    }

    public String getModate() {
        return this.modate;
    }

    public void setModate(String modate) {
        this.modate = modate;
    }

    private String qidate;//起始日期

    private String modate;//结尾日期

    public int getRu_shuid() {
        return ru_shuid;
    }

    public void setRu_shuid(int ru_shuid) {
        this.ru_shuid = ru_shuid;
    }

    public String getWu_fenlei() {
        return wu_fenlei;
    }

    public void setWu_fenlei(String wu_fenlei) {
        this.wu_fenlei = wu_fenlei;
    }

    public int getWu_kucun() {
        return wu_kucun;
    }

    public void setWu_kucun(int wu_kucun) {
        this.wu_kucun = wu_kucun;
    }

    public int getRu_id() {
        return ru_id;
    }

    public void setRu_id(int ru_id) {
        this.ru_id = ru_id;
    }

    public int getRu_wuid() {
        return ru_wuid;
    }

    public void setRu_wuid(int ru_wuid) {
        this.ru_wuid = ru_wuid;
    }

    public Date getRu_ruku() {
        return ru_ruku;
    }

    public void setRu_ruku(Date ru_ruku) {
        this.ru_ruku = ru_ruku;
    }

    public String getRu_rukur() {
        return ru_rukur;
    }

    public void setRu_rukur(String ru_rukur) {
        this.ru_rukur = ru_rukur;
    }

    public String getRu_cangid() {
        return ru_cangid;
    }

    public void setRu_cangid(String ru_cangid) {
        this.ru_cangid = ru_cangid;
    }

    public int getRu_rukushu() {
        return ru_rukushu;
    }

    public void setRu_rukushu(int ru_rukushu) {
        this.ru_rukushu = ru_rukushu;
    }

    public int getRu_leixing() {
        return ru_leixing;
    }

    public void setRu_leixing(int ru_leixing) {
        this.ru_leixing = ru_leixing;
    }

    public int getRu_shijiru() {
        return ru_shijiru;
    }

    public void setRu_shijiru(int ru_shijiru) {
        this.ru_shijiru = ru_shijiru;
    }

    public int getRu_sunhao() {
        return ru_sunhao;
    }

    public void setRu_sunhao(int ru_sunhao) {
        this.ru_sunhao = ru_sunhao;
    }

    public int getRu_kucun() {
        return ru_kucun;
    }

    public void setRu_kucun(int ru_kucun) {
        this.ru_kucun = ru_kucun;
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

    public int getWuid() {
        return wuid;
    }

    public void setWuid(int wuid) {
        this.wuid = wuid;
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

    public int getShu_id() {
        return shu_id;
    }

    public void setShu_id(int shu_id) {
        this.shu_id = shu_id;
    }

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


}

package com.zhoujixing.entity;


import java.util.Date;

public class VoteEntity {

    private int h_id;//

    private String h_bt;//标题

    private String h_nr;//内容

    private Date h_kssj;//开始时间

    private Date h_jssj;//结束时间

    private Date h_bmsj;//报名时间

    private Date h_bjssj;//报名结束时间

    private int p_id;

    private String p_name;//名称

    private String p_tup;//图片路径

    private String p_jieshao;//介绍

    private int t_id;

    private int t_pid;//票对象id

    private int t_hid;//活动id

    private int t_ps;//票数

    private int x_id;

    private String x_appid;//appid

    private String x_ipdz;//ip地址

    private String x_name;//名称

    private Date x_sj;//投票时间

    private String x_tpr;//投票人

    private int x_tps;//投票数

    private int z_id;

    private int z_zdt;//最多投几票

    private int z_zdtg;//最多可以给几个人投票

    private int z_ygt;//给一个人最多几票

    private int z_hid;

    public int getZ_hid() {
        return z_hid;
    }

    public void setZ_hid(int z_hid) {
        this.z_hid = z_hid;
    }

    public int getH_id() {
        return h_id;
    }

    public void setH_id(int h_id) {
        this.h_id = h_id;
    }

    public String getH_bt() {
        return h_bt;
    }

    public void setH_bt(String h_bt) {
        this.h_bt = h_bt;
    }

    public String getH_nr() {
        return h_nr;
    }

    public void setH_nr(String h_nr) {
        this.h_nr = h_nr;
    }

    public Date getH_kssj() {
        return h_kssj;
    }

    public void setH_kssj(Date h_kssj) {
        this.h_kssj = h_kssj;
    }

    public Date getH_jssj() {
        return h_jssj;
    }

    public void setH_jssj(Date h_jssj) {
        this.h_jssj = h_jssj;
    }

    public Date getH_bmsj() {
        return h_bmsj;
    }

    public void setH_bmsj(Date h_bmsj) {
        this.h_bmsj = h_bmsj;
    }

    public Date getH_bjssj() {
        return h_bjssj;
    }

    public void setH_bjssj(Date h_bjssj) {
        this.h_bjssj = h_bjssj;
    }

    public int getP_id() {
        return p_id;
    }

    public void setP_id(int p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getP_tup() {
        return p_tup;
    }

    public void setP_tup(String p_tup) {
        this.p_tup = p_tup;
    }

    public String getP_jieshao() {
        return p_jieshao;
    }

    public void setP_jieshao(String p_jieshao) {
        this.p_jieshao = p_jieshao;
    }

    public int getT_id() {
        return t_id;
    }

    public void setT_id(int t_id) {
        this.t_id = t_id;
    }

    public int getT_pid() {
        return t_pid;
    }

    public void setT_pid(int t_pid) {
        this.t_pid = t_pid;
    }

    public int getT_hid() {
        return t_hid;
    }

    public void setT_hid(int t_hid) {
        this.t_hid = t_hid;
    }

    public int getT_ps() {
        return t_ps;
    }

    public void setT_ps(int t_ps) {
        this.t_ps = t_ps;
    }

    public int getX_id() {
        return x_id;
    }

    public void setX_id(int x_id) {
        this.x_id = x_id;
    }

    public String getX_appid() {
        return x_appid;
    }

    public void setX_appid(String x_appid) {
        this.x_appid = x_appid;
    }

    public String getX_ipdz() {
        return x_ipdz;
    }

    public void setX_ipdz(String x_ipdz) {
        this.x_ipdz = x_ipdz;
    }

    public String getX_name() {
        return x_name;
    }

    public void setX_name(String x_name) {
        this.x_name = x_name;
    }

    public Date getX_sj() {
        return x_sj;
    }

    public void setX_sj(Date x_sj) {
        this.x_sj = x_sj;
    }

    public String getX_tpr() {
        return x_tpr;
    }

    public void setX_tpr(String x_tpr) {
        this.x_tpr = x_tpr;
    }

    public int getX_tps() {
        return x_tps;
    }

    public void setX_tps(int x_tps) {
        this.x_tps = x_tps;
    }

    public int getZ_id() {
        return z_id;
    }

    public void setZ_id(int z_id) {
        this.z_id = z_id;
    }

    public int getZ_zdt() {
        return z_zdt;
    }

    public void setZ_zdt(int z_zdt) {
        this.z_zdt = z_zdt;
    }

    public int getZ_zdtg() {
        return z_zdtg;
    }

    public void setZ_zdtg(int z_zdtg) {
        this.z_zdtg = z_zdtg;
    }

    public int getZ_ygt() {
        return z_ygt;
    }

    public void setZ_ygt(int z_ygt) {
        this.z_ygt = z_ygt;
    }

//    @Override
//    public String toString() {
//        return "VoteEntity{" +
//                "h_id=" + h_id +
//                ", h_bt='" + h_bt + '\'' +
//                ", h_nr='" + h_nr + '\'' +
//                ", h_kssj=" + h_kssj +
//                ", h_jssj=" + h_jssj +
//                ", h_bmsj=" + h_bmsj +
//                ", h_bjssj=" + h_bjssj +
//                ", p_id=" + p_id +
//                ", p_name='" + p_name + '\'' +
//                ", p_tup='" + p_tup + '\'' +
//                ", p_jieshao='" + p_jieshao + '\'' +
//                ", t_id=" + t_id +
//                ", t_pid=" + t_pid +
//                ", t_hid=" + t_hid +
//                ", t_ps=" + t_ps +
//                ", x_id=" + x_id +
//                ", x_appid='" + x_appid + '\'' +
//                ", x_ipdz='" + x_ipdz + '\'' +
//                ", x_name='" + x_name + '\'' +
//                ", x_sj=" + x_sj +
//                ", x_tpr='" + x_tpr + '\'' +
//                ", x_tps=" + x_tps +
//                ", z_id=" + z_id +
//                ", z_zdt=" + z_zdt +
//                ", z_zdtg=" + z_zdtg +
//                ", z_ygt=" + z_ygt +
//                '}';
//    }
//
//    public VoteEntity(int h_id, String h_bt, String h_nr, Date h_kssj, Date h_jssj, Date h_bmsj, Date h_bjssj, int p_id, String p_name, String p_tup, String p_jieshao, int t_id, int t_pid, int t_hid, int t_ps, int x_id, String x_appid, String x_ipdz, String x_name, Date x_sj, String x_tpr, int x_tps, int z_id, int z_zdt, int z_zdtg, int z_ygt) {
//        this.h_id = h_id;
//        this.h_bt = h_bt;
//        this.h_nr = h_nr;
//        this.h_kssj = h_kssj;
//        this.h_jssj = h_jssj;
//        this.h_bmsj = h_bmsj;
//        this.h_bjssj = h_bjssj;
//        this.p_id = p_id;
//        this.p_name = p_name;
//        this.p_tup = p_tup;
//        this.p_jieshao = p_jieshao;
//        this.t_id = t_id;
//        this.t_pid = t_pid;
//        this.t_hid = t_hid;
//        this.t_ps = t_ps;
//        this.x_id = x_id;
//        this.x_appid = x_appid;
//        this.x_ipdz = x_ipdz;
//        this.x_name = x_name;
//        this.x_sj = x_sj;
//        this.x_tpr = x_tpr;
//        this.x_tps = x_tps;
//        this.z_id = z_id;
//        this.z_zdt = z_zdt;
//        this.z_zdtg = z_zdtg;
//        this.z_ygt = z_ygt;
//    }

}

package com.participate.entity;

import java.util.Date;

/**
 * 仓库
 * 出入库表
 */
public class OutEnterEntity {
    /**
     * 自增主键id
     */
    private  int ru_id;

    /**
     * 入库时间
     */
    private Date ru_ruku;

    /**
     * 入库人
     */
    private String ru_rukur;

    /**
     * 入库数量
     */
    private  int ru_rukushu;

    /**
     * 类型
     */
    private int ru_leixing;

    /**
     * 实际入库
     */
    private  int ru_shijiru;

    /**
     * 损耗
     */
    private  int ru_sunhao;

    public int getRu_id() {
        return ru_id;
    }

    public void setRu_id(int ru_id) {
        this.ru_id = ru_id;
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
}

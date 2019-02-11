package com.zhoujixing.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 * 中奖基础数据类
 */
public class Lottery implements Serializable {

    private static final long serialVersionUID = 6163071141331307143L;

    private Integer id;

    //中奖类型
    private String prize;

    //中奖率
    private Integer v;

    public Lottery(){

    }

    public Lottery(Integer id, String prize, Integer v) {
        this.id = id;
        this.prize = prize;
        this.v = v;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lottery lottery = (Lottery) o;
        return Objects.equals(id, lottery.id) &&
                Objects.equals(prize, lottery.prize) &&
                Objects.equals(v, lottery.v);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, prize, v);
    }

    @Override
    public String toString() {
        return "Lottery{" +
                "id=" + id +
                ", prize='" + prize + '\'' +
                ", v=" + v +
                '}';
    }
}

package com.zhoujixing.entity;

import java.util.Date;
import java.util.Objects;

public class Record {

    private Integer id;
    private Integer uid;
    private String prizeName;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getPrizeName() {
        return prizeName;
    }

    public void setPrizeName(String prizeName) {
        this.prizeName = prizeName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Record record = (Record) o;
        return Objects.equals(id, record.id) &&
                Objects.equals(uid, record.uid) &&
                Objects.equals(prizeName, record.prizeName) &&
                Objects.equals(createTime, record.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, uid, prizeName, createTime);
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", uid=" + uid +
                ", prizeName='" + prizeName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

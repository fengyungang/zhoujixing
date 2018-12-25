package com.zhoujixing.entity;

import java.util.Date;
import java.util.Objects;

public class DishCategory {

    private Integer id;
    private String categoryName;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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
        DishCategory that = (DishCategory) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(categoryName, that.categoryName) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, categoryName, createTime);
    }

    @Override
    public String toString() {
        return "DishCategory{" +
                "id=" + id +
                ", categoryName='" + categoryName + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

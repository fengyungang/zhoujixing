package com.zhoujixing.entity;

import java.util.Date;
import java.util.Objects;

public class Dish {
    private Integer id;
    private String dishName;
    private Double price;
    private String depict;
    private String image;
    private Integer categoryId;
    private Date createTime;
    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dish dish = (Dish) o;
        return Objects.equals(id, dish.id) &&
                Objects.equals(dishName, dish.dishName) &&
                Objects.equals(price, dish.price) &&
                Objects.equals(depict, dish.depict) &&
                Objects.equals(image, dish.image) &&
                Objects.equals(categoryId, dish.categoryId) &&
                Objects.equals(createTime, dish.createTime) &&
                Objects.equals(updateTime, dish.updateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dishName, price, depict, image, categoryId, createTime, updateTime);
    }

    @Override
    public String toString() {
        return "Dish{" +
                "id=" + id +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", depict='" + depict + '\'' +
                ", image='" + image + '\'' +
                ", categoryId=" + categoryId +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}

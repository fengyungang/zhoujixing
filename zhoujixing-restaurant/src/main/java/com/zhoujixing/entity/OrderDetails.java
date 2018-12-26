package com.zhoujixing.entity;

import java.util.Date;
import java.util.Objects;

public class OrderDetails {

    private Integer id;
    private Integer buyerId;
    private Integer dishId;
    private Integer tableId;
    private String dishName;
    private Double price;
    private Integer amount;
    private String image;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
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

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
        OrderDetails that = (OrderDetails) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(buyerId, that.buyerId) &&
                Objects.equals(dishId, that.dishId) &&
                Objects.equals(tableId, that.tableId) &&
                Objects.equals(dishName, that.dishName) &&
                Objects.equals(price, that.price) &&
                Objects.equals(amount, that.amount) &&
                Objects.equals(image, that.image) &&
                Objects.equals(createTime, that.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerId, dishId, tableId, dishName, price, amount, image, createTime);
    }

    @Override
    public String toString() {
        return "OrderDetails{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", dishId=" + dishId +
                ", tableId=" + tableId +
                ", dishName='" + dishName + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                ", image='" + image + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}

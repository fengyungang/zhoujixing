package com.zhoujixing.entity;

import java.util.Date;
import java.util.Objects;

public class Order {

    private Integer id;
    private String buyerName;
    private String buyerPhone;
    private String buyerAddress;
    private Double totalMoney;
    private Integer orderStatus;
    private Integer paymentStatus;
    private Date createTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public String getBuyerPhone() {
        return buyerPhone;
    }

    public void setBuyerPhone(String buyerPhone) {
        this.buyerPhone = buyerPhone;
    }

    public String getBuyerAddress() {
        return buyerAddress;
    }

    public void setBuyerAddress(String buyerAddress) {
        this.buyerAddress = buyerAddress;
    }

    public Double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(Integer paymentStatus) {
        this.paymentStatus = paymentStatus;
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
        Order order = (Order) o;
        return Objects.equals(id, order.id) &&
                Objects.equals(buyerName, order.buyerName) &&
                Objects.equals(buyerPhone, order.buyerPhone) &&
                Objects.equals(buyerAddress, order.buyerAddress) &&
                Objects.equals(totalMoney, order.totalMoney) &&
                Objects.equals(orderStatus, order.orderStatus) &&
                Objects.equals(paymentStatus, order.paymentStatus) &&
                Objects.equals(createTime, order.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerName, buyerPhone, buyerAddress, totalMoney, orderStatus, paymentStatus, createTime);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", buyerName='" + buyerName + '\'' +
                ", buyerPhone='" + buyerPhone + '\'' +
                ", buyerAddress='" + buyerAddress + '\'' +
                ", totalMoney=" + totalMoney +
                ", orderStatus=" + orderStatus +
                ", paymentStatus=" + paymentStatus +
                ", createTime=" + createTime +
                '}';
    }
}

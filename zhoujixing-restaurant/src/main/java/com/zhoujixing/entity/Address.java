package com.zhoujixing.entity;

import java.util.Objects;

public class Address {

    private Integer id;
    private Integer buyerId;
    private Integer storeId;
    private String province;
    private String city;
    private String area;
    private String detailedAddress;
    private Integer isDefault;

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

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(id, address.id) &&
                Objects.equals(buyerId, address.buyerId) &&
                Objects.equals(storeId, address.storeId) &&
                Objects.equals(province, address.province) &&
                Objects.equals(city, address.city) &&
                Objects.equals(area, address.area) &&
                Objects.equals(detailedAddress, address.detailedAddress) &&
                Objects.equals(isDefault, address.isDefault);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerId, storeId, province, city, area, detailedAddress, isDefault);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", storeId=" + storeId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", detailedAddress='" + detailedAddress + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}

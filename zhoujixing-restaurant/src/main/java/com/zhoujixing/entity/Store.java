package com.zhoujixing.entity;

import java.util.Objects;

public class Store {

    private Integer id;
    private String storeName;
    private String storeAddress;
    private String practiceTime;
    private String storeType;
    private Integer storeStatus;
    private String image;
    private String dutyParagraph;
    private String enterpriseLegalPerson;
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getPracticeTime() {
        return practiceTime;
    }

    public void setPracticeTime(String practiceTime) {
        this.practiceTime = practiceTime;
    }

    public String getStoreType() {
        return storeType;
    }

    public void setStoreType(String storeType) {
        this.storeType = storeType;
    }

    public Integer getStoreStatus() {
        return storeStatus;
    }

    public void setStoreStatus(Integer storeStatus) {
        this.storeStatus = storeStatus;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDutyParagraph() {
        return dutyParagraph;
    }

    public void setDutyParagraph(String dutyParagraph) {
        this.dutyParagraph = dutyParagraph;
    }

    public String getEnterpriseLegalPerson() {
        return enterpriseLegalPerson;
    }

    public void setEnterpriseLegalPerson(String enterpriseLegalPerson) {
        this.enterpriseLegalPerson = enterpriseLegalPerson;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return Objects.equals(id, store.id) &&
                Objects.equals(storeName, store.storeName) &&
                Objects.equals(storeAddress, store.storeAddress) &&
                Objects.equals(practiceTime, store.practiceTime) &&
                Objects.equals(storeType, store.storeType) &&
                Objects.equals(storeStatus, store.storeStatus) &&
                Objects.equals(image, store.image) &&
                Objects.equals(dutyParagraph, store.dutyParagraph) &&
                Objects.equals(enterpriseLegalPerson, store.enterpriseLegalPerson) &&
                Objects.equals(phone, store.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, storeName, storeAddress, practiceTime, storeType, storeStatus, image, dutyParagraph, enterpriseLegalPerson, phone);
    }

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", practiceTime='" + practiceTime + '\'' +
                ", storeType='" + storeType + '\'' +
                ", storeStatus=" + storeStatus +
                ", image='" + image + '\'' +
                ", dutyParagraph='" + dutyParagraph + '\'' +
                ", enterpriseLegalPerson='" + enterpriseLegalPerson + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}

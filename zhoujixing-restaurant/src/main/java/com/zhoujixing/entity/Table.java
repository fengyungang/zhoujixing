package com.zhoujixing.entity;

import java.util.Objects;

public class Table {

    private Integer id;
    private Integer buyerId;
    private Integer capacity;
    private String depict;
    private Integer tableStatus;

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

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDepict() {
        return depict;
    }

    public void setDepict(String depict) {
        this.depict = depict;
    }

    public Integer getTableStatus() {
        return tableStatus;
    }

    public void setTableStatus(Integer tableStatus) {
        this.tableStatus = tableStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return Objects.equals(id, table.id) &&
                Objects.equals(buyerId, table.buyerId) &&
                Objects.equals(capacity, table.capacity) &&
                Objects.equals(depict, table.depict) &&
                Objects.equals(tableStatus, table.tableStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, buyerId, capacity, depict, tableStatus);
    }

    @Override
    public String toString() {
        return "Table{" +
                "id=" + id +
                ", buyerId=" + buyerId +
                ", capacity=" + capacity +
                ", depict='" + depict + '\'' +
                ", tableStatus=" + tableStatus +
                '}';
    }
}

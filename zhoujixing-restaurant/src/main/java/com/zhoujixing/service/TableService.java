package com.zhoujixing.service;

import com.zhoujixing.entity.Table;

import java.util.List;

public interface TableService {
    /**
     * 添加餐桌信息
     * @param table
     * @return
     */
    boolean addTable(Table table);

    /**
     * 获取所有餐桌信息
     * @return
     */
    List<Table> getAllTable();

    /**
     * 根据状态获取餐桌信息
     * @param tableStatus
     * @return
     */
    List<Table> getByTableStatus(Integer tableStatus);

    /**
     * 根据订单编号查询餐桌信息
     * @param buyerId
     * @return
     */
    Table getByBuyerId(Integer buyerId);

    /**
     * 根据id查询餐桌信息
     * @param id
     * @return
     */
    Table getById(Integer id);

    /**
     * 修改餐桌信息
     * @param table
     * @return
     */
    boolean modifyTable(Table table);

    /**
     * 删除餐桌信息
     * @param id
     * @return
     */
    boolean removeTable(Integer id);
}

package com.zhoujixing.mapper;


import com.zhoujixing.entity.Table;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TableMapper {

    /**
     * 插入餐桌信息
     * @param table
     * @return
     */
    int insertTable(Table table);

    /**
     * 查询所有餐桌信息
     * @return
     */
    List<Table> selectAllTable();

    /**
     * 根据餐桌状态查询餐桌信息
     * @param tableStatus
     * @return
     */
    List<Table> selectByTableStatus(Integer tableStatus);

    /**
     * 根据订单编号查询餐桌信息
     * @param buyerId
     * @return
     */
    Table selectByBuyerId(Integer buyerId);

    /**
     * 根据订id查询餐桌信息
     * @param id
     * @return
     */
    Table selectById(Integer id);

    /**
     * 修改餐桌信息
     * @param table
     * @return
     */
    int updateTable(Table table);

    /**
     * 根据id删除餐桌信息
     * @param id
     * @return
     */
    int deleteTable(Integer id);
}

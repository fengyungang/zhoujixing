package com.zhoujixing.mapper;

import com.zhoujixing.entity.OrderDetails;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDetailsMapper {

    /**
     * 插入订单详情信息
     * @param orderDetails
     * @return
     */
    int insertDetails(OrderDetails orderDetails);

    /**
     * 根据id查询订单详情
     * @param id
     * @return
     */
    OrderDetails selectById(Integer id);

    /**
     * 根据买家id查询订单详情
     * @param buyerId
     * @return
     */
    List<OrderDetails> selectByBuyerId(Integer buyerId);

    /**
     * 修改订单详情
     * @param orderDetails
     * @return
     */
    int updateDetails(OrderDetails orderDetails);

    /**
     * 根据买家id删除订单详情信息
     * @param id
     * @return
     */
    int deleteDetails(Integer id);
}

package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.GoodsMapper;
import com.zhoujixing.dao.OrderMapper;
import com.zhoujixing.entity.GoodsModel;
import com.zhoujixing.entity.OrderModel;
import com.zhoujixing.service.GoodsService;
import com.zhoujixing.service.OrderService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    /**
     * 添加方法
     * @param orderModel
     * @return
     */
    @Override
    public int add(OrderModel orderModel) {
        return orderMapper.add(orderModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_order_id
     * @return
     */
    @Override
    public OrderModel getById(Integer shop_order_id) {
        return orderMapper.getById(shop_order_id);
    }

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize) {
        Page page = PageHelper.startPage(pageIndex,pageSize);
        List<OrderModel> orderModelList = orderMapper.selA(map);
        PageInfo<OrderModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("orderModelList",orderModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<OrderModel> selA(Map<String, Object> map) {
        return orderMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param orderModel
     * @return
     */
    @Override
    public int update(OrderModel orderModel) {
        return orderMapper.update(orderModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_order_id
     * @return
     */
    @Override
    public int delById(Integer shop_order_id) {
        return orderMapper.delById(shop_order_id);
    }
}

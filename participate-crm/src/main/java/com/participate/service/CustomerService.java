package com.participate.service;

import com.participate.entity.CustomerModel;
import com.participate.entity.DateStatisticsModel;
import com.participate.entity.TimeStatisticsModel;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface CustomerService {
    /**
     * 添加方法
     * @param customerModel
     * @return
     */
    int add(CustomerModel customerModel);

    /**
     * 根据id查询一条信息
     * @param customer_id
     * @return
     */
    CustomerModel getById(Integer customer_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<CustomerModel> selA(Map<String,Object> map);

    /**
     * 根据id修改某条信息
     * @param customerModel
     * @return
     */
    int update(CustomerModel customerModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param id
     * @return
     */
    int delById(Integer id);

    /**
     * 查询满意度及数量根据小时
     * @param date
     * @return
     */
    List<TimeStatisticsModel> getHourCOUNT(Date date);

    /**
     * 查询满意度及数量根据日期
     * @param date
     * @return
     */
    List<DateStatisticsModel> getDayCOUNT(Date date);
}

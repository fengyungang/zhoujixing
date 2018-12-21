package com.participate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.CustomerMapper;
import com.participate.entity.CustomerModel;
import com.participate.entity.DateStatisticsModel;
import com.participate.entity.TimeStatisticsModel;
import com.participate.service.CustomerService;
import com.participate.utils.DateUtils;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    /**
     * 添加方法
     * @param customerModel
     * @return
     */
    @Override
    public int add(CustomerModel customerModel) {
        return customerMapper.add(customerModel);
    }

    /**
     * 根据id查询一条信息
     * @param customer_id
     * @return
     */
    @Override
    public CustomerModel getById(Integer customer_id) {
        return customerMapper.getById(customer_id);
    }

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String,Object> selA(Map<String,Object> map, Integer pageIndex, Integer pageSize) {

        Page page = PageHelper.startPage(pageIndex,pageSize);
        List<CustomerModel> customerModelList = customerMapper.selA(map);
        PageInfo<CustomerModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("customerModelList",customerModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<CustomerModel> selA(Map<String,Object> map){
        return customerMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param customerModel
     * @return
     */
    @Override
    public int update(CustomerModel customerModel) {
        return customerMapper.update(customerModel);
    }

    /**
     * -根据id删除客户信息（物理删除）
     * @param id
     * @return
     */
    @Override
    public int delById(Integer id) {
        return customerMapper.delById(id);
    }

    /**
     * 查询满意度及数量根据小时
     * @param date
     * @return
     */
    @Override
    public List<TimeStatisticsModel> getHourCOUNT(Date date){
        List<TimeStatisticsModel> timeStatisticsModelList = customerMapper.getHourCOUNT(date);
        String dateHour = DateUtils.DtS(date,"yyyy-MM-dd HH");
        date = DateUtils.StD(dateHour,"yyyy-MM-dd HH");
        for (int i = 0; i < timeStatisticsModelList.size(); i++) {
             timeStatisticsModelList.get(i).setTime_statistics_time(date);
        }
        return timeStatisticsModelList;
    }

    /**
     * 查询满意度及数量根据日期
     * @param date
     * @return
     */
    @Override
    public List<DateStatisticsModel> getDayCOUNT(Date date){
        List<DateStatisticsModel> dateStatisticsModelList = customerMapper.getDayCOUNT(date);
        String day = DateUtils.DtS(date,"yyyy-MM-dd");
        date = DateUtils.StD(day,"yyyy-MM-dd");
        for (int i = 0; i < dateStatisticsModelList.size(); i++) {
             dateStatisticsModelList.get(i).setDate_statistics_time(date);
        }
        return dateStatisticsModelList;
    }
}

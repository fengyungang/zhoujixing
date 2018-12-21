package com.participate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.DateStatisticsMapper;
import com.participate.entity.DateStatisticsModel;
import com.participate.service.DateStatisticsService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DateStatisticsServiceImpl implements DateStatisticsService {
    @Autowired
    private DateStatisticsMapper dateStatisticsMapper;

    /**
     * 添加方法
     * @param dateStatisticsModel
     * @return
     */
    @Override
    public int add(DateStatisticsModel dateStatisticsModel) {
        return dateStatisticsMapper.add(dateStatisticsModel);
    }

    /**
     * 根据id查询一条信息
     * @param date_statistics_id
     * @return
     */
    @Override
    public DateStatisticsModel getById(Integer date_statistics_id) {
        return dateStatisticsMapper.getById(date_statistics_id);
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
        List<DateStatisticsModel> dateStatisticsModelList = dateStatisticsMapper.selA(map);
        PageInfo<DateStatisticsModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("dateStatisticsModelList",dateStatisticsModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<DateStatisticsModel> selA(Map<String,Object> map){
        return dateStatisticsMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param dateStatisticsModel
     * @return
     */
    @Override
    public int update(DateStatisticsModel dateStatisticsModel) {
        return dateStatisticsMapper.update(dateStatisticsModel);
    }

    /**
     * -根据id删除客户信息（物理删除）
     * @param date_statistics_id
     * @return
     */
    @Override
    public int delById(Integer date_statistics_id) {
        return dateStatisticsMapper.delById(date_statistics_id);
    }

    @Override
    public Integer getCodeTotal(Map<String,Object> map){

        Integer i = dateStatisticsMapper.getCodeTotal(map);
        i = i==null?0:i;
        return i;
    }
    @Override
    public Integer getTotal(Map<String,Object> map){

        Integer i = dateStatisticsMapper.getTotal(map);
        i = i==null?0:i;
        return i;
    }
}

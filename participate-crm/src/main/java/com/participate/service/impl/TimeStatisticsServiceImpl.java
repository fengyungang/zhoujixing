package com.participate.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.TimeStatisticsMapper;
import com.participate.entity.TimeStatisticsModel;
import com.participate.service.TimeStatisticsService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TimeStatisticsServiceImpl implements TimeStatisticsService {
    @Autowired
    private TimeStatisticsMapper timeStatisticsMapper;
    /**
     * 添加方法
     * @param timeStatisticsModel
     * @return
     */
    @Override
    public int add(TimeStatisticsModel timeStatisticsModel) {
        return timeStatisticsMapper.add(timeStatisticsModel);
    }

    /**
     * 根据id查询一条信息
     * @param time_statistics_id
     * @return
     */
    @Override
    public TimeStatisticsModel getById(Integer time_statistics_id) {
        return timeStatisticsMapper.getById(time_statistics_id);
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
        List<TimeStatisticsModel> timeStatisticsModelList = timeStatisticsMapper.selA(map);
        PageInfo<TimeStatisticsModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("timeStatisticsModelList",timeStatisticsModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<TimeStatisticsModel> selA(Map<String,Object> map){
        return timeStatisticsMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param timeStatisticsModel
     * @return
     */
    @Override
    public int update(TimeStatisticsModel timeStatisticsModel) {
        return timeStatisticsMapper.update(timeStatisticsModel);
    }

    /**
     * -根据id删除客户信息（物理删除）
     * @param time_statistics_id
     * @return
     */
    @Override
    public int delById(Integer time_statistics_id) {
        return timeStatisticsMapper.delById(time_statistics_id);
    }

    @Override
    public Integer getCodeTotal(Map<String, Object> map) {
        Integer i = timeStatisticsMapper.getCodeTotal(map);
        i = i==null?0:i;
        return i;
    }

    @Override
    public Integer getTotal(Map<String, Object> map) {

        Integer i = timeStatisticsMapper.getTotal(map);
        i = i==null?0:i;
        return i;

    }
}

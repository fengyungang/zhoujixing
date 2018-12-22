package com.zhoujixing.service;

import com.zhoujixing.entity.TimeStatisticsModel;

import java.util.List;
import java.util.Map;

public interface TimeStatisticsService {
    /**
     * 添加方法
     * @param timeStatisticsModel
     * @return
     */
    int add(TimeStatisticsModel timeStatisticsModel);

    /**
     * 根据id查询一条信息
     * @param time_statistics_id
     * @return
     */
    TimeStatisticsModel getById(Integer time_statistics_id);

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    List<TimeStatisticsModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param timeStatisticsModel
     * @return
     */
    int update(TimeStatisticsModel timeStatisticsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param time_statistics_id
     * @return
     */
    int delById(Integer time_statistics_id);

    /**
     * 查询某个code数量
     * @param map
     * @return
     */
    Integer getCodeTotal(Map<String,Object> map);

    /**
     * 查询总数量
     * @param map
     * @return
     */
    Integer getTotal(Map<String,Object> map);
}

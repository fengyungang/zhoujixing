package com.zhoujixing.dao;

import com.zhoujixing.entity.DateStatisticsModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface DateStatisticsMapper {
    /**
     * 添加方法
     * @param dateStatisticsModel
     * @return
     */
    int add(DateStatisticsModel dateStatisticsModel);

    /**
     * 根据id查询一条信息
     * @param date_statistics_id
     * @return
     */
    DateStatisticsModel getById(Integer date_statistics_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<DateStatisticsModel> selA(Map<String,Object> map);
    /**
     * 根据id修改某条信息
     * @param dateStatisticsModel
     * @return
     */
    int update(DateStatisticsModel dateStatisticsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param date_statistics_id
     * @return
     */
    int delById(Integer date_statistics_id);

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

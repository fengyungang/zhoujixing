package com.zhoujixing.mapper;


import com.zhoujixing.entity.CooperateEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CooperateMapper {
    /**
     * 添加方法
     * @param cooperateEntity
     * @return
     */
    int add(CooperateEntity cooperateEntity);

    /**
     * 根据id查询一条信息
     * @param cooperate_id
     * @return
     */
    CooperateEntity getById(Integer cooperate_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<CooperateEntity> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param cooperateEntity
     * @return
     */
    int update(CooperateEntity cooperateEntity);

    /**
     * 根据id删除一条信息
     * @param cooperate_id
     * @return
     */
    int delById(Integer cooperate_id);
}

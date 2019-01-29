package com.zhoujixing.mapper;


import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.GoodEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface GoodMapper {
    /**
     * 添加方法
     * @param goodEntity
     * @return
     */
    int add(GoodEntity goodEntity);

    /**
     * 根据id查询一条信息
     * @param good_id
     * @return
     */
    GoodEntity getById(Integer good_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<GoodEntity> selA(Map<String, Object> map);

    /**
     * 根据id删除一条信息（物理删除）
     * @param good_id
     * @return
     */
    int delById(Integer good_id);
}

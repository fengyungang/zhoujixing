package com.zhoujixing.mapper;


import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.NewsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {
    /**
     * 添加方法
     * @param commentEntity
     * @return
     */
    int add(CommentEntity commentEntity);

    /**
     * 根据id查询一条信息
     * @param comment_id
     * @return
     */
    CommentEntity getById(Integer comment_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<CommentEntity> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param commentEntity
     * @return
     */
    int update(CommentEntity commentEntity);

    /**
     * 根据id删除一条信息（物理删除）
     * @param comment_id
     * @return
     */
    int delById(Integer comment_id);
}

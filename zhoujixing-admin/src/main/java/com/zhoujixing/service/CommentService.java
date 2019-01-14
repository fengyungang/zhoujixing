package com.zhoujixing.service;


import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.NewsEntity;

import java.util.Map;


public interface CommentService {
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
     * 查询所有信息（支持分页）
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    Map<String,Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize);
    /**
     * 根据id修改某条信息
     * @param commentEntity
     * @return
     */
    int update(CommentEntity commentEntity);

    /**
     * 根据id删除一条信息
     * @param comment_id
     * @return
     */
    int delById(Integer comment_id);
}

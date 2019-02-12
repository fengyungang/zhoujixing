package com.zhoujixing.service;

import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CategoryModel;
import com.zhoujixing.entity.CommentModel;

import java.util.List;
import java.util.Map;

public interface CommentService {
    /**
     * 添加方法
     * @param commentModel
     * @return
     */
    int add(CommentModel commentModel);

    /**
     * 根据id查询一条信息
     * @param shop_comment_id
     * @return
     */
    CommentModel getById(Integer shop_comment_id);

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
    List<CommentModel> selA(Map<String, Object> map);

    /**
     * 根据id修改某条信息
     * @param commentModel
     * @return
     */
    int update(CommentModel commentModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_comment_id
     * @return
     */
    int delById(Integer shop_comment_id);

}

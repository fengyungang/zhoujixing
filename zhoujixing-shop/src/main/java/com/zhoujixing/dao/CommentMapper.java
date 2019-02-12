package com.zhoujixing.dao;

import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.CommentModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface CommentMapper {
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

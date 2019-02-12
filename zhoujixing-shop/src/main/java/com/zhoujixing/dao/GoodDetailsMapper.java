package com.zhoujixing.dao;

import com.zhoujixing.entity.CartModel;
import com.zhoujixing.entity.GoodDetailsModel;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface GoodDetailsMapper {
    /**
     * 添加方法
     * @param goodDetailsModel
     * @return
     */
    int add(GoodDetailsModel goodDetailsModel);

    /**
     * 根据id查询一条信息
     * @param shop_good_details_id
     * @return
     */
    GoodDetailsModel getById(Integer shop_good_details_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<GoodDetailsModel> selA(Map<String, Object> map);
    /**
     * 根据id修改某条信息
     * @param goodDetailsModel
     * @return
     */
    int update(GoodDetailsModel goodDetailsModel);

    /**
     * -根据id删除客户信息（物理删除）
     * @param shop_good_details_id
     * @return
     */
    int delById(Integer shop_good_details_id);

}

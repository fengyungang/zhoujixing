package com.zhoujixing.service;


import com.zhoujixing.entity.CooperateEntity;
import com.zhoujixing.entity.NewsEntity;

import java.util.Map;


public interface NewsService {
    /**
     * 添加方法
     * @param newsEntity
     * @return
     */
    int add(NewsEntity newsEntity);

    /**
     * 根据id查询一条信息
     * @param news_id
     * @return
     */
    NewsEntity getById(Integer news_id);

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
     * @param newsEntity
     * @return
     */
    int update(NewsEntity newsEntity);

    /**
     * 根据id删除一条信息
     * @param news_id
     * @return
     */
    int delById(Integer news_id);

    /**
     * 根据id每次浏览文章，增加浏览量
     * @param news_id
     * @return
     */

    int addBrowse(Integer news_id);
    /**
     * 根据id，增加点赞次数
     * @param news_id
     * @return
     */
    int addGood(Integer news_id);
}

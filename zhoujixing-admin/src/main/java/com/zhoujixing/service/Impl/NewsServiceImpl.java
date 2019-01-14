package com.zhoujixing.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.entity.CooperateEntity;
import com.zhoujixing.entity.NewsEntity;
import com.zhoujixing.mapper.CooperateMapper;
import com.zhoujixing.mapper.NewsMapper;
import com.zhoujixing.service.CooperateService;
import com.zhoujixing.service.NewsService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    /**
     * 添加方法
     * @param newsEntity
     * @return
     */
    @Override
    public int add(NewsEntity newsEntity) {
        newsEntity.setNews_del("0");
        newsEntity.setNews_browse(0);
        newsEntity.setNews_good(0);
        return newsMapper.add(newsEntity);
    }

    /**
     * 根据id查询一条信息
     * @param news_id
     * @return
     */
    @Override
    public NewsEntity getById(Integer news_id) {
        return newsMapper.getById(news_id);
    }

    /**
     * 查询所有信息
     * @param map
     * @param pageIndex
     * @param pageSize
     * @return
     */
    @Override
    public Map<String, Object> selA(Map<String, Object> map, Integer pageIndex, Integer pageSize) {
        PageHelper.startPage(pageIndex,pageSize);
        List<NewsEntity> newsEntityList = newsMapper.selA(map);
        PageInfo<NewsEntity> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();

        map.put("newsEntityList",newsEntityList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 根据id修改某条信息
     * @param newsEntity
     * @return
     */
    @Override
    public int update(NewsEntity newsEntity) {
        return newsMapper.update(newsEntity);
    }

    /**
     * 根据id删除一条信息（物理删除）
     * @param news_id
     * @return
     */
    @Override
    public int delById(Integer news_id) {
        return newsMapper.delById(news_id);
    }

    /**
     * 根据id每次浏览文章，增加浏览量
     * @param news_id
     * @return
     */
    @Override
    public int addBrowse(Integer news_id) {
        return newsMapper.addBrowse(news_id);
    }

    /**
     * 根据id，增加点赞次数
     * @param news_id
     * @return
     */
    @Override
    public int addGood(Integer news_id) {
        return newsMapper.addGood(news_id);
    }
}

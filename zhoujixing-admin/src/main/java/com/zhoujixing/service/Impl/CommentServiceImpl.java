package com.zhoujixing.service.Impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.entity.CommentEntity;
import com.zhoujixing.entity.NewsEntity;
import com.zhoujixing.mapper.CommentMapper;
import com.zhoujixing.mapper.NewsMapper;
import com.zhoujixing.service.CommentService;
import com.zhoujixing.service.NewsService;
import com.zhoujixing.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    /**
     * 添加方法
     * @param commentEntity
     * @return
     */
    @Override
    public int add(CommentEntity commentEntity) {
        commentEntity.setComment_del("0");
        return commentMapper.add(commentEntity);
    }

    /**
     * 根据id查询一条信息
     * @param comment_id
     * @return
     */
    @Override
    public CommentEntity getById(Integer comment_id) {
        return commentMapper.getById(comment_id);
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
        List<CommentEntity> commentEntityList = commentMapper.selA(map);
        PageInfo<CommentEntity> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();

        map.put("commentEntityList",commentEntityList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 根据id修改某条信息
     * @param commentEntity
     * @return
     */
    @Override
    public int update(CommentEntity commentEntity) {
        return commentMapper.update(commentEntity);
    }

    /**
     * 根据id删除一条信息（物理删除）
     * @param comment_id
     * @return
     */
    @Override
    public int delById(Integer comment_id) {
        return commentMapper.delById(comment_id);
    }
}

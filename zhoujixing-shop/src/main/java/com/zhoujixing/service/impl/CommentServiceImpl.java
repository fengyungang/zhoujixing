package com.zhoujixing.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhoujixing.dao.CollectMapper;
import com.zhoujixing.dao.CommentMapper;
import com.zhoujixing.entity.CollectModel;
import com.zhoujixing.entity.CommentModel;
import com.zhoujixing.service.CollectService;
import com.zhoujixing.service.CommentService;
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
     * @param commentModel
     * @return
     */
    @Override
    public int add(CommentModel commentModel) {
        return commentMapper.add(commentModel);
    }

    /**
     * 根据id查询一条信息
     * @param shop_comment_id
     * @return
     */
    @Override
    public CommentModel getById(Integer shop_comment_id) {
        return commentMapper.getById(shop_comment_id);
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
        Page page = PageHelper.startPage(pageIndex,pageSize);
        List<CommentModel> commentModelList = commentMapper.selA(map);
        PageInfo<CommentModel> pageInfo = new PageInfo<>(page.getResult());
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("commentModelList",commentModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    @Override
    public List<CommentModel> selA(Map<String, Object> map) {
        return commentMapper.selA(map);
    }

    /**
     * 根据id修改某条信息
     * @param commentModel
     * @return
     */
    @Override
    public int update(CommentModel commentModel) {
        return commentMapper.update(commentModel);
    }

    /**
     * 根据id删除客户信息（物理删除）
     * @param shop_comment_id
     * @return
     */
    @Override
    public int delById(Integer shop_comment_id) {
        return commentMapper.delById(shop_comment_id);
    }
}

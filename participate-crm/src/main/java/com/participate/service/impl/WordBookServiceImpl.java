package com.participate.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.participate.dao.WordBookMapper;
import com.participate.entity.WordBookModel;
import com.participate.service.WordBookService;
import com.participate.utils.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class WordBookServiceImpl implements WordBookService {
    @Autowired
    private WordBookMapper wordBookMapper;

    /**
     * 添加方法
     * @param wordBookModel
     * @return
     */
    @Override
    public int add(WordBookModel wordBookModel) {
        return wordBookMapper.add(wordBookModel);
    }

    /**
     * 根据id查询一条信息
     * @param id
     * @return
     */
    @Override
    public WordBookModel getById(Integer id) {
        return wordBookMapper.getById(id);
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
        List<WordBookModel> wordBookModelList = wordBookMapper.selA(map);
        PageInfo<WordBookModel> pageInfo = new PageInfo<>();
        Long num = pageInfo.getTotal();

        // 获取分页情况，一共多少页，一页多少数据
        PageBean pageBean = new PageBean(pageIndex,num.intValue(),pageSize);
        pageBean.init();
        //清空map
        map.clear();
        map.put("wordBookModelList",wordBookModelList);
        map.put("pageBean",pageBean);
        return map;
    }

    /**
     * 查询所有信息（不支持分页）
     * @param map
     * @return
     */
    public List<WordBookModel> selA(Map<String, Object> map){
        return wordBookMapper.selA(map);
    }
    /**
     *  根据id修改某条信息
     * @param wordBookModel
     * @return
     */
    @Override
    public int update(WordBookModel wordBookModel) {
        return wordBookMapper.update(wordBookModel);
    }

    /**
     * 根据id删除销售人员信息（物理删除）
     * @param word_book_id
     * @return
     */
    @Override
    public int delById(Integer word_book_id) {
        return wordBookMapper.delById(word_book_id);
    }

    @Override
    public WordBookModel getByCode(Integer word_book_code) {
        return wordBookMapper.getByCode(word_book_code);
    }

    @Override
    public List<WordBookModel> getCode(Map<String,Object> map){
        return wordBookMapper.getCode(map);
    }
}

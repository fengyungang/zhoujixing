package com.participate.dao;

import com.participate.entity.SalesmanModel;
import com.participate.entity.WordBookModel;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface WordBookMapper {
    /**
     * 添加方法
     * @param wordBookModel
     * @return
     */
    int add(WordBookModel wordBookModel);

    /**
     * 根据id查询一条信息
     * @param word_book_id
     * @return
     */
    WordBookModel getById(Integer word_book_id);

    /**
     * 查询所有信息
     * @param map
     * @return
     */
    List<WordBookModel> selA(Map<String,Object> map);

    /**
     * 根据id修改某条信息
     * @param wordBookModel
     * @return
     */
    int update(WordBookModel wordBookModel);

    /**
     * 根据id删除字典表信息（物理删除）
     * @param word_book_id
     * @return
     */
    int delById(Integer word_book_id);

    /**
     * 查询字典信息根据编码
     * @param word_book_code
     * @return
     */
    WordBookModel getByCode(Integer word_book_code);

    /**
     * 查询字典的code
     * @param map
     * @return
     */
    List<WordBookModel> getCode(Map<String,Object> map);
}

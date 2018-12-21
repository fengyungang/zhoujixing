package com.participate.entity;

import lombok.Data;

import java.util.Date;

/**
 * 字典表
 * WordBook的model，对应word_book表
 */
@Data
public class WordBookModel {
    private Integer word_book_id;//字典表主键id
    //未联系0，很不满意、不满意、一般、满意和很满意1-5
    private Integer word_book_code;//字典表编码标识
    private String word_book_name;//字典表名称/值
    private String word_book_type;//字典表类型
    private String word_book_state;//字典表状态
    private Date word_book_create_time;//创建时间
}

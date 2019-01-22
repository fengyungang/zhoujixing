package com.zhoujixing.entity;

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

    public Integer getWord_book_id() {
        return word_book_id;
    }

    public void setWord_book_id(Integer word_book_id) {
        this.word_book_id = word_book_id;
    }

    public Integer getWord_book_code() {
        return word_book_code;
    }

    public void setWord_book_code(Integer word_book_code) {
        this.word_book_code = word_book_code;
    }

    public String getWord_book_name() {
        return word_book_name;
    }

    public void setWord_book_name(String word_book_name) {
        this.word_book_name = word_book_name;
    }

    public String getWord_book_type() {
        return word_book_type;
    }

    public void setWord_book_type(String word_book_type) {
        this.word_book_type = word_book_type;
    }

    public String getWord_book_state() {
        return word_book_state;
    }

    public void setWord_book_state(String word_book_state) {
        this.word_book_state = word_book_state;
    }

    public Date getWord_book_create_time() {
        return word_book_create_time;
    }

    public void setWord_book_create_time(Date word_book_create_time) {
        this.word_book_create_time = word_book_create_time;
    }
}

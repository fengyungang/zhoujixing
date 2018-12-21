package com.participate.entity;

import lombok.Data;

import java.util.Date;
/**
 * 统计日期表
 * DateStatistics的model，对应date_statistics表
 */
@Data
public class DateStatisticsModel {
    private Integer date_statistics_id;//统计日期表主键
    private Integer word_book_code;//关联字典表的code标识码
    private Integer date_statistics_bars;//条数
    private Date date_statistics_time;//时间
}

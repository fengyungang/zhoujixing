package com.participate.entity;

import lombok.Data;

import java.util.Date;
/**
 * 统计时间表
 * TimeStatistics的model，对应time_statistics表
 */
@Data
public class TimeStatisticsModel {
    private Integer time_statistics_id;//统计时间表主键
    private Integer word_book_code;//关联字典表的code标识码
    private Integer time_statistics_bars;//条数
    private Date time_statistics_time;//时间
}

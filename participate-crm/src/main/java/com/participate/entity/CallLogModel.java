package com.participate.entity;

import lombok.Data;

import java.util.Date;

/**
 * 通话记录信息表
 * CallLog的model，对应call_log表
 */
@Data
public class CallLogModel {
    private Integer call_log_id;//通话记录信息表主键id
    private Integer customer_id;//客户表id（关联外键）
    private Integer salesman_id;//销售人员id（关联外键）
    private String call_log_content;//联系内容
    private String call_log_customer_feedback;//客户反馈
    private Date call_log_create_time;//创建时间
    private Date call_log_contact_time;//联系时间

}

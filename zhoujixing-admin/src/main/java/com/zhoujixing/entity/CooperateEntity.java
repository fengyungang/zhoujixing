package com.zhoujixing.entity;

import lombok.Data;

import java.util.Date;

/**
 * 合作申请表
 * Cooperate的model，对应cooperate表
 */
@Data
public class CooperateEntity {
    private Integer cooperate_id;//合作申请表主键id
    private String cooperate_corporate_name;//公司名称
    private String cooperate_subsector;//从属行业
    private String cooperate_province;//所属省份
    private String cooperate_city;//所属城市
    private String cooperate_area;//所属区县
    private String cooperate_linkman;//联系人
    private String cooperate_phone;//联系电话
    private String cooperate_qq;//QQ号码
    private Integer cooperate_state;//状态（0未读，1是已读）
    private Date cooperate_create_time;//创建时间


}

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

    public Integer getCooperate_id() {
        return cooperate_id;
    }

    public void setCooperate_id(Integer cooperate_id) {
        this.cooperate_id = cooperate_id;
    }

    public String getCooperate_corporate_name() {
        return cooperate_corporate_name;
    }

    public void setCooperate_corporate_name(String cooperate_corporate_name) {
        this.cooperate_corporate_name = cooperate_corporate_name;
    }

    public String getCooperate_subsector() {
        return cooperate_subsector;
    }

    public void setCooperate_subsector(String cooperate_subsector) {
        this.cooperate_subsector = cooperate_subsector;
    }

    public String getCooperate_province() {
        return cooperate_province;
    }

    public void setCooperate_province(String cooperate_province) {
        this.cooperate_province = cooperate_province;
    }

    public String getCooperate_city() {
        return cooperate_city;
    }

    public void setCooperate_city(String cooperate_city) {
        this.cooperate_city = cooperate_city;
    }

    public String getCooperate_area() {
        return cooperate_area;
    }

    public void setCooperate_area(String cooperate_area) {
        this.cooperate_area = cooperate_area;
    }

    public String getCooperate_linkman() {
        return cooperate_linkman;
    }

    public void setCooperate_linkman(String cooperate_linkman) {
        this.cooperate_linkman = cooperate_linkman;
    }

    public String getCooperate_phone() {
        return cooperate_phone;
    }

    public void setCooperate_phone(String cooperate_phone) {
        this.cooperate_phone = cooperate_phone;
    }

    public String getCooperate_qq() {
        return cooperate_qq;
    }

    public void setCooperate_qq(String cooperate_qq) {
        this.cooperate_qq = cooperate_qq;
    }

    public Integer getCooperate_state() {
        return cooperate_state;
    }

    public void setCooperate_state(Integer cooperate_state) {
        this.cooperate_state = cooperate_state;
    }

    public Date getCooperate_create_time() {
        return cooperate_create_time;
    }

    public void setCooperate_create_time(Date cooperate_create_time) {
        this.cooperate_create_time = cooperate_create_time;
    }
}

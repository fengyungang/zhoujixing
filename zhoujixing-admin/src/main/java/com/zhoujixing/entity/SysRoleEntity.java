package com.zhoujixing.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 角色表
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2018-11-07 14:56:28
 */
public class SysRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	private Long id;
	/**
	 * 角色名称
	 */
	private String name;
	/**
	 * 角色描述
	 */
	private String discription;
	/**
	 * 角色状态(0：无效；1：有效)
	 */
	private Integer state;
	/**
	 * 是否超级管理员
	 */
	private Integer rootflag;
	/**
	 * 创建人ID
	 */
	private Long creatorid;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 角色权限
	 */
	private String options;
	/**
	 * 所属站点
	 */
	private Long fromsite;
	/**
	 * 所属平台
	 */
	private String platform;

	/**
	 * 设置：自增主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：自增主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：角色名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：角色名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：角色描述
	 */
	public void setDiscription(String discription) {
		this.discription = discription;
	}
	/**
	 * 获取：角色描述
	 */
	public String getDiscription() {
		return discription;
	}
	/**
	 * 设置：角色状态(0：无效；1：有效)
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：角色状态(0：无效；1：有效)
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：是否超级管理员
	 */
	public void setRootflag(Integer rootflag) {
		this.rootflag = rootflag;
	}
	/**
	 * 获取：是否超级管理员
	 */
	public Integer getRootflag() {
		return rootflag;
	}
	/**
	 * 设置：创建人ID
	 */
	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}
	/**
	 * 获取：创建人ID
	 */
	public Long getCreatorid() {
		return creatorid;
	}
	/**
	 * 设置：创建时间
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建时间
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：角色权限
	 */
	public void setOptions(String options) {
		this.options = options;
	}
	/**
	 * 获取：角色权限
	 */
	public String getOptions() {
		return options;
	}
	/**
	 * 设置：所属站点
	 */
	public void setFromsite(Long fromsite) {
		this.fromsite = fromsite;
	}
	/**
	 * 获取：所属站点
	 */
	public Long getFromsite() {
		return fromsite;
	}
	/**
	 * 设置：所属平台
	 */
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	/**
	 * 获取：所属平台
	 */
	public String getPlatform() {
		return platform;
	}
}

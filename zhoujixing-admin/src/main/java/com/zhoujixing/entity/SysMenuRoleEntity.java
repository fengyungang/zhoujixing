package com.zhoujixing.entity;


import java.io.Serializable;

/**
 * 菜单角色关系表
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2018-11-07 14:56:28
 */
public class SysMenuRoleEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	private Long id;
	/**
	 * 角色ID
	 */
	private Long roleid;
	/**
	 * 菜单ID
	 */
	private Long menuid;

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
	 * 设置：角色ID
	 */
	public void setRoleid(Long roleid) {
		this.roleid = roleid;
	}
	/**
	 * 获取：角色ID
	 */
	public Long getRoleid() {
		return roleid;
	}
	/**
	 * 设置：菜单ID
	 */
	public void setMenuid(Long menuid) {
		this.menuid = menuid;
	}
	/**
	 * 获取：菜单ID
	 */
	public Long getMenuid() {
		return menuid;
	}
}

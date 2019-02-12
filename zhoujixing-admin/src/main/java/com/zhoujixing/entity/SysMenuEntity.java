package com.zhoujixing.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 功能菜单表
 * 
 * @author MIT
 * @email
 * @date 2018-11-07 14:56:28
 */
public class SysMenuEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 自增主键
	 */
	private Long id;
	/**
	 * 父级ID
	 */
	private String parentid;
	/**
	 * 菜单名称
	 */
	private String menuname;
	/**
	 * 排序
	 */
	private Integer ordernum;
	/**
	 * 功能地址
	 */
	private String url;
	/**
	 * 功能图标
	 */
	private String icon;
	/**
	 * 自定义属性
	 */
	private String attributes;
	/**
	 * 权限代码
	 */
	private String actions;
	/**
	 * 所属平台
	 */
	private String platform;
	/**
	 * 创建日期
	 */
	private Date createtime;
	/**
	 * 创建人
	 */
	private Long creatorid;
	/**
	 * 状态(1:可用，0：禁用)
	 */
	private Integer state;
	/**
	 * 0：菜单；1：按钮
	 */
	private Integer menutype;

	/**
	 * 查询子菜单的集合
	 */
	private List<?> list;

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
	 * 设置：父级ID
	 */
	public void setParentid(String parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：父级ID
	 */
	public String getParentid() {
		return parentid;
	}
	/**
	 * 设置：菜单名称
	 */
	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	/**
	 * 获取：菜单名称
	 */
	public String getMenuname() {
		return menuname;
	}
	/**
	 * 设置：排序
	 */
	public void setOrdernum(Integer ordernum) {
		this.ordernum = ordernum;
	}
	/**
	 * 获取：排序
	 */
	public Integer getOrdernum() {
		return ordernum;
	}
	/**
	 * 设置：功能地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：功能地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：功能图标
	 */
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/**
	 * 获取：功能图标
	 */
	public String getIcon() {
		return icon;
	}
	/**
	 * 设置：自定义属性
	 */
	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}
	/**
	 * 获取：自定义属性
	 */
	public String getAttributes() {
		return attributes;
	}
	/**
	 * 设置：权限代码
	 */
	public void setActions(String actions) {
		this.actions = actions;
	}
	/**
	 * 获取：权限代码
	 */
	public String getActions() {
		return actions;
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
	/**
	 * 设置：创建日期
	 */
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	/**
	 * 获取：创建日期
	 */
	public Date getCreatetime() {
		return createtime;
	}
	/**
	 * 设置：创建人
	 */
	public void setCreatorid(Long creatorid) {
		this.creatorid = creatorid;
	}
	/**
	 * 获取：创建人
	 */
	public Long getCreatorid() {
		return creatorid;
	}
	/**
	 * 设置：状态(1:可用，0：禁用)
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：状态(1:可用，0：禁用)
	 */
	public Integer getState() {
		return state;
	}
	/**
	 * 设置：0：菜单；1：按钮
	 */
	public void setMenutype(Integer menutype) {
		this.menutype = menutype;
	}
	/**
	 * 获取：0：菜单；1：按钮
	 */
	public Integer getMenutype() {
		return menutype;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
}

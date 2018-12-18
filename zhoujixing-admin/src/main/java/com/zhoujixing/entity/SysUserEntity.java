package com.zhoujixing.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 后台管理用户表
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2018-11-07 14:56:28
 */
public class SysUserEntity implements Serializable {
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
	 * 用户账号
	 */
	private String loginname;
	/**
	 * 用户密码(MD5加密长32位)
	 */
	private String loginpass;
	/**
	 * 真实姓名
	 */
	private String realname;
	/**
	 * 创建时间
	 */
	private Date createtime;
	/**
	 * 性别（0：女；1：男；2：保密）
	 */
	private Integer sex;
	/**
	 * 所属省份
	 */
	private String province;
	/**
	 * 所属城市
	 */
	private String city;
	/**
	 * 所属区县
	 */
	private String area;
	/**
	 * 所属企业
	 */
	private Long companyid;
	/**
	 * 电子邮箱
	 */
	private String email;
	/**
	 * 登录次数
	 */
	private Long logincount;
	/**
	 * 最后登录IP
	 */
	private String lastloginip;
	/**
	 * 最后登录时间
	 */
	private Date lastlogintime;
	/**
	 * 最后登录地址
	 */
	private String lastloginaddr;
	/**
	 * 备注
	 */
	private String remark;
	/**
	 * 用户状态（0：不可用；1：可用；2：已禁用；-1：已删除）
	 */
	private Integer state;

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
	 * 设置：用户账号
	 */
	public void setLoginname(String loginname) {
		this.loginname = loginname;
	}
	/**
	 * 获取：用户账号
	 */
	public String getLoginname() {
		return loginname;
	}
	/**
	 * 设置：用户密码(MD5加密长32位)
	 */
	public void setLoginpass(String loginpass) {
		this.loginpass = loginpass;
	}
	/**
	 * 获取：用户密码(MD5加密长32位)
	 */
	public String getLoginpass() {
		return loginpass;
	}
	/**
	 * 设置：真实姓名
	 */
	public void setRealname(String realname) {
		this.realname = realname;
	}
	/**
	 * 获取：真实姓名
	 */
	public String getRealname() {
		return realname;
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
	 * 设置：性别（0：女；1：男；2：保密）
	 */
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	/**
	 * 获取：性别（0：女；1：男；2：保密）
	 */
	public Integer getSex() {
		return sex;
	}
	/**
	 * 设置：所属省份
	 */
	public void setProvince(String province) {
		this.province = province;
	}
	/**
	 * 获取：所属省份
	 */
	public String getProvince() {
		return province;
	}
	/**
	 * 设置：所属城市
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * 获取：所属城市
	 */
	public String getCity() {
		return city;
	}
	/**
	 * 设置：所属区县
	 */
	public void setArea(String area) {
		this.area = area;
	}
	/**
	 * 获取：所属区县
	 */
	public String getArea() {
		return area;
	}
	/**
	 * 设置：所属企业
	 */
	public void setCompanyid(Long companyid) {
		this.companyid = companyid;
	}
	/**
	 * 获取：所属企业
	 */
	public Long getCompanyid() {
		return companyid;
	}
	/**
	 * 设置：电子邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * 获取：电子邮箱
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * 设置：登录次数
	 */
	public void setLogincount(Long logincount) {
		this.logincount = logincount;
	}
	/**
	 * 获取：登录次数
	 */
	public Long getLogincount() {
		return logincount;
	}
	/**
	 * 设置：最后登录IP
	 */
	public void setLastloginip(String lastloginip) {
		this.lastloginip = lastloginip;
	}
	/**
	 * 获取：最后登录IP
	 */
	public String getLastloginip() {
		return lastloginip;
	}
	/**
	 * 设置：最后登录时间
	 */
	public void setLastlogintime(Date lastlogintime) {
		this.lastlogintime = lastlogintime;
	}
	/**
	 * 获取：最后登录时间
	 */
	public Date getLastlogintime() {
		return lastlogintime;
	}
	/**
	 * 设置：最后登录地址
	 */
	public void setLastloginaddr(String lastloginaddr) {
		this.lastloginaddr = lastloginaddr;
	}
	/**
	 * 获取：最后登录地址
	 */
	public String getLastloginaddr() {
		return lastloginaddr;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 设置：用户状态（0：不可用；1：可用；2：已禁用；-1：已删除）
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：用户状态（0：不可用；1：可用；2：已禁用；-1：已删除）
	 */
	public Integer getState() {
		return state;
	}
}

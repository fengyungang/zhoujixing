package com.zhoujixing.entity;


import java.io.Serializable;
import java.util.Date;

/**
 * 全国行政区域代码表
 * 
 * @author MIT
 * @email framework@gmail.com
 * @date 2018-12-21 11:25:21
 */
public class SysCityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 省市区名称
	 */
	private String name;
	/**
	 * 上级ID
	 */
	private Long parentid;
	/**
	 * 
	 */
	private String xpath;
	/**
	 * 简称
	 */
	private String shortname;
	/**
	 * 级别:0,中国；1，省分；2，市；3，区、县
	 */
	private Integer leveltype;
	/**
	 * 城市代码
	 */
	private String citycode;
	/**
	 * 邮编
	 */
	private String zipcode;
	/**
	 * 经度
	 */
	private Float lon;
	/**
	 * 纬度
	 */
	private Float lat;
	/**
	 * 拼音
	 */
	private String pinyin;
	/**
	 * 
	 */
	private Integer state;

	/**
	 * 设置：主键
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 获取：主键
	 */
	public Long getId() {
		return id;
	}
	/**
	 * 设置：省市区名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：省市区名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：上级ID
	 */
	public void setParentid(Long parentid) {
		this.parentid = parentid;
	}
	/**
	 * 获取：上级ID
	 */
	public Long getParentid() {
		return parentid;
	}
	/**
	 * 设置：
	 */
	public void setXpath(String xpath) {
		this.xpath = xpath;
	}
	/**
	 * 获取：
	 */
	public String getXpath() {
		return xpath;
	}
	/**
	 * 设置：简称
	 */
	public void setShortname(String shortname) {
		this.shortname = shortname;
	}
	/**
	 * 获取：简称
	 */
	public String getShortname() {
		return shortname;
	}
	/**
	 * 设置：级别:0,中国；1，省分；2，市；3，区、县
	 */
	public void setLeveltype(Integer leveltype) {
		this.leveltype = leveltype;
	}
	/**
	 * 获取：级别:0,中国；1，省分；2，市；3，区、县
	 */
	public Integer getLeveltype() {
		return leveltype;
	}
	/**
	 * 设置：城市代码
	 */
	public void setCitycode(String citycode) {
		this.citycode = citycode;
	}
	/**
	 * 获取：城市代码
	 */
	public String getCitycode() {
		return citycode;
	}
	/**
	 * 设置：邮编
	 */
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	/**
	 * 获取：邮编
	 */
	public String getZipcode() {
		return zipcode;
	}
	/**
	 * 设置：经度
	 */
	public void setLon(Float lon) {
		this.lon = lon;
	}
	/**
	 * 获取：经度
	 */
	public Float getLon() {
		return lon;
	}
	/**
	 * 设置：纬度
	 */
	public void setLat(Float lat) {
		this.lat = lat;
	}
	/**
	 * 获取：纬度
	 */
	public Float getLat() {
		return lat;
	}
	/**
	 * 设置：拼音
	 */
	public void setPinyin(String pinyin) {
		this.pinyin = pinyin;
	}
	/**
	 * 获取：拼音
	 */
	public String getPinyin() {
		return pinyin;
	}
	/**
	 * 设置：
	 */
	public void setState(Integer state) {
		this.state = state;
	}
	/**
	 * 获取：
	 */
	public Integer getState() {
		return state;
	}
}

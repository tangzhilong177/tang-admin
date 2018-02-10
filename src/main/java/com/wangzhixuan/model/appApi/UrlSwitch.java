package com.wangzhixuan.model.appApi;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * Url开关
 *
 */
@TableName("url_switch")
public class UrlSwitch implements Serializable{
	
	@TableField(exist = false)
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 */
	@TableId(type = IdType.AUTO)
	private Long id;
	
	/**
	 * 标题
	 */
	@TableField(value = "app_name")
	private String appName;
	
	/**
	 * App
	 */
	@TableField(value = "app_id")
	private Integer appId;
	
	/**
	 * 可用时Url
	 */
	@TableField(value = "url")
	private String url;
	
	public Long getId() {
		return id;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public Integer getAppId() {
		return appId;
	}

	public void setAppId(Integer appId) {
		this.appId = appId;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public void setId(Long id) {
		this.id = id;
	}

}

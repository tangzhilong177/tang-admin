package com.wangzhixuan.model.appApi;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 资讯
 */
public class News implements Serializable{
	
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
	@TableField(value = "title")
	private String title;
	
	/**
	 * Logo
	 */
	@TableField(value = "logo")
	private String logo;
	
	/**
	 * 内容
	 */
	@TableField(value = "content")
	private String content;
	
	/**
	 * Url
	 */
	@TableField(value = "url")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}

package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 首页视频轮播实体类
 * @author yangyuhao
 */
@Table(name="INDEX_SHOW")
@Entity
public class IndexShow {
	
	//首页轮播图id
	private Integer id;
	//轮播图标题
	private String title;
	//轮播图链接地址
	private String src;
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="SRC")
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
}

package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 弹幕实体类
 * @author yangyuhao
 */
@Table(name="DANMU")
@Entity
public class Danmu {
	
	//弹幕id
	private Integer id;
	//弹幕内容
	private String text;
	//弹幕颜色
	private String color;
	//弹幕尺寸: 0-小; 1-中; 2-大
	private Integer size;
	//弹幕显示位置: 0-滚动; 1-顶部固定; 2-底部固定;
	private Integer position;
	//在视频中出现的时间点,单位为100ms
	private Integer time;
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="TEXT")
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	@Column(name="COLOR")
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
	@Column(name="SIZE")
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	
	@Column(name="POSITION")
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	
	@Column(name="TIME")
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
}

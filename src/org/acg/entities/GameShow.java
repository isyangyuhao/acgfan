package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 游戏页面轮播图实体类
 * @author yangyuhao
 */
@Table(name="GAME_SHOW")
@Entity
public class GameShow {

	//游戏轮播图id
	private Integer id;
	//游戏图片链接
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
	
	@Column(name="SRC")
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
}

package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 推荐游戏实体类
 * @author yangyuhao
 */
@Table(name="GAME_INTRODUCE")
@Entity
public class GameIntroduce {

	//推荐游戏id
	private Integer id;
	//游戏名
	private String name;
	//游戏类型: 1-新游推荐; 2-热门推荐; 3-网游推荐;
	private Integer typeId;
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAME")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="TYPE_ID")
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

}

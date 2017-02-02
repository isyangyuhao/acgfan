package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 友情链接实体类
 * @author yangyuhao
 */
@Table(name="FRIEND_LINK")
@Entity
public class FriendLink {
	
	//友情链接id
	private Integer id;
	//链接名
	private String name;
	//链接地址
	private String src;
	
	public FriendLink() {
		
	}
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="NAME", nullable=false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="SRC", nullable=false)
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}

}

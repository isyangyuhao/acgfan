package org.acg.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 画板实体类
 * @author yangyuhao
 */
@Table(name="PALETTE")
@Entity
public class Palette {
	
	//画板id
	private Integer id;
	//画板名称
	private String name;
	//点赞数
	private int well;
	
	//画板对应图像链接
	private String src;
	@Column(name="SRC")
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	//画板发布时间
	private Date createTime;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME")
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	//映射Palette与User单向多对一关联关系
	//发布用户
	@JsonIgnore
	private User user;
	//外键列名为USER_ID
	@JoinColumn(name="USER_ID")
	@ManyToOne
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	//映射Palette与User双向多对多关联关系,由Palette维护关联关系
	//点赞的用户集合
	@JsonIgnore
	private Set<User> users;
	/*
	 * 存放双向多对多关联关系的外检表名为PALETTE_USER
	 * 外键列PALETTE_ID对应Video的id属性
	 * 外键列USER_ID对应User的id属性
	 */
	@JoinTable(name="PALETTE_USER",
	joinColumns={@JoinColumn(name="PALETTE_ID", referencedColumnName="ID")},
		inverseJoinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")})
	@ManyToMany(fetch=FetchType.EAGER)
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	//映射Palette与PaletteType双向多对一关联关系,由Palette维护关联关系
	//画板类别
	@JsonIgnore
	private PaletteType paletteType;
	//外键列名为PALETTE_TYPE
	@JoinColumn(name="PALETTE_TYPE")
	@ManyToOne(fetch=FetchType.EAGER)
	public PaletteType getPaletteType() {
		return paletteType;
	}
	public void setPaletteType(PaletteType paletteType) {
		this.paletteType = paletteType;
	}
	
	public Palette() {
		
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
	
	@Column(name="WELL", nullable=true)
	public int getWell() {
		return well;
	}
	public void setWell(int well) {
		this.well = well;
	}
	
}

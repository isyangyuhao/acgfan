package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 管理员实体类
 * @author yangyuhao
 */
@Table(name="ADMIN")
@Entity
public class Admin {
	
	//管理员id
	private Integer id;
	//管理员名称
	private String name;
	//管理员密码
	private String password;
	
	//管理员任务
	private String work;
	@Column(name="WORK")
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	
	//映射Admin和Role双向多对一关联关系,由Admin维护关联关系
	@JsonIgnore
	private Role role;
	@JoinColumn(name="ROLE_ID")
	@ManyToOne(fetch=FetchType.EAGER)
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public Admin() {
		
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
	
	@Column(name="PASSWORD", nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}

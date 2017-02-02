package org.acg.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * 管理员权限实体类
 * @author yangyuhao
 */
@Table(name="PERMISSION")
@Entity
public class Permission {
	
	//权限id
	private Integer id;
	//权限名
	private String permissionName;
	
	//映射Permission和Role双向关联关系
	private Set<Role> roles;
	@ManyToMany(mappedBy="permissions", fetch=FetchType.EAGER)
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
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
	
	@Column(name="PERMISSION_NAME")
	public String getPermissionName() {
		return permissionName;
	}
	public void setPermissionName(String permissionName) {
		this.permissionName = permissionName;
	}
	
}

package org.acg.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * 管理员角色实体类
 * @author yangyuhao
 */
@Table(name="ROLE")
@Entity
public class Role {

	//角色id
	private Integer id;
	//角色名
	private String roleName;
	
	//映射Role和Permission双向多对多关联关系
	private Set<Permission> permissions;
	@JoinTable(name="ROLE_PERMISSION",
	joinColumns={@JoinColumn(name="ROLE_ID", referencedColumnName="ID")},
	inverseJoinColumns={@JoinColumn(name="PERMISSION_ID", referencedColumnName="ID")})
	@ManyToMany(fetch=FetchType.EAGER)
	public Set<Permission> getPermissions() {
		return permissions;
	}
	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
	
	//映射Role和Admin双向一对多关联关系,由Admin维护关联关系
	private Set<Admin> admins;
	@OneToMany(mappedBy="role", fetch=FetchType.EAGER)
	public Set<Admin> getAdmins() {
		return admins;
	}
	public void setAdmins(Set<Admin> admins) {
		this.admins = admins;
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
	
	@Column(name="ROLE_NAME")
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
		
}

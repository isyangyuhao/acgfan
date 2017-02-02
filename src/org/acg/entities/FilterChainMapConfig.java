package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 权限验证过滤器配置实体类
 * @author yangyuhao
 */
@Table(name="FILTER_MAP_CONFIG")
@Entity
public class FilterChainMapConfig {
	
	//验证配置id
	private Integer id;
	//验证的url地址
	private String url;
	//验证的权限和角色
	private String role;
	
	@Column(name="ID")
	@GeneratedValue
	@Id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="URL")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="ROLE")
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
}

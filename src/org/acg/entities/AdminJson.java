package org.acg.entities;

/**
 * Description : 管理员生成json实体类
 * @author yangyuhao
 */
public class AdminJson {
	
	private Integer id;
	private String name;
	private String role;
	private String work;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	
}

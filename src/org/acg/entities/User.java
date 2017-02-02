package org.acg.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 用户实体类
 * @author yangyuhao
 */
@Table(name="USER")
@Entity
public class User {
	
	//用户id
	private Integer id;
	//用户名
	private String username;
	@JsonIgnore
	//用户密码
	private String password;
	//用户个性签名
	private String introduce;
	//用户性别 : m->男 / f->女
	private String sex;
	//用户出生日期
	private Date birth;
	//用户注册时间
	private Date createTime;
	//用户硬币数
	private int dollar;
	//用户头像
	private String icon;
	
	//映射User与Video双向多对多关联关系，由Video维护关联关系
	//用户收藏的视频集合
	@JsonIgnore
	private Set<Video> videos;
	//映射到Video类中的users属性
	@ManyToMany(mappedBy="users", fetch=FetchType.EAGER)
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	
	//映射User与Indent双向一对多关联关系,由Indent维护关联关系
	//用户订单的集合
	@JsonIgnore
	private Set<Indent> indents = new HashSet<>();
	//映射到Indent中的user属性
	@OneToMany(mappedBy="user")
	public Set<Indent> getIndents() {
		return indents;
	}
	public void setIndents(Set<Indent> indents) {
		this.indents = indents;
	}
	
	//映射User与Palette双向多对多关联关系,由Palette维护关联关系
	//点赞的画板集合
	@JsonIgnore
	private Set<Palette> palettes = new HashSet<>();
	//映射到Palette类中的users属性
	@ManyToMany(mappedBy="users")
	public Set<Palette> getPalettes() {
		return palettes;
	}
	public void setPalettes(Set<Palette> palettes) {
		this.palettes = palettes;
	}
	
	public User() {
		
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
	
	@Column(name="USERNAME", nullable=false)
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name="PASSWORD", nullable=false)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Column(name="INTRODUCE", nullable=true)
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	@Column(name="SEX", nullable=true)
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="BIRTH", nullable=true)
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME", nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	@Column(name="DOLLAR", nullable=false)
	public int getDollar() {
		return dollar;
	}
	public void setDollar(int dollar) {
		this.dollar = dollar;
	}
	
	@Column(name="ICON", nullable=true)
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	
}

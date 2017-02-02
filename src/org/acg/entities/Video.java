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
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 视频实体类
 * @author yangyuhao
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@Table(name="VIDEO")
@Entity
public class Video {
	
	//视频id
	private Integer id;
	//视频名
	private String name;
	//视频图片地址
	private String src;
	//视频发布时间
	private Date createTime;
	//视频硬币数
	private int dollar;
	
	//视频播放连接地址
	private String avSrc;
	@Column(name="AV_SRC")
	public String getAvSrc() {
		return avSrc;
	}
	public void setAvSrc(String avSrc) {
		this.avSrc = avSrc;
	}
	
	//映射Video与VideoType双向多对一关联关系,由Video维护关联关系
	//视频类型
	private VideoType videoType;
	//外键列名为VIDEO_TYPE
	@JoinColumn(name="VIDEO_TYPE")
	@ManyToOne
	public VideoType getVideoType() {
		return videoType;
	}
	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}
	
	//映射Video与User双向多对多关联关系,由Video维护关联关系
	//收藏该视频的用户集合
	private Set<User> users = new HashSet<>();
	/*
	 * 存放双向多对多关联关系的外检表名为VIDEO_USER
	 * 外键列VIDEO_ID对应Video的id属性
	 * 外键列USER_ID对应User的id属性
	 */
	@JsonIgnore
	@JoinTable(name="VIDEO_USER",
	joinColumns={@JoinColumn(name="VIDEO_ID", referencedColumnName="ID")},
		inverseJoinColumns={@JoinColumn(name="USER_ID", referencedColumnName="ID")})
	@ManyToMany
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	//映射Video与VideoComment双项一对多关联关系
	private Set<VideoComment> videoComments;
	//VideoComment的外键列名为VIDEO_ID
	@JsonIgnore
	@JoinColumn(name="VIDEO_ID")
	@OneToMany(fetch=FetchType.EAGER)
	public Set<VideoComment> getVideoComments() {
		return videoComments;
	}
	public void setVideoComments(Set<VideoComment> videoComments) {
		this.videoComments = videoComments;
	}
	
	//映射Video与Danmu单项一对多关联关系
	private Set<Danmu> danmus;
	//Danmu的外键列名为VIDEO_ID
	@JsonIgnore
	@JoinColumn(name="VIDEO_ID")
	@OneToMany(fetch=FetchType.EAGER)
	public Set<Danmu> getDanmus() {
		return danmus;
	}
	public void setDanmus(Set<Danmu> danmus) {
		this.danmus = danmus;
	}
	
	public Video() {
		
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
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME", nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name="DOLOAR", nullable=true)
	public int getDollar() {
		return dollar;
	}
	public void setDollar(int dollar) {
		this.dollar = dollar;
	}
	
}

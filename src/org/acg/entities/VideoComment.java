package org.acg.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;

/**
 * 视频评论实体类
 * @author yangyuhao
 */
@Table(name="VIDEO_COMMENT")
@Entity
public class VideoComment {
	
	//视频评论id
	private Integer id;
	//评论内容
	private String content;
	//创建时间
	private Date createTime;
	
	//映射VideoComment与User单项多对一关联关系,由Video维护关联关系
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
	
	public VideoComment() {
		
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
	
	@Column(name="CONTENT", nullable=false)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_TIME", nullable=false)
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}

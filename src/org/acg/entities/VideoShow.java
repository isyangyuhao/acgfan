package org.acg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

/**
 * 视频轮播实体类
 * @author yangyuhao
 */
@Table(name="VIDEO_SHOW")
@Entity
public class VideoShow {

	//视频轮播id
	private Integer id;
	//文字介绍
	private String title;
	
	//轮播图连接地址
	private String src;
	@Column(name="SRC")
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	
	//映射VideoShow与Video单项一对一关联关系
	private Video video;
	@JoinColumn(name="VIDEO_ID")
	@OneToOne
	public Video getVideo() {
		return video;
	}
	public void setVideo(Video video) {
		this.video = video;
	}
	
	//映射VideoShow与VideoType单项多对一关联关系
	//轮播视频类型
	private VideoType videoType;
	@JoinColumn(name="VIDEO_TYPE")
	@ManyToOne
	public VideoType getVideoType() {
		return videoType;
	}
	public void setVideoType(VideoType videoType) {
		this.videoType = videoType;
	}
	
	public VideoShow() {
		
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

	@Column(name="TITLE")
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}

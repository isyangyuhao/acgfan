package org.acg.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 视频类型实体类
 * @author yangyuhao
 */
@Table(name="VIDEO_TYPE")
@Entity
public class VideoType {
	
	//视频类型id
	private Integer id;
	//视频类型名
	private String typeName;
	
	//视频类型介绍
	private String typeIntroduce;
	@Column(name="TYPE_INTRODUCE")
	public String getTypeIntroduce() {
		return typeIntroduce;
	}
	public void setTypeIntroduce(String typeIntroduce) {
		this.typeIntroduce = typeIntroduce;
	}
	
	//映射VideoType与Video的双向一对多关联关系，由Video维护关联关系
	//该视频类型下的视频集合
	@JsonIgnore
	private Set<Video> videos = new HashSet<>();
	//映射到Video类中的videoType属性
	@OneToMany(mappedBy="videoType")
	public Set<Video> getVideos() {
		return videos;
	}
	public void setVideos(Set<Video> videos) {
		this.videos = videos;
	}
	
	public VideoType() {
		
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

	@Column(name="TYPE_NAME", nullable=false)
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

}

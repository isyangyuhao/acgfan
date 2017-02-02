package org.acg.action.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.acg.entities.Admin;
import org.acg.service.admin.BaseAdminService;
import org.acg.service.admin.VideoAdminService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Description : 后台管理视频控制器
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class VideoAdminAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private VideoAdminService videoAdminService;
	@Autowired
	private BaseAdminService baseAdminService;
	
	private Integer id;
	private String name;
	private String src;
	private String avSrc;
	private Integer videoType;
	
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
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public String getAvSrc() {
		return avSrc;
	}
	public void setAvSrc(String avSrc) {
		this.avSrc = avSrc;
	}
	public Integer getVideoType() {
		return videoType;
	}
	public void setVideoType(Integer videoType) {
		this.videoType = videoType;
	}
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private String title;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	private Map<String, Object> sessionMap;

	/**
	 * Url: video-videos-ajax <br>
	 * Desc: 获取全部视频信息
	 * @permission video
	 * @return [{id:1, name:xxx, src:xxx, createTime:xxx, dollar:0, avSrc:xxx, videoType:{id:1, typeName:xxx, typeIntroduce:xxx}}, {id:1, name:xxx, src:xxx, createTime:xxx, dollar:0, avSrc:xxx, videoType:{id:1, typeName:xxx, typeIntroduce:xxx}}, ... ]
	 */
	public String videosAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "video")) {					
					inputStream = new ByteArrayInputStream(videoAdminService.getAllVideoJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-addVideo-ajax <br>
	 * Desc: 添加新的视频，传入{name:xxx, src:xxx, acSrc:xxx, videoType:1}
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String addVideoAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.addVideo(name, src, avSrc, videoType);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-updateVideo-ajax <br>
	 * Desc: 更新指定视频信息，传入{id:1, name:xxx, src:xxx, avSrc:xxx, videoType:1}
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String updateVideoAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.updateVideo(id, name, src, avSrc, videoType);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-deleteVideo-ajax
	 * Desc: 删除视频，传入 id:1
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String deleteVideoAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.deleteVideo(id);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-indexShow-ajax <br>
	 * Desc: 获取全部首页轮播图
	 * @permission video
	 * @return [{id:1, title:xxx, src:xxx}, {id:2, title:xxx, src:xxx}, ... ]
	 */
	public String indexShowAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "video")) {					
					inputStream = new ByteArrayInputStream(videoAdminService.getAllIndexShowJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-updateIndexShow-ajax <br>
	 * Desc: 更新指定的首页轮播图，传入{id:1, title:xxx, src:xxx}
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String updateIndexShowAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.updateIndexShow(id, title, src);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-videoShow-ajax <br>
	 * Desc: 获取全部视频轮播图
	 * @permission video
	 * @return [{id:1, title:xxx, src:xxx, video:{...}, videoType:{id:1, typeName:xxx, typeIntroduce:xxx}}, ... ]
	 */
	public String videoShowAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "video")) {					
					inputStream = new ByteArrayInputStream(videoAdminService.getAllVideoShowJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-updateVideoShow-ajax <br>
	 * Desc: 更新指定的视频轮播图，传入{id:1, title:xxx, src:xxx, videoType:1}
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String updateVideoShowAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.updateVideoShow(1, title, src, videoType);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-videoComment-ajax <br>
	 * Desc: 获取全部视频评论
	 * @permission video
	 * @return [{id:1, content:xxx, createTime:xxx, user:{...}}, ... ]
	 */
	public String videoCommentAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if(baseAdminService.isPermission(admin, "video")) {					
					inputStream = new ByteArrayInputStream(videoAdminService.getAllVideoCommentJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-deleteVideoComment-ajax <br>
	 * Desc: 删除指定视频评论，传入{id=1}
	 * @permission video
	 * @return 1:成功; 0:失败
	 */
	public String deleteVideoCommentAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.deleteVideoComment(id);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: video-danmu-ajax <br>
	 * Desc: 获取全部弹幕
	 * @permission video
	 * @return [{id:1, text:xxx, color:#ffffff, size:1, position:0, time:1}, ... ]
	 */
	public String danmuAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "video")) {					
					inputStream = new ByteArrayInputStream(videoAdminService.getAllDanmuJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * 删除指定id弹幕
	 * @permission video
	 * @return
	 */
	public String deleteDanmuAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = videoAdminService.deleteDanmu(id);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}
	
}

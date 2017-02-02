package org.acg.action.main;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.acg.entities.Danmu;
import org.acg.entities.FriendLink;
import org.acg.entities.IndexShow;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoType;
import org.acg.service.main.AccountService;
import org.acg.service.main.IndexService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.Key;
import com.sun.accessibility.internal.resources.accessibility;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * Description : 视频主站控制器 <br>
 * 完成视频显示,分类,播放,评论,打赏等操作
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class IndexAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private AccountService accountService;
	
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private Integer typeId;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String content;
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	private Integer videoId;
	public Integer getVideoId() {
		return videoId;
	}
	public void setVideoId(Integer videoId) {
		this.videoId = videoId;
	}
	
	private String search;
	public String getSearch() {
		return search;
	}
	public void setSearch(String search) {
		this.search = search;
	}
	
	private String text;
	private String color;
	private Integer size;
	private Integer position;
	private Integer time;
	
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Integer getSize() {
		return size;
	}
	public void setSize(Integer size) {
		this.size = size;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public Integer getTime() {
		return time;
	}
	public void setTime(Integer time) {
		this.time = time;
	}
	
//=====================================
	
	/**
	 * 执行用户搜索
	 * @return index/search.jsp页面
	 */
	public String searchExecute() {
		System.out.println("* search key : " + search);
		ArrayList<Video> videos = indexService.search(search);
		requestMap.put("videos", videos);
		return "index-search";
	}
	
	/**
	 * 加载出主页需要显示的内容 <br>
	 * 加载页脚内容
	 */
	public String indexShow() {
		//获取全部的友情链接
		ArrayList<FriendLink> friendLinks = indexService.getAllFriendLink();
		sessionMap.put("friendLinks", friendLinks);
		//获取所有类型的视频数量
		int[] videoCount = new int[8];
		for (int i = 0; i < videoCount.length; ++i) {
			videoCount[i] = indexService.getVideoCounByType(i+1);
		}
		sessionMap.put("videoCount", videoCount);
		//获取所有视频类型
		ArrayList<VideoType> videoTypes = indexService.getAllVideoType();
		sessionMap.put("videoTypes", videoTypes);
		//获取全部的首页轮播图
		ArrayList<IndexShow> indexShows = indexService.getAllIndexShow();
		requestMap.put("indexShows", indexShows);
		//获取所有类型对应的视频
		for (int i = 0; i < videoCount.length; ++i) {
			String key = "videos" + (i+1);
			requestMap.put(key, indexService.getVideoByType(i+1));
		}
		//获取首页Bar图
		sessionMap.put("indexBar", indexService.getIndexBar());
		sessionMap.put("myselfBar", indexService.getMyselfBar());
		return "index-index";
	}
	
	/**
	 * 显示具体类别下的视频页面
	 * @return index/more.jsp页面
	 */
	public String moreShow() {
		//存放当前视频类型id
		requestMap.put("typeNow", typeId);
		//获取当前类型的轮播图
		requestMap.put("videoShows", indexService.getVideoShowByType(typeId));
		//获取当前类型的视频
		requestMap.put("videos", indexService.getVideoByType(typeId));
		return "index-more";
	}
	
	/**
	 * 显示播放视频内容页
	 * @return index/play.jsp
	 */
	public String playShow() {
		//获取视频
		Video video = indexService.getVideoById(id);
		//获取弹幕
		ArrayList<String> danmus = new ArrayList<>();
		Iterator<Danmu> iterator = video.getDanmus().iterator();
		while (iterator.hasNext()) {
			Danmu danmu = iterator.next();
			String text = danmu.getText();
			String color = danmu.getColor();
			int size = danmu.getSize();
			int position = danmu.getPosition();
			int time = danmu.getTime();
			String json = "{ text:'" + text + "', color:'" + color + "', size:" + size + ", position:" + position + ", time:" + time + "}";
			danmus.add(json);
		}
		requestMap.put("danmus", danmus);
		//获取当前需要播放的视频
		requestMap.put("video", video);
		return "index-play";
	}
	
	/**
	 * 通过ajax提交用户视频评论
	 * @return 1:提价成功; 0:提交失败
	 */
	public String commentAjax() {
		//获取需要评论的视频
		Video video = indexService.getVideoById(videoId);
		User user = (User) sessionMap.get("user");
		//提交评论
		boolean flag = indexService.insertVideoComment(content, user, video);
		//评论成功返回1
		if(flag) {
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
		} else {  //评论失败返回0
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
		return "index-ajax-comment";
	}
	
	/**
	 * 通过ajax将视频加入收藏
	 * @return 1:收藏成功; 0:收藏失败
	 */
	public String likeAjax() {
		User user = (User) sessionMap.get("user");
		boolean flag = indexService.addLikeVideo(videoId, user);
		sessionMap.remove("user");
		sessionMap.put("user", user);
		if (flag) {
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
		return "index-ajax-like";
	}
	
	/**
	 * 加入视频收藏
	 * @return index/collect.jsp
	 */
	public String likeExecute() {
		User user = (User) sessionMap.get("user");
		Integer userId = user.getId();
		boolean flag = indexService.addLikeVideo(videoId, user);
		sessionMap.remove("user");
		user = accountService.getUserById(userId);
		sessionMap.put("user", user);
		requestMap.put("videoCount", user.getVideos().size());
		return "account-collect";
	}
	
	/**
	 * 移除视频收藏
	 * @return index/collect.jsp
	 */
	public String removeExecute() {
		User user = (User) sessionMap.get("user");
		Integer userId = user.getId();
		indexService.removeLike(userId, videoId);
		sessionMap.remove("user");
		user = accountService.getUserById(userId);
		sessionMap.put("user", user);
		requestMap.put("videoCount", user.getVideos().size());
		return "account-collect";
	}
	
	/**
	 * 提交弹幕
	 * @return 1
	 */
	public String danmuAjax() {
		indexService.addDanmu(videoId, text, color, size, position, time);
		try {
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "index-ajax-danmu";
	}

//=====================================

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	
}

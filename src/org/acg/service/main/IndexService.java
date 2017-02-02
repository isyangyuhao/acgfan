package org.acg.service.main;

import java.util.ArrayList;

import org.acg.entities.Bar;
import org.acg.entities.FriendLink;
import org.acg.entities.IndexShow;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;

import net.sf.cglib.transform.impl.InterceptFieldFilter;

/**
 * Description : 视频主站业务逻辑接口层
 * @author yangyuhao
 */
public interface IndexService {
	
	/**
	 * 获取所有的友情链接
	 * @return friendLinks 友情链接集合
	 */
	public ArrayList<FriendLink> getAllFriendLink();
	
	/**
	 * 通过视频类型获取对应视频数
	 * @param typeId 视频类型id 
	 * @return sum 视频数量
	 */
	public int getVideoCounByType(Integer typeId);
	
	/**
	 * 获取全部的视频类型实体类
	 * @return videoTypes 视频类型实体类集合
	 */
	public ArrayList<VideoType> getAllVideoType();
	
	/**
	 * 获取全部首页轮播图
	 * @return indexShow 首页视频轮播图集合
	 */
	public ArrayList<IndexShow> getAllIndexShow();
	
	/**
	 * 通过类型id获取对应类型全部视频
	 * @param typeId 类型id
	 * @return videos 视频集合
	 */
	public ArrayList<Video> getVideoByType(Integer typeId);
	
	/**
	 * 通过视频类型id获取对应的视频轮播图
	 * @param typeId 视频类型id
	 * @return videoShows 视频轮播图集合
	 */
	public ArrayList<VideoShow> getVideoShowByType(Integer typeId);
	
	/**
	 * 通过视频id获取视频
	 * @param id 视频id
	 * @return video 视频实体类
	 */
	public Video getVideoById(Integer id);
	
	/**
	 * 保存视频评论
	 * @param content 评论内容
	 * @param user 评论用户
	 * @param video 评论视频
	 * @return true:插入成功; false:插入失败
	 */
	public boolean insertVideoComment(String content, User user, Video video);
	
	/**
	 * 用户添加收藏视频
	 * @param videoId 收藏的视频id
	 * @param user 收藏的用户
	 * @return true:添加成功; false:添加失败
	 */
	public boolean addLikeVideo(Integer videoId, User user);
	
	/**
	 * 用户取消视频收藏
	 * @param userId 用户id
	 * @param videoId 视频id
	 */
	public void removeLike(Integer userId, Integer videoId);
	
	/**
	 * 获取首页bar图
	 * @return 首页bar实体类
	 */
	public Bar getIndexBar();
	
	/**
	 * 获取个人中心bar图
	 * @return 个人中心bar实体类
	 */
	public Bar getMyselfBar();
	
	/**
	 * 搜索视频
	 * @param key 关键字
	 * @return videos 视频实体类集合
	 */
	public ArrayList<Video> search(String key);
	
	/**
	 * 添加弹幕
	 * @param videoId 视频id号
	 * @param text 弹幕内容
	 * @param color 弹幕颜色
	 * @param size 弹幕尺寸
	 * @param position 弹幕位置
	 * @param time 弹幕出现时间
	 */
	public void addDanmu(Integer videoId, String text, String color, Integer size, Integer position, Integer time);
	
}

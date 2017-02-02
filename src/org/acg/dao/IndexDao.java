package org.acg.dao;

import java.util.ArrayList;

import org.acg.entities.Bar;
import org.acg.entities.Danmu;
import org.acg.entities.FriendLink;
import org.acg.entities.IndexShow;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;

/**
 * Description : 视频主站数据访问接口层
 * @author yangyuhao
 */
public interface IndexDao {
	
	/**
	 * 获取所有友情链接
	 * @return friendLinks 友情链接集合
	 */
	public ArrayList<FriendLink> getAllFriendLink();
	
	/**
	 * 通过类别id号获取对应类型视频数
	 * @param typeId 类型id
	 * @return sum 对应类型视频数量
	 */
	public int getVideoCountByType(Integer typeId);
	
	/**
	 * 获取所有的视频类型实体类
	 * @return videoTypes 用户类型实体类集合
	 */
	public ArrayList<VideoType> getAllVideoType();
	
	/**
	 * 获取全部首页轮播图
	 * @return indexShows 首页轮播图集合
	 */
	public ArrayList<IndexShow> getAllIndexShow();
	
	/**
	 * 通过类别id获取对应类别所有视频实体类
	 * @param typeId 视频类型id
	 * @return videos 视频实体类集合
	 */
	public ArrayList<Video> getVideoByType(Integer typeId);
	
	/**
	 * 通过类型id获取对应类别的所有视频展示轮播图
	 * @param id 视频类型id
	 * @return videoShows 视频轮播图集合
	 */
	public ArrayList<VideoShow> getVideoShowByType(Integer typeId);
	
	/**
	 * 通过视频id获取对应视频实体类
	 * @param id 视频id
	 * @return video 视频实体类
	 */
	public Video getVideoById(Integer id);
	
	/**
	 * 插入一条新的用户评论实体类
	 * @param videoComment 用户评论实体类
	 */
	public void insertVideoComment(VideoComment videoComment, Video video);
	
	/**
	 * 更新用户实体类
	 * @param user 用户实体类
	 */
	public void updateUser(User user);
	
	/**
	 * 更新视频实体类
	 * @param video 视频实体类
	 */
	public void updateVideo(Video video);
	
	/**
	 * 删除video_user表数据
	 * @param userId 用户id
	 * @param videoId 视频id
	 */
	public void deleteVideoUser(Integer userId, Integer videoId);
	
	/**
	 * 获取全部的Bar图
	 * @return bars 实体类集合
	 */
	public ArrayList<Bar> getAllBar();
	
	/**
	 * 根据关键字获取视频实体类集合
	 * @param key 关键字
	 * @return videos 用户实体类集合
	 */
	public ArrayList<Video> getVideosByKey(String key);
	
	/**
	 * 插入一条新的弹幕
	 * @param danmu 弹幕实体类
	 */
	public void insertDanmu(Danmu danmu); 
}

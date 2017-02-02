package org.acg.dao;

import java.util.ArrayList;


import org.acg.entities.Admin;
import org.acg.entities.Danmu;
import org.acg.entities.FriendLink;
import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.Goods;
import org.acg.entities.IndexShow;
import org.acg.entities.Palette;
import org.acg.entities.Role;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;
import org.apache.coyote.http11.filters.VoidInputFilter;

/**
 * Description : 后台管理相关数据访问接口层
 * @author yangyuhao
 */
public interface AdminDao {
	
	/**
	 * 通过管理员名获取管理员实体类
	 * @param name 管理员用户名
	 * @return admin 管理员实体类
	 */
	public ArrayList<Admin> getAdminByName(String name);
		
	/**
	 * 更新视频类型实体类
	 * @param videoType 视频类型实体类
	 */
	public void updateVideoType(VideoType videoType);
	
	/**
	 * 通过视频类型id获取视频类型实体类
	 * @param id 视频类型id
	 * @return videoType 视频类型实体类
	 */
	public VideoType getVideoTypeById(Integer id);
	
	/**
	 * 更新友情链接实体类
	 */
	public void updateFriendLink(FriendLink friendLink);
	
	/**
	 * 通过id获取对应的友情链接实体类
	 * @param id
	 * @return
	 */
	public FriendLink getFriendLinkById(Integer id);
	
	/**
	 * 获取所有视频信息
	 * @return 视频信息的集合
	 */
	public ArrayList<Video> getAllVideo();
	
	/**
	 * 添加新的视频
	 * @param video
	 */
	public void insertVideo(Video video);
	
	/**
	 * 删除视频
	 * @param video
	 */
	public void deleteVideo(Video video);
	
	/**
	 * 更新首页轮播图
	 * @param indexShow
	 */
	public void updateIndexShow(IndexShow indexShow);
	
	/**
	 * 通过id获取对应的首页轮播图
	 * @param id
	 * @return
	 */
	public IndexShow getIndexShowById(Integer id);
	
	/**
	 * 获取所有视频轮播图
	 * @return
	 */
	public ArrayList<VideoShow> getAllVideoShow();
	
	/**
	 * 更新视频轮播图
	 * @param videoShow
	 */
	public void updateVideoShow(VideoShow videoShow);
	
	/**
	 * 通过id获取对应的视频轮播图
	 * @param id
	 * @return
	 */
	public VideoShow getVideoShowById(Integer id);
	
	/**
	 * 获取所有视频评论
	 * @return
	 */
	public ArrayList<VideoComment> getAllVideoComment();
	
	/**
	 * 删除指定视频评论
	 * @param videoComment
	 */
	public void deleteVideoComment(VideoComment videoComment);
	
	/**
	 * 通过id获取对应的视频评论
	 * @param id
	 * @return
	 */
	public VideoComment getVideoCommentById(Integer id);
	
	/**
	 * 获取所有视频弹幕
	 * @return
	 */
	public ArrayList<Danmu> getAllDanmu();
	
	/**
	 * 删除指定弹幕
	 * @param danmu
	 */
	public void deleteDanmu(Danmu danmu);
	
	/**
	 * 获取id对应的弹幕
	 * @param id
	 * @return
	 */
	public Danmu getDanmuById(Integer id);
	
	/**
	 * 添加新的商品信息
	 * @param goods
	 */
	public void insertGoods(Goods goods);
	
	/**
	 * 更新指定商品信息
	 * @param goods
	 */
	public void updateGoods(Goods goods);
	
	/**
	 * 获取id对应的商品
	 * @param id
	 */
	public Goods getGoodsById(Integer id);
	
	/**
	 * 删除指定商品信息
	 * @param goods
	 */
	public void deleteGoods(Goods goods);
	
	/**
	 * 获取所有推荐游戏
	 * @return
	 */
	public ArrayList<Game> getAllGame();
	
	/**
	 * 获取id对应的推荐游戏
	 * @param id
	 * @return
	 */
	public Game getGameById(Integer id);
	
	/**
	 * 更新指定的推荐游戏
	 * @param game
	 */
	public void updateGame(Game game);
	
	/**
	 * 获取所有游戏
	 * @return
	 */
	public ArrayList<GameIntroduce> getAllGameIntroduce();
	
	/**
	 * 更新指定的游戏
	 * @param gameIntroduce
	 */
	public void insertGameIntroduce(GameIntroduce gameIntroduce);
	
	/**
	 * 获取id所对应的游戏
	 * @param id
	 */
	public GameIntroduce getGameIntroduceById(Integer id);
	
	/**
	 * 更新指定游戏
	 * @param gameIntroduce
	 */
	public void updateGameIntroduce(GameIntroduce gameIntroduce);
	
	/**
	 * 删除指定游戏
	 * @param gameIntroduce
	 */
	public void deleteGameIntroduce(GameIntroduce gameIntroduce);
	
	/**
	 * 删除指定画板
	 * @param palette
	 */
	public void deletePalette(Palette palette);
	
	/**
	 * 获取所有管理员
	 * @return
	 */
	public ArrayList<Admin> getAllAdmin();
	
	/**
	 * 获取id所对应的管理员
	 * @param id
	 * @return
	 */
	public Admin getAdminById(Integer id);
	
	/**
	 * 更新指定的管理员信息
	 * @param admin
	 */
	public void updateAdmin(Admin admin);
	
	/**
	 * 更新指定管理员角色
	 * @param roleId
	 */
	public void updateAdminRole(Integer id, Role role);
	
	/**
	 * 获取roleId所对应的管理员角色
	 * @param roleId
	 * @return
	 */
	public Role getRoleById(Integer roleId);
	
	/**
	 * 删除指定id管理员
	 * @param id
	 */
	public void deleteAdmin(Admin admin);
}

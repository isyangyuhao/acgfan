package org.acg.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Description : 后台管理视频相关业务逻辑接口层
 * @author yangyuhao
 */
public interface VideoAdminService {
	
	/**
	 * 获取所有json格式的视频信息
	 * @return 
	 * @throws JsonProcessingException 
	 */
	public String getAllVideoJson() throws JsonProcessingException;
	
	/**
	 * 添加新的视频
	 * @param name
	 * @param src
	 * @param avSrc
	 * @param videoType
	 * @return
	 */
	public boolean addVideo(String name, String src, String avSrc, Integer videoType);
	
	/**
	 * 更新指定的视频实体类
	 * @param id
	 * @param name
	 * @param src
	 * @param avSrc
	 * @param videoType
	 * @return 1:成功; 0:失败
	 */
	public boolean updateVideo(Integer id, String name, String src, String avSrc, Integer videoType);
	
	/**
	 * 删除指定视频实体类
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deleteVideo(Integer id);
	
	/**
	 * 获取所有json格式的首页轮播图信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllIndexShowJson() throws JsonProcessingException;
	
	/**
	 * 更新指定的首页轮播图
	 * @param id
	 * @param title
	 * @param src
	 * @return 1:成功; 0:失败
	 */
	public boolean updateIndexShow(Integer id, String title, String src);
	
	/**
	 * 获取所有json格式的视频轮播图信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllVideoShowJson() throws JsonProcessingException;
	
	/**
	 * 更新指定的视频轮播图
	 * @param id
	 * @param title
	 * @param src
	 * @param videoType
	 * @return 1:成功; 0:失败
	 */
	public boolean updateVideoShow(Integer id, String title, String src, Integer videoType);
	
	/**
	 * 获取所有json格式的视频评论
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllVideoCommentJson() throws JsonProcessingException;
	
	/**
	 * 删除id对应的视频评论
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deleteVideoComment(Integer id);
	
	/**
	 * 获取所有json格式的弹幕
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllDanmuJson() throws JsonProcessingException;
	
	/**
	 * 删除id对应的弹幕
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deleteDanmu(Integer id);
}

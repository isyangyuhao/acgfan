package org.acg.service.admin;

import java.util.ArrayList;

import org.acg.dao.AdminDao;
import org.acg.entities.Admin;
import org.acg.entities.VideoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 后台管理相关主业务逻辑接口层
 * @author yangyuhao
 */
public interface BaseAdminService {

	/**
	 * 通过管理员名获取管理员实体类
	 * @param name 管理员名
	 * @return admin 管理员实体类
	 */
	public ArrayList<Admin> getAdminByName(String name);
	
	/**
	 * 获取全部的JSON格式的用户信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllUserJson() throws JsonProcessingException;
	
	/**
	 * 获取管理员JSON格式数据
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAdminJson(String name) throws JsonProcessingException;
	
	/**
	 * 获取json格式全部的视频类型
	 * @return json格式视频类型信息
	 * @throws JsonProcessingException 
	 */
	public String getAllVideoTypeJson() throws JsonProcessingException;
	
	/**
	 * 更新视频类型实体类
	 * @param id 视频类型id
	 * @param name 视频类型名
	 * @param introduce 视频类型介绍
	 * @return 1:更新成功; 0:更新失败
	 */
	public boolean updateVideoType(String id, String name, String introduce);
	
	/**
	 * 获取所有的json格式的友情链接
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllFriendLinkJson() throws JsonProcessingException;
	
	/**
	 * 更新指定的友情链接实体类
	 * @param id
	 * @param name
	 * @param src
	 * @return 1:成功; 0:失败
	 */
	public boolean updateFriendLink(Integer id, String name, String src);
	
	/**
	 * 判断当前管理员是否存在权限
	 * @param admin 管理员名
	 * @param permissionName 权限名
	 * @return true:有权限; false:没有权限
	 */
	public boolean isPermission(Admin admin, String permissionName);
		
}

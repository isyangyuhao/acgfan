package org.acg.service.admin.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.acg.dao.AccountDao;
import org.acg.dao.AdminDao;
import org.acg.dao.IndexDao;
import org.acg.dao.ShopDao;
import org.acg.entities.Admin;
import org.acg.entities.FriendLink;
import org.acg.entities.Permission;
import org.acg.entities.User;
import org.acg.entities.VideoType;
import org.acg.service.admin.BaseAdminService;
import org.apache.shiro.authc.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 后台管理相关主业务逻辑实现类
 * @author yangyuhao
 */
@Service
public class BaseAdminServiceImpl implements BaseAdminService {

	private ObjectMapper objectMapper;
	
	{
		objectMapper = new ObjectMapper();
	}
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private AccountDao accountDao;
	@Autowired
	private IndexDao indexDao;
	
	@Transactional
	@Override
	public ArrayList<Admin> getAdminByName(String name) {
		return adminDao.getAdminByName(name);
	}

	@Transactional
	@Override
	public String getAllUserJson() throws JsonProcessingException {
		ArrayList<User> users = accountDao.getAllUser();
		String result = objectMapper.writeValueAsString(users);
		return result;
	}


	@Transactional
	@Override
	public String getAdminJson(String name) throws JsonProcessingException {
		Admin admin = adminDao.getAdminByName(name).get(0);
		String adminJson = objectMapper.writeValueAsString(admin);
		return adminJson;
	}

	@Transactional
	@Override
	public String getAllVideoTypeJson() throws JsonProcessingException {
		ArrayList<VideoType> videoTypes = indexDao.getAllVideoType();
		String result = objectMapper.writeValueAsString(videoTypes);
		return result;
	}

	@Transactional
	@Override
	public boolean updateVideoType(String id, String name, String introduce) {
		if (id == null || name == null || introduce == null) {
			return false;
		}
		VideoType videoType = adminDao.getVideoTypeById(Integer.parseInt(id));
		videoType.setTypeName(name);
		videoType.setTypeIntroduce(introduce);
		adminDao.updateVideoType(videoType);
		return true;
	}

	@Transactional
	@Override
	public String getAllFriendLinkJson() throws JsonProcessingException {
		ArrayList<FriendLink> friendLinks = indexDao.getAllFriendLink();
		String json = "";
		json = objectMapper.writeValueAsString(friendLinks);
		return json;
	}

	@Transactional
	@Override
	public boolean updateFriendLink(Integer id, String name, String src) {
		if (id == null || name == null || src == null) {
			return false;
		}
		FriendLink friendLink = adminDao.getFriendLinkById(id);
		friendLink.setName(name);
		friendLink.setSrc(src);
		adminDao.updateFriendLink(friendLink);
		return true;
	}

	@Transactional
	@Override
	public boolean isPermission(Admin admin, String permissionName) {
		Set<Permission> permissions = admin.getRole().getPermissions();
		Iterator<Permission> iterator = permissions.iterator();
		while (iterator.hasNext()) {
			if (iterator.next().getPermissionName().equals(permissionName)) {
				return true;
			}
		}
		return false;
	}

}

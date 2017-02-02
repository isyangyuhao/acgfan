package org.acg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.acg.entities.Admin;
import org.acg.service.admin.BaseAdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.apple.eawt.Application;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * 后台管理主单元测试类
 * @author yangyuhao
 */
public class BaseAdminTest {

	private ApplicationContext applicationContext = null;
	private BaseAdminService baseAdminService = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		baseAdminService = applicationContext.getBean(BaseAdminService.class);
	}
	
	/**
	 * 测试通过管理员名获取管理员实体类
	 */
	@Test
	public void testGetAdminByName() {
		String name = "admin";
		ArrayList<Admin> admin = baseAdminService.getAdminByName(name);
		//打印测试数据
		System.out.println("* admin size : " + admin.size());
		System.out.println("* admin roleName : " + admin.get(0).getRole().getRoleName());
	}
	
	/**
	 * 获取全部的JSON格式的用户信息
	 */
	@Test
	public void testGetAllUserJson() {
		String json = "";
		try {
			json = baseAdminService.getAllUserJson();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//打印测试结果
		System.out.println("* users json : " + json);
	}
	
	/**
	 * 测试获取全部json格式视频类型信息
	 */
	@Test
	public void testGetAllVideoTypeJson() {
		String json = "";
		try {
			json = baseAdminService.getAllVideoTypeJson();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		//打印测试结果
		System.out.println("* videoTypes json : " + json);
	}
	
	/**
	 * 测试更新视频类型实体类
	 */
	@Test
	public void testUpdateVideoType() {
		baseAdminService.updateVideoType("1", "testTypeName", "testTypeIntroduce");
	}
	
	/**
	 * 测试获取全部的友情链接json
	 */
	@Test
	public void testGetAllFriendLinkJson() {
		String json = null;
		try {
			json = baseAdminService.getAllFriendLinkJson();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试更新友情链接实体类
	 */
	@Test
	public void testUpdateFriendLink() {
		baseAdminService.updateFriendLink(1, "哔哩哔哩动画111", "http://www.bilibili.com/");
	}

	/**
	 * 测试判断管理员是否存在对应权限
	 */
	@Test
	public void testAdminPermission() {
		Admin admin = baseAdminService.getAdminByName("admin").get(0);
		String permissionName = "shop";
		System.out.println(baseAdminService.isPermission(admin, permissionName));
	}
	
}

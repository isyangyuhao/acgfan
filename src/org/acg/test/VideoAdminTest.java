package org.acg.test;

import static org.junit.Assert.*;

import org.acg.service.admin.VideoAdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Description : 后台管理视频相关业务逻辑单元测试类
 * @author yangyuhao
 */
public class VideoAdminTest {

	private ApplicationContext applicationContext = null;
	private VideoAdminService videoAdminService = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		videoAdminService = applicationContext.getBean(VideoAdminService.class);
	}

	/**
	 * 测试获取全部视频信息json
	 */
	@Test
	public void testGetAllVideoJson(){
		String json = "";
		try {
			json = videoAdminService.getAllVideoJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试添加视频
	 */
	@Test
	public void testAddVideo(){
		videoAdminService.addVideo("testTitle", "testSrc", "testAcSrc", 1);
	}
	
	/**
	 * 测试更新视频实体类
	 */
	@Test
	public void testUpdateVideo(){
		videoAdminService.updateVideo(1, "爱丽丝兔耳的思念于夏天离去的你111", "photo/index/index_t1/av1.png", "aaa", 1);
	}
	
	/**
	 * 测试删除视频实体类
	 */
	@Test
	public void testDeleteVideo(){
		videoAdminService.deleteVideo(118);
	}
	
	/**
	 * 测试获取全部首页轮播图json
	 */
	@Test
	public void testGetAllIndexShowJson(){
		String json = "";
		try {
			json = videoAdminService.getAllIndexShowJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试更新指定首页轮播图
	 */
	@Test
	public void testUpdateIndexShow(){
		videoAdminService.updateIndexShow(1, "正版新番,动画修炼!xx 第7话111", "photo/index/index_show/show1-1.jpg");
	}
	
	/**
	 * 测试获取全部视频轮播图json
	 */
	@Test
	public void testGetAllVideoShowJson(){
		String json = "";
		try {
			json = videoAdminService.getAllVideoShowJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试更新指定视频轮播图
	 */
	@Test
	public void testUpdateVideoShowJson(){
		videoAdminService.updateVideoShow(1, "口水三国关羽篇111", "photo/index/index_show/show2-1.png", 1);
	}
	
	/**
	 * 测试获取全部视频评论json
	 */
	@Test
	public void testGetAllVideoComment(){
		String json = "";
		try {
			json = videoAdminService.getAllVideoCommentJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试删除指定视频评论
	 */
	@Test
	public void testDeleteVideoComment(){
		videoAdminService.deleteVideoComment(11);
	}
	
	/**
	 * 测试获取全部弹幕json
	 */
	@Test
	public void testGetAllDanmuJson(){
		String json = "";
		try {
			json = videoAdminService.getAllDanmuJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试删除指定弹幕
	 */
	@Test
	public void testDeleteDanmu(){
		videoAdminService.deleteDanmu(57);
	}
	
}

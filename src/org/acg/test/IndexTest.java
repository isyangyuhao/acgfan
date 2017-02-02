package org.acg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.acg.entities.Bar;
import org.acg.entities.FriendLink;
import org.acg.entities.IndexShow;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;
import org.acg.service.main.AccountService;
import org.acg.service.main.IndexService;
import org.apache.coyote.http11.filters.VoidInputFilter;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description : 测试视频主站业务逻辑
 * @author yangyuhao
 *
 */
public class IndexTest {

	ApplicationContext applicationContext = null;
	IndexService indexService = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		indexService = applicationContext.getBean(IndexService.class);
	}
	
	/**
	 * 测试获取全部友情连接
	 */
	@Test
	public void testGetAllFriendLink() {
		ArrayList<FriendLink> friendLinks = indexService.getAllFriendLink();
		//输出测试结果
		System.out.println("* friendLinks size : " + friendLinks.size());
		System.out.println("* friendLink1 name : " + friendLinks.get(1).getName());
	}
	
	/**
	 * 测试通过视频类型名获取视频数量
	 */
	@Test
	public void testGetVideoCountByType() {
		int typeId = 1;
		int sum = indexService.getVideoCounByType(typeId);
		//打印测试数据
		System.out.println("* type1 video sum : " + sum);
	}
	
	/**
	 * 测试获取全部的视频实体类
	 */
	@Test
	public void testGetAllVideoType() {
		ArrayList<VideoType> videoTypes = indexService.getAllVideoType();
		//打印测试数据
		System.out.println("* videoType count : " + videoTypes.size());
		System.out.println("* videoType1 name : " + videoTypes.get(0).getTypeName());
	}
	
	/**
	 * 测试获取全部首页轮播图实体类
	 */
	@Test
	public void testGetAllIndexShow() {
		ArrayList<IndexShow> indexShows = indexService.getAllIndexShow();
		//打印测试数据
		System.out.println("* indexShow count : " + indexShows.size());
		System.out.println("* indexSHow1 title : " + indexShows.get(0).getTitle());
	}
	
	/**
	 * 测试根据视频类型获取对应的视频实体类
	 */
	@Test
	public void testGetVideoByType() {
		int videoType = 6;
		ArrayList<Video> videos = indexService.getVideoByType(videoType);
		//打印测试数据
		System.out.println("* video count : " + videos.size());
		System.out.println("* video1 id : " + videos.get(0).getId());
	}
	
	/**
	 * 测试根据视频类型获取对应的视频轮播图实体类
	 */
	@Test
	public void testGetVideoShowByType() {
		int videoType = 1;
		ArrayList<VideoShow> videoShows = indexService.getVideoShowByType(videoType);
		//打印测试数据
		System.out.println("* videoShows count : " + videoShows.size());
		System.out.println("* videoShow1 title : " + videoShows.get(0).getTitle());
	}
	
	/**
	 * 测试通过视频id获取对应视频实体类
	 */
	@Test
	public void testGetVideoById() {
		Integer id = 10;
		Video video = indexService.getVideoById(id);
		//打印测试数据
		System.out.println("* video id : " + video.getId());
		System.out.println("* video name : " + video.getName());
	}
	
	/**
	 * 测试用户提交视频评论
	 */
	@Test
	public void testInsertVideoComment() {
		AccountService accountService = applicationContext.getBean(AccountService.class);
		String content = "小鬼子真不傻，金坷垃不能给他们";
		User user = accountService.getUserById(5);
		Video video = indexService.getVideoById(75);
		boolean flag = indexService.insertVideoComment(content, user, video);
		//打印测试数据
		System.out.println("* insert falg : " + flag);
	}
	
	/**
	 * 测试用户收藏视频
	 */
	@Test
	public void testAddVideoLike() {
		AccountService accountService = applicationContext.getBean(AccountService.class);
		User user = accountService.getUserById(1);
		Integer videoId = 11;
		boolean flag = indexService.addLikeVideo(videoId, user);
		//打印测试数据
		System.out.println("* username is " + user.getUsername());
		System.out.println("* flag is " + flag);
	}
	
	/**
	 * 测试用户移除视频
	 */
	@Test
	public void testRemoveVideoLike() {
		Integer userId = 1;
		Integer videoId = 5;
		indexService.removeLike(userId, videoId);
	}
	
	/**
	 * 测试获取首页bar实体类
	 */
	@Test
	public void testGetIndexBar() {
		Bar bar = indexService.getIndexBar();
		//打印测试数据
		System.out.println("* index bar src is " + bar.getSrc());
	}
	
	/**
	 * 测试视频搜索
	 */
	@Test
	public void testSearch() {
		String key = "的";
		ArrayList<Video> videos = indexService.search(key);
		//打印测试数据
		System.out.println("* search video count : " + videos.size());
	}
	
	/**
	 * 测试提交弹幕
	 */
	@Test
	public void testAddDanmu() {
		Integer videoId = 75;
		String text = "* 单元测试类测试...";
		String color = "red";
		int size = 1;
		int position = 1;
		int time = 40;
		indexService.addDanmu(videoId, text, color, size, position, time);
	}
	
}

package org.acg.test;

import static org.junit.Assert.*;

import org.acg.service.admin.OtherAdminService;
import org.acg.service.admin.VideoAdminService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Description : 后台管理其他相关业务逻辑单元测试类
 * @author yangyuhao
 */
public class OtherAdminTest {
	
	private ApplicationContext applicationContext = null;
	private OtherAdminService otherAdminService = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		otherAdminService = applicationContext.getBean(OtherAdminService.class);
	}
	
	/**
	 * 测试获取全部商品信息json
	 */
	@Test
	public void testGetAllGoodsJson(){
		String json = "";
		try {
			json = otherAdminService.getAllGoodsJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}

	/**
	 * 测试添加商品
	 */
	@Test
	public void testAddGoods(){
		otherAdminService.addGoods("蛤？", "苟利国家生死以", (double) 450, 450);
	}
	
	/**
	 * 测试更新商品
	 */
	@Test
	public void testUpdateGoods(){
		otherAdminService.updateGoods(13, "蛤？", "+1s", (double) 450, 2);
	}
	
	/**
	 * 测试删除商品
	 */
	@Test
	public void testDeleteGoods(){
		otherAdminService.deleteGoods(13);
	}
	
	/**
	 * 测试获取全部推荐游戏json
	 */
	@Test
	public void testGetAllGameJson(){
		String json = "";
		try {
			json = otherAdminService.getAllGameJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试更新推荐游戏
	 */
	@Test
	public void testUpdateGame(){
		otherAdminService.updateGame(3, "蛤", "苟利国家生死以", "岂因祸福避趋之");
	}
	
	/**
	 * 测试获取全部游戏json
	 */
	@Test
	public void testGetAllGameIntroduceJson(){
		String json = "";
		try {
			json = otherAdminService.getAllGameIntroduceJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试添加新游戏
	 */
	@Test
	public void testAddGameIntroduce(){
		otherAdminService.addGameIntroduce("蛤", 1);
	}
	
	/**
	 * 测试更新游戏
	 */
	@Test
	public void testUpdateGameIntroduce(){
		otherAdminService.updateGameIntroduce(42, "蛤？", 1);
	}
	
	/**
	 * 测试删除游戏
	 */
	@Test
	public void testDeleteGameIntroduce(){
		otherAdminService.deleteGameIntroduce(44);
	}
	
	/**
	 * 测试获取全部画板json
	 */
	@Test
	public void testGetAllPaletteJson(){
		String json = "";
		try {
			json = otherAdminService.getAllPaletteJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试删除画板
	 */
	@Test
	public void testDeletePalette(){
		otherAdminService.deletePalette(37);
	}
	
	/**
	 * 测试获取全部管理员json
	 */
	@Test
	public void testGetAllAdminJson(){
		String json = "";
		try {
			json = otherAdminService.getAllAdminJson();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(json);
	}
	
	/**
	 * 测试更新管理员角色
	 */
	@Test
	public void testUpdateAdminRole(){
		otherAdminService.updateAdminRole(2, 3);
	}
	
	/**
	 * 测试更新管理员任务
	 */
	@Test
	public void testUpdateAdminWork(){
		otherAdminService.updateAdminWork(2, "蛤？");
	}
}

package org.acg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.acg.entities.Goods;
import org.acg.entities.ShopShow;
import org.acg.service.main.ShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 周边商城单元测试类
 * @author lizhen
 */
public class ShopTest {

	private ApplicationContext applicationContext = null;
	private ShopService shopService;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		shopService = applicationContext.getBean(ShopService.class);
	}
	
	/**
	 * 测试获取全部的商品轮播图
	 */
	@Test
	public void testGetAllShopShow() {
		ArrayList<ShopShow> shopShows = shopService.getAllShopShow();
		//打印测试结果
		System.out.println("* shopShows size : " + shopShows.size());
	}
	
	/**
	 * 测试获取全部的商品信息
	 */
	@Test
	public void testGetAllGoods(){
		ArrayList<Goods> goods = shopService.getAllGoods();
		System.out.println("* goods size : " + goods.size());
	}
	
}

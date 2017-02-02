package org.acg.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.acg.entities.Game;
import org.acg.entities.GameShow;
import org.acg.service.main.GameService;
import org.acg.service.main.ShopService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description : 游戏相关单元测试类
 * @author lizhen
 *
 */
public class GameTest {
	
	private ApplicationContext applicationContext = null;
	private GameService gameService;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		gameService = (GameService) applicationContext.getBean(GameService.class);
	}
	
	
	/**
	 * 获取全部游戏的轮播图
	 */
	@Test
	public void testGetAllGameShow(){
		ArrayList<GameShow> gameShows = gameService.getAllGameShow();
		System.out.println("* gameShows size:" + gameShows.size());
		
	}
	
	/**
	 * 获取全部游戏信息
	 */
	@Test
	public void testGetAllGame(){
		ArrayList<Game> games = gameService.getAllGame();
		System.out.println("* games size : " + games.size());
	}


}

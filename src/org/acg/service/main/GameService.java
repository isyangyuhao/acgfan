package org.acg.service.main;

import java.util.ArrayList;

import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.GameShow;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * 游戏中心业务逻辑接口层
 * @author lizhen
 */
public interface GameService {
	/**
	 * 返回全部游戏轮播图
	 * @return 游戏轮播图实体类集合
	 */
	public ArrayList<GameShow> getAllGameShow();
	/**
	 * 返回全部游戏信息
	 * @return 游戏信息实体类集合
	 */
	public ArrayList<Game> getAllGame();
	/**
	 * 返回全部的游戏介绍名称
	 * @param id 类型名的id
	 * @return 游戏介绍名称实体类集合
	 */
	public ArrayList<GameIntroduce> getGameIntroduce(Integer id);

	
	
}

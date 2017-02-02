package org.acg.dao;

import java.util.ArrayList;

import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.GameShow;

/**
 * Description : 游戏中心数据访问接口层
 * @author lizhen
 */
public interface GameDao {
	
	/**
	 * 获取全部的游戏展示轮播图实体类
	 * @return 轮播图实体类集合
	 */
	public ArrayList<GameShow> getAllGameShow();
	/**
	 * 获取全部的游戏信息
	 * @return 游戏实体类集合
	 */
	public ArrayList<Game> getAllGame();
	
	/**
	 * 获取全部的游戏介绍名称
	 * @param id 类型名的id
	 * @return 游戏介绍名称实体类集合
	 */
	public ArrayList<GameIntroduce> getGameIntroduceByType(Integer id);
	
	
}

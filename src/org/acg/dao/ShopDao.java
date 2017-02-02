package org.acg.dao;

import java.util.ArrayList;

import org.acg.entities.Goods;
import org.acg.entities.ShopShow;

/**
 * 周边商城数据访问接口层
 * @author lizhen
 */
public interface ShopDao {

	/**
	 * 获取全部的商品展示轮播图实体类
	 * @return 轮播图实体类集合
	 */
	public ArrayList<ShopShow> getAllShopShow();
	/**
	 * 获取全部的商品信息
	 * @return 商品信息实体类集合
	 */
	public ArrayList<Goods> getAllGoods();
	
}

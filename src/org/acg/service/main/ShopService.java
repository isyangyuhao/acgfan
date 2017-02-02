package org.acg.service.main;

import java.util.ArrayList;

import org.acg.entities.Goods;
import org.acg.entities.ShopShow;

/**
 * Description : 周边商城业务逻辑接口层
 * @author lizhen
 */
public interface ShopService {
	
	/**
	 * 返回全部商品轮播图
	 * @return 商品轮播图实体类集合
	 */
	public ArrayList<ShopShow> getAllShopShow();
	/**
	 * 返回全部商品信息
	 * @return 商品信息实体类集合
	 */
	public ArrayList<Goods> getAllGoods();
	
	
}

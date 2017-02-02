package org.acg.service.main.impl;

import java.util.ArrayList;

import org.acg.dao.ShopDao;
import org.acg.entities.Goods;
import org.acg.entities.ShopShow;
import org.acg.service.main.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description : 周边商城业务逻辑实现类
 * @author lizhen
 */
@Service
public class ShopServiceImpl implements ShopService {
	
	@Autowired
	private ShopDao shopDao;
	
	//声明式事务
	@Transactional
	@Override
	public ArrayList<ShopShow> getAllShopShow() {
		return shopDao.getAllShopShow();
	}

	@Transactional
	@Override
	public ArrayList<Goods> getAllGoods() {
		return shopDao.getAllGoods();
	}
	
}

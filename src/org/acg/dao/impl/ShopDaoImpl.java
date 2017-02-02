package org.acg.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.ShopDao;
import org.acg.entities.Goods;
import org.acg.entities.ShopShow;
import org.springframework.stereotype.Repository;

/**
 * 周边商城数据访问实现类
 * @author lizhen
 */
@Repository
public class ShopDaoImpl implements ShopDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ArrayList<ShopShow> getAllShopShow() {
		String jpql = "from ShopShow";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<ShopShow> shopShows = (ArrayList<ShopShow>) query.getResultList();
		return shopShows;
	}

	@Override
	public ArrayList<Goods> getAllGoods() {
		String jpql = "from Goods";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Goods> goods = (ArrayList<Goods>) query.getResultList();
		return goods;
	}

	

	
}

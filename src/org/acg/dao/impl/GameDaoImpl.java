package org.acg.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.GameDao;
import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.GameShow;
import org.acg.entities.ShopShow;
import org.springframework.stereotype.Repository;

/**
 * 游戏中心数据访问实现类
 * @author lizhen
 */
@Repository
public class GameDaoImpl implements GameDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ArrayList<GameShow> getAllGameShow() {
		String jpql = "from GameShow";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<GameShow> gameShows = (ArrayList<GameShow>) query.getResultList();
		return gameShows;
	}

	@Override
	public ArrayList<Game> getAllGame() {
		String jpql = "from Game";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<Game> games = (ArrayList<Game>) query.getResultList();
		return games;
	}

	@Override
	public ArrayList<GameIntroduce> getGameIntroduceByType(Integer id) {
		String jpql = "from GameIntroduce where typeId = :typeId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("typeId", id);
		@SuppressWarnings("unchecked")
		ArrayList<GameIntroduce> gameIntroduces = (ArrayList<GameIntroduce>) query.getResultList();
		return gameIntroduces;
	}
	
}

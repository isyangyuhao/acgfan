package org.acg.service.main.impl;

import java.util.ArrayList;

import org.acg.dao.GameDao;
import org.acg.dao.IndexDao;
import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.GameShow;
import org.acg.service.main.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 游戏中心业务逻辑层
 * @author yangyuhao
 *
 */
@Service
public class GameServiceImpl implements GameService {

	@Autowired
	private GameDao gameDao;

	@Transactional
	@Override
	public ArrayList<GameShow> getAllGameShow() {
		return gameDao.getAllGameShow();
	}

	@Transactional
	@Override
	public ArrayList<Game> getAllGame() {
		return gameDao.getAllGame();
	}

	@Transactional
	@Override
	public ArrayList<GameIntroduce> getGameIntroduce(Integer id) {
		return gameDao.getGameIntroduceByType(id);
	}
	
}

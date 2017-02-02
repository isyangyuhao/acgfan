package org.acg.action.main;

import java.util.ArrayList;
import java.util.Map;

import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.GameShow;
import org.acg.service.main.GameService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * 游戏中心相关控制器
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class GameAction extends ActionSupport implements RequestAware, SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private GameService gameService;
	
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	
	/**
	 * 显示游戏中心页面
	 * @return game/game.jsp
	 */
	public String gameShow() {
		ArrayList<GameShow> gameShows = gameService.getAllGameShow();
		requestMap.put("gameShows", gameShows);
		
		ArrayList<Game> games = gameService.getAllGame();
		requestMap.put("games", games);
		
		requestMap.put("intro1", gameService.getGameIntroduce(1));
		requestMap.put("intro2", gameService.getGameIntroduce(2));
		requestMap.put("intro3", gameService.getGameIntroduce(3));
		requestMap.put("intro2size", gameService.getGameIntroduce(2).size());
		
		return "game-game";
	}
	
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}
	
	
	
}

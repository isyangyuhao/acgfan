package org.acg.action.main;

import java.util.ArrayList;
import java.util.Map;

import org.acg.entities.Goods;
import org.acg.entities.ShopShow;
import org.acg.service.main.ShopService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Description : 周边商城控制器 <br>
 * 完成物品展示,购买,结算等操作
 * @author lizhen
 */
@Scope("prototype")
@Controller
public class ShopAction implements SessionAware, RequestAware {
	
	@Autowired
	private ShopService shopService;
	
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	
	/**
	 * 商城主界面展示
	 * @return shop/shop.jsp页面
	 */
	public String shopShow() {
		ArrayList<ShopShow> shopShows = shopService.getAllShopShow();
		requestMap.put("shopShows", shopShows);
		
		ArrayList<Goods> goods = shopService.getAllGoods();
		requestMap.put("goods", goods);
		return "shop-shop";
	}
	
	/**
	 * 展示商品详细信息
	 * @return shop/detail.jsp页面;
	 */
	public String detailShow() {
		return "shop-detail";
	}

	@Override
	public void setRequest(Map<String, Object> arg0) {
		requestMap = arg0;
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}
	
}

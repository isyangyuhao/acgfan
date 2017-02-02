package org.acg.action.main;

import java.util.ArrayList;
import java.util.Map;

import org.acg.service.main.PaletteService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * Description : 画板模块相关请求控制器 <br>
 * 完成画板显示,评论,点赞等操作
 * @author lizhen
 */
@Scope("prototype")
@Controller
public class PaletteAction implements SessionAware, RequestAware {
	
	@Autowired
	private PaletteService paletteService;
	
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	
	private Integer typeId;
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	/**
	 * 画友主界面显示
	 * @return palette/palette.jsp
	 */
	public String paletteShow() {
		requestMap.put("paletteShows", paletteService.getAllPaletteShow());
		requestMap.put("paletteType", paletteService.getAllPaletteType());
		requestMap.put("palettes", paletteService.getAllPalette());
		requestMap.put("recommend", paletteService.getAllRecommend());
		//存放各个类型对应的画板实体类
		requestMap.put("prevalent", paletteService.getAllPaletteType().get(0).getPalettes());
		requestMap.put("hot", paletteService.getAllPaletteType().get(1).getPalettes());
		requestMap.put("good", paletteService.getAllPaletteType().get(2).getPalettes());
		return "palette-palette";
	}

	/**
	 * 显示画板详细内容
	 * @return palette/detail.jsp
	 */
	public String detailShow() {
		requestMap.put("palette", paletteService.getPaletteById(id));
		
		return "palette-detail";
	}
	
	/**
	 * 显示展示画板同一类别更多内容页面
	 * @return palette/more.jsp
	 */
	public String moreShow() {
		requestMap.put("paletteType", paletteService.getAllPaletteType().get(typeId-1));
		requestMap.put("palette", paletteService.getAllPaletteType().get(typeId-1).getPalettes());
		return "palette-more";
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

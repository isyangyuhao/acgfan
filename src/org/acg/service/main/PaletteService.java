package org.acg.service.main;

import java.util.ArrayList;

import org.acg.entities.Palette;
import org.acg.entities.PaletteShow;
import org.acg.entities.PaletteType;
import org.acg.entities.Recommend;

/**
 * Description : 画板业务逻辑接口层
 * @author lizhen
 */
public interface PaletteService {
	/**
	 * 返回全部的画板展示轮播图实体类
	 * @return 画板展示轮播图实体类集合
	 */
	public ArrayList<PaletteShow> getAllPaletteShow();
	/**
	 * 返回全部的画板类型实体类
	 * @return 画板类型实体类
	 */
	public ArrayList<PaletteType> getAllPaletteType();
	/**
	 * 返回全部的画板实体类
	 * @return 画板实体类
	 */
	public ArrayList<Palette> getAllPalette();
	/**
	 * 返回全部的推荐实体类
	 * @return 推荐实体类
	 */
	public ArrayList<Recommend> getAllRecommend();
	/**
	 * 通过id返回画板实体类
	 * @param id 画板实体类id
	 * @return 画板实体类
	 */
	public Palette getPaletteById(Integer id);

}

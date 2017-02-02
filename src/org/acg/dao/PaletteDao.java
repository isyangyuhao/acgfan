package org.acg.dao;

import java.util.ArrayList;

import org.acg.entities.Palette;
import org.acg.entities.PaletteShow;
import org.acg.entities.PaletteType;
import org.acg.entities.Recommend;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * Description : 画板数据访问层
 * @author lizhen
 */
public interface PaletteDao {
	/**
	 * 获取全部的画板展示轮播图实体类
	 * @return 画板轮播图实体类集合
	 */
	public ArrayList<PaletteShow> getAllPaletteShow();
	/**
	 * 获取全部的画板类型实体类
	 * @return 画板类型实体类
	 */
	public ArrayList<PaletteType> getAllPaletteType();
	/**
	 * 获取全部的画板实体类
	 * @return 画板实体类
	 */
	public ArrayList<Palette> getAllPalette();
	/**
	 * 获取全部的推荐实体类
	 * @return 推荐实体类
	 */
	public ArrayList<Recommend> getAllRecommend();
	/**
	 * 通过id获取画板实体类
	 * @param id 画板实体类id
	 * @return 画板实体类
	 */
	public Palette getPaletteById(Integer id);

}

package org.acg.service.admin;

import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Description : 后台管理其他相关业务逻辑接口层
 * @author yangyuhao
 */
public interface OtherAdminService {
	
	/**
	 * 获取所有json格式的商品信息
	 * @return
	 * @throws JsonProcessingException
	 */
	public String getAllGoodsJson() throws JsonProcessingException;
	
	/**
	 * 添加商品信息
	 * @param name
	 * @param photoDesc
	 * @param price
	 * @param stock
	 * @return 1:成功; 0:失败
	 */
	public boolean addGoods(String name, String photoDesc, Double price, Integer stock);
	
	/**
	 * 更新商品信息
	 * @param id
	 * @param name
	 * @param photoDesc
	 * @param price
	 * @param stock
	 * @return 1:成功; 2:失败
	 */
	public boolean updateGoods(Integer id, String name, String photoDesc, Double price, Integer stock);
	
	/**
	 * 删除商品信息
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deleteGoods(Integer id);
	
	/**
	 * 获取所有json格式的推荐游戏信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllGameJson() throws JsonProcessingException;
	
	/**
	 * 更新推荐游戏信息
	 * @param id
	 * @param name
	 * @param title
	 * @param src
	 * @return 1:成功; 0:失败
	 */
	public boolean updateGame(Integer id, String name, String title, String src);
	
	/**
	 * 获取所有json格式的游戏信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllGameIntroduceJson() throws JsonProcessingException;
	
	/**
	 * 添加新游戏
	 * @param name
	 * @param typeId
	 * @return 1:成功; 0:失败
	 */
	public boolean addGameIntroduce(String name, Integer typeId);
	
	/**
	 * 更新游戏
	 * @param id
	 * @param name
	 * @param typeId
	 * @return 1:成功; 0:失败
	 */
	public boolean updateGameIntroduce(Integer id, String name, Integer typeId);
	
	/**
	 * 删除游戏
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deleteGameIntroduce(Integer id);
	
	/**
	 * 获取所有json格式画板信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllPaletteJson() throws JsonProcessingException;
	
	/**
	 * 删除指定画板
	 * @param id
	 * @return 1:成功; 0:失败
	 */
	public boolean deletePalette(Integer id);
	
	/**
	 * 获取所有json格式管理员信息
	 * @return
	 * @throws JsonProcessingException 
	 */
	public String getAllAdminJson() throws JsonProcessingException;
	
	/**
	 * 更新指定管理员角色
	 * @param id
	 * @param role
	 * @return 1:成功; 0:失败
	 */
	public boolean updateAdminRole(Integer id, Integer roleId);
	
	/**
	 * 更新指定管理员任务
	 * @param id
	 * @param work
	 * @return 1:成功; 0:失败
	 */
	public boolean updateAdminWork(Integer id, String work);
	
	/**
	 * 添加管理员
	 * @param name
	 * @param password
	 * @param roleId
	 * @return
	 */
	public boolean addAdmin(String name, String password, Integer roleId);
	
	/**
	 * 删除管理员
	 * @param id
	 * @return
	 */
	public boolean deleteAdmin(Integer id);
}

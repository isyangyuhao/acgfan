package org.acg.service.admin.impl;

import java.util.ArrayList;

import org.acg.entities.Role;

import org.acg.dao.AdminDao;
import org.acg.dao.IndexDao;
import org.acg.dao.PaletteDao;
import org.acg.dao.ShopDao;
import org.acg.entities.Admin;
import org.acg.entities.AdminJson;
import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.Goods;
import org.acg.entities.Palette;
import org.acg.entities.PaletteJson;
import org.acg.service.admin.OtherAdminService;
import org.apache.commons.lang3.ObjectUtils.Null;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.hibernate.type.AdaptedImmutableType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jdk.nashorn.internal.ir.Flags;

/**
 * Description : 后台管理其他相关业务逻辑实现类
 * @author yangyuhao
 */
@Service
public class OtherAdminServiceImpl implements OtherAdminService{

	private ObjectMapper objectMapper;
	
	{
		objectMapper = new ObjectMapper();
	}
	
	@Autowired
	private ShopDao shopDao;
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private PaletteDao paletteDao;
	
	@Transactional
	@Override
	public String getAllGoodsJson() throws JsonProcessingException {
		ArrayList<Goods> goods = shopDao.getAllGoods();
		String json = "";
		json = objectMapper.writeValueAsString(goods);
		return json;
	}

	@Transactional
	@Override
	public boolean addGoods(String name, String photoDesc, Double price, Integer stock) {
		if (name == null || photoDesc == null || price == null || stock == null) {
			return false;
		}
		Goods goods = new Goods();
		goods.setName(name);
		goods.setPhotoDesc(photoDesc);
		goods.setPrice(price);
		goods.setStock(stock);
		adminDao.insertGoods(goods);
		return true;
	}

	@Transactional
	@Override
	public boolean updateGoods(Integer id, String name, String photoDesc, Double price, Integer stock) {
		if (id == null || name == null || photoDesc == null || price == null || stock == null) {
			return false;
		}
		Goods goods = adminDao.getGoodsById(id);
		goods.setName(name);
		goods.setPhotoDesc(photoDesc);
		goods.setPrice(price);
		goods.setStock(stock);
		adminDao.updateGoods(goods);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteGoods(Integer id) {
		if (id == null) {
			return false;
		}
		Goods goods = adminDao.getGoodsById(id);
		adminDao.deleteGoods(goods);
		return true;
	}

	@Transactional
	@Override
	public String getAllGameJson() throws JsonProcessingException {
		ArrayList<Game> gameIntroduces = adminDao.getAllGame();
		String json = "";
		json = objectMapper.writeValueAsString(gameIntroduces);
		return json;
	}

	@Transactional
	@Override
	public boolean updateGame(Integer id, String name, String title, String src) {
		if (id == null || name == null || title == null || src == null) {
			return false;
		}
		Game game = adminDao.getGameById(id);
		game.setName(name);
		game.setTitle(title);
		game.setSrc(src);
		adminDao.updateGame(game);
		return true;
	}

	@Transactional
	@Override
	public String getAllGameIntroduceJson() throws JsonProcessingException {
		ArrayList<GameIntroduce> gameIntroduces = adminDao.getAllGameIntroduce();
		String json = "";
		json = objectMapper.writeValueAsString(gameIntroduces);
		return json;
	}

	@Transactional
	@Override
	public boolean addGameIntroduce(String name, Integer typeId) {
		if (name == null || typeId == null) {
			return false;
		}
		GameIntroduce gameIntroduce = new GameIntroduce();
		gameIntroduce.setName(name);
		gameIntroduce.setTypeId(typeId);
		adminDao.insertGameIntroduce(gameIntroduce);
		return true;
	}

	@Transactional
	@Override
	public boolean updateGameIntroduce(Integer id, String name, Integer typeId) {
		if (id == null || name == null || typeId == null) {
			return false;
		}
		GameIntroduce gameIntroduce = adminDao.getGameIntroduceById(id);
		gameIntroduce.setName(name);
		gameIntroduce.setTypeId(typeId);
		adminDao.updateGameIntroduce(gameIntroduce);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteGameIntroduce(Integer id) {
		if (id == null) {
			return false;
		}
		GameIntroduce gameIntroduce = adminDao.getGameIntroduceById(id);
		adminDao.deleteGameIntroduce(gameIntroduce);
		return true;
	}

	@Transactional
	@Override
	public String getAllPaletteJson() throws JsonProcessingException {
		ArrayList<Palette> palettes = paletteDao.getAllPalette();
		ArrayList<PaletteJson> paletteJsons = new ArrayList<>();
		for (Palette palette : palettes) {
			PaletteJson paletteJson = new PaletteJson();
			paletteJson.setId(palette.getId());
			paletteJson.setName(palette.getName());
			paletteJson.setSrc(palette.getSrc());
			paletteJson.setTypeName(palette.getPaletteType().getTypeName());
			paletteJson.setUserName(palette.getUser().getUsername());
			paletteJsons.add(paletteJson);
		}
		String json = "";
		json = objectMapper.writeValueAsString(paletteJsons);
		return json;
	}

	@Transactional
	@Override
	public boolean deletePalette(Integer id) {
		if (id == null) {
			return false;
		}
		Palette palette = paletteDao.getPaletteById(id);
		adminDao.deletePalette(palette);
		return true;
	}

	@Override
	public String getAllAdminJson() throws JsonProcessingException {
		ArrayList<Admin> admins = adminDao.getAllAdmin();
		ArrayList<AdminJson> adminJsons = new ArrayList<>();
		for (Admin admin : admins) {
			AdminJson adminJson = new AdminJson();
			adminJson.setId(admin.getId());
			adminJson.setName(admin.getName());
			adminJson.setWork(admin.getWork());
			adminJson.setRole(admin.getRole().getRoleName());
			adminJsons.add(adminJson);
		}
		String json = "";
		json = objectMapper.writeValueAsString(adminJsons);
		return json;
	}

	@Transactional
	@Override
	public boolean updateAdminRole(Integer id, Integer roleId) {
		if (id == null || roleId == null) {
			return false;
		}
		Role role = adminDao.getRoleById(roleId);
		adminDao.updateAdminRole(id, role);
		return true;
	}

	@Transactional
	@Override
	public boolean updateAdminWork(Integer id, String work) {
		if (id == null || work == null) {
			return false;
		}
		Admin admin = adminDao.getAdminById(id);
		admin.setWork(work);
		adminDao.updateAdmin(admin);
		return true;
	}

	@Transactional
	@Override
	public boolean addAdmin(String name, String password, Integer roleId) {
		if (name == null || password == null || roleId == null) {
			return false;
		}
		Admin admin = new Admin();
		Role role = adminDao.getRoleById(roleId);
		admin.setName(name);
		
		//盐值加密
		String hashAlgorithmName = "MD5";
		Object credentials = password;
		ByteSource credentialsSalt = ByteSource.Util.bytes(name + "360ABCCA5341962132E2E6204D7D88B2");
		int hashIterations = 1024;
		Object result = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
		
		admin.setPassword(result+"");
		admin.setRole(role);
		admin.setWork("您暂时没有工作任务...");
		adminDao.updateAdmin(admin);
		return true;
	}

	@Transactional
	@Override
	public boolean deleteAdmin(Integer id) {
		if (id == null) {
			return false;
		}
		Admin admin = adminDao.getAdminById(id);
		adminDao.deleteAdmin(admin);
		return true;
	}
	
}

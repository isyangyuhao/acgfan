package org.acg.action.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.acg.entities.Admin;
import org.acg.service.admin.BaseAdminService;
import org.acg.service.admin.OtherAdminService;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import jdk.nashorn.internal.ir.Flags;

/**
 * Description : 后台管理其他相关控制器 <br>
 * 		周边商城、游戏中心、画友等板块
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class OtherAdminAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = 1L;
	
	@Autowired
	private OtherAdminService otherAdminService;
	@Autowired
	private BaseAdminService baseAdminService;
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private String name;
	private String photoDesc;
	private Double price;
	private Integer stock;
	private Integer id;
	private String title;
	private String src;
	private Integer typeId;
	private String work;
	private Integer roleId;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhotoDesc() {
		return photoDesc;
	}
	public void setPhotoDesc(String photoDesc) {
		this.photoDesc = photoDesc;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getWork() {
		return work;
	}
	public void setWork(String work) {
		this.work = work;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private Map<String, Object> sessionMap;

	/**
	 * Url: other-goods-ajax <br>
	 * Desc: 获取全部商品信息
	 * @permission shop
	 * @return [{id:1, name:xxx, price:1, stock:1, photoDesc:xxx, photoMore:xxx, buySrc:xxx, goodsType:xxx}, ... ]
	 */
	public String goodsAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "shop")) {					
					inputStream = new ByteArrayInputStream(otherAdminService.getAllGoodsJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-addGoods-ajax <br>
	 * Desc: 添加商品，传入{name:xxx, photoDesc:xxx, price:100, stock:1}
	 * @permission shop
	 * @return 1:成功; 0:失败
	 */
	public String addGoodsAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.addGoods(name, photoDesc, price, stock);
		boolean flag2 = baseAdminService.isPermission(admin, "shop");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-updateGoods-ajax
	 * Desc: 更新商品信息，传入{id:1, name:xxx, photoDesc:xxx, price:100, stock:1}
	 * @permission shop
	 * @return 1:成功; 0:失败
	 */
	public String updateGoodsAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.updateGoods(id, name, photoDesc, price, stock);
		boolean flag2 = baseAdminService.isPermission(admin, "shop");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-deleteGoods-ajax
	 * Desc: 删除商品信息，传入 id:1
	 * @permission shop
	 * @return 1:成功; 0:失败
	 */
	public String deleteGoodsAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.deleteGoods(id);
		boolean flag2 = baseAdminService.isPermission(admin, "shop");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-game-ajax
	 * Desc: 获取全部推荐游戏信息
	 * @permission game
	 * @return [{id:1, name:xxx, title:xxx, src:xxx}, ... ]
	 */
	public String gameAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "game")) {					
					inputStream = new ByteArrayInputStream(otherAdminService.getAllGameJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-updateGame-ajax
	 * Desc: 更新推荐信息，传入{id:1, name:xxx, title:xxx, src:xxx}
	 * @permission game
	 * @return 1:成功; 0:失败
	 */
	public String updateGameAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.updateGame(id, name, title, src);
		boolean flag2 = baseAdminService.isPermission(admin, "game");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-gameIntroduce-ajax
	 * Desc: 获取全部游戏信息
	 * @permission game
	 * @return [{id:1, name:xxx, typeId:1}, ... ]
	 */
	public String gameIntroduceAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "game")) {					
					inputStream = new ByteArrayInputStream(otherAdminService.getAllGameIntroduceJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-addGameIntroduce-ajax
	 * Desc: 添加新游戏，传入{name:xxx, typeId:1}
	 * @permission game
	 * @return 1:成功; 0:失败
	 */
	public String addGameIntroduceAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.addGameIntroduce(name, typeId);
		boolean flag2 = baseAdminService.isPermission(admin, "game");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-updateGameIntroduce-ajax <br>
	 * Desc: 更新游戏，传入{id:1, name:xxx, typeId:1}
	 * @permission game
	 * @return 1:成功; 0:失败
	 */
	public String updateGameIntroduceAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.updateGameIntroduce(id, name, typeId);
		boolean flag2 = baseAdminService.isPermission(admin, "game");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-deleteGameIntroduce-ajax
	 * Desc: 删除游戏，传入 id:1
	 * @permission game
	 * @return 1:成功; 0:失败
	 */
	public String deleteGameIntroduceAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.deleteGameIntroduce(id);
		boolean flag2 = baseAdminService.isPermission(admin, "game");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-palette-ajax <br>
	 * Desc: 获取全部画板
	 * @permission palette
	 * @return [{id:1, name:xxx, src:xxx, createTime:xxx, typeName:xxx, userName:xxx}, ... ]
	 */
	public String paletteAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "palette")) {					
					inputStream = new ByteArrayInputStream(otherAdminService.getAllPaletteJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-deletePalette-ajax
	 * Desc: 删除画板，传入 id:1
	 * @permission palette
	 * @return 1:成功; 0:失败
	 */
	public String deletePaletteAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.deletePalette(id);
		boolean flag2 = baseAdminService.isPermission(admin, "palette");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-admin-ajax <br>
	 * Desc: 获取全部管理员
	 * @permission admin
	 * @return [{id:1, name:xxx, role:xxx, work:xxx}, ... ]
	 */
	public String adminAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "admin")) {					
					inputStream = new ByteArrayInputStream(otherAdminService.getAllAdminJson().getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				}
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} finally {
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return "ajax";
	}
	
	/**
	 * 添加管理员
	 * @permission admin
	 * @return
	 */
	public String addAdminAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.addAdmin(name, password, roleId);
		boolean flag2 = baseAdminService.isPermission(admin, "admin");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-updateAdminRole-ajax
	 * Desc: 更新管理员角色，传入 {id:1, roleId:1}
	 * @permission admin
	 * @return 1:成功; 0:失败
	 */
	public String updateAdminRoleAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.updateAdminRole(id, roleId);
		boolean flag2 = baseAdminService.isPermission(admin, "admin");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * Url: other-updateAdminWork-ajax
	 * Desc: 更新管理员任务，传入{id:1, work:xxx}
	 * @permission admin
	 * @return 1:成功; 0:失败
	 */
	public String updateAdminWorkAjax(){
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.updateAdminWork(id, work);
		boolean flag2 = baseAdminService.isPermission(admin, "admin");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	/**
	 * 删除管理员
	 * @permission admin
	 * @return
	 */
	public String deleteAdminAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = otherAdminService.deleteAdmin(id);
		boolean flag2 = baseAdminService.isPermission(admin, "admin");
		if(flag && flag2) {
			try {
				inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		} else {
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} finally {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return "ajax";
	}
	
	@Override
	public void setSession(Map<String, Object> arg0) {
		sessionMap = arg0;
	}

}

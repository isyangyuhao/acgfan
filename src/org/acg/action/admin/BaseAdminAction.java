package org.acg.action.admin;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.acg.entities.Admin;
import org.acg.entities.AdminJson;
import org.acg.service.admin.BaseAdminService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;

/**
 * Description : 后台管理主控制器
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class BaseAdminAction extends ActionSupport implements SessionAware {
	

	private static final long serialVersionUID = 1L;

	private ObjectMapper objectMapper;
	{
		objectMapper = new ObjectMapper();
	}
	
	@Autowired
	private BaseAdminService baseAdminService;
	
	private Map<String, Object> sessionMap;
	
	private String username;
	private String password;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private String videoTypeId;
	private String videoTypeName;
	private String videoTypeIntroduce;
	public String getVideoTypeId() {
		return videoTypeId;
	}
	public void setVideoTypeId(String videoTypeId) {
		this.videoTypeId = videoTypeId;
	}
	public String getVideoTypeName() {
		return videoTypeName;
	}
	public void setVideoTypeName(String videoTypeName) {
		this.videoTypeName = videoTypeName;
	}
	public String getVideoTypeIntroduce() {
		return videoTypeIntroduce;
	}
	public void setVideoTypeIntroduce(String videoTypeIntroduce) {
		this.videoTypeIntroduce = videoTypeIntroduce;
	}
	
	private Integer id;
	private String name;
	private String src;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	
	/**
	 * 管理员登陆
	 * @return admin/index.html页面
	 */
	public String adminLogin() {
		//获取Subject
		Subject currentUser = SecurityUtils.getSubject();
		//调用isAuthenticated判断当前用户是否被认证,即是否已经登录
        if (!currentUser.isAuthenticated()) {
            //将用户名和密码封装为UsernamePasswordToken对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            //设置token为记住我
            token.setRememberMe(true);
            //调用了subject的login方法执行登录
            try {
    			currentUser.login(token);
    			//如果登录失败则抛出异常
            } catch (org.apache.shiro.authc.AuthenticationException  ae) {
            	return "admin-login-error";
            }
        }
        Admin admin = baseAdminService.getAdminByName(username).get(0);
        sessionMap.put("admin", admin);
		return "admin-login-success";
	}
	
	/**
	 * 退出登录
	 * @return index-index-show
	 */
	public String adminLogout() {
		sessionMap.remove("admin");
		return "admin-logout";
	}
	
	/**
	 * 返回用户登录状态
	 * @return 1:登录; 0:未登录
	 */
	public String isloginAjax() {
		if(sessionMap.get("admin") != null) {
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
	 * 返回所有用户信息 <br>
	 * @permission user
	 * @return json格式所有用户信息
	 */
	public String usersAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (!baseAdminService.isPermission(admin, "user")) {
					inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
				} else {
					inputStream = new ByteArrayInputStream(baseAdminService.getAllUserJson().getBytes("UTF-8"));
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
	 * 获取管理员信息
	 * @return json格式管理员信息
	 */
	public String adminAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		String adminJsonStr = null;
		AdminJson adminJson = new AdminJson();
		adminJson.setId(admin.getId());
		adminJson.setName(admin.getName());
		adminJson.setRole(admin.getRole().getRoleName());
		adminJson.setWork(admin.getWork());
		try {
			adminJsonStr = objectMapper.writeValueAsString(adminJson);
		} catch (JsonProcessingException e1) {
			e1.printStackTrace();
		}
		
		try {
			inputStream = new ByteArrayInputStream(adminJsonStr.getBytes("UTF-8"));
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
	 * 返回json格式视频类型信息
	 * @permission video
	 * @return
	 */
	public String videoTypeAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "video")) {
					inputStream = new ByteArrayInputStream(baseAdminService.getAllVideoTypeJson().getBytes("UTF-8"));
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
	 * 修改视频类型
	 * @permission video
	 * @return 1:更新成功; 0:更新失败
	 */
	public String updateVideoTypeAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = baseAdminService.updateVideoType(videoTypeId, videoTypeName, videoTypeIntroduce);
		boolean flag2 = baseAdminService.isPermission(admin, "video");
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
	 * Url : admin-friendLinks-ajax <br>
	 * Desc : 获取全部的友情连接
	 * @permission user
	 * @return [{id:1, name:xxx, src:xxx}, {id:2, name:xxx, src:xxx}, ... ]
	 */
	public String friendLinksAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		try {
			try {
				if (baseAdminService.isPermission(admin, "user")) {					
					inputStream = new ByteArrayInputStream(baseAdminService.getAllFriendLinkJson().getBytes("UTF-8"));
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
	 * Url : admin-updateFriendLink-ajax <br>
	 * Desc : 更新指定的友情链接, 传入{id:1, name:xxx, src:xxx}
	 * @permission user
	 * @return 1:成功; 0:失败
	 */
	public String updateFriendLinkAjax() {
		Admin admin = (Admin) sessionMap.get("admin");
		boolean flag = baseAdminService.updateFriendLink(id, name, src);
		boolean flag2 = baseAdminService.isPermission(admin, "user");
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

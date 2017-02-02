package org.acg.action.main;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

import javax.servlet.Servlet;
import javax.servlet.ServletContext;

import org.acg.entities.User;
import org.acg.entities.VideoComment;
import org.acg.service.main.AccountService;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.engine.jdbc.spi.ResultSetReturn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.xml.internal.security.keys.keyresolver.implementations.PrivateKeyResolver;
import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

/**
 * Description : 账户相关控制器 <br>
 * 用于用户账户的登录,注册,修改用户信息,退出登录等
 * @author yangyuhao
 */
@Scope("prototype")
@Controller
public class AccountAction extends ActionSupport implements RequestAware, SessionAware {
	
	private static final long serialVersionUID = 1L;

	@Autowired
	private AccountService accountService;
	
	private Map<String, Object> requestMap;
	private Map<String, Object> sessionMap;
	
	
	private InputStream inputStream;
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	
	private Integer id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	private String username;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	private String password;
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	private String introduce;
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	private String sex;
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	private Date birth;
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	
	private String q1;
	private String q2;
	private String q3;
	private String q4;
	private String q5;
	public String getQ1() {
		return q1;
	}
	public void setQ1(String q1) {
		this.q1 = q1;
	}
	public String getQ2() {
		return q2;
	}
	public void setQ2(String q2) {
		this.q2 = q2;
	}
	public String getQ3() {
		return q3;
	}
	public void setQ3(String q3) {
		this.q3 = q3;
	}
	public String getQ4() {
		return q4;
	}
	public void setQ4(String q4) {
		this.q4 = q4;
	}
	public String getQ5() {
		return q5;
	}
	public void setQ5(String q5) {
		this.q5 = q5;
	}
	
//==================================================
	
	
	/**
	 * 显示登录页面
	 * @return 返回videws/account/login.jsp页面
	 */
	public String loginShow() {
		return "account-login";
	}
	
	/**
	 * 通过ajax判断用户名是否存在
	 * @return 1:存在; 0:不存在
	 */
	public String usernameAjax() {
		if(accountService.isUsernameExist(username) == 1) {
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
		} else if (accountService.isUsernameExist(username) == 0){
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
		} else {
			try {
				inputStream = new ByteArrayInputStream("-1".getBytes("UTF-8"));
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
		return "account-ajax-username";
	}
	
	/**
	 * 执行用户登录操作
	 * @return 1:index.jsp; 0/-1:error.jsp
	 */
	public String loginExecute() {
		if (accountService.login(username, password) == 1) {
			//登录成功
			User user = accountService.getUserByName(username);
			sessionMap.put("user", user);
			return "account-login";
		} else if (accountService.login(username, password) == -1) {
			//密码错误
			requestMap.put("errorMsg", "您的密码输入有误,请重新登录!");
			return "account-error";
		} else {
			//用户名不存在
			requestMap.put("errorMsg", "您的用户名不存在,请重新登录!");
			return "account-error";
		}
	}
	
	/**
	 * 用户退出登录
	 * @return index.jsp
	 */
	public String exitExecute() {
		sessionMap.remove("user");
		return "account-exit";
	}

	/**
	 * 显示用户登录答题页面
	 * @return account/question页面
	 */
	public String questionShow() {
		return "account-question";
	}
	
	/**
	 * 提交问题,判断是否正确 <br>
	 * 如果正确则跳转到注册界面,否则跳转到错误页面
	 * @return account/register.jsp || error.jsp
	 */
	public String questionExecute() {
		if (accountService.isQuestionAllRight(q1, q2, q3, q4, q5)) {
			//答题正确
			return "account-register";
		} else {
			//答题失误
			requestMap.put("errorMsg", "您的答案并没有全部正确,请重新准备答题注册吧!");
			return "account-error";
		}
	}
	
	/**
	 * 执行用户注册
	 * @return account/success.jsp || error.jsp
	 */
	public String registerExecute() {
		if (accountService.register(username, password, introduce, birth, sex)) {
			return "account-success";
		} else {
			requestMap.put("errorMsg", "注册失败,请稍后再试!");
			return "account-error";
		}
	}
	
	/**
	 * 显示用户信息修改
	 * @return account/edit.jsp
	 */
	public String editShow() {
		return "account-edit";
	}
	
	/**
	 * 执行用户信息修改
	 * @return index.jsp || error.jsp
	 */
	public String editExecute() {
		boolean flag = accountService.update(id, username, password, introduce, birth, sex);
		if (flag) {
			//刷新session中的user记录
			sessionMap.put("user", accountService.getUserById(id));
			return "account-index";
		} else {
			requestMap.put("errorMsg", "用户信息修改失败,可能是您修改的用户名已被使用或者不合法!");
			return "account-error";
		}
	}
	
	/**
	 * 显示个人中心页面
	 * @return account/myself.jsp
	 */
	public String myselfShow() {
		//获取用户视频评论实体类
		User user = (User) sessionMap.get("user");
		Integer userId = user.getId();
		ArrayList<VideoComment> videoComments = accountService.getVideoCommentByUser(userId);
		requestMap.put("comments", videoComments);
		requestMap.put("videoCount", user.getVideos().size());
		return "account-myself";
	}
	
	/**
	 * 显示我的收藏页面
	 * @return account/collect.jsp
	 */
	public String collectShow() {
		User user = (User) sessionMap.get("user");
		requestMap.put("videoCount", user.getVideos().size());
		return "account-collect";
	}
	
	private File file;
	private String fileContentType;
	private String fileFileName;
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	/**
	 * 上传用户头像
	 * @return account/myself.jsp
	 * @throws IOException 
	 */
	public String iconExecute() {
		FileOutputStream outputStream = null;
		FileInputStream inputStream = null;
		try {
			ServletContext servletContext = ServletActionContext.getServletContext();
			String dir = servletContext.getRealPath("/photo/account/user/" + fileFileName);
			 outputStream = new FileOutputStream(dir);
			 inputStream = new FileInputStream(file);
			byte [] buffer = new byte[1024];
			int len = 0;
			while ((len = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, len);
			}
			User user = (User) sessionMap.get("user");
			Integer id = user.getId();
			accountService.updateUserIcon(id, fileFileName);
			sessionMap.remove("user");
			sessionMap.put("user", accountService.getUserById(id));
		} catch(Exception e) {
			requestMap.put("errorMsg", "头像上传失败!");
			return "account-error";
		} finally {
			try {
				outputStream.close();
				inputStream.close();
			} catch (Exception e) {
				sessionMap.put("errorMsg", "头像上传失败!");
				return "account-error";
			}
		}

		return "account-index";
	}
	
//==================================================

	//被动注入request和session的Map栈
	@Override
	public void setSession(Map<String, Object> arg0) {	
		this.sessionMap = arg0;
	}
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.requestMap = arg0;
	}
	
}

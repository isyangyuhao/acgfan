package org.acg.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.acg.dao.AccountDao;
import org.acg.entities.Admin;
import org.acg.entities.Indent;
import org.acg.entities.Palette;
import org.acg.entities.Question;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.service.main.AccountService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

/**
 * 用户账户业务逻辑测试
 * @author yangyuhao
 */
public class AccountTest {

	private ApplicationContext applicationContext = null;
	private AccountService accountService = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		accountService = applicationContext.getBean(AccountService.class);
	}
	
	/**
	 * 测试判断用户名是否存在
	 */
	@Test
	public void testIsUsernameExist() {
		String username1 = "root";  //存在
		String username2 = "";  //为空
		String username3 = "no";  //不存在
		//输出测试结果
		System.out.println("* username1 exist : " + accountService.isUsernameExist(username1));
		System.out.println("* username2 exist : " + accountService.isUsernameExist(username2));
		System.out.println("* username3 exist : " + accountService.isUsernameExist(username3));
	}
	
	/**
	 * 测试用户登录
	 */
	@Test
	public void testLogin() {
		
		accountService.register("testPassword", "root", "test", new Date(), "m");
		
		//测试登录
		String username = "testPassword";
		String password = "root";
		//输出测试结果
		System.out.println("* user1 login : " + accountService.login(username, password));
	}
	
	/**
	 * 测试通过用户名获取用户实体类
	 */
	@Test
	public void testGetUserByName() {
		String username = "root";
		User user = accountService.getUserByName(username);
		//输出测试结果
		System.out.println("* user objectAddress : " + user);
		System.out.println("* user username : " + user.getUsername());
		System.out.println("* user password : " + user.getPassword());
	}
	
	/**
	 * 测试获取全部注册问题实体类
	 */
	@Test
	public void testGetAllQuestion() {
		ArrayList<Question> questions = accountService.getAllQuestion();
		//输出测试结果
		System.out.println("* questions size : " + questions.size());
		System.out.println("* question1 content : " + questions.get(1).getContent());
	}
	
	/**
	 * 测试回答注册问题,判断是否全部回答正确
	 */
	@Test
	public void testQuestionAllRight() {
		boolean answer1 = accountService.isQuestionAllRight("A", "B", "C", "D", "A");  //错误的回答
		boolean answer2 = accountService.isQuestionAllRight("B", "B", "D", "B", "C");  //正确的回答
		//输出测试结果
		System.out.println("* answer1 : " + answer1);
		System.out.println("* answer2 : " + answer2);
	}
	
	/**
	 * 测试用户注册
	 */
	@Test
	public void testRegister() {
		String username = "user_test";
		String password = "root";
		String introduce = "";
		String sex = "f";
		Date birth = new Date();
		boolean flag = accountService.register(username, password, introduce, birth, sex);
		//输出测试结果
		System.out.println("* register flag : " + flag);
		System.out.println("* user : " + accountService.getUserByName(username));
	}
	
	/**
	 * 测试用户修改信息
	 */
	@Test
	public void testUpdate() {
		Integer id = 41;
		String username = "$$user_test";
		String password = "root";
		String introduce = "this is a test";
		Date birth = new Date();
		String sex = "f";
		//输出测试结果
		System.out.println("* update flag : " + accountService.update(id, username, password, introduce, birth, sex));
		User user = accountService.getUserByName(username);
		System.out.println("* updated user : " + user.getUsername() + "/" + user.getIntroduce() + "/" + user.getSex());
	}
	
	/**
	 * 测试通过用户id获取用户实体类
	 */
	@Test
	public void testGetUserById() {
		Integer id = 1;
		User user = accountService.getUserById(id);
		//输出测试结果
		System.out.println("* user address : " + user);
		System.out.println("* user name : " + user.getUsername());
	}
	
	/**
	 * 测试通过用户id获取对应视频评论实体类集合
	 */
	@Test
	public void testGetVideoCommentByUser() {
		Integer userId = 5;
		ArrayList<VideoComment> videoComments = accountService.getVideoCommentByUser(userId);
		//打印测试结果
		System.out.println("* VideoComment count : " + videoComments.size());
	}
	
	/**
	 * 测试用户修改头像
	 */
	@Test
	public void testUpdateUserIcon() {
		Integer id = 1;
		String iconName = "av10.png";
		accountService.updateUserIcon(id, iconName);
	}

	@Test
	public void testChangeTestAccountPassword() {
		
		String username = "root";
		String password = "root";
		Date date = accountService.getUserByName(username).getCreateTime();

		
		//密码加密
		String hashAlgorithmName = "MD5";  //加密算法
		Object credentials = password;  //加密内容
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = time.format(date);
		ByteSource credentialsSalt = ByteSource.Util.bytes(username + timeStr + "360ABCCA5341962132E2E6204D7D88B2");  //盐值:用户名+时间戳+固定值(YLQZ)
		String hashIterationsStr = timeStr.substring(timeStr.length() - 3, timeStr.length());
		int hashIterations = Integer.parseInt(233 + hashIterationsStr);  //加密次数:基础次数(233次)+时间戳后三位
		Object passwordRes = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);  //加密结果
		
		System.out.println(passwordRes);
		
	}
	
}

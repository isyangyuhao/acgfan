package org.acg.service.main.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.EntityManager;

import org.acg.dao.AccountDao;
import org.acg.dao.IndexDao;
import org.acg.entities.Question;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.service.main.AccountService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description : 用户账户相关操作业务逻辑层实现
 * @author yangyuhao
 */
@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private IndexDao indexDao;
	
	@Transactional(readOnly=true)
	@Override
	public int isUsernameExist(String username) {
		if ("".equals(username)) {
			return 0;
		} else if (accountDao.isUsernameExist(username) == true) {
			return 1;
		} else if (accountDao.isUsernameExist(username) == false) {
			return -1;
		}
		return 0;
	}

	@Transactional(readOnly=true)
	@Override
	public int login(String username, String password) {
		
		if (accountDao.isUsernameExist(username)) {
			
			//密码加密
			String hashAlgorithmName = "MD5";  //加密算法
			Object credentials = password;  //加密内容
			Date date = accountDao.getUserByUsername(username).getCreateTime();  //获取用户登录时间
			SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
			String timeStr = time.format(date);
			ByteSource credentialsSalt = ByteSource.Util.bytes(username + timeStr + "360ABCCA5341962132E2E6204D7D88B2");  //盐值:用户名+时间戳+固定值
			String hashIterationsStr = timeStr.substring(timeStr.length() - 3, timeStr.length());
			int hashIterations = Integer.parseInt(233 + hashIterationsStr);  //加密次数:基础次数(233次)+时间戳后三位
			Object passwordRes = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);  //加密结果
			
			if (accountDao.getPasswordByUsername(username).equals(passwordRes+"")) {
				return 1;
			} else {
				return -1;
			}
		} else {
			return 0;
		}
	}
	
	@Transactional(readOnly=true)
	@Override
	public User getUserByName(String username) {
		User user = accountDao.getUserByUsername(username);
		return user;
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<Question> getAllQuestion() {
		return accountDao.getAllQuestion();
	}
	
	@Transactional(readOnly=true)
	@Override
	public boolean isQuestionAllRight(String q1, String q2, String q3, String q4, String q5) {
		boolean flag = true;
		ArrayList<Question> questions = accountDao.getAllQuestion();
		ArrayList<String> userInputs = new ArrayList<>();
		userInputs.add(q1);
		userInputs.add(q2);
		userInputs.add(q3);
		userInputs.add(q4);
		userInputs.add(q5);
		for (int i = 0; i < questions.size(); ++i) {
			if (!questions.get(i).getAnswerRight().equals(userInputs.get(i))) {
				flag = false;
			}
		}
		return flag;
	}

	@Transactional
	@Override
	public boolean register(String username, String password, String introduce, Date birth, String sex) {
		if (username == "" || password == "") {
			return false;
		}
		User user = new User();
		user.setUsername(username);
		
		//密码加密
		String hashAlgorithmName = "MD5";  //加密算法
		Object credentials = password;  //加密内容
		Date date = new Date();  //当前时间
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = time.format(date);
		ByteSource credentialsSalt = ByteSource.Util.bytes(username + timeStr + "360ABCCA5341962132E2E6204D7D88B2");  //盐值:用户名+时间戳+固定值(360ABCCA5341962132E2E6204D7D88B2)
		String hashIterationsStr = timeStr.substring(timeStr.length() - 3, timeStr.length());
		int hashIterations = Integer.parseInt(233 + hashIterationsStr);  //加密次数:基础次数(233次)+时间戳后三位
		Object passwordRes = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);  //加密结果
		
		user.setPassword(passwordRes + "");
		user.setSex(sex);
		user.setBirth(birth);
		user.setIcon("photo/account/user/default_icon.png");
		//如果用户没有个性签名,则使用默认的
		if (introduce == "") {
			introduce = "这位用户很懒,什么都没有留下...";
		}
		user.setIntroduce(introduce);
		//默认为注册用户提供10枚硬币
		user.setDollar(10);
		//记录用户注册时间
		user.setCreateTime(date);
		//执行保存
		accountDao.insertUser(user);
		
		return true;
	}

	@Transactional
	@Override
	public boolean update(Integer id, String username, String password, String introduce, Date birth, String sex) {
		if (username == "" || password == "") {
			return false;
		}
		//除原来名之外,不能修改为已存在的用户名
		if (accountDao.isUsernameExist(username) && !username.equals(accountDao.getUserById(id).getUsername())) {
			return false;
		}
		User user = accountDao.getUserById(id);
		
		//密码加密
		String hashAlgorithmName = "MD5";  //加密算法
		Object credentials = password;  //加密内容
		Date date = accountDao.getUserByUsername(username).getCreateTime();  //获取用户登录时间
		SimpleDateFormat time = new SimpleDateFormat("yyyyMMddHHmmss");
		String timeStr = time.format(date);
		ByteSource credentialsSalt = ByteSource.Util.bytes(username + timeStr + "360ABCCA5341962132E2E6204D7D88B2");  //盐值:用户名+时间戳+固定值
		String hashIterationsStr = timeStr.substring(timeStr.length() - 3, timeStr.length());
		int hashIterations = Integer.parseInt(233 + hashIterationsStr);  //加密次数:基础次数(233次)+时间戳后三位
		Object passwordRes = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);  //加密结果
		
		user.setUsername(username);
		user.setPassword(passwordRes+"");
		user.setIntroduce(introduce);
		user.setBirth(birth);
		user.setSex(sex);
		accountDao.updateUser(user);
		return true;
	}

	@Transactional(readOnly=true)
	@Override
	public User getUserById(Integer id) {
		User user = accountDao.getUserById(id);
		return user;
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<VideoComment> getVideoCommentByUser(Integer userId) {
		return accountDao.getVideoCommentByUser(userId);
	}

	@Transactional
	@Override
	public void updateUserIcon(Integer id, String iconName) {
		String icon = "photo/account/user/" + iconName;
		User user = accountDao.getUserById(id);
		user.setIcon(icon);
		accountDao.updateUser(user);
	}


}

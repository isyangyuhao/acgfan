package org.acg.service.main;

import java.util.ArrayList;
import java.util.Date;

import org.acg.entities.Question;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;

/**
 * Description : 用户账户相关操作业务逻辑接口层
 * @author yangyuhao
 *
 */
public interface AccountService {
	
	/**
	 * 判断用户是否存在
	 * @param username 用户名
	 * @return 1:存在; 0:用户名为空; -1:不存在
	 */
	public int isUsernameExist(String username);
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return 1:登录成功; 0:用户名不存在; -1:密码错误
	 */
	public int login(String username, String password);
	
	/**
	 * 通过用户名获取用户实体类
	 * @param username 用户名
	 * @return user 用户实体类
	 */
	public User getUserByName(String username);
	
	/**
	 * 通过id获取用户实体类
	 * @param id 用户id
	 * @return user 用户实体类
	 */
	public User getUserById(Integer id);
	
	/**
	 * 获取全部的注册问题实体类
	 * @return questions 注册问题实体类集合
	 */
	public ArrayList<Question> getAllQuestion();
	
	/**
	 * 判断用户注册答题是否全部正确
	 * @param q1 用户第一题答案
	 * @param q2 用户第二题答案
	 * @param q3 用户第三题答案
	 * @param q4 用户第四题答案
	 * @param q5 用户第五题答案
	 * @return true:全部正确; false:存在错误
	 */
	public boolean isQuestionAllRight(String q1, String q2, String q3, String q4, String q5);
	
	/**
	 * 注册用户
	 * @param username 用户名
	 * @param password 密码
	 * @param introduce 个性签名
	 * @param birth 出生年月
	 * @param sex 性别
	 * @return true:注册成功; false:注册失败
	 */
	public boolean register(String username, String password, String introduce, Date birth, String sex);
	
	/**
	 * 更新用户信息
	 * @param username 用户名
	 * @param password 密码
	 * @param introduce 个性签名
	 * @param birth 出生年月
	 * @param sex 性别
	 * @return true:更新成功; false:更新失败
	 */
	public boolean update(Integer id, String username, String password, String introduce, Date birth, String sex);
	
	/**
	 * 通过用户id获取其视频评论实体类集合
	 * @param userId 用户id
	 * @return videoComments 用户评论实体类集合
	 */
	public ArrayList<VideoComment> getVideoCommentByUser(Integer userId);
	
	/**
	 * 更新用户头像
	 * @param id 用户id
	 * @param icon 用户上传头像名
	 */
	public void updateUserIcon(Integer id, String iconName);
	
}

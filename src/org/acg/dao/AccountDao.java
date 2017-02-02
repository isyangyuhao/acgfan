package org.acg.dao;

import java.util.ArrayList;
import java.util.Date;

import org.acg.entities.Question;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;

/**
 * Description : 用户账户相关操作数据访问接口层 <br>
 * 用于对User表进行相关数据访问与操作
 * @author yangyuhao
 *
 */
public interface AccountDao {
	
	/**
	 * 判断用户名是否存在
	 * @param username 用户名
	 * @return true:存在; false:不存在
	 */
	public boolean isUsernameExist(String username);
	
	/**
	 * 根据指定用户名获取密码
	 * @param username 用户名
	 * @return password 密码
	 */
	public String getPasswordByUsername(String username);
	
	/**
	 * 通过用户名获取对应的用户实体类
	 * @param username
	 * @return user 用户实体类
	 */
	public User getUserByUsername(String username);
	
	/**
	 * 通过id获取对应用户实体类
	 * @param id 用户id
	 * @return user 用户实体类
	 */
	public User getUserById(Integer id);
	
	/**
	 * 获取所有注册问题实体类
	 * @return questions 注册问题实体类集合
	 */
	public ArrayList<Question> getAllQuestion();
	
	/**
	 * 插入一条用户记录
	 * @param user 用户实体类
	 */
	public void insertUser(User user);
	
	/**
	 * 更新一条用户记录
	 * @param user 用户实体类
	 */
	public void updateUser(User user);
	
	/**
	 * 通过用户id获取其评论实体类集合
	 * @param id 用户id
	 * @return videoComments 视频评论实体类集合
	 */
	public ArrayList<VideoComment> getVideoCommentByUser(Integer userId);
	
	/**
	 * 获取全部的用户实体类
	 * @return users 用户实体类集合
	 */
	public ArrayList<User> getAllUser();
	
}

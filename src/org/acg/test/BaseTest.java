package org.acg.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.acg.entities.FriendLink;
import org.acg.entities.Question;
import org.acg.entities.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Description : 测试项目基本配置
 * @author yangyuhao
 */
public class BaseTest {

	private ApplicationContext applicationContext = null;
	
	{
		applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	/**
	 * 测试C3P0数据库连接池数据源 <br>
	 * 测试JPA生成数据表
	 */
	@Test
	public void testDatabaseSource() {
		DataSource dataSource = applicationContext.getBean(DataSource.class);
		System.out.println(dataSource);
	}
	
	/**
	 * 插入用户表测试数据
	 */
	@Test
	public void insertTestValueForUser() {
		EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	//操作开始 [[
		//判断是否存在测试账户root,如果不存在则建立
		String jpql = "select u from User u where u.username = 'root'";
		Query query = entityManager.createQuery(jpql);
		User userRoot = (User) query.getSingleResult();
		if (userRoot == null) {
			userRoot.setUsername("root");
			userRoot.setPassword("root");
			userRoot.setSex("m");
			userRoot.setIntroduce("该用户很懒,没有更新签名...");
			userRoot.setDollar(10);
			userRoot.setBirth(new Date());
			userRoot.setCreateTime(new Date());
		}
		//插入20条测试用户
		for (int i = 0; i < 20; ++i) {
			User user = new User();
			user.setUsername("test" + i);
			user.setPassword("root");
			user.setBirth(new Date());
			user.setCreateTime(new Date());
			user.setDollar(10);
			user.setIntroduce("该用户很懒,没有更新签名...");
			user.setSex("m");
			entityManager.persist(user);
		} 
	//操作结束 ]]
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	/**
	 * 插入用户注册答题信息
	 */
	@Test
	public void insertQuestionValue() {
		EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	//操作开始 [[
		Question question1 = new Question();
		question1.setContent("复制UP主签名并发送弹幕会造成怎样结果?");
		question1.setAnswerA("A. 考试会100分");
		question1.setAnswerB("B. 会被系统禁言");
		question1.setAnswerC("C. 会中彩票");
		question1.setAnswerD("D. 自己帐号会变成VIP");
		question1.setAnswerRight("B");
		entityManager.persist(question1);
		//========================================
		Question question2 = new Question();
		question2.setContent("当观看过程中有发现有恶意黑自己喜欢角色的弹幕时应该?");
		question2.setAnswerA("A. 去黑别的角色");
		question2.setAnswerB("B. 举报该弹幕");
		question2.setAnswerC("C. 打穿屏幕");
		question2.setAnswerD("D. 弹幕刷屏");
		question2.setAnswerRight("B");
		entityManager.persist(question2);
		//========================================
		Question question3 = new Question();
		question3.setContent("在视频中版聊会怎样?");
		question3.setAnswerA("A. 瞬间爆炸");
		question3.setAnswerB("B. 生灵涂炭");
		question3.setAnswerC("C. 关闭视频");
		question3.setAnswerD("D. 遮挡屏幕影响别人观看");
		question3.setAnswerRight("D");
		entityManager.persist(question3);
		//========================================
		Question question4 = new Question();
		question4.setContent("在做科普的过程中应当怎样?");
		question4.setAnswerA("A. 遮挡字幕");
		question4.setAnswerB("B. 有理有据");
		question4.setAnswerC("C. 引起战争");
		question4.setAnswerD("D. 涉及剧透");
		question4.setAnswerRight("B");
		entityManager.persist(question4);
		//========================================
		Question question5 = new Question();
		question5.setContent("看排行类视频的时候,以下那种弹幕比较适宜?");
		question5.setAnswerA("A. 剧透第一名");
		question5.setAnswerB("B. xxx太低了");
		question5.setAnswerC("C. 讨论关注作品信息");
		question5.setAnswerD("D. 怎么没有xxx");
		question5.setAnswerRight("C");
		entityManager.persist(question5);
		//========================================
	//操作结束 ]]
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();
	}
	
	/**
	 * 插入友情链接内容
	 */
	@Test
	public void insertFriendLink() {
		EntityManagerFactory entityManagerFactory = applicationContext.getBean(EntityManagerFactory.class);
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
	//操作开始 [[
		FriendLink friendLink1 = new FriendLink();
		friendLink1.setName("哔哩哔哩动画");
		friendLink1.setSrc("http://www.bilibili.com/");
		FriendLink friendLink2 = new FriendLink();
		friendLink2.setName("AcFun动画网");
		friendLink2.setSrc("http://www.acfun.tv/");
		FriendLink friendLink3 = new FriendLink();
		friendLink3.setName("Bootstrap中文网");
		friendLink3.setSrc("http://www.bootcss.com/");
		FriendLink friendLink4 = new FriendLink();
		friendLink4.setName("有字库");
		friendLink4.setSrc("http://www.youziku.com/");
		FriendLink friendLink5 = new FriendLink();
		friendLink5.setName("AngularJS中文网");
		friendLink5.setSrc("http://www.apjs.net/");
		FriendLink friendLink6 = new FriendLink();
		friendLink6.setName("Spring");
		friendLink6.setSrc("http://spring.io/");
		entityManager.persist(friendLink1);
		entityManager.persist(friendLink2);
		entityManager.persist(friendLink3);
		entityManager.persist(friendLink4);
		entityManager.persist(friendLink5);
		entityManager.persist(friendLink6);
	//操作结束 [[
		entityTransaction.commit();
		entityManager.close();
		entityManagerFactory.close();

	}

}

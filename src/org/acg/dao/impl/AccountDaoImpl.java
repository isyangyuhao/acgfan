package org.acg.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.AccountDao;
import org.acg.entities.Question;
import org.acg.entities.User;
import org.acg.entities.VideoComment;
import org.aspectj.weaver.reflect.ReflectionBasedReferenceTypeDelegate;
import org.springframework.stereotype.Repository;

/**
 * Description : 用户账户相关操作数据访问层实现
 * @author yangyuhao
 */
@Repository
public class AccountDaoImpl implements AccountDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean isUsernameExist(String username) {
		String jpql = "select u from User u where u.username = :username";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("username", username);
		@SuppressWarnings("unchecked")
		List<User> res = query.getResultList();
		if (res.size() > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String getPasswordByUsername(String username) {
		String jpql = "select u.password from User u where u.username = :username";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("username", username);
		String password = (String) query.getSingleResult();
		return password;
	}

	@Override
	public User getUserByUsername(String username) {
		String jqpl = "select u from User u where u.username = :username";
		Query query = entityManager.createQuery(jqpl);
		query.setParameter("username", username);
		User user = (User) query.getSingleResult();
		return user;
	}

	@Override
	public ArrayList<Question> getAllQuestion() {
		String jpql = "select q from Question q";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Question> questions = (ArrayList<Question>) query.getResultList();
		return questions;
	}

	@Override
	public void insertUser(User user) {
		entityManager.persist(user);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public User getUserById(Integer id) {
		User user = entityManager.find(User.class, id);
		return user;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<VideoComment> getVideoCommentByUser(Integer userId) {
		String jpql = "from VideoComment vc left outer join fetch vc.user where vc.user.id = :userId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("userId", userId);
		ArrayList<VideoComment> videoComments = (ArrayList<VideoComment>) query.getResultList();
		return videoComments;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<User> getAllUser() {
		String jpql = "from User";
		Query query = entityManager.createQuery(jpql);
		return (ArrayList<User>) query.getResultList();
	}
	
}

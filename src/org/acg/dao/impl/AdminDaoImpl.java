package org.acg.dao.impl;

import java.util.ArrayList;

import org.acg.entities.Role;
import javax.persistence.EntityManager;
import javax.persistence.JoinColumn;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.AdminDao;
import org.acg.dao.PaletteDao;
import org.acg.entities.Admin;
import org.acg.entities.Danmu;
import org.acg.entities.FriendLink;
import org.acg.entities.Game;
import org.acg.entities.GameIntroduce;
import org.acg.entities.Goods;
import org.acg.entities.IndexShow;
import org.acg.entities.Palette;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

/**
 * 后台关联相关数据库访问实现类
 * @author yangyuhao
 */
@Repository
public class AdminDaoImpl implements AdminDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public ArrayList<Admin> getAdminByName(String name) {
		String jpql = "from Admin where name = :name";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("name", name);
		@SuppressWarnings("unchecked")
		ArrayList<Admin> admin = (ArrayList<Admin>) query.getResultList();
		return admin;
	}

	@Override
	public void updateVideoType(VideoType videoType) {
		entityManager.merge(videoType);
	}

	@Override
	public VideoType getVideoTypeById(Integer id) {
		return entityManager.find(VideoType.class, id);
	}

	@Override
	public void updateFriendLink(FriendLink friendLink) {
		entityManager.merge(friendLink);
	}

	@Override
	public FriendLink getFriendLinkById(Integer id) {
		return entityManager.find(FriendLink.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Video> getAllVideo() {
		String jpql = "select v from Video v";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Video> videos = (ArrayList<Video>) query.getResultList();
		return videos;
	}

	@Override
	public void insertVideo(Video video) {
		entityManager.merge(video);
	}
	
	@Override
	public void deleteVideo(Video video) {
		entityManager.remove(video);
	}

	@Override
	public void updateIndexShow(IndexShow indexShow) {
		entityManager.merge(indexShow);
	}

	@Override
	public IndexShow getIndexShowById(Integer id) {
		return entityManager.find(IndexShow.class, id);
	}

	@Override
	public ArrayList<VideoShow> getAllVideoShow() {
		String jpql = "from VideoShow vs";
		Query query = entityManager.createQuery(jpql);
		ArrayList<VideoShow> videoShows = (ArrayList<VideoShow>) query.getResultList();
		return videoShows;
	}

	@Override
	public void updateVideoShow(VideoShow videoShow) {
		entityManager.merge(videoShow);
	}

	@Override
	public VideoShow getVideoShowById(Integer id) {
		return entityManager.find(VideoShow.class, id);
	}

	@Override
	public ArrayList<VideoComment> getAllVideoComment() {
		String jpql = "from VideoComment vc";
		Query query = entityManager.createQuery(jpql);
		ArrayList<VideoComment> videoComments = (ArrayList<VideoComment>) query.getResultList();
		return videoComments;
	}

	@Override
	public void deleteVideoComment(VideoComment videoComment) {
		entityManager.remove(videoComment);
	}

	@Override
	public VideoComment getVideoCommentById(Integer id) {
		return entityManager.find(VideoComment.class, id);
	}

	@Override
	public ArrayList<Danmu> getAllDanmu() {
		String jpql = "from Danmu d";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Danmu> danmus = (ArrayList<Danmu>) query.getResultList();
		return danmus;
	}

	@Override
	public void deleteDanmu(Danmu danmu) {
		entityManager.remove(danmu);
//		entityManager.remove(entityManager.merge(danmu));
	}

	@Override
	public Danmu getDanmuById(Integer id) {
		return entityManager.find(Danmu.class, id);
	}

	@Override
	public void insertGoods(Goods goods) {
		entityManager.merge(goods); 
	}

	@Override
	public void updateGoods(Goods goods) {
		entityManager.merge(goods);
	}

	@Override
	public Goods getGoodsById(Integer id) {
		return entityManager.find(Goods.class, id);
	}

	@Override
	public void deleteGoods(Goods goods) {
		entityManager.remove(goods);
	}

	@Override
	public ArrayList<Game> getAllGame() {
		String jpql = "from Game gi";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Game> games = (ArrayList<Game>) query.getResultList();
		return games;
	}

	@Override
	public Game getGameById(Integer id) {
		return entityManager.find(Game.class, id);
	}

	@Override
	public void updateGame(Game game) {
		entityManager.merge(game);
	}

	@Override
	public ArrayList<GameIntroduce> getAllGameIntroduce() {
		String jpql = "from GameIntroduce gi";
		Query query = entityManager.createQuery(jpql);
		ArrayList<GameIntroduce> gameIntroduces = (ArrayList<GameIntroduce>) query.getResultList();
		return gameIntroduces;
	}

	@Override
	public void insertGameIntroduce(GameIntroduce gameIntroduce) {
		entityManager.merge(gameIntroduce);
	}

	@Override
	public GameIntroduce getGameIntroduceById(Integer id) {
		return entityManager.find(GameIntroduce.class, id);
	}

	@Override
	public void updateGameIntroduce(GameIntroduce gameIntroduce) {
		entityManager.merge(gameIntroduce);
	}

	@Transactional
	@Override
	public void deleteGameIntroduce(GameIntroduce gameIntroduce) {
		entityManager.remove(gameIntroduce);
	}

	@Override
	public void deletePalette(Palette palette) {
		entityManager.remove(palette);
	}

	@Override
	public ArrayList<Admin> getAllAdmin() {
		String jpql = "from Admin a";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Admin> admins = (ArrayList<Admin>) query.getResultList();
		return admins;
	}

	@Override
	public Admin getAdminById(Integer id) {
		return entityManager.find(Admin.class, id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		entityManager.merge(admin);
	}

	@Override
	public void updateAdminRole(Integer id, Role role) {
		String jpql = "update Admin a set a.role=:role where a.id=:id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("role", role);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public Role getRoleById(Integer roleId) {
		return entityManager.find(Role.class, roleId);
	}

	@Override
	public void deleteAdmin(Admin admin) {
		entityManager.remove(admin);
	}
	
}

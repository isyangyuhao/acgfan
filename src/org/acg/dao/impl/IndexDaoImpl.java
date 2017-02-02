package org.acg.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.IndexDao;
import org.acg.entities.Bar;
import org.acg.entities.Danmu;
import org.acg.entities.FriendLink;
import org.acg.entities.IndexShow;
import org.acg.entities.User;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.entities.VideoType;
import org.springframework.stereotype.Repository;

import com.sun.image.codec.jpeg.JPEGQTable;

import sun.net.www.content.image.jpeg;

/**
 * 视频主站数据访问实现类
 * @author yangyuhao
 */
@Repository
public class IndexDaoImpl implements IndexDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<FriendLink> getAllFriendLink() {
		String jpql = "select f from FriendLink f";
		Query query = entityManager.createQuery(jpql);
		ArrayList<FriendLink> friendLinks = (ArrayList<FriendLink>) query.getResultList();
		return friendLinks;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int getVideoCountByType(Integer typeId) {
		String jpql = "from Video v left outer join fetch v.videoType "
				+ "where v.videoType.id = :typeId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("typeId", typeId);
		ArrayList<Video> videos = (ArrayList<Video>) query.getResultList();
		return videos.size();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<VideoType> getAllVideoType() {
		String jpql = "from VideoType vt";
		Query query = entityManager.createQuery(jpql);
		ArrayList<VideoType> videoTypes = (ArrayList<VideoType>) query.getResultList();
		return videoTypes;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<IndexShow> getAllIndexShow() {
		String jpql = "from IndexShow";
		Query query = entityManager.createQuery(jpql);
		ArrayList<IndexShow> indexShows = (ArrayList<IndexShow>) query.getResultList();
		return indexShows;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Video> getVideoByType(Integer typeId) {
		String jpql = "from Video v left outer join fetch v.videoType "
				+ "where v.videoType.id = :typeId order by v.createTime desc";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("typeId", typeId);
		ArrayList<Video> videos = (ArrayList<Video>) query.getResultList();
		return videos;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<VideoShow> getVideoShowByType(Integer typeId) {
		String jpql = "from VideoShow vs left outer join fetch vs.videoType where vs.videoType.id = :typeId";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("typeId", typeId);
		ArrayList<VideoShow> videoShows = (ArrayList<VideoShow>) query.getResultList();
		return videoShows;
	}

	@Override
	public Video getVideoById(Integer id) {
		Video video = entityManager.find(Video.class, id);
		return video;
	}


	@Override
	public void insertVideoComment(VideoComment videoComment, Video video) {
		entityManager.persist(videoComment);
		entityManager.merge(video);
	}

	@Override
	public void updateUser(User user) {
		entityManager.merge(user);
	}

	@Override
	public void updateVideo(Video video) {
		entityManager.merge(video);
	}

	@Override
	public void deleteVideoUser(Integer userId, Integer videoId) {
		String sql = "delete from video_user where user_id=:userId and video_id=:videoId";
		Query query = entityManager.createNativeQuery(sql);
		query.setParameter("userId", userId);
		query.setParameter("videoId", videoId);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Bar> getAllBar() {
		String jpql = "from Bar";
		Query query = entityManager.createQuery(jpql);
		ArrayList<Bar> bars = (ArrayList<Bar>) query.getResultList();
		return bars;
	}

	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<Video> getVideosByKey(String key) {
		String jpql = "from Video v where v.name like :key";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("key", "%"+key+"%");
		ArrayList<Video> videos = (ArrayList<Video>) query.getResultList();
		return videos;
	}

	@Override
	public void insertDanmu(Danmu danmu) {
		entityManager.persist(danmu);
	}

}

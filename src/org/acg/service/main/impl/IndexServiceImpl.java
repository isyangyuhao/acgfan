package org.acg.service.main.impl;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Id;

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
import org.acg.service.main.IndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sun.accessibility.internal.resources.accessibility;

/**
 * Description : 视频主站业务逻辑实现类
 * @author yangyuhao
 */
@Service
public class IndexServiceImpl implements IndexService {
	
	@Autowired
	private IndexDao indexDao;

	@Transactional(readOnly=true)
	@Override
	public ArrayList<FriendLink> getAllFriendLink() {
		return indexDao.getAllFriendLink();
	}

	@Transactional(readOnly=true)
	@Override
	public int getVideoCounByType(Integer typeId) {
		return indexDao.getVideoCountByType(typeId);
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<VideoType> getAllVideoType() {
		return indexDao.getAllVideoType();
	}
	
	@Transactional(readOnly=true)
	@Override
	public ArrayList<IndexShow> getAllIndexShow() {
		return indexDao.getAllIndexShow();
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<Video> getVideoByType(Integer typeId) {
		return indexDao.getVideoByType(typeId);
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<VideoShow> getVideoShowByType(Integer typeId) {
		return indexDao.getVideoShowByType(typeId);
	}

	@Transactional(readOnly=true)
	@Override
	public Video getVideoById(Integer id) {
		return indexDao.getVideoById(id);
	}

	@Transactional
	@Override
	public boolean insertVideoComment(String content, User user, Video video) {
		//如果不符合规则,则保存失败
		if (content.equals("") || user == null || video == null) {
			return false;
		}
		VideoComment videoComment = new VideoComment();
		videoComment.setContent(content);
		videoComment.setCreateTime(new Date());
		videoComment.setUser(user);
		video.getVideoComments().add(videoComment);
		indexDao.insertVideoComment(videoComment, video);
		return true;
	}

	@Transactional
	@Override
	public boolean addLikeVideo(Integer videoId, User user) {
		Video video = indexDao.getVideoById(videoId);
		video.getUsers().add(user);
		indexDao.updateVideo(video);
		return true;
	}

	@Transactional
	@Override
	public void removeLike(Integer userId, Integer videoId) {
		indexDao.deleteVideoUser(userId, videoId);
	}

	@Transactional(readOnly=true)
	@Override
	public Bar getIndexBar() {
		return indexDao.getAllBar().get(0);
	}

	@Transactional(readOnly=true)
	@Override
	public Bar getMyselfBar() {
		return indexDao.getAllBar().get(1);
	}

	@Transactional(readOnly=true)
	@Override
	public ArrayList<Video> search(String key) {
		return indexDao.getVideosByKey(key);
	}

	@Transactional
	@Override
	public void addDanmu(Integer videoId, String text, String color, Integer size, Integer position, Integer time) {
		Video video = getVideoById(videoId);
		Danmu danmu = new Danmu();
		danmu.setText(text);
		danmu.setColor(color);
		danmu.setSize(size);
		danmu.setPosition(position);
		danmu.setTime(time);
		video.getDanmus().add(danmu);
		indexDao.insertDanmu(danmu);
		indexDao.updateVideo(video);
	}

}

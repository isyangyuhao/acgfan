package org.acg.service.admin.impl;

import java.util.Date;
import java.util.Set;
import java.util.ArrayList;

import javax.persistence.Id;

import org.acg.action.admin.VideoAdminAction;
import org.acg.dao.AdminDao;
import org.acg.dao.IndexDao;
import org.acg.entities.Danmu;
import org.acg.entities.IndexShow;
import org.acg.entities.Video;
import org.acg.entities.VideoComment;
import org.acg.entities.VideoShow;
import org.acg.service.admin.VideoAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Description : 后台管理视频相关业务逻辑实现类
 * @author yangyuhao
 */
@Service
public class VideoAdminServiceImpl implements VideoAdminService {
	
	private ObjectMapper objectMapper;
	
	{
		objectMapper = new ObjectMapper();
	}
	
	@Autowired
	private AdminDao adminDao;
	@Autowired
	private IndexDao indexDao;

	@Transactional
	@Override
	public String getAllVideoJson() throws JsonProcessingException {
		ArrayList<Video> videos = adminDao.getAllVideo();
		String json = "";
		json = objectMapper.writeValueAsString(videos);
		return json;
	}

	@Transactional
	@Override
	public boolean addVideo(String name, String src, String avSrc, Integer videoType) {
		if (name == null || src == null || avSrc == null || videoType == null) {
			return false;
		}
		Video video = new Video();
		video.setName(name);
		video.setSrc(src);
		video.setAvSrc(avSrc);
		video.setCreateTime(new Date());
		video.setVideoType(adminDao.getVideoTypeById(videoType));
		adminDao.insertVideo(video);
		return true;
	}
	
	@Transactional
	@Override
	public boolean updateVideo(Integer id, String name, String src, String avSrc, Integer videoType) {
		if (id == null || name == null || src == null || avSrc == null || videoType == null) {
			return false;
		}
		Video video = indexDao.getVideoById(id);
		video.setName(name);
		video.setSrc(src);
		video.setAvSrc(avSrc);
		video.setVideoType(adminDao.getVideoTypeById(videoType));
		indexDao.updateVideo(video);
		return true;
	}
	
	@Transactional
	@Override
	public boolean deleteVideo(Integer id) {
		if (id == null) {
			return false;
		}
		Video video = indexDao.getVideoById(id);
		Set<VideoComment> videoComments = video.getVideoComments();
		for (VideoComment videoComment : videoComments) {
			adminDao.deleteVideoComment(videoComment);
		}
		Set<Danmu> danmus = video.getDanmus();
		for (Danmu danmu : danmus) {
			adminDao.deleteDanmu(danmu);
		}
		adminDao.deleteVideo(video);
		return true;
	}

	@Transactional
	@Override
	public String getAllIndexShowJson() throws JsonProcessingException {
		ArrayList<IndexShow> indexShows = indexDao.getAllIndexShow();
		String json = "";
		json = objectMapper.writeValueAsString(indexShows);
		return json;
	}

	@Transactional
	@Override
	public boolean updateIndexShow(Integer id, String title, String src) {
		if (id == null || title == null || src == null) {
			return false;
		}
		IndexShow indexShow = adminDao.getIndexShowById(id);
		indexShow.setTitle(title);
		indexShow.setSrc(src);
		adminDao.updateIndexShow(indexShow);
		return true;
	}

	@Transactional
	@Override
	public String getAllVideoShowJson() throws JsonProcessingException {
		ArrayList<VideoShow> videoShows = adminDao.getAllVideoShow();
		String json = "";
		json = objectMapper.writeValueAsString(videoShows);
		return json;
	}

	@Transactional
	@Override
	public boolean updateVideoShow(Integer id, String title, String src, Integer videoType) {
		if (id == null || title == null || src == null || videoType == null) {
			return false;
		}
		VideoShow videoShow = adminDao.getVideoShowById(id);
		videoShow.setTitle(title);
		videoShow.setSrc(src);
		videoShow.setVideoType(adminDao.getVideoTypeById(videoType));
		adminDao.updateVideoShow(videoShow);
		return true;
	}

	@Transactional
	@Override
	public String getAllVideoCommentJson() throws JsonProcessingException {
		ArrayList<VideoComment> videoComments = adminDao.getAllVideoComment();
		String json = "";
		json = objectMapper.writeValueAsString(videoComments);
		return json;
	}

	@Transactional
	@Override
	public boolean deleteVideoComment(Integer id) {
		if (id == null) {
			return false;
		}
		VideoComment videoComment = adminDao.getVideoCommentById(id);
		adminDao.deleteVideoComment(videoComment);
		return true;
	}

	@Transactional
	@Override
	public String getAllDanmuJson() throws JsonProcessingException {
		ArrayList<Danmu> danmus = adminDao.getAllDanmu();
		String json = "";
		json = objectMapper.writeValueAsString(danmus);
		return json;
	}

	@Transactional
	@Override
	public boolean deleteDanmu(Integer id) {
		if (id == null) {
			return false;
		}
		Danmu danmu = adminDao.getDanmuById(id);
		adminDao.deleteDanmu(danmu);
		return true;
	}

	
}

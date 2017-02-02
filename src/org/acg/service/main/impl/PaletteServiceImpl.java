package org.acg.service.main.impl;

import java.util.ArrayList;

import org.acg.dao.PaletteDao;
import org.acg.entities.Palette;
import org.acg.entities.PaletteShow;
import org.acg.entities.PaletteType;
import org.acg.entities.Recommend;
import org.acg.service.main.PaletteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Description : 画板业务逻辑实现类
 * @author lizhen
 */
@Service
public class PaletteServiceImpl implements PaletteService {
	
	@Autowired
	private PaletteDao paletteDao;

	@Transactional
	@Override
	public ArrayList<PaletteShow> getAllPaletteShow() {
		return paletteDao.getAllPaletteShow();
	}

	@Transactional
	@Override
	public ArrayList<PaletteType> getAllPaletteType() {
		return paletteDao.getAllPaletteType();
	}

	@Transactional
	@Override
	public ArrayList<Palette> getAllPalette() {
		return paletteDao.getAllPalette();
	}

	@Transactional
	@Override
	public ArrayList<Recommend> getAllRecommend() {
		return paletteDao.getAllRecommend();
	}

	@Override
	public Palette getPaletteById(Integer id) {
		return paletteDao.getPaletteById(id);
	}
	
}

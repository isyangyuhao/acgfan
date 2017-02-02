package org.acg.dao.impl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.dao.PaletteDao;
import org.acg.entities.Palette;
import org.acg.entities.PaletteShow;
import org.acg.entities.PaletteType;
import org.acg.entities.Recommend;
import org.springframework.stereotype.Repository;

/**
 * 画板数据访问实现类
 * @author lizhen
 */
@Repository
public class PaletteDaoImpl implements PaletteDao {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public ArrayList<PaletteShow> getAllPaletteShow() {
		String jpql = "from PaletteShow";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<PaletteShow> paletteShows = (ArrayList<PaletteShow>) query.getResultList();
		return paletteShows;
	}

	@Override
	public ArrayList<PaletteType> getAllPaletteType() {
		String jpql = "from PaletteType";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<PaletteType> pattleTypes = (ArrayList<PaletteType>) query.getResultList();
		return pattleTypes;
	}

	@Override
	public ArrayList<Palette> getAllPalette() {
		String jpql = "from Palette p order by p.createTime desc";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<Palette> palettes = (ArrayList<Palette>) query.getResultList();
		return palettes;
	}

	@Override
	public ArrayList<Recommend> getAllRecommend() {
		String jpql = "from Recommend";
		Query query = entityManager.createQuery(jpql);
		@SuppressWarnings("unchecked")
		ArrayList<Recommend> recommends = (ArrayList<Recommend>) query.getResultList();
		return recommends;
	}

	@Override
	public Palette getPaletteById(Integer id) {
		String jpql = "from Palette where id = :id";
		Query query = entityManager.createQuery(jpql);
		query.setParameter("id", id);
		@SuppressWarnings("unchecked")
		Palette palette =  (Palette) query.getSingleResult();
		return palette;
	}

	

	
}

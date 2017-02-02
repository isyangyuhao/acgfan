package org.acg.shiro;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.acg.entities.FilterChainMapConfig;

public class FilterChainDefinitionMapBuilder {

	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	public LinkedHashMap<String, String> buildFilterChainDefinitionMap() {
		LinkedHashMap<String, String> map = new LinkedHashMap<>();
		
		String jpql = "from FilterChainMapConfig";
		Query query = entityManager.createQuery(jpql);
		ArrayList<FilterChainMapConfig> mapConfigs = (ArrayList<FilterChainMapConfig>) query.getResultList();
		for (int i = 0; i < mapConfigs.size(); ++i) {
			map.put(mapConfigs.get(i).getUrl(), mapConfigs.get(i).getRole());
		}
				
		return map;
	}
	
}

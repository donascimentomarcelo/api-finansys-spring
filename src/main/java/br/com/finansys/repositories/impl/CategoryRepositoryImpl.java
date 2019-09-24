package br.com.finansys.repositories.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.queries.CategoryQueryRepository;

@Service
public class CategoryRepositoryImpl implements CategoryQueryRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Category> findByParams(String name, String description) {
		
		StringBuilder builder = new StringBuilder();
		Map<String, Object> params = new HashMap<>();
		
		builder.append("SELECT bean FROM Category bean WHERE 1 = 1");
		
		if (StringUtils.hasText(name)) {
			builder.append(" and name = :name");
			params.put("name", name);
		}
		
		if (StringUtils.hasText(description)) {
			builder.append(" and description = :description");
			params.put("description", description);
		}
		
		TypedQuery<Category> query = entityManager.createQuery(builder.toString(), Category.class);
		
		for (Map.Entry<String, Object> param: params.entrySet()) {
			query.setParameter(param.getKey(), param.getValue());
		}
		
		return query.getResultList();
	}

}

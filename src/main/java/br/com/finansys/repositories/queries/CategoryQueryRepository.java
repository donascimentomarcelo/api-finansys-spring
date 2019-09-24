package br.com.finansys.repositories.queries;

import java.util.List;

import br.com.finansys.domain.Category;

public interface CategoryQueryRepository {
	public List<Category> findByParams(String name, String description);
}

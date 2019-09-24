package br.com.finansys.services;

import java.util.List;

import br.com.finansys.domain.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> getAll();
	Category findOne(Integer id);
	void update(Category category, Integer id);
	void delete(Integer id);
	List<Category> findByParams(String name, String description);
}

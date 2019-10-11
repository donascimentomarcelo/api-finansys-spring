package br.com.finansys.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;

import br.com.finansys.domain.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> getAll();
	Category findOne(Integer id);
	void update(Category category, Integer id);
	void delete(Integer id);
	List<Category> findByParams(String name, String description);
	Page<Category> paginate(Integer page, Integer linesPerPage, String orderBy, String direction, String name,
			String description);
	Optional<Category> findByName(String name);
}

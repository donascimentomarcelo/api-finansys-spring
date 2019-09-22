package br.com.finansys.services;

import java.util.List;
import java.util.Optional;

import br.com.finansys.domain.Category;

public interface CategoryService {

	Category save(Category category);
	List<Category> getAll();
	Optional<Category> findOne(Integer id);

}

package br.com.finansys.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.CategoryRepository;
import br.com.finansys.services.CategoryService;
import br.com.finansys.services.exceptions.ObjectNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category findOne(Integer id) {
		return categoryRepository.findById(id)
					.orElseThrow(() -> new ObjectNotFoundException("This category can't be finded!"));
	}

	@Override
	public void update(Category category, Integer id) {
		findOne(id);
		category.setId(id);
		categoryRepository.save(category);
	}

	@Override
	public void delete(Integer id) {
		Category category = findOne(id);
		categoryRepository.delete(category);
	}

	@Override
	public List<Category> findByParams(String name, String description) {
		return categoryRepository.findByParams(name, description);
	}

	@Override
	public Page<Category> paginate(Integer page, Integer linesPerPage, String orderBy, String direction, String name,
			String description) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return categoryRepository.paginate(pageRequest, name.toLowerCase(), description.toLowerCase());
	}

	@Override
	public Optional<Category> findByName(String name) {
		return categoryRepository.findByName(name);
	}

}

package br.com.finansys.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

}

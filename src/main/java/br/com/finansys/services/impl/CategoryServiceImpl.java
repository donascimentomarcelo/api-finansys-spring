package br.com.finansys.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.finansys.domain.Category;
import br.com.finansys.repositories.CategoryRepository;
import br.com.finansys.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category save(Category category) {
		System.out.println(category);
		return categoryRepository.save(category);
	}

}

package br.com.finansys.resources;


import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.finansys.domain.Category;
import br.com.finansys.services.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Category category) {
		Category newCategory = categoryService.save(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(newCategory.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}

}

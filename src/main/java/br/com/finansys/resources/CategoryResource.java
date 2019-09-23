package br.com.finansys.resources;


import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.finansys.domain.Category;
import br.com.finansys.dtos.CategoryDto;
import br.com.finansys.services.CategoryService;

@RestController
@RequestMapping(value = "/api/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService categoryService;
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CategoryDto dto) {
		Category obj = CategoryDto.fromDto(dto);
		Category category = categoryService.save(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(category.getId())
				.toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@GetMapping
	public ResponseEntity<List<CategoryDto>> getAll() {
		List<Category> list = categoryService.getAll();
		List<CategoryDto> dto = list
					.stream()
					.map(category -> new CategoryDto(category))
					.collect(Collectors.toList());
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findOne(@PathVariable Integer id) {
		Category category = categoryService.findOne(id);
		return ResponseEntity.ok(category);
	}

}

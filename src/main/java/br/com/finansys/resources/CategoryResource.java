package br.com.finansys.resources;


import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	public ResponseEntity<?> create(@Valid @RequestBody CategoryDto dto) {
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

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody CategoryDto dto, @PathVariable Integer id){
		Category category = CategoryDto.fromDto(dto);
		categoryService.update(category, id);
		return ResponseEntity.noContent().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		categoryService.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/findByParams")
	public ResponseEntity<List<Category>> findByParams(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description) {
		List<Category> list = categoryService.findByParams(name, description);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/paginate")
	public ResponseEntity<Page<Category>> paginate(
			@RequestParam(value = "name") String name,
			@RequestParam(value = "description") String description,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "10") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "name") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC")String direction) {
		Page<Category> list = categoryService.paginate(page, linesPerPage, orderBy, direction, name, description);
		return ResponseEntity.ok(list);
	}
	
	@PostMapping("/save-many")
	public ResponseEntity<?> saveMany(@Valid @RequestBody List<CategoryDto> dtos) {
		List<Category> list = dtos
		.stream()
		.map(category -> CategoryDto.fromDto(category))
		.collect(Collectors.toList());
		categoryService.saveMany(list);
		return ResponseEntity.created(null).build();
	}
}

package br.com.finansys.dtos;

import java.io.Serializable;

import br.com.finansys.domain.Category;

public class CategoryDto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String name;
	private String description;

	public CategoryDto(Category category) {
		this.name = category.getName();
		this.description = category.getDescription();
	}

	public CategoryDto() {

	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public static Category fromDto(CategoryDto dto) {
		return new Category(null, dto.getName(), dto.getDescription());
	}
}

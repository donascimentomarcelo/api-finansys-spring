package br.com.finansys.services.validators.Impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.finansys.dtos.CategoryDto;
import br.com.finansys.resources.exceptions.FieldMessage;
import br.com.finansys.services.CategoryService;
import br.com.finansys.services.validators.CategoryValidator;

public class CategoryValidatorImpl implements ConstraintValidator<CategoryValidator, CategoryDto> {

	@Autowired
	private CategoryService categoryService;
	
	@Override
	public boolean isValid(CategoryDto dto, ConstraintValidatorContext context) {
		List<FieldMessage> exceptions = new ArrayList<>();
		
		if (categoryService.findByName(dto.getName()) != null) {
			exceptions.add(new FieldMessage("name", "This name alredy exists!"));
		}
		
		for (FieldMessage field : exceptions) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(field.getMessage())
				.addPropertyNode(field.getFieldName())
				.addConstraintViolation();
		}
		return exceptions.isEmpty();
	}

}

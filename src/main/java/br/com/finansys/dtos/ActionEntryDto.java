package br.com.finansys.dtos;

import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.com.finansys.domain.Entry;

public class ActionEntryDto {

	@NotEmpty(message = "The field NAME must be filled!")
	@Length(min=5, max=80, message="In field NAME, the size should be between 5 and 80 characters!")
	private String name;
	
	@NotEmpty(message = "The field DESCRIPTION must be filled!")
	@Length(min = 5, max=80, message = "In field DESCRIPTION, the size should be between 5 and 80 characters!")
	private String description;
	private String type;
	private Date date;
	private String paid;
	private String amount;
	private CategoryDto category;

	public ActionEntryDto(Entry entry) {
		this.name = entry.getName();
		this.description = entry.getDescription();
		this.type = entry.getType();
		this.date = entry.getDate();
		this.paid = entry.getPaid();
		this.amount = entry.getAmount();
		this.category = CategoryDto.fromDto(entry.getCategory());
	}

	public ActionEntryDto() {
	
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getPaid() {
		return paid;
	}

	public void setPaid(String paid) {
		this.paid = paid;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public CategoryDto getCategory() {
		return category;
	}

	public void setCategory(CategoryDto category) {
		this.category = category;
	}

	public static Entry fromEntry(ActionEntryDto dto) {
		return new Entry(null, dto.getName(), dto.getDescription(), dto.getType(), dto.getDate(), dto.getPaid(), dto.getAmount(), CategoryDto.fromDto(dto.getCategory()));
	}
}

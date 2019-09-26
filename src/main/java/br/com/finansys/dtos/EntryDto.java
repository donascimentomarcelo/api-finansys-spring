package br.com.finansys.dtos;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.finansys.domain.Entry;

public class EntryDto {

	private Integer id;
	private String name;
	private String description;
	private String type;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date date;
	private String paid;
	private String amount;
	private String category;

	public EntryDto(Entry entry) {
		this.id = entry.getId();
		this.name = entry.getName();
		this.description = entry.getDescription();
		this.type = entry.getType();
		this.date = entry.getDate();
		this.paid = entry.getPaid();
		this.amount = entry.getAmount();
		this.category = entry.getCategory().getName();
	}

	public EntryDto() {
	
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public static EntryDto fromDto(Entry entry) {
		return new EntryDto(entry);
	}
	
}

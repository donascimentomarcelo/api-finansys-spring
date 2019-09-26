package br.com.finansys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCategory")
	private Integer id;
	private String name;
	private String description;
	
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Entry> entries = new ArrayList<>();

	public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public Category() {

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
	public List<Entry> getEntries() {
		return entries;
	}
	public void setEntries(List<Entry> entries) {
		this.entries = entries;
	}
}

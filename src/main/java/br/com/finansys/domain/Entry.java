package br.com.finansys.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Entry {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqEntry")
	private String id;
	private String name;
	private String description;
	private String type;
	private Date date;
	private String paid;
	private String amount;
	
	@JoinColumn(name = "categoryId")
	@ManyToOne
	private Category category;

	public Entry(String id, String name, String description, String type, Date date, String paid, String amount,
			Category category) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.type = type;
		this.date = date;
		this.paid = paid;
		this.amount = amount;
		this.category = category;
	}

	public Entry() {
	
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
}

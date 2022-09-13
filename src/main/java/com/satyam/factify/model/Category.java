package com.satyam.factify.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.beans.factory.annotation.Required;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "category")
public class Category {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name", nullable = false, unique = true)
	@NotEmpty(message = "name can not be empty")
	@NotNull(message = "name can not be null")
	private String name;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "category")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<Fact> facts;
	
	public Category() {

	}

	public Category(String name) {
		this.name = name;
	}

	public List<Fact> getFacts() {
		return facts;
	}

	public void setFacts(List<Fact> facts) {
		this.facts = facts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "category [id=" + id + ", name=" + name + "]";
	}
	
	
}

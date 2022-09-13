package com.satyam.factify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.factify.model.Category;
import com.satyam.factify.service.CategoryService;

@Validated
@RestController
@RequestMapping("/api/category")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Category> getAllCategories() {
		return categoryService.findAll();
	}
	
	@GetMapping("/{id}")
	public Category findCategoryById(@PathVariable("id") int id) {
		return categoryService.findCategoryById(id);
	}
	
	@GetMapping("/byName/{name}")
	public Category findCategoryByName(@PathVariable("name") String name) {
		return categoryService.findCategoryByName(name);
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@Valid @NotNull @RequestBody Category category) {
		
		if(category == null) {
			throw new RuntimeException("Category can not be null. provide data");
		}
		
		Category newCategory = categoryService.findCategoryByName(category.getName());
		
		if(newCategory != null) {
			throw new RuntimeException("Category with the given name already exists. Category name must be unique.");
		}
		
		category.setId(0);
		categoryService.createCategory(category);
		return new ResponseEntity<Category>(category, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public Category updateCategory(@PathVariable("id") int id,@Valid @RequestBody Category category) {
		category.setId(id);
		categoryService.createCategory(category);
		return category;
	}
	
	@DeleteMapping("/{id}")
	public Category deleteCategory(@PathVariable("id") int id) {
		Category category =  categoryService.findCategoryById(id);
		
		
		if(category == null) {
			throw new RuntimeException("Category with the given id not found - " + id);
		}
		
		categoryService.deleteCategory(id);
		
		return category;
		
	}
	
	
}

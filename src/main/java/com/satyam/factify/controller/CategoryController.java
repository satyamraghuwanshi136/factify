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
	public ResponseEntity<List<Category>> getAllCategories() {
		List<Category> categoryList =  categoryService.findAll();
		
		return new ResponseEntity<List<Category>>(categoryList, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Category> findCategoryById(@PathVariable("id") int id) {
		Category category = categoryService.findCategoryById(id);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@GetMapping("/byName/{name}")
	public ResponseEntity<Category> findCategoryByName(@PathVariable("name") String name) {
		Category category = categoryService.findCategoryByName(name);
		return new ResponseEntity<Category>(category, HttpStatus.OK);
	}
	
	@PostMapping("/")
	public ResponseEntity<Category> createCategory(@Valid @NotNull @RequestBody Category category) {
		
		if(category == null) {
			throw new RuntimeException("Category can not be null. provide data");
		}
		
		Category responseCategory = categoryService.createCategory(category);
		return new ResponseEntity<Category>(responseCategory, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Category> updateCategory(@PathVariable("id") int id,@Valid @RequestBody Category category) {
		category.setId(id);
		
		Category responseCategory = categoryService.updateCategory(id,category);
		return new ResponseEntity<Category>(responseCategory, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
		categoryService.deleteCategory(id);
		String message = "Category with the given ID : " + id + " is deleted successfully.";
		return new ResponseEntity<String>(message, HttpStatus.OK);
		
	}
	
	
}

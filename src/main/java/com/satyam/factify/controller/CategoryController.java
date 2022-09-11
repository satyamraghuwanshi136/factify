package com.satyam.factify.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@PostMapping("/")
	public Category createCategory(@RequestBody Category category) {
		category.setId(0);
		categoryService.createCategory(category);
		return category;
	}
	
	@PutMapping("/{id}")
	public Category createCategory(@PathVariable("id") int id, @RequestBody Category category) {
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
		System.out.println(category);
		categoryService.deleteCategory(id);
		
		return category;
		
	}
	
	
}

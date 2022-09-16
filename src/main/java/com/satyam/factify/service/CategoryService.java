package com.satyam.factify.service;

import java.util.List;

import com.satyam.factify.model.Category;

public interface CategoryService {
	
	public List<Category> findAll();
	public Category createCategory(Category category);
	public Category updateCategory(int id, Category category);
	public Category findCategoryById(int id);
	public void deleteCategory(int id);
	public Category findCategoryByName(String name);

}

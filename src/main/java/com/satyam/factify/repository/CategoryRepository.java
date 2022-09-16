package com.satyam.factify.repository;

import java.util.List;

import com.satyam.factify.model.Category;

public interface CategoryRepository {
	
	public List<Category> findAll();
	
	public Category createCategory(Category category);
	
	public Category findCategoryById(int id);
	
	public void deleteCategory(int id);
	
	public Category findCategoryByName(String name);

	public Category updateCategory(Category category);
}

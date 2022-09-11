package com.satyam.factify.repository;

import java.util.List;

import com.satyam.factify.model.Category;

public interface CategoryRepository {
	
	public List<Category> findAll();
	
	public void createCategory(Category category);
	
	public Category findCategoryById(int id);
	
	public void deleteCategory(int id);
}

package com.satyam.factify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.factify.exceptionhandling.CategoryAlreadyExistsException;
import com.satyam.factify.exceptionhandling.CategoryNotFoundException;
import com.satyam.factify.model.Category;
import com.satyam.factify.repository.CategoryRepository;


@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public List<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Category createCategory(Category category) {
		List<Category> newCategory = categoryRepository.findByName(category.getName());
		
		if(!newCategory.isEmpty()) {
			throw new CategoryAlreadyExistsException("Category with the given name already exists. Category name must be unique.");
		}
		return categoryRepository.save(category);
	}
	
	@Override
	public Category updateCategory(int id, Category category) {
		Optional<Category> result = categoryRepository.findById(id);
		
		if (!result.isPresent()) {
			throw new CategoryNotFoundException("Category with the given ID not Found. ID: " + id);
		}
		
		List<Category> dbCategory = categoryRepository.findByName(category.getName());
		
		if(!dbCategory.isEmpty()) {
			throw new CategoryAlreadyExistsException("Category with the given name already exists. Category name must be unique.");
		}
		
		return categoryRepository.save(category);
	}
	

	@Override
	public Category findCategoryById(int id) {
		
		Optional<Category> category = categoryRepository.findById(id);
		
		if (!category.isPresent()) {
			throw new CategoryNotFoundException("Category with the given ID not Found. ID: " + id);
		}
		return category.get();
	}
	
	@Override
	public void deleteCategory(int id) {
		Optional<Category> category = categoryRepository.findById(id);
		if (!category.isPresent()) {
			throw new CategoryNotFoundException("Category with the given ID not Found. ID: " + id);
		}
		categoryRepository.deleteById(id);
	}

	@Override
	public Category findCategoryByName(String name) {
		List<Category> category = categoryRepository.findByName(name);
		
		if(category.isEmpty()) {
			throw new CategoryNotFoundException("Category With the name: " + name + " not found.");
		}
		
		return category.get(0);
	}


}

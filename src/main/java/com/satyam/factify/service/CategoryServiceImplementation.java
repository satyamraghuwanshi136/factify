package com.satyam.factify.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.factify.model.Category;
import com.satyam.factify.repository.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	@Transactional
	public List<Category> findAll() {
		
		return categoryRepository.findAll();
	}

	@Override
	@Transactional
	public void createCategory(Category category) {
		categoryRepository.createCategory(category);
	}

	@Override
	@Transactional
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		return categoryRepository.findCategoryById(id);
	}
	
	@Override
	@Transactional
	public void deleteCategory(int id) {
		categoryRepository.deleteCategory(id);
	}
	

}

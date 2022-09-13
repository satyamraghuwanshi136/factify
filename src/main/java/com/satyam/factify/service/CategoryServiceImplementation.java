package com.satyam.factify.service;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.satyam.factify.exceptionhandling.ErrorResponse;
import com.satyam.factify.exceptionhandling.category.CategoryAlreadyExistsException;
import com.satyam.factify.exceptionhandling.category.CategoryNotFoundException;
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
		
		Category category = categoryRepository.findCategoryById(id);
		if (category == null) {
			throw new CategoryNotFoundException("Category with the given ID not Found. ID: " + id);
		}
		return category;
	}
	
	@Override
	@Transactional
	public void deleteCategory(int id) {
		Category category = categoryRepository.findCategoryById(id);
		if (category == null) {
			throw new CategoryNotFoundException("Category with the given ID not Found. ID: " + id);
		}
		categoryRepository.deleteCategory(id);
	}

	@Override
	public Category findCategoryByName(String name) {
		Category category = categoryRepository.findCategoryByName(name);
		
		if(category == null) {
			throw new CategoryNotFoundException("Category With the name: " + name + " not found.");
		}
		
		return category;
	}

}

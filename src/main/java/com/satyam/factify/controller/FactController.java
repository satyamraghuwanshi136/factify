package com.satyam.factify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.FactoryBeanNotInitializedException;
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
import com.satyam.factify.model.Fact;
import com.satyam.factify.service.CategoryService;
import com.satyam.factify.service.FactService;

@RestController
@RequestMapping("/api/fact")
public class FactController {
	
	@Autowired
	private FactService factService;
	
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/all")
	public List<Fact> getAllFacts() {
		return factService.findAll();
	}
	
	@GetMapping("/{id}")
	public Fact findFactById(@PathVariable("id") int id) {
		return factService.findFactById(id);
	}
	
	@PostMapping("/{categoryId}")
	public Fact createFact(@PathVariable("categoryId") int categoryId,@Valid @NotNull @RequestBody Fact fact) {
		fact.setId(0);
		Category category =  categoryService.findCategoryById(categoryId);
		
		if(category == null) {
			throw new RuntimeException("Category with the given id not found - " + categoryId);
		}
		
		fact.setCategory(category);
		
		factService.createFact(fact);
		return fact;
	}
	
	@PutMapping("/{categoryId}/{factId}")
	public Fact updateFact(@PathVariable("categoryId") int categoryId, @PathVariable("factId") int factId,@Valid @NotNull @RequestBody Fact fact) {
		fact.setId(factId);
		Category category =  categoryService.findCategoryById(categoryId);
		
		if(category == null) {
			throw new RuntimeException("Category with the given id not found - " + categoryId);
		}
		
		fact.setCategory(category);
		factService.createFact(fact);
		return fact;
	}
	
	@DeleteMapping("/{id}")
	public Fact deleteCategory(@PathVariable("id") int id) {
		Fact fact =  factService.findFactById(id);
		
		
		if(fact == null) {
			throw new RuntimeException("Fact with the given id not found - " + id);
		}
	
		factService.deleteFact(id);
		
		return fact;
	}
	
	
}

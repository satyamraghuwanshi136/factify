package com.satyam.factify.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.FactoryBeanNotInitializedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.satyam.factify.exceptionhandling.CategoryNotFoundException;
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
	public ResponseEntity<List<Fact>> getAllFacts() {
		List<Fact> facts =  factService.findAll();
		return new ResponseEntity<List<Fact>>(facts, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fact> findFactById(@PathVariable("id") int id) {
		Fact fact = factService.findFactById(id);
		return new ResponseEntity<Fact>(fact, HttpStatus.OK);
	}
	
	@PostMapping("/{categoryId}")
	public ResponseEntity<Fact> createFact(@PathVariable("categoryId") int categoryId,@Valid @NotNull @RequestBody Fact fact) {
		fact.setId(0);
		Category category =  categoryService.findCategoryById(categoryId);
		
		if(category == null) {
			throw new CategoryNotFoundException("Category with the given id not found - " + categoryId);
		}
		
		fact.setCategory(category);
		
		factService.createFact(fact);
		
		return new ResponseEntity<Fact>(fact, HttpStatus.CREATED);
	}
	
	@PutMapping("/{categoryId}/{factId}")
	public ResponseEntity<Fact> updateFact(@PathVariable("categoryId") int categoryId, @PathVariable("factId") int factId,@Valid @NotNull @RequestBody Fact fact) {
		fact.setId(factId);
		Category category =  categoryService.findCategoryById(categoryId);
		
		if(category == null) {
			throw new CategoryNotFoundException("Category with the given id not found - " + categoryId);
		}
		
		
		fact.setCategory(category);
		factService.updateFact(factId, fact);
		return new ResponseEntity<Fact>(fact, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable("id") int id) {
		factService.deleteFact(id);
		String message = "Fact with the given ID : " + id + " is deleted successfully.";
		return new ResponseEntity<String>(message, HttpStatus.OK);
	}
	
	
}

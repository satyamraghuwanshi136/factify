package com.satyam.factify.repository;

import java.util.List;

import com.satyam.factify.model.Category;
import com.satyam.factify.model.Fact;

public interface FactRepository {
	
	public List<Fact> findAll();
	
	public void createFact(Fact fact);
	
	public Fact findFactById(int id);
	
	public void deleteFact(int id);

	public void updateFact(Fact fact);
}

package com.satyam.factify.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.satyam.factify.model.Category;
import com.satyam.factify.model.Fact;

public interface FactService {
	
	public List<Fact> findAll();
	public void createFact(Fact fact);
	public Fact findFactById(int id);
	public void deleteFact(int id);
	public void updateFact(int factId, Fact fact);

}

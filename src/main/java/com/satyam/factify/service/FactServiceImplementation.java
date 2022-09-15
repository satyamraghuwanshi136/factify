package com.satyam.factify.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.satyam.factify.exceptionhandling.FactNotFoundException;
import com.satyam.factify.model.Fact;
import com.satyam.factify.repository.FactRepository;

@Service
public class FactServiceImplementation implements FactService {

	@Autowired
	FactRepository factRepository;
	
	@Override
	@Transactional
	public List<Fact> findAll() {
		return factRepository.findAll();
	}

	@Override
	@Transactional
	public void createFact(Fact fact) {
		factRepository.createFact(fact);
	}
	
	@Override
	@Transactional
	public void updateFact(int factId, Fact fact) {
		Fact newFact = factRepository.findFactById(factId);
		
		if(newFact == null) {
			throw new FactNotFoundException("Fact with the given ID: "+ factId + " does Not Found");
		}
		factRepository.updateFact(fact);
	}

	@Override
	@Transactional
	public Fact findFactById(int id) {
		Fact fact = factRepository.findFactById(id);
		if(fact == null) {
			throw new FactNotFoundException("Fact with the given ID: "+ id + " does Not Found");
		}
		return factRepository.findFactById(id);
	}

	@Override
	@Transactional
	public void deleteFact(int id) {
		Fact fact =  factRepository.findFactById(id);
			
		if(fact == null) {
			throw new FactNotFoundException("Fact with the given ID: "+ id + " does Not Found");
		}
	
		factRepository.deleteFact(id);
	}

}

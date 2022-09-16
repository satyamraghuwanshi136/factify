package com.satyam.factify.service;

import java.util.List;
import java.util.Optional;

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
	public Fact createFact(Fact fact) {
		return factRepository.save(fact);
	}
	
	@Override
	public Fact updateFact(int factId, Fact fact) {
		Optional<Fact> newFact = factRepository.findById(factId);
		
		if(!newFact.isPresent()) {
			throw new FactNotFoundException("Fact with the given ID: "+ factId + " does Not Found");
		}
		return factRepository.save(fact);
	}

	@Override
	public Fact findFactById(int id) {
		Optional<Fact> fact = factRepository.findById(id);
		if(!fact.isPresent()) {
			throw new FactNotFoundException("Fact with the given ID: "+ id + " does Not Found");
		}
		return fact.get();
	}

	@Override
	public void deleteFact(int id) {
		Optional<Fact> fact =  factRepository.findById(id);
			
		if(!fact.isPresent()) {
			throw new FactNotFoundException("Fact with the given ID: "+ id + " does Not Found");
		}
	
		factRepository.deleteById(id);
	}

}

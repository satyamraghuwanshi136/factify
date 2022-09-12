package com.satyam.factify.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Fact findFactById(int id) {
		return factRepository.findFactById(id);
	}

	@Override
	@Transactional
	public void deleteFact(int id) {
		factRepository.deleteFact(id);
	}

}

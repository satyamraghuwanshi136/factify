package com.satyam.factify.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyam.factify.model.Fact;


@Repository
public class FactRepositoryImplementation implements FactRepository {
	
	@Autowired
	EntityManager entityManager;
	

	@Override
	public List<Fact> findAll() {
		
		TypedQuery<Fact> query = entityManager.createQuery("from Fact", Fact.class);
		
		List<Fact> facts = query.getResultList();
		
		return facts;
	}

	@Override
	public Fact createFact(Fact fact) {
		return entityManager.merge(fact);
	}
	
	@Override
	public Fact updateFact(Fact fact) {
		return entityManager.merge(fact);
	}

	@Override
	public Fact findFactById(int id) {
		Fact fact =  entityManager.find(Fact.class, id);
		return fact;
	}

	@Override
	public void deleteFact(int id) {
		Query query = entityManager.createQuery("delete from Fact where id=:factId");
		query.setParameter("factId", id);
		
		query.executeUpdate();
	}

}

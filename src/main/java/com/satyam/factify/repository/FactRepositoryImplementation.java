package com.satyam.factify.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyam.factify.model.Category;
import com.satyam.factify.model.Fact;
import com.satyam.factify.service.CategoryService;


@Repository
public class FactRepositoryImplementation implements FactRepository {
	
	@Autowired
	EntityManager entityManager;
	
	@Autowired
	CategoryService categoryService;

	@Override
	public List<Fact> findAll() {
		Session session = entityManager.unwrap(Session.class);
		
		Query<Fact> query = session.createQuery("from Fact", Fact.class);
		
		List<Fact> facts = query.getResultList();
		
		return facts;
	}

	@Override
	public void createFact(Fact fact) {
		Session session = entityManager.unwrap(Session.class);
//		Category category = categoryService.findCategoryById(fact.getCategory().getId());
//		System.out.prinln(fact);
		session.saveOrUpdate(fact);
	}

	@Override
	public Fact findFactById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Fact fact =  session.find(Fact.class, id);
		return fact;
	}

	@Override
	public void deleteFact(int id) {
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Fact where id=:factId");
		query.setParameter("factId", id);
		
		query.executeUpdate();
	}

}

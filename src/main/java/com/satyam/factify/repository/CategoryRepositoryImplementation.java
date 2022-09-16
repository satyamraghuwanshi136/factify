package com.satyam.factify.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyam.factify.model.Category;


@Repository
public class CategoryRepositoryImplementation implements CategoryRepository {

	@Autowired
	private EntityManager entityManager;


	@Override
	public List<Category> findAll() {
		TypedQuery<Category> query = entityManager.createQuery("from Category", Category.class);
		
		List<Category> categories = query.getResultList();
		
		return categories;
	}


	@Override
	public Category createCategory(Category category) {
		return entityManager.merge(category);
	}
	
	@Override
	public Category updateCategory(Category category) {
		return entityManager.merge(category);
	}


	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		Category category =  entityManager.find(Category.class, id);
		return category;
	}


	@Override
	public void deleteCategory(int id) {
		Query query = entityManager.createQuery("delete from Category where id=:categoryId");
		query.setParameter("categoryId", id);
		
		query.executeUpdate();
	}


	@Override
	public Category findCategoryByName(String name) {
		Query query = entityManager.createQuery("from Category where name=:categoryName");
		query.setParameter("categoryName", name);
		
		List<Category> categories = (List<Category>) query.getResultList();
		if(categories.isEmpty()) return null;
		return categories.get(0);
	}

}

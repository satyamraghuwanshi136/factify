package com.satyam.factify.repository;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.satyam.factify.model.Category;


@Repository
public class CategoryRepositoryImplementation implements CategoryRepository {

	@Autowired
	private EntityManager entityManager;


	@Override
	public List<Category> findAll() {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		Query<Category> query = session.createQuery("from Category", Category.class);
		
		List<Category> categories = query.getResultList();
		
		return categories;
	}


	@Override
	public void createCategory(Category category) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		
		session.saveOrUpdate(category);
	}


	@Override
	public Category findCategoryById(int id) {
		// TODO Auto-generated method stub
		Session session = entityManager.unwrap(Session.class);
		Category category =  session.find(Category.class, id);
		return category;
	}


	@Override
	public void deleteCategory(int id) {
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("delete from Category where id=:categoryId");
		query.setParameter("categoryId", id);
		
		query.executeUpdate();
	}


	@Override
	public Category findCategoryByName(String name) {
		Session session = entityManager.unwrap(Session.class);

		Query query = session.createQuery("from Category where name=:categoryName");
		query.setParameter("categoryName", name);
		
		Category newCategory = (Category) query.uniqueResult();
		
		return newCategory;
	}

}

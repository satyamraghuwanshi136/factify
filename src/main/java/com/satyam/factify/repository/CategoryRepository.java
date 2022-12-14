package com.satyam.factify.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyam.factify.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{
	List<Category> findByName(String name);
}

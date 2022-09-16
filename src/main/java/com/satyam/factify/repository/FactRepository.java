package com.satyam.factify.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.satyam.factify.model.Fact;

public interface FactRepository extends JpaRepository<Fact, Integer>{

}

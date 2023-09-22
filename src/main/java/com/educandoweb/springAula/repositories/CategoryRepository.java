package com.educandoweb.springAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springAula.entities.Category;


// VARIAS OPERAÇÕES PARA TRABALHAR COM USUARIO //
public interface CategoryRepository extends JpaRepository<Category, Long> {
	
}

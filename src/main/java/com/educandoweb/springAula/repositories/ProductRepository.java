package com.educandoweb.springAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springAula.entities.Product;


// VARIAS OPERAÇÕES PARA TRABALHAR COM USUARIO //
public interface ProductRepository extends JpaRepository<Product, Long> {
	
}

package com.educandoweb.springAula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springAula.entities.Product;
import com.educandoweb.springAula.repositories.ProductRepository;

// @Component // REGISTRA A CLASSE COMO COMPONENTE DO SPRING E PODERA SER INJETADO AUTOMATICAMENTE PELO @AUTOWIRED //
@Service // REGISTRAR UM SERVIÇO NA CAMADA DE SERVIÇO //
public class ProductService {
	@Autowired
	private ProductRepository repository;
	
	// BUSCA TOTAL //
	public List<Product> findAll(){
		return repository.findAll();
	}
	
	// BUSCAR POR ID //
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
	}

}

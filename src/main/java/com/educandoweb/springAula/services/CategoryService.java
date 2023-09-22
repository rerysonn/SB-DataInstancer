package com.educandoweb.springAula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springAula.entities.Category;
import com.educandoweb.springAula.repositories.CategoryRepository;

// @Component // REGISTRA A CLASSE COMO COMPONENTE DO SPRING E PODERA SER INJETADO AUTOMATICAMENTE PELO @AUTOWIRED //
@Service // REGISTRAR UM SERVIÇO NA CAMADA DE SERVIÇO //
public class CategoryService {
	@Autowired
	private CategoryRepository repository;
	
	// BUSCA TOTAL //
	public List<Category> findAll(){
		return repository.findAll();
	}
	
	// BUSCAR POR ID //
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
	}

}

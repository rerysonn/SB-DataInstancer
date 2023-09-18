package com.educandoweb.springAula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springAula.entities.User;
import com.educandoweb.springAula.repositories.UserRepository;

// @Component // REGISTRA A CLASSE COMO COMPONENTE DO SPRING E PODERA SER INJETADO AUTOMATICAMENTE PELO @AUTOWIRED //
@Service // REGISTRAR UM SERVIÇO NA CAMADA DE SERVIÇO //
public class UserService {
	@Autowired
	private UserRepository repository;
	
	// BUSCA TOTAL //
	public List<User> findAll(){
		return repository.findAll();
	}
	
	// BUSCAR POR ID //
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
	}

}

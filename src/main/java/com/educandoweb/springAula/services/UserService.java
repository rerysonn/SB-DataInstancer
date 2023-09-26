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
	// INSERÇÃO DE USUARIOS //
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//DELEÇÃO DO USUARIO
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	//ATUALIZAR O USUARIO
	public User update(Long id, User obj) {
		User entity = repository.getReferenceById(id);
		updateData(entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}

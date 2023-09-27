package com.educandoweb.springAula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.educandoweb.springAula.entities.User;
import com.educandoweb.springAula.repositories.UserRepository;
import com.educandoweb.springAula.services.exceptions.DatabaseException;
import com.educandoweb.springAula.services.exceptions.ResourceNotFoundException;

import jakarta.persistence.EntityNotFoundException;

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
		return obj.orElseThrow(() -> new ResourceNotFoundException(id));
	}
	// INSERÇÃO DE USUARIOS //
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//DELEÇÃO DO USUARIO
	public void delete(Long id){
	    try {
	        if(!repository.existsById(id)) throw new ResourceNotFoundException(id);
	        repository.deleteById(id);
	    }catch (EmptyResultDataAccessException e){
	        throw new ResourceNotFoundException(id);
	    }catch(DataIntegrityViolationException e) {
	    	throw new DatabaseException(e.getMessage());
	    }
	}
	
	//ATUALIZAR O USUARIO
	public User update(Long id, User obj) {
		try {
			User entity = repository.getReferenceById(id);
			updateData(entity, obj);
			return repository.save(entity);
	}catch(EntityNotFoundException e) {
		 throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}

}

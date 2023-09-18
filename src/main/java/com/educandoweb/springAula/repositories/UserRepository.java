package com.educandoweb.springAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springAula.entities.User;


// VARIAS OPERAÇÕES PARA TRABALHAR COM USUARIO //
public interface UserRepository extends JpaRepository<User, Long> {
	
}

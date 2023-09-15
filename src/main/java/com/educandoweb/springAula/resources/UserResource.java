package com.educandoweb.springAula.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springAula.entities.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	// ENDPOINT PARA ACESSAR OS USUARIOS //
	  // RETORNAR RESPOSTAS DE REQUISIÇÕES WEB //
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(11L, "Reryson", "reryson@gmail", "999999", "12345");
		return ResponseEntity.ok().body(u);
		
	}

}

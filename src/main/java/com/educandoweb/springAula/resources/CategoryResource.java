package com.educandoweb.springAula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springAula.entities.Category;
import com.educandoweb.springAula.services.CategoryService;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {
	@Autowired
	private CategoryService service;
	
	// ENDPOINT PARA ACESSAR OS USUARIOS //
	  // RETORNAR RESPOSTAS DE REQUISIÇÕES WEB //
	@GetMapping
	public ResponseEntity<List<Category>> findAll(){		
		List<Category> list = service.findAll();	
		return ResponseEntity.ok().body(list);
	}
	// INDICAR QUE A REQUISIÇÃO VAI ACEITAR UM ID DENTRO DA URL
	@GetMapping(value  = "/{id}")
	public ResponseEntity<Category> findbyId(@PathVariable Long  id){
		Category obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}

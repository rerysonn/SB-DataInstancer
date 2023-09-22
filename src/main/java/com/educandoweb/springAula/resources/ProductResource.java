package com.educandoweb.springAula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.educandoweb.springAula.entities.Product;
import com.educandoweb.springAula.services.ProductService;

@RestController
@RequestMapping(value = "/products")
public class ProductResource {
	@Autowired
	private ProductService service;
	
	// ENDPOINT PARA ACESSAR OS USUARIOS //
	  // RETORNAR RESPOSTAS DE REQUISIÇÕES WEB //
	@GetMapping
	public ResponseEntity<List<Product>> findAll(){		
		List<Product> list = service.findAll();	
		return ResponseEntity.ok().body(list);
	}
	// INDICAR QUE A REQUISIÇÃO VAI ACEITAR UM ID DENTRO DA URL
	@GetMapping(value  = "/{id}")
	public ResponseEntity<Product> findbyId(@PathVariable Long  id){
		Product obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

}

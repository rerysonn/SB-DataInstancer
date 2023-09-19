package com.educandoweb.springAula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.educandoweb.springAula.entities.Order;
import com.educandoweb.springAula.repositories.OrderRepository;

// @Component // REGISTRA A CLASSE COMO COMPONENTE DO SPRING E PODERA SER INJETADO AUTOMATICAMENTE PELO @AUTOWIRED //
@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;

	public List<Order> findAll() {
		return repository.findAll();
	}

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}
}



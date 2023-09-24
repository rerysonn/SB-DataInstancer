package com.educandoweb.springAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springAula.entities.OrderItem;


// VARIAS OPERAÇÕES PARA TRABALHAR COM USUARIO //
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
	
}

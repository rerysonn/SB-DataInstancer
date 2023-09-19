package com.educandoweb.springAula.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.springAula.entities.Order;


// VARIAS OPERAÇÕES PARA TRABALHAR COM USUARIO //
public interface OrderRepository extends JpaRepository<Order, Long> {

}

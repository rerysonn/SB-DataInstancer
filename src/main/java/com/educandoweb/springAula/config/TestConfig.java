// PERFIL DE TESTE: ESTE CODIGO É UMA CONFIGURAÇÃO DE TESTE QUE CRIA INSTANCIAS DO TIPO 'Usuarios' e 'Pedido' E AS SALVA NO BANCO DE DADOS //

package com.educandoweb.springAula.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.springAula.entities.Order;
import com.educandoweb.springAula.entities.User;
import com.educandoweb.springAula.repositories.OrderRepository;
import com.educandoweb.springAula.repositories.UserRepository;

@Configuration // CONFIG EXPECIFICA DE TESTE //
@Profile("test") // SOMENTE NO PERFIL DE TESTE //
public class TestConfig implements CommandLineRunner {
	
	@Autowired // SPRING QUANDO RODANDO A APLICAÇÃO RESOLVE A DEPENDENCIA INSTANCIANDO UM UserRepository //
	private UserRepository userRepository;
	
	
	@Autowired
	private OrderRepository orderRepository;

	
	// TUDO OQ COLOCAR DENTRO DO METODO, SERA EXECUTADO QUANDO A APLICAÇÃO FOR EXECUTADA //
		// NULL NO ID: PQ O ID SERA GERADO PELO BANCO DE DADOS //
	@Override	
	public void run(String... args) throws Exception {
		// INSTANCIAR O BANCO DE DADOS COM USUARIOS //
		User u1 = new User(null, "Davi Santos", "davi@gmail.com", "977389474", "paysandu");
		User u2 = new User(null, "Pedro goncalves", "pedro@gmail.com", "977389474", "345535");
		
		// INSTANCIAR O BANCO DE DADOS COM PEDIDOS ASSOCIADAS AOS USUARIOS //
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		// SALVAR AS INTANCIAS NO BANCO DE DADOS 
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
	
	
}

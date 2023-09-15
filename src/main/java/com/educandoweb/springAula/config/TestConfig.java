package com.educandoweb.springAula.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.springAula.entities.User;
import com.educandoweb.springAula.repositories.UserRepository;

@Configuration // CONFIG EXPECIFICA DE TESTE //
@Profile("test") // SOMENTE NO PERFIL DE TESTE //
public class TestConfig implements CommandLineRunner {
	
	@Autowired // SPRING QUANDO RODANDO A APLICAÇÃO RESOLVE A DEPENDENCIA INSTANCIANDO UM UserRepository //
	private UserRepository userRepository;

	
	// TUDO OQ COLOCAR DENTRO DO METODO, SERA EXECUTADO QUANDO A APLICAÇÃO FOR EXECUTADA //
		// NULL NO ID: PQ O ID SERA GERADO PELO BANCO DE DADOS //
	@Override	
	public void run(String... args) throws Exception {
		// INSTANCIAR O BANCO DE DADOS //
		User u1 = new User(null, "Davi Santos", "davi@gmail.com", "977389474", "paysandu");
		User u2 = new User(null, "Pedro goncalves", "pedro@gmail.com", "977389474", "345535");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	
	
}

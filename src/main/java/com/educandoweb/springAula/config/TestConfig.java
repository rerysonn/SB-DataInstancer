// PERFIL DE TESTE: ESTE CODIGO É UMA CONFIGURAÇÃO DE TESTE QUE CRIA INSTANCIAS DO TIPO 'Usuarios' e 'Pedido' E AS SALVA NO BANCO DE DADOS //

package com.educandoweb.springAula.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.educandoweb.springAula.entities.Category;
import com.educandoweb.springAula.entities.Order;
import com.educandoweb.springAula.entities.OrderItem;
import com.educandoweb.springAula.entities.Payment;
import com.educandoweb.springAula.entities.Product;
import com.educandoweb.springAula.entities.User;
import com.educandoweb.springAula.entities.enums.OrderStatus;
import com.educandoweb.springAula.repositories.CategoryRepository;
import com.educandoweb.springAula.repositories.OrderItemRepository;
import com.educandoweb.springAula.repositories.OrderRepository;
import com.educandoweb.springAula.repositories.ProductRepository;
import com.educandoweb.springAula.repositories.UserRepository;

@Configuration // CONFIG EXPECIFICA DE TESTE //
@Profile("test") // SOMENTE NO PERFIL DE TESTE //
public class TestConfig implements CommandLineRunner {
	
	@Autowired // SPRING QUANDO RODANDO A APLICAÇÃO RESOLVE A DEPENDENCIA INSTANCIANDO UM UserRepository //
	private UserRepository userRepository;
		
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	
	// TUDO OQ COLOCAR DENTRO DO METODO, SERA EXECUTADO QUANDO A APLICAÇÃO FOR EXECUTADA //
		// NULL NO ID: PQ O ID SERA GERADO PELO BANCO DE DADOS //
	@Override	
	public void run(String... args) throws Exception {
		// INSTANCIAR O BANCO DE DADOS COM CATEGORIAS //
		Category cat1 = new Category(null, "Eletronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
	
		// SALVAR AS INTANCIAS NO BANCO DE DADOS 
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// ASSOCIAÇÃO DE CATEGORIAS COM PRODUTOS
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		// SALVAR AS INTANCIAS NO BANCO DE DADOS 
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		// INSTANCIAR O BANCO DE DADOS COM USUARIOS //
		User u1 = new User(null, "Davi Santos", "davi@gmail.com", "977389474", "paysandu");
		User u2 = new User(null, "Pedro Sherring", "pedro@gmail.com", "977389474", "345535");
		
		// INSTANCIAR O BANCO DE DADOS COM PEDIDOS ASSOCIADAS AOS USUARIOS //
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.WAITING_PAYMENT, u1);
		
		// SALVAR OS PEDIDOS NO BANCO DE DADOS 
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPayment(pay1);
		
		orderRepository.save(o1);
	}
	
	
}

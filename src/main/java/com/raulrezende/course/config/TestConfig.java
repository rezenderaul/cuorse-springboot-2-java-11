package com.raulrezende.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.raulrezende.course.entities.Order;
import com.raulrezende.course.entities.User;
import com.raulrezende.course.repositories.OrderRepository;
import com.raulrezende.course.repositories.UserRepository;

@Configuration // Informa ao Spring que é uma classe de configuração
@Profile("test") // Indica que a classe será uma config específica do pefil de test
public class TestConfig implements CommandLineRunner{

	@Autowired // Mecanismo de injeção de dependência implicíto do Spring
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public void run(String... args) throws Exception {
		// Tudo que estiver dentro desse método será executado automaticamente
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456"); 
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), u1); 
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), u2); 
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), u1);
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
	}
}

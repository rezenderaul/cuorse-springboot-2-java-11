package com.raulrezende.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulrezende.course.entities.Order;
import com.raulrezende.course.repositories.OrderRepository;

@Service // Registra a classe como serviço do spring, podendo assim ser injetado automáticamente
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	public List<Order> findAll() {
		return repository.findAll();
	}
	
	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
		// A operação get do Optional retorna, um objeto do tipo declarado
	}
}

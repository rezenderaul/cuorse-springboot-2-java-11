package com.raulrezende.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulrezende.course.entities.Product;
import com.raulrezende.course.repositories.ProductRepository;

@Service // Registra a classe como serviço do spring, podendo assim ser injetado automáticamente
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	public List<Product> findAll() {
		return repository.findAll();
	}
	
	public Product findById(Long id) {
		Optional<Product> obj = repository.findById(id);
		return obj.get();
		// A operação get do Optional retorna, um objeto do tipo declarado
	}
}

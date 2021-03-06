package com.raulrezende.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulrezende.course.entities.Category;
import com.raulrezende.course.repositories.CategoryRepository;

@Service // Registra a classe como serviço do spring, podendo assim ser injetado automáticamente
public class CategoryService {

	@Autowired
	private CategoryRepository repository;
	
	public List<Category> findAll() {
		return repository.findAll();
	}
	
	public Category findById(Long id) {
		Optional<Category> obj = repository.findById(id);
		return obj.get();
		// A operação get do Optional retorna, um objeto do tipo declarado
	}
}

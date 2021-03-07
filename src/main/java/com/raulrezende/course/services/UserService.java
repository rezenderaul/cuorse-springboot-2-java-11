package com.raulrezende.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.raulrezende.course.entities.User;
import com.raulrezende.course.repositories.UserRepository;

@Service // Registra a classe como serviço do spring, podendo assim ser injetado automáticamente
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public List<User> findAll() {
		return repository.findAll();
	}
	
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.get();
		// A operação get do Optional retorna, um objeto do tipo declarado
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
}

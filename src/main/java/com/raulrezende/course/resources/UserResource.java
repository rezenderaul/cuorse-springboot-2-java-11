package com.raulrezende.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulrezende.course.entities.User;
import com.raulrezende.course.services.UserService;

// Controlador rest que responde no caminho users
@RestController // informa que esta classe é um recurso web, implementado por um contralador REST
@RequestMapping(value="/users") // Nome e caminho do recurso (endpoint)
public class UserResource {

	@Autowired
	private UserService service;
	
	@GetMapping // Responde a requisições do tipo get do http
	public ResponseEntity<List<User>> findAll() {
		// ResponseEntity<T>: tipo específico do spring para retornar respostas de requisições web
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}") // Indica que a requisição aceita um id na url
	public ResponseEntity<User> findById(@PathVariable Long id) {
		// @PathVariable indica que o parametro será passado por url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
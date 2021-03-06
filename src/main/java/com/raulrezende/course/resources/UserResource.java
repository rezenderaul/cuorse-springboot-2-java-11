package com.raulrezende.course.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulrezende.course.entities.User;

// Controlador rest que responde no caminho users
@RestController // informa que esta classe é um recurso web, implementado por um contralador REST
@RequestMapping(value="/users") // Nome e caminho do recurso (endpoint)
public class UserResource {

	@GetMapping // Responde a requisições do tipo get do http
	public ResponseEntity<User> findAll() {
		// ResponseEntity<T>: tipo específico do spring para retornar respostas de requisições web
		User u = new User(1L, "Maria", "maria@gamil.com", "99999", "12345");
		return ResponseEntity.ok().body(u);
	}
}

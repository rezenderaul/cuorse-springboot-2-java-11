package com.raulrezende.course.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.raulrezende.course.entities.User;
import com.raulrezende.course.services.UserService;

// Controlador rest que responde no caminho users
@RestController // informa que esta classe é um recurso web, implementado por um contralador REST
@RequestMapping(value="/users") // Nome e caminho do recurso (endpoint)
public class UserResource {

	@Autowired
	private UserService service;
	
	// Utiliza-se o método get para retornar dados do banco de dados
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
	
	// Utiliza-se o método post para inserir dados no banco de dados
	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) {
		// @RequestBody -> O atributo será um json e depois desserializado no objeto User
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(obj.getId()).toUri();
		// Retorna uma uri do registro criado no banco de dados
		return ResponseEntity.created(uri).body(obj);
		// Retorna o resposta 201 com caminho para acessar o registro criado
	}
}
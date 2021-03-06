package com.raulrezende.course.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raulrezende.course.entities.Order;
import com.raulrezende.course.services.OrderService;

// Controlador rest que responde no caminho users
@RestController // informa que esta classe é um recurso web, implementado por um contralador REST
@RequestMapping(value="/orders") // Nome e caminho do recurso (endpoint)
public class OrderResource {

	@Autowired
	private OrderService service;
	
	@GetMapping // Responde a requisições do tipo get do http
	public ResponseEntity<List<Order>> findAll() {
		// ResponseEntity<T>: tipo específico do spring para retornar respostas de requisições web
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value="/{id}") // Indica que a requisição aceita um id na url
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		// @PathVariable indica que o parametro será passado por url
		Order obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}
}
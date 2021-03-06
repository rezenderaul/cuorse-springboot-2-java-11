package com.raulrezende.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raulrezende.course.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
// Nesse caso, não é necessário criar a implementação da interface, 
// pois o Spring Data JPA já tem um implementação padrão para essa interface
}

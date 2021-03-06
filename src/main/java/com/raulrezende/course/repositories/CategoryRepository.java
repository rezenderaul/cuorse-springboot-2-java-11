package com.raulrezende.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raulrezende.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
/* 
* Não é necessário colocar @Repository, pois a classe está herdando o JpaRepository, que já é
* um repositório do spring
* Nesse caso, não é necessário criar a implementação da interface, 
* pois o Spring Data JPA já tem um implementação padrão para essa interface
**/
}

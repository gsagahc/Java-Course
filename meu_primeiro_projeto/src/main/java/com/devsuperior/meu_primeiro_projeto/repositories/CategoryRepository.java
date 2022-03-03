package com.devsuperior.meu_primeiro_projeto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.devsuperior.meu_primeiro_projeto.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
	

}

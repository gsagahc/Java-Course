package com.gui.br.vendas.aplicativodevendas.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public interface CategoriaRepository  extends JpaRepository<Categoria, Long> {
	List<Categoria> findByName(String name);

}

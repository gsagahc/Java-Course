package com.gui.br.vendas.aplicativodevendas.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Estoque;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public interface EstoqueRepository  extends JpaRepository<Estoque, Long> {
	List<Estoque> findByProduto(String nome);


}

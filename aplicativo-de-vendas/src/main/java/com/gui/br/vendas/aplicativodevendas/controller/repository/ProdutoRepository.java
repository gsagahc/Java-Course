package com.gui.br.vendas.aplicativodevendas.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public interface ProdutoRepository  extends JpaRepository<Produto, Long> {
	List<Produto> findByNome(String nome);

}

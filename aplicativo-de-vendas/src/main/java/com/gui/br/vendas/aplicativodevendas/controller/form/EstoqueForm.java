package com.gui.br.vendas.aplicativodevendas.controller.form;

import javax.persistence.OneToOne;

import com.gui.br.vendas.aplicativodevendas.controller.repository.EstoqueRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Estoque;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public class EstoqueForm {
	
	private Long quantidade;
	@OneToOne
	private Produto produto;
	
	
	

	public Long getQuantidade() {
		return quantidade;
	}



	public Produto getProduto() {
		return produto;
	}



	public Estoque converter(EstoqueRepository estoquerepository) {
		
		return new Estoque(getQuantidade(), getProduto());
	}
}

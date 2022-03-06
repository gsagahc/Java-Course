package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Estoque;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public class EstoqueDto {
	private Long id;
	private Long quantidade;
	private Produto produto;


	

	public EstoqueDto(Estoque estoque) {
		this.id= estoque.getId();
		this.quantidade = estoque.getQuantidade();
		this.produto = estoque.getProduto();
	
	}


	public Long getId() {
		return id;
	}




	public Long getQuantidade() {
		return quantidade;
	}


	


	public Produto getProduto() {
		return produto;
	}



	public static List <EstoqueDto> converter(List<Estoque>estoque){
		return estoque.stream().map(EstoqueDto::new).collect(Collectors.toList());
		
	}
	
}

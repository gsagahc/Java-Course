package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Estoque;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public class DetalhesEstoqueDto {
	private Long id;
	private Long quantidade;
	private Produto produto;
	
	public DetalhesEstoqueDto(Estoque estoque) {
		this.id = estoque.getId();
		this.quantidade=estoque.getQuantidade();
		this.produto=estoque.getProduto();
	
		
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

	

	public static List <DetalhesEstoqueDto> converter(List<Estoque>estoque){
		return estoque.stream().map(DetalhesEstoqueDto::new).collect(Collectors.toList());
		
	}
	

}

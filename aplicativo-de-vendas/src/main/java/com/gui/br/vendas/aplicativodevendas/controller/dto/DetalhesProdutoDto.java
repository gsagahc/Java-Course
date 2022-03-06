package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public class DetalhesProdutoDto {
	private Long id;
	private String nome;
	private Double preco;
	private Categoria categoria;
	
	public DetalhesProdutoDto(Produto produto) {
		this.id = produto.getId();
		this.nome=produto.getNome();
		this.preco=produto.getPreco();
		this.categoria=produto.getCategoria();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	
	public Double getPreco() {
		return preco;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public static List <DetalhesProdutoDto> converter(List<Produto>produtos){
		return produtos.stream().map(DetalhesProdutoDto::new).collect(Collectors.toList());
		
	}
	

}

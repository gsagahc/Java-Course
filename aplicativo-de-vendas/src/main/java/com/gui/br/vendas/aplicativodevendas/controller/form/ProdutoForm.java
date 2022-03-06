package com.gui.br.vendas.aplicativodevendas.controller.form;

import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.gui.br.vendas.aplicativodevendas.controller.repository.ProdutoRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

public class ProdutoForm {
	@NotEmpty @NonNull 
	private String nome;
	private Double preco;
	@ManyToOne
	private Categoria categoria;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
		
	public Double getPreco() {
		return preco;
	}
	public void setPreco(Double preco) {
		this.preco = preco;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria_id(Categoria categoria) {
		this.categoria = categoria;
	}
	public Produto converter(ProdutoRepository produtorepository) {
		
		return new Produto(getNome().toUpperCase(), getPreco(), getCategoria());
	}
}

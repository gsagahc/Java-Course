package com.gui.br.vendas.aplicativodevendas.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
@Entity
public class Estoque {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Long quantidade;
	@OneToOne
	private Produto produto;
	
	public Estoque() {
		
	}

	public Estoque(Long quantidade, Produto produto) {
		this.quantidade = quantidade;
		this.produto = produto;
		
	}

	public Long getId() {
		return id;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}



	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estoque other = (Estoque) obj;
		return Objects.equals(id, other.id);
	}
	
	

}

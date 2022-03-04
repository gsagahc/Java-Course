package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public class DetalhesCategoriaDto {
	private Long id;
	private String name;
	
	
	public DetalhesCategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.name=categoria.getName();
	
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public static List <DetalhesCategoriaDto> converter(List<Categoria>categorias){
		return categorias.stream().map(DetalhesCategoriaDto::new).collect(Collectors.toList());
		
	}
	

}

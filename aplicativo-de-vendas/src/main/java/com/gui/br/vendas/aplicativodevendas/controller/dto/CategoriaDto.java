package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Categoria;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public class CategoriaDto {
	private Long id;
	private String name;
	
	
	public CategoriaDto(Categoria categoria) {
		this.id = categoria.getId();
		this.name=categoria.getName();
		
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}


	public static List <CategoriaDto> converter(List<Categoria>categorias){
		return categorias.stream().map(CategoriaDto::new).collect(Collectors.toList());
		
	}
	

}

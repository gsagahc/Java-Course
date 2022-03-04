package com.gui.br.vendas.aplicativodevendas.controller.form;

import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.gui.br.vendas.aplicativodevendas.controller.repository.CategoriaRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Categoria;

public class CategoriaForm {
	@NotEmpty @NonNull 
	private String name;
	
	public String getName() {
		return name;
	}
	public void setNome(String name) {
		this.name = name;
	}
	
	
	public Categoria converter(CategoriaRepository categoriarepository) {
		
		return new Categoria(getName().toUpperCase());
	}
}

package com.gui.br.vendas.aplicativodevendas.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gui.br.vendas.aplicativodevendas.controller.dto.CategoriaDto;
import com.gui.br.vendas.aplicativodevendas.controller.dto.DetalhesCategoriaDto;
import com.gui.br.vendas.aplicativodevendas.controller.dto.DetalhesClienteDto;
import com.gui.br.vendas.aplicativodevendas.controller.form.CategoriaForm;
import com.gui.br.vendas.aplicativodevendas.controller.repository.CategoriaRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Categoria;

@RestController
@RequestMapping("/categorias")
public class CategoriasController {
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping 
	public List<CategoriaDto> lista (String name){
		if (name == null) {
			List<Categoria> categorias = categoriaRepository.findAll();
			return CategoriaDto.converter(categorias);
		}else {
			List<Categoria> categorias =categoriaRepository.findByName(name);
			return CategoriaDto.converter(categorias);
		}
			
		
	}
	@PostMapping
	@Transactional
	public ResponseEntity<CategoriaDto>cadastrar(@RequestBody @Valid CategoriaForm form, UriComponentsBuilder uriBuilder){
		Categoria categoria = form.converter (categoriaRepository);
		categoriaRepository.save(categoria);
		URI uri= uriBuilder.path("/categorias{id}").buildAndExpand(categoria.getId()).toUri();
		return ResponseEntity.created(uri).body(new CategoriaDto(categoria));
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesCategoriaDto>detalhar(@PathVariable Long id){
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		if (categoria.isPresent()) {
			return ResponseEntity.ok(new DetalhesCategoriaDto(categoria.get()));
		}
		return ResponseEntity.notFound().build();
	}
	

}

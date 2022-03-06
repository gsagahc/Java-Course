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

import com.gui.br.vendas.aplicativodevendas.controller.dto.DetalhesClienteDto;
import com.gui.br.vendas.aplicativodevendas.controller.dto.DetalhesProdutoDto;
import com.gui.br.vendas.aplicativodevendas.controller.dto.ProdutoDto;
import com.gui.br.vendas.aplicativodevendas.controller.form.ProdutoForm;
import com.gui.br.vendas.aplicativodevendas.controller.repository.ProdutoRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

@RestController
@RequestMapping("/produtos")
public class ProdutosController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping 
	public List<ProdutoDto> lista (String nome){
		if (nome == null) {
			List<Produto> produtos = produtoRepository.findAll();
			return ProdutoDto.converter(produtos);
		}else {
			List<Produto> produtos =produtoRepository.findByNome(nome);
			return ProdutoDto.converter(produtos);
		}
			
		
	}
	@PostMapping
	@Transactional
	public ResponseEntity<ProdutoDto>cadastrar(@RequestBody @Valid ProdutoForm form, UriComponentsBuilder uriBuilder){
		Produto produto = form.converter (produtoRepository);
		produtoRepository.save(produto);
		URI uri= uriBuilder.path("/produtos{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProdutoDto(produto));
	}
	@GetMapping("/{id}")
	public ResponseEntity<DetalhesProdutoDto>detalhar(@PathVariable Long id){
		Optional<Produto> produto = produtoRepository.findById(id);
		if (produto.isPresent()) {
			return ResponseEntity.ok(new DetalhesProdutoDto(produto.get()));
		}
		return ResponseEntity.notFound().build();
	}
	

}

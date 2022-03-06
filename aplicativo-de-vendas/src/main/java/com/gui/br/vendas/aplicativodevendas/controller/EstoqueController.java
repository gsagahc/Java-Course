package com.gui.br.vendas.aplicativodevendas.controller;

import java.net.URI;
import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.gui.br.vendas.aplicativodevendas.controller.dto.EstoqueDto;
import com.gui.br.vendas.aplicativodevendas.controller.dto.ProdutoDto;
import com.gui.br.vendas.aplicativodevendas.controller.form.EstoqueForm;
import com.gui.br.vendas.aplicativodevendas.controller.repository.EstoqueRepository;
import com.gui.br.vendas.aplicativodevendas.controller.repository.ProdutoRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Estoque;
import com.gui.br.vendas.aplicativodevendas.entities.Produto;

@RestController
@RequestMapping("/estoque")
public class EstoqueController {
	
	@Autowired
	EstoqueRepository estoqueRepository;
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@GetMapping 
	public List<EstoqueDto> lista (String nome){
		if (nome==null) {
		List<Estoque> estoque = estoqueRepository.findAll();
		return EstoqueDto.converter(estoque);
		}
		List<Estoque> estoque = estoqueRepository.findByProduto(nome);
		return EstoqueDto.converter(estoque);
	}
	
			
		

	@PostMapping
	@Transactional
	public ResponseEntity<EstoqueDto>cadastrar(@RequestBody @Valid EstoqueForm form, UriComponentsBuilder uriBuilder){
		Estoque estoque = form.converter (estoqueRepository);
		estoqueRepository.save(estoque);
		URI uri= uriBuilder.path("/estoque{produto}").buildAndExpand(estoque.getProduto()).toUri();
		return ResponseEntity.created(uri).body(new EstoqueDto(estoque));
	}
	/*@GetMapping("/{produto}")
	public ResponseEntity<DetalhesEstoqueDto>detalhar(@PathVariable Produto produto){
		
		Optional<Estoque> estoque = estoqueRepository.findByProduto(produto);
		if (estoque.isPresent()) {
			return ResponseEntity.ok(new DetalhesEstoqueDto(estoque.get()));
		}
		return ResponseEntity.notFound().build();
	}*/
	

}

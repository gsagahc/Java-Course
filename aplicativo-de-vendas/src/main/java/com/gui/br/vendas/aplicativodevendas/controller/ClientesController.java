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

import com.gui.br.vendas.aplicativodevendas.controller.dto.ClienteDto;
import com.gui.br.vendas.aplicativodevendas.controller.form.ClienteForm;
import com.gui.br.vendas.aplicativodevendas.controller.repository.ClienteRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClientesController {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@GetMapping 
	public List<ClienteDto> lista (String nome){
		if (nome == null) {
			List<Cliente> clientes = clienteRepository.findAll();
			return ClienteDto.converter(clientes);
		}else {
			List<Cliente> clientes =clienteRepository.findByNome(nome);
			return ClienteDto.converter(clientes);
		}
			
		
	}
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteDto>cadastrar(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder){
		Cliente cliente = form.converter (clienteRepository);
		clienteRepository.save(cliente);
		URI uri= uriBuilder.path("/clientes{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new ClienteDto(cliente));
	}
	

}

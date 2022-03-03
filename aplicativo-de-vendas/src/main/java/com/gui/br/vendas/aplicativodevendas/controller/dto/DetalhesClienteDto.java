package com.gui.br.vendas.aplicativodevendas.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public class DetalhesClienteDto {
	private Long id;
	private String nome;
	private String cpf;
	private String endereco;
	private String complemento;
	private String email;
	private String fone;
	
	public DetalhesClienteDto(Cliente cliente) {
		this.id = cliente.getId();
		this.nome=cliente.getNome();
		this.cpf=cliente.getCpf();
		this.endereco=cliente.getEndereco();
		this.complemento=cliente.getComplemento();
		this.email=cliente.getEmail();
		this.fone=cliente.getFone();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getEmail() {
		return email;
	}

	public String getFone() {
		return fone;
	}
	public static List <DetalhesClienteDto> converter(List<Cliente>clientes){
		return clientes.stream().map(DetalhesClienteDto::new).collect(Collectors.toList());
		
	}
	

}

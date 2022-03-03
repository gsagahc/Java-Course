package com.gui.br.vendas.aplicativodevendas.controller.form;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.springframework.lang.NonNull;

import com.gui.br.vendas.aplicativodevendas.controller.repository.ClienteRepository;
import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public class ClienteForm {
	@NotEmpty @NonNull 
	private String nome;
	@NotEmpty @NonNull 
	private String cpf;
	private String endereco;
	private String complemento;
	private String email;
	private String fone;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFone() {
		return fone;
	}
	public void setFone(String fone) {
		this.fone = fone;
	}
	
	public Cliente converter(ClienteRepository clienterepository) {
		
		return new Cliente(getNome().toUpperCase(),getCpf(),getEndereco().toUpperCase(),getComplemento().toUpperCase(), getEmail().toUpperCase(),getFone());
	}
}

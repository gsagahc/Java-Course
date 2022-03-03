package com.gui.br.vendas.aplicativodevendas.controller.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gui.br.vendas.aplicativodevendas.entities.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Long> {
	List<Cliente> findByNome(String nome);

}

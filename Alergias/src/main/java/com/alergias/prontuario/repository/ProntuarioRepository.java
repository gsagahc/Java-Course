package com.alergias.prontuario.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alergias.prontuario.model.Prontuario;



public interface ProntuarioRepository extends JpaRepository<Prontuario, String>{

	List<Prontuario> findByCpf(String cpf);

}
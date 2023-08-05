package com.alergias.prontuario.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alergias.prontuario.model.Usuario;



public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	Optional<Usuario> findByApelido(String apelido);

}

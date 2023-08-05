package com.alergias.prontuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alergias.prontuario.model.TipoProdutoAlergia;


public interface TipoProdutoAlergiaRepository extends JpaRepository<TipoProdutoAlergia, String>{

}

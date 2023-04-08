package com.alergiasprontuario.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.alergiasprontuario.model.TipoProdutoAlergia;

public interface TipoProdutoAlergiaRepository extends JpaRepository<TipoProdutoAlergia, String>{

}

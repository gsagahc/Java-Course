package com.alergias.prontuario.controller;

import java.awt.print.Pageable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alergias.prontuario.controller.dto.DadosAlergiaDto;
import com.alergias.prontuario.model.Alergia_Prontuario;
import com.alergias.prontuario.model.Prontuario;
import com.alergias.prontuario.model.TipoProdutoAlergia;
import com.alergias.prontuario.repository.AlergiaProntuario;
import com.alergias.prontuario.repository.ProntuarioRepository;



@RestController
@RequestMapping("/")
public class AlergiasProntuarioController {

	@Autowired
	ProntuarioRepository repository;

	@GetMapping ("/consultar/{cpf}")
	public  ResponseEntity<Object> listar(@PathVariable(value="cpf") String cpf){
		List<Prontuario> prontuario =  repository.findByCpf(cpf);
		if ( prontuario.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Prontuário não localizado");
		}else
			return ResponseEntity.status(HttpStatus.OK).body(prontuario);
	}

	@Autowired
	AlergiaProntuario repAlergias;

	@PostMapping("/cadastrar")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<String> cadastrar(@RequestBody  DadosAlergiaDto dados) {
		repAlergias.save(new Alergia_Prontuario(dados));
		return  ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso");

	}
	@PutMapping("/cancelar/{id_alergia}")
	@ResponseStatus(HttpStatus.CREATED)
	@Transactional
	public ResponseEntity<Object> cancelar(@PathVariable(value="id_alergia") String id_alergia, @RequestBody  DadosAlergiaDto dados) {
		Optional<Alergia_Prontuario> alergia = repAlergias.findById(id_alergia);
		if (!alergia.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alergia não localizada para o prontuario");
		}else {

			javax.persistence.Query query_aux =  em.createNamedQuery("Alergia.cancelar");   
			query_aux.setParameter("codPro", dados.getCod_pro_canc());
			query_aux.setParameter("dataHora", LocalDateTime.now());
			query_aux.setParameter("id", id_alergia);
			query_aux.executeUpdate();
			return ResponseEntity.status(HttpStatus.OK).body("Alergia cancelado com sucesso!");

		}

	}


	@PersistenceContext
	EntityManager em;

	@GetMapping ("/datahora")
	public  Object getDateTime(){
		javax.persistence.Query q =  em.createNamedQuery("QueryUtils.getDateTime");      
		return q.getSingleResult();


	}


	@GetMapping ("/produtos/{descricao}")
	public  ResponseEntity<Object> getProdutoAlergia(@PathVariable(value="descricao")String descricao, Pageable page) {

		StoredProcedureQuery  proc =  this.em.createNamedStoredProcedureQuery("sp_carrega_produtos_alergia");
		if (!proc.execute()) {

			javax.persistence.Query query_aux =  em.createNamedQuery("TipoProdutoAlergia.findByDesc");   
			query_aux.setParameter("searchTerm", descricao);
			List<TipoProdutoAlergia> produtoalergia =  query_aux.getResultList();
			return ResponseEntity.status(HttpStatus.OK).body(produtoalergia);
		}else
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tabela vazia");

	}	
}

package com.alergiasprontuario.controler;

import java.util.List;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.alergiasprontuario.model.Alergia_Prontuario;
import com.alergiasprontuario.model.DadosAlergia;
import com.alergiasprontuario.model.Prontuario;
import com.alergiasprontuario.model.TipoProdutoAlergia;
import com.alergiasprontuario.repository.AlergiaProntuario;
import com.alergiasprontuario.repository.ProntuarioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import jakarta.transaction.HeuristicMixedException;
import jakarta.transaction.HeuristicRollbackException;
import jakarta.transaction.RollbackException;
import jakarta.transaction.SystemException;
import jakarta.transaction.Transaction;
import jakarta.transaction.Transactional;


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
		public ResponseEntity<String> cadastrar(@RequestBody  DadosAlergia dados) {
	       repAlergias.save(new Alergia_Prontuario(dados));
	        return  ResponseEntity.status(HttpStatus.CREATED).body("Cadastrado com sucesso");
			
		}
		
		@DeleteMapping("/deletar/{id_alergia}")
		public ResponseEntity<Object> deletar(@PathVariable(value="id_alergia") String id_alergia){
			Optional <Alergia_Prontuario> alergia = repAlergias.findById(id_alergia);
	    	if (!alergia.isPresent()) {
	    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Alergia não localizada para o paciente");
	    	}else {
	    		repAlergias.deleteById(id_alergia);
	    	    return ResponseEntity.status(HttpStatus.OK).body("Alergia excluída com sucesso!");
			
	    	}
		}
		@PersistenceContext
		EntityManager em;
				  
		  @GetMapping ("/datahora")
		    public  Object getDateTime(){
			  jakarta.persistence.Query q =  em.createNamedQuery("QueryUtils.getDateTime");      
		      	   return q.getSingleResult();
		

		  }
		 

	        @GetMapping ("/produtos/{descricao}")
	        public  ResponseEntity<Object> getProdutoAlergia(@PathVariable(value="descricao") String descricao) {
		    	      
	        	StoredProcedureQuery  proc =  this.em.createNamedStoredProcedureQuery("sp_carrega_produtos_alergia");
                if (!proc.execute()) {
                    
		        	jakarta.persistence.Query query_aux =  em.createNamedQuery("TipoProdutoAlergia.findByDesc");   
				    query_aux.setParameter("searchTerm", descricao);
					List<TipoProdutoAlergia> produtoalergia =  query_aux.getResultList();
				    return ResponseEntity.status(HttpStatus.OK).body(produtoalergia);
                }else
                	return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Tabela vazia");
                
			  }	
}

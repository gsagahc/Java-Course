package com.alergias.prontuario.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "tipoProdutoAlergia")
@NamedNativeQueries({
   		
    @NamedNativeQuery(
            name = "TipoProdutoAlergia.findByDesc",
            query =
                "select * from tp_produtos_alergias "
                + "where descricao like :searchTerm||'%' "
                + "order by descricao" ,
              
                resultClass = TipoProdutoAlergia.class),
    
    
    })
  @NamedStoredProcedureQueries({
	  @NamedStoredProcedureQuery(
			  name = "sp_carrega_produtos_alergia",
			  procedureName = "sp_carrega_produtos_alergia"
			  )
	  
		
  })



@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tp_produtos_alergias")

public class TipoProdutoAlergia implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="cod_sal")
	String codsal;
	@Column(name="descricao")
	String descricao; 
	@Column(name="tipo")
	String tipo ;  
	@Column(name="desccompl")
	String descricaocompleta;          


}

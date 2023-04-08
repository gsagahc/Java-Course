package com.alergiasprontuario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQueries;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.Table;
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

public class TipoProdutoAlergia {
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

package com.alergiasprontuario.model;




import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;

import com.alergiasprontuario.utils.Utils;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Table(name="alergia_prontuario")
@Entity(name = "Alergia")
public class Alergia_Prontuario {
   
	@Id
	@SequenceGenerator(name="sequence_alerg", sequenceName="sq_seq_aleprt")
	@Column(name="id_alergia")
	private long id_alergia;
	
	@JoinColumn(name="cod_prt")
	private String cod_prt;
	@Column(name="cod_sal")
	private String cod_sal;
	@Column(name="complemento")
	private String complemento;
	@Column(name="cod_pro")
	private String cod_pro;
	@Column(name="cod_pro_canc")
	private String cod_pro_canc;
	@Column(name="dt_hr_incl_alergia")
	private LocalDateTime dt_hr_incl_alergia = LocalDateTime.now();
	@Column(name="dt_hr_canc_alergia")
	private String dt_hr_canc_alergia;
	@Column(name="alerg_txt")
	private String alerg_txt;  
	
	
    public Alergia_Prontuario(DadosAlergia dados) {
       this.cod_prt = dados.cod_prt();
	   this.cod_pro_canc = dados.cod_pro();
	   this.cod_sal = dados.cod_sal();
	   this.complemento = dados.complemento();
	   this.cod_pro  = dados.cod_pro();
	   this.alerg_txt = dados.alerg_txt();
	 
	}
}    

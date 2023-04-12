package com.alergiasprontuario.model;



import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Faprtcad")
@Entity(name = "Prontuario")
public class Prontuario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private String cod_prt;
	private String cpf;
	private String nome_pac;
	
	@OneToMany(mappedBy = "cod_prt")
	@OrderBy("dt_hr_incl_alergia DESC")
	private List<Alergia_Prontuario> alergias;
	

}

package com.alergiasprontuario.controler;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class HomeController {

	@GetMapping@RequestMapping("/")
	@ResponseBody
	public String index() {
		return "Bem vindo ao sistema de controle de alergias"+
	           "\nEscolha uma das opções:"+
				"\nConsultar:  /consultar/{cpf}"+
	            "\nCadastrar:  /cadastrar/{JSON}"+
		        "\nDeletar:    /deletar/{id_alergia}"+
		        "\ndatahora banco:  /datahora"+
		        "\nListar produtos alergênico/sais:  /produtos/{descricao}";
	}		
	
}

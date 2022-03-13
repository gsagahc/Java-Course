package br.com.gui.loja;

import java.math.BigDecimal;

import br.com.gui.loja.http.JavaHttpClient;
import br.com.gui.loja.orcamento.Orcamento;
import br.com.gui.loja.orcamento.RegistroDeOrcamento;

public class TestesAdapter {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento();
		orcamento.aprovar();
		orcamento.finalizar();
		
		RegistroDeOrcamento registro = new RegistroDeOrcamento(new JavaHttpClient());
		registro.registrar(orcamento);
			
			

	}

}

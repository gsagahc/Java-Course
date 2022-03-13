package br.com.gui.loja.orcamento;

import java.util.Map;

import br.com.gui.loja.desconto.DomainException;
import br.com.gui.loja.http.HttpAdapter;

public class RegistroDeOrcamento {
	private HttpAdapter http;
	
	public RegistroDeOrcamento(HttpAdapter http) {
		this.http=http;
	}
	public void registrar(Orcamento orcamento) {
		if (! orcamento.isFinalizado()) {
			throw new DomainException("Orçamento não finalizado!");
		}
		String url="http://api.gsagahc.loja/orcamento";
		Map<String, Object> dados= Map.of(
				"valor",  orcamento.getValor(),
				"quantidadedeItens", orcamento.getquantidadeDeItens());
				
				
		http.post(url, dados);
	}

}

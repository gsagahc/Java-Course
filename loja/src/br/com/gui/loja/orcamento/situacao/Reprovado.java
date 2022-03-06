package br.com.gui.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class Reprovado extends SituacaoOrcamento{
	
	public void finalizarO(Orcamento orcamento) {
		 orcamento.setSituacao(new Finalizado());
	}
}


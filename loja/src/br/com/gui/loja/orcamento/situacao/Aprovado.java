package br.com.gui.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class Aprovado extends SituacaoOrcamento{
	public BigDecimal calcularDescontoExtra(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.05"));
		
	}
	public void finalizarO(Orcamento orcamento) {
		 orcamento.setSituacao(new Finalizado());
	}
}


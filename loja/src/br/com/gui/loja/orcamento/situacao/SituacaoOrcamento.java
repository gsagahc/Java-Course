package br.com.gui.loja.orcamento.situacao;

import java.math.BigDecimal;

import br.com.gui.loja.desconto.DomainException;
import br.com.gui.loja.orcamento.Orcamento;

public abstract class SituacaoOrcamento {
	
	public BigDecimal calValDescExtra(Orcamento orcanento) {
		return BigDecimal.ZERO;
	}
	
	public void aprovar(Orcamento orcamento) {
		throw new DomainException("Or�amento j� foi aprovado");
	}
	
	public void reprovar(Orcamento orcamento) {
		throw new DomainException("Or�amento j� foi aprovado");
	}
	
	public void finalizar(Orcamento orcamento) {
		throw new DomainException("Or�amento n�o pode ser finalizado");
	}

}

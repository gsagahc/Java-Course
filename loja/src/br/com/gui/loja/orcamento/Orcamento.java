package br.com.gui.loja.orcamento;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.situacao.EmAnalise;
import br.com.gui.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento {
	private BigDecimal valor;
	private int quantidadeDeItens;
	private SituacaoOrcamento situacao;

	public Orcamento(BigDecimal valor, int quantidadeDeItens) {
			this.valor = valor;
			this.quantidadeDeItens= quantidadeDeItens;
			this.situacao= new EmAnalise();
	}
	public void aplicarDescontoExtra() {
		BigDecimal valorDescontroextra=  this.situacao.calValDescExtra(this);
		this.valor=this.valor.subtract(valorDescontroextra)	;
	}
	public void aprovar() {
		this.situacao.aprovar(this);
	}
	public void reprovar() {
		this.situacao.reprovar(this);
	}
	public void finalizar() {
		this.situacao.finalizar(this);
	}
	public BigDecimal getValor() {
		return valor;
	} 
	public int getquantidadeDeItens() {
		return quantidadeDeItens;
	}
	public SituacaoOrcamento getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}
	
	

}

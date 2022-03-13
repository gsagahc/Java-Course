package br.com.gui.loja.orcamento;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import br.com.gui.loja.orcamento.situacao.EmAnalise;
import br.com.gui.loja.orcamento.situacao.SituacaoOrcamento;

public class Orcamento implements Orcavel {
	private BigDecimal valor;
	private SituacaoOrcamento situacao;
	private List<Orcavel> itens ;

	
	public Orcamento() {
			this.valor = BigDecimal.ZERO;
			this.itens= new ArrayList<>();
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
		try {
			Thread.sleep(2000);
		}catch  (InterruptedException e){
			throw new RuntimeException(e);
			
		}
				
		return this.valor;
	} 
	public int getquantidadeDeItens() {
		return itens.size();
	}
	public SituacaoOrcamento getSituacao() {
		return situacao;
	}
	public void setSituacao(SituacaoOrcamento situacao) {
		this.situacao = situacao;
	}
	public boolean isFinalizado() {
		// TODO Auto-generated method stub
		return situacao instanceof SituacaoOrcamento;
	}
	public void adicionarItem(Orcavel item) {
		this.valor =  valor.add(item.getValor());
		this.itens.add(item);
		
	}
	

}

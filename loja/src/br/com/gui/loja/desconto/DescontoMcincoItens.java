package br.com.gui.loja.desconto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class DescontoMcincoItens extends Desconto{
	
	
	
	public DescontoMcincoItens(Desconto proximo) {
		super(proximo);
		}

	public BigDecimal efetuarCalculo (Orcamento orcamento) {
	 	return orcamento.getValor().multiply(new BigDecimal ("0.1"));
		
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
		return orcamento.getquantidadeDeItens() > 5;
	}
}

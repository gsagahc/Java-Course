package br.com.gui.loja.desconto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class DescontoValMQuinhentos extends Desconto {
	
	
	public DescontoValMQuinhentos(Desconto proximo) {
		super(proximo);
	
	}

	public BigDecimal calcular (Orcamento orcamento) {
		
		return orcamento.getValor().multiply(new BigDecimal ("0.05"));
	
	}

	@Override
	protected BigDecimal efetuarCalculo(Orcamento orcamento) {
		return null;
	}

	@Override
	public boolean deveAplicar(Orcamento orcamento) {
	    return orcamento.getValor().compareTo(new BigDecimal("500")) > 0;
	}
}

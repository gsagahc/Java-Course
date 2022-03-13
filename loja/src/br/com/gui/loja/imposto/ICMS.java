package br.com.gui.loja.imposto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class ICMS extends Imposto{
	public ICMS(Imposto outro) {
		super(outro);
		
	}

	public BigDecimal realizarCalculo(Orcamento orcamento) {
		return orcamento.getValor().multiply(new BigDecimal("0.1"));
	}
}

package br.com.gui.loja.desconto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class CalculadoraDeDescontos {
	public BigDecimal calcular (Orcamento orcamento) {
		Desconto desconto = new DescontoMcincoItens(new DescontoValMQuinhentos(new SemDesconto()));
			
		return  desconto.calcular(orcamento);
	}

}

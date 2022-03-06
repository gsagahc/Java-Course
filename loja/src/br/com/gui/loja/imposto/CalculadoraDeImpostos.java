package br.com.gui.loja.imposto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public class CalculadoraDeImpostos {
	public BigDecimal calcular(Orcamento orcamento, Imposto imposto) {
		return imposto.calcular(orcamento);
		
		}
		
		


}

package br.com.gui.loja.imposto;

import java.math.BigDecimal;

import br.com.gui.loja.orcamento.Orcamento;

public interface Imposto {
	BigDecimal calcular(Orcamento orcamento);
		

}

package br.com.gui.loja;

import java.math.BigDecimal;

import br.com.gui.loja.desconto.CalculadoraDeDescontos;
import br.com.gui.loja.orcamento.ItemOrcamento;
import br.com.gui.loja.orcamento.Orcamento;

public class TesteDescontos {

	public static void main(String[] args) {
		Orcamento primeiro =  new Orcamento();
		primeiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		
		Orcamento segundo =  new Orcamento();
		segundo.adicionarItem(new ItemOrcamento(new BigDecimal("200")));
		
		Orcamento terceiro =  new Orcamento();
		terceiro.adicionarItem(new ItemOrcamento(new BigDecimal("200")));

		CalculadoraDeDescontos calc = new CalculadoraDeDescontos();
		System.out.println(calc.calcular(primeiro));
		
		System.out.println(calc.calcular(segundo));
		
		System.out.println(calc.calcular(terceiro));
	}

}

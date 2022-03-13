package br.com.gui.loja;

import java.math.BigDecimal;

import br.com.gui.loja.imposto.CalculadoraDeImpostos;
import br.com.gui.loja.imposto.ICMS;
import br.com.gui.loja.imposto.IPI;
import br.com.gui.loja.imposto.ISS;
import br.com.gui.loja.orcamento.ItemOrcamento;
import br.com.gui.loja.orcamento.Orcamento;

public class TesteImposto {

	public static void main(String[] args) {
		Orcamento orcamento = new Orcamento ();
		orcamento.adicionarItem(new ItemOrcamento(new BigDecimal("100")));
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		System.out.println(calculadora.calcular(orcamento, new ICMS(new ISS(new IPI(null)))));
	}

}

package br.com.gui.loja.pedido.acao;

import br.com.gui.loja.pedido.Pedido;

public class EnviarEmail implements AcoesPedido{
	public void executarAcao(Pedido pedido) {
		System.out.println("Enviando email do pedido...");
	}

}

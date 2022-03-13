package br.com.gui.loja.pedido.acao;

import br.com.gui.loja.pedido.Pedido;

public class LogDePedido implements AcoesPedido{
	@Override 
	public void executarAcao(Pedido pedido) {
		System.out.println("Pedido foi gerado: "+ pedido);
		
	}

}

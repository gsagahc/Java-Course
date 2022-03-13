package br.com.gui.loja.pedido;

import java.time.LocalDateTime;
import java.util.List;

import br.com.gui.loja.orcamento.Orcamento;
import br.com.gui.loja.pedido.acao.AcoesPedido;
import br.com.gui.loja.pedido.acao.EnviarEmail;
import br.com.gui.loja.pedido.acao.SalvarPedidoBanco;

public class GeraPedidoHandler {
	private List<AcoesPedido> acoes;
	
	public GeraPedidoHandler(List<AcoesPedido> acoes) {
		this.acoes = acoes;
	}

	public void executa(GeraPedido dados) {
		Orcamento orcamento = new Orcamento ();
		
		Pedido pedido = new Pedido(dados.getCliente(), LocalDateTime.now(), orcamento);
		
		acoes.forEach(a -> a.executarAcao(pedido));
	}
}

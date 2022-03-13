package br.com.gui.loja;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;

import br.com.gui.loja.pedido.GeraPedido;
import br.com.gui.loja.pedido.GeraPedidoHandler;
import br.com.gui.loja.pedido.acao.EnviarEmail;
import br.com.gui.loja.pedido.acao.LogDePedido;
import br.com.gui.loja.pedido.acao.SalvarPedidoBanco;

public class TestePedidos {

	public static void main(String[] args) {
	
		Scanner sc =  new Scanner (System.in);
	  
	  System.out.println("Digite o nome do cliente:");
	  String cliente = sc.nextLine();
	  System.out.println("Digite o valor do orçamento:");
	  BigDecimal valor = sc.nextBigDecimal();
	  System.out.println("Digite a quantidade de itens:");
	  int quantidade = sc.nextInt();
	  
	  GeraPedido pedido = new GeraPedido(cliente, valor, quantidade);
	  GeraPedidoHandler handler = new GeraPedidoHandler(
			  Arrays.asList(new SalvarPedidoBanco(),
			  new EnviarEmail(),
			  new LogDePedido()));
	  handler.executa(pedido);
	  
	  System.out.println(pedido.toString());
	  }

}

package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import entidades.Produto;
import util.PredicadoProduto;

public class Program {
	static List<Produto> prod = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		adicionarProd();
		
		for (Produto p : prod) {
			System.out.println("Nome: "+p.getNome()+" Preço: "+ p.getPreco());
		}
		System.out.println("--------------------------------");
		System.out.println("");
		prod.removeIf(new PredicadoProduto());
		
		for (Produto p : prod) {
			System.out.println("Nome: "+p.getNome()+" Preço: "+ p.getPreco());
		}
		System.out.println("--------------------------------");
		System.out.println("");
		prod.clear();
		adicionarProd();
		
		System.out.println("Digite o valor mínimo");
		double min = sc.nextDouble();
		prod.removeIf(p -> p.getPreco()>= min);
		for (Produto p : prod) {
			System.out.println("Nome: "+p.getNome()+" Preço: "+ p.getPreco());
		}
	}
	
	public static void  adicionarProd() { 
		prod.add(new Produto("Iphone", 1000.0));
		prod.add(new Produto("TV", 800.0));
		prod.add(new Produto("Mouse", 25.0));
		prod.add(new Produto("Teclado", 30.0));
		
	}

}

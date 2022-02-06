package aplicacao;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import entidades.Produto;
import util.toUpperCase;

public class Program {
	static List<Produto> prod = new ArrayList<>();
	
	public static void main(String[] args) {
		adicionarProd();
		List<String> nomes = prod.stream().map(new toUpperCase()).collect(Collectors.toList());
		System.out.println("Metodo 1");
		nomes.forEach(System.out::println);
		
		System.out.println("-----------------------");
		System.out.println("Metodo 2");
		nomes = prod.stream().map(Produto::toUppercase).collect(Collectors.toList());
		nomes.forEach(System.out::println);
		System.out.println("-----------------------");
		System.out.println("Metodo 3");
		Function<Produto, String> func = p -> p.getNome().toUpperCase();
		nomes = prod.stream().map(func).collect(Collectors.toList());
		nomes.forEach(System.out::println);
		System.out.println("-----------------------");
		System.out.println("Metodo 4");
		nomes = prod.stream().map(p -> p.getNome().toUpperCase()).collect(Collectors.toList());
		nomes.forEach(System.out::println);
		
	}
	
	public static void adicionarProd() {
		prod.add(new Produto("Tv", 900.0));
		prod.add(new Produto("Mouse", 50.0));
		prod.add(new Produto("Tablet", 350.0));
		prod.add(new Produto("HD Case", 80.90));
	}

}

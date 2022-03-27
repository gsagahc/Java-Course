package application;

import java.util.ArrayList;
import java.util.List;

import entities.Product;
import entities.ProductService;

public class Program {
	static List<Product> prod = new ArrayList<>();
	public static void main(String[] args) {
		adicionarProd();
		ProductService ps = new ProductService();
		double sum = ps.filteredSum(prod, p -> p.getName().charAt(0)=='T');
		System.out.println(sum);
	}
	public static void adicionarProd() {
		prod.add(new Product("Tv", 900.0));
		prod.add(new Product("Mouse", 50.0));
		prod.add(new Product("Tablet", 350.50));
		prod.add(new Product("HD Case", 80.90));
	}


}

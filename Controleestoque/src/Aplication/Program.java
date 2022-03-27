package Aplication;

import java.util.Scanner;

import Entities.Products;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Products product = new Products();
	    System.out.println("Entre com os dados do produto:");
	    System.out.print("Nome:");
	    product.name = sc.nextLine();
	    System.out.print("Preço:");
	    product.price = sc.nextDouble();
	    System.out.print("Quantidade:");
	    product.quantity = sc.nextInt();
	    
	    System.out.println(product.toString());
	    
	    System.out.println("Entre a quantidade a ser adicionada: ");
	    int quant = sc.nextInt();
	    product.addProduct(quant); 
	    
	    System.out.println(product.toString());
	    
	    System.out.println("Entre a quantidade a removida");
	    quant = sc.nextInt();
	    product.removeProducts(quant); 
	    
	    System.out.println(product.toString());
        sc.close();
	}

}

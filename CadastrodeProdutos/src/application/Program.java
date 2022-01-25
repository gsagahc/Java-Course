package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		List <Product> products = new ArrayList<>();
		Product product = new Product();
		System.out.println("Enter number of products:");
		int number = sc.nextInt();
		for (int i=0; i < number ; i++) {
			System.out.println("Product #"+i+" Data:");
			System.out.println("Common, used or imported (c/u/i):");
			char type = sc.next().charAt(0);
			System.out.println("Name: ");
			String name = sc.next();
			System.out.println("Price: ");
			Double price = sc.nextDouble();
			
			if (type == 'c'){
				product = new Product(name, price);
			}
			if (type=='i') {
				System.out.println("Customs fee:");
				double customsfee = sc.nextDouble();
				product = new ImportedProduct(name, price, customsfee);
			}
			if (type =='u') {
				System.out.println("Manufacture date:");
				Date manufactreddate = sdf.parse(sc.next());
				product = new UsedProduct(name, price, manufactreddate);
			}
			products.add(product);
		}
		for (Product pdt : products) {
			System.out.println(pdt.priceTag());
		}
		sc.close();
		
	}

}

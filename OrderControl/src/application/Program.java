package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import entities.Clients;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		System.out.println("Enter client data: ");
		System.out.println("Name:");
		String name = sc.next() ;
		System.out.println("E-mail: ");
		String email = sc.next();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date btdate = sdf.parse(sc.next());
		Clients client = new Clients(name, email, btdate);
		System.out.println("Enter order data: ");
		System.out.println("Status: ");
		OrderStatus status = OrderStatus.valueOf(sc.next());
		
		Order order = new Order(new Date(), status, client);
		System.out.println("How many items to this order? ");
		int quantity = sc.nextInt();
		for (int i=0; i<=quantity; i++) {
			System.out.println("Enter product "+ i +" data: ");
			System.out.println("Product name: ");
			sc.nextLine();
			String productName = sc.next();
			double productPrice = sc.nextDouble();
			Product product = new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			int productQuantity = sc.nextInt();
			OrderItem item = new OrderItem(productQuantity, productPrice, product);
			order.addItem(item);		
					
		}
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println(order);
		
		sc.close();
	}

}

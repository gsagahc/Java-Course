package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Clients;

public class Program {
	
	

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite o número de clientes: ");
		int numero =  sc.nextInt();
		List<Clients> clients = new ArrayList<>();
		for (int i=0; i<numero; i++) {
			System.out.println("Digite o nome do cliente "+ i);
			String nome = sc.next();
			System.out.println("Digite o email ");
			String email = sc.next();
			System.out.println("Digite o ID ");
			int id = sc.nextInt();
			Clients c = new Clients(nome, email, id);
			
			clients.add(c);
						
		}
		System.out.println(clients.toString());
		
	}
			
}
	



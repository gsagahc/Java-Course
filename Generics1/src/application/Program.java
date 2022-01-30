package application;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import services.PrintService;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		PrintService<Integer> ps = new PrintService<>();
		System.out.println("How many values? ");
		int number = sc.nextInt();
		for (int i=0; i< number; i++) {
			System.out.println("Digite o valor (" +i+")");
			ps.addValue(sc.nextInt());
		}
	
		ps.print();
		System.out.println("First:  "+ ps.first());
		
		sc.close();
	}

}

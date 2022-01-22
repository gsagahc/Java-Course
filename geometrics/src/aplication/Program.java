package aplication;
import java.util.Scanner;

import Entities.Triangle;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Triangle x,y;
		x = new Triangle();
		y = new Triangle();
		
		System.out.println("Entre os lados do triangulo x: ");
		x.a = sc.nextDouble();  
		x.b = sc.nextDouble();
		x.c = sc.nextDouble();
		
		System.out.println("Entre os lados do triangulo y: ");
		y.a = sc.nextDouble();  
		y.b = sc.nextDouble();
		y.c = sc.nextDouble();
		
		double areaX = x.area();
		double areaY = y.area();
		
		System.out.printf("Triangle x area: %.4f%n", areaX);
		System.out.printf("Triangle y area: %.4f%n", areaY);

	}

}

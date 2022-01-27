package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Circle;
import entities.Rectangle;
import entities.Shape;
import entities.enums.Color;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Shape> shape = new ArrayList<>(); 
		
		System.out.println("Enter the number of shapes: ");
		int number = sc.nextInt();
		
		for (int i=0; i < number ; i++) {
			System.out.println("Shape  #" +(i+1)+" data:");
			System.out.println("Rectangle or circle (r/c):");
			char type = sc.next().charAt(0);
			if (type=='r') {
				System.out.println("Color  (BLACK/BLUE/RED):");	
				Color color = Color.valueOf(sc.next());
				System.out.println("Width: ");
				double width = sc.nextDouble();
				System.out.println("Height: ");
				double height = sc.nextDouble();
				Rectangle rectangle = new Rectangle(color, width, height);
				shape.add(rectangle);
			} else {
				System.out.println("Color  (BLACK/BLUE/RED):");	
				Color color = Color.valueOf(sc.next());
				System.out.println("Radius: ");
				double radius = sc.nextDouble();
				Circle circle = new Circle(color,radius);
				shape.add(circle);
				
			}
			System.out.println("SHAPE AREAS");
			for (Shape sp: shape) {
				System.out.println(sp.toString() );
			}
				
			
			
			
			
		}

	}

}

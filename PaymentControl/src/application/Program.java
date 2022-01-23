package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entities.Employee;
import entities.OutsourcedEmployee;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of employee: ");
		int number = sc.nextInt();
		double aditionalcharge=0.0;
		List<Employee> employees = new ArrayList<Employee>(); 
		for (int i=0; i<number; i++) {
			Employee employee;
			System.out.println("Employee #"+i+ " data:");
			sc.nextLine();
			System.out.println("Outsouced? (y/n)");
			char outsourced= sc.nextLine().charAt(0);
			System.out.println("Name:");
			String name=sc.next();
			System.out.println("Hours: ");
			int hour = sc.nextInt();
			System.out.println("Value per hour: ");
			double valuePerhour = sc.nextDouble();
			if (outsourced=='y') {
				System.out.println("Additional charge:");
				aditionalcharge= sc.nextDouble();
			}
			if (outsourced=='n') {
				employee = new Employee(name, hour, valuePerhour);
						
			}
			else {
				employee = new OutsourcedEmployee(name, hour, valuePerhour, aditionalcharge);
			}
			employees.add(employee);
			
		}
		System.out.println("PAYMENTS:  ");
		for (Employee emp: employees) {
			System.out.println(emp.getName()+ " - "+emp.payment());
		}
	}

}

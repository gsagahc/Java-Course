package application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import entities.Employee;

public class Program {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		List<Employee> list =  new ArrayList<>();
		String caminho = "/home/gui/Temp/teste.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))) {
			String nome = br.readLine();
			while (nome != null) {
				if (!nome.trim().isEmpty()) {
					String[] campos = nome.split(",");
					list.add(new Employee(campos[0],Double.parseDouble(campos[1])));
				}	
				nome = br.readLine();
			}
			Collections.sort(list);
			for (Employee emp: list) {
				System.out.println(emp.getName()+" , "+ emp.getSalary());
				
			}
		}

	}

}

package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import entities.Product;
import entities.services.calculationService;

public class Program {

	public static void main(String[] args) throws IOException {
		List<Product> list =  new ArrayList<>();
		String caminho ="/home/gui/Temp/in.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(caminho))){
				String line = br.readLine();
			
				while (line != null && line.trim().length()>0) {
					
						String[] campos = line.split(",");
						list.add(new Product(campos[0], Double.parseDouble(campos[1])));
				
					line = br.readLine();
				}
				Product x = calculationService.max(list);
				System.out.println("Max: ");
				System.out.println(x.getPrice());
		} catch (IOException e) {
			System.out.println("Error:  "+e.getMessage());
		}

	}

}

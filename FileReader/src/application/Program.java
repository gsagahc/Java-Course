package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Program {

	public static void main(String[] args) {
		//Leitura de arquivo
		String path = "/home/gui/Temp/teste.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(path))){
			String line = br.readLine();
			while (line != null) {
				System.out.println(line);
				line = br.readLine();
			}
			
		}
		catch(IOException e){
			System.out.println("Error:  "+ e.getMessage());
			
		}
		//Escrita de arquivo
		path =  "/home/gui/Temp/testew.txt";
		String[] lines = new String[] {"Good Morning", "Good Afternoon", "Good night"};
		try (BufferedWriter br = new BufferedWriter(new FileWriter(path, true))){
			for (String ln : lines) {
				br.write(ln);
				br.newLine();
			}
			
		}
		catch (IOException e) {
			System.out.println("Error:  "+ e.getMessage());
			
		}

	}

}

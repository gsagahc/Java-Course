package application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = null;
		File file = new File("/home/gui/Temp/teste.txt");
		try {
			sc = new Scanner (file);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}	
		}
		catch (IOException e){
			System.out.println("Erro na abertura do arquivo");
		}
			
		finally {
			if (sc != null) {
				sc.close();
			}
		}
				
	}

}

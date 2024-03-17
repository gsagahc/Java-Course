package testApp;
import java.util.Scanner;

import testApp.Identifier;
public class mainApp {

	public static void main(String[] args) {
		String valor;
		Identifier ident = new Identifier();
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite a entrada:");
		System.out.println();
		valor=scanner.nextLine();
        if (ident.validateIdentifier(valor)) {
        	System.out.println("Validacao OK");	
        }else
        {
        	System.out.println(valor);
        }
	}

}

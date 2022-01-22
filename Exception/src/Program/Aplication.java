package Program;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Aplication {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
        try {
        	
        	String[] vect = sc.nextLine().split(" ");
        	int position = sc.nextInt();
        	System.out.println(vect[position]);
        }
        catch (ArrayIndexOutOfBoundsException e) {
        	System.out.println("Invalid position!");
		}
        catch (InputMismatchException e) {
			System.out.println("Você precisa digitar um número inteiro");
		}
        System.out.println("Fim do programa");
        sc.close();
	}

}

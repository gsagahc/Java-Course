import java.util.Scanner;
import entities.Product;

public class Program {

	public static void main(String[] args) {
	Scanner sc = new Scanner (System.in);
	System.out.println("Digite a quantidade de itens:");

	int n = sc.nextInt() ;
	Product[] vect = new Product[n];
	
	for (int i=0; i< vect.length; i++) {
		sc.nextLine();
		String name = sc.next();
		double price = sc.nextDouble();
		vect[i] = new Product(name, price);
	}
	double soma =0.0;
	for (int i=0; i < vect.length; i++) {
		soma += vect[i].getPrice();
	}
	double avg = soma / n;
	System.out.println("Media de preços: $ "+avg);
    sc.close();
	}

}

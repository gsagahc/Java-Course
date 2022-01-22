import java.util.Scanner;
import java.util.Vector;

public class Application {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		System.out.println("Digite a quantidade de itens:");
		int n = sc.nextInt();
		double[] vect = new double[n];
		for (int i=0; i<n; i++) {
			vect[i] = sc.nextDouble();
		}
		
		double sum =0.0;
		
		for (int i=0; i < vect.length; i++ ) {
			sum+=vect[i];
		}
		double media = sum/n;
		
		System.out.println("A média dos itens do vetor é:"+ media);
		
		sc.close();
	}

}

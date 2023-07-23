package Main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FibonacciPrimes {

    // Verifica se um número é primo
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite a quantidade de números na sequência de Fibonacci: ");
        int n = scanner.nextInt();

        // Gerando a sequência de Fibonacci
        int[] fibonacci = new int[n];
        fibonacci[0] = 0;
        fibonacci[1] = 1;
        for (int i = 2; i < n; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        // Criando uma lista de números primos com a mesma quantidade de números da sequência de Fibonacci
        List<Integer> primesList = new ArrayList<>();
        int count = 0;
        int num = 2;
        while (count < n) {
            if (isPrime(num)) {
                primesList.add(num);
                count++;
            }
            num++;
        }

        // Exibindo a sequência de Fibonacci e a lista de números primos
        System.out.println("Sequência de Fibonacci:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci[i] + " ");
        }
        System.out.println();

        System.out.println("Lista de números primos:");
        for (int i = 0; i < primesList.size(); i++) {
            System.out.print(primesList.get(i) + " ");
        }
        System.out.println();
    }
}
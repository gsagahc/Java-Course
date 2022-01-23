
package appfibonasse;
import java.util.Scanner;
/**
 *
 * @author gui
 */
public class AppFibonasse {
   private static boolean Primo(int numero) {
    for (int j = 2; j < numero; j++) {
        if (numero % j == 0)
                
            return false;   
    }
    return true;
}
    public static void main(String[] args) {
        int numero;
        char resposta;
        Fibonacci fibo;
        int[] ArrayPrimos;
        Scanner sc = new Scanner(System.in);
        
          System.out.println("Digite um número: ");
          numero = sc.nextInt();
          int quadrado = numero* numero;
          fibo = new Fibonacci(quadrado);
          ArrayPrimos = new int[numero];
          int n =0 ;
          
          for(int i = 2; i < quadrado; i++ )
          {
            if (Primo(fibo.Arrayfibonacci[i]) ){
                ArrayPrimos[n] = fibo.Arrayfibonacci[i];
                n++;
            }
            if (n == numero){
                break;
            }
            
          }
          for (int i=0; i< numero; i++){
            System.out.println(ArrayPrimos[i]);
           
        }
      
        
     
    }
    
}

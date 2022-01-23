/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appfibonasse;

/**
 *
 * @author gui
 */
public class Fibonacci {
    int[] Arrayfibonacci;
    public Fibonacci(int quantidade)
    {
       Arrayfibonacci = new int[quantidade];
       for (int i = 0; i < quantidade; i++){
           if (i <= 1){
              Arrayfibonacci[i] = 1 ;
           }
           if (i > 1){
             Arrayfibonacci[i] = Arrayfibonacci[i-1] + Arrayfibonacci[i-2] ;
           }  
       }
       
    }
    
}

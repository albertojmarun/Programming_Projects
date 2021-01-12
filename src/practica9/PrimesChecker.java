/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.HashSet;

/**
 *
 * @author AlbertoMarun
 */
public class PrimesChecker {
    
    private HashSet<Integer> prime_numbers;
    private Integer max_integer;
    
    /**
     * 
     * @param max 
     */
    public PrimesChecker(int max){
        prime_numbers = new HashSet<>();
        max_integer = max;
        
        for (int i = 0; i < max; i++){
            if(checkPrime(i)){
                prime_numbers.add(i);
            }
        }
    }
    
    /**
     * 
     * @param number
     * @return 
     */
    private static boolean checkPrime(int number){
        boolean prime = true;
        
        if (number == 1){
            prime = false;
        }
        
        for(int i = 2; prime && i < number; i++){
            if(number % i == 0){
                prime = false;
            }
        }
        
        return prime;
    }
    
    public static void main(String[] args){
        System.out.println(checkPrime(1));
    }
}

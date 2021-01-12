package practica9;

import java.util.HashSet;

/**
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date January 08, 2021.
 */
public class PrimesChecker {
    
    private HashSet<Integer> prime_numbers;
    private Integer max_integer;
    
    /**
     * Initialize the Set and stablish the maximum integer to analyze.
     * @param max (int) Maximum integer to find a primer number, inclusive.
     */
    public PrimesChecker(int max){
        prime_numbers = new HashSet<>();
        max_integer = max;
        
        for (int i = 0; i <= max; i++){
            if(checkPrime(i)){
                prime_numbers.add(i);
            }
        }
    }
    
    /**
     * This functions, find if a number is Prime or not, without taking into account the max_integer.
     * @param number (int) number to analyze.
     * @return (boolean) true if the number is prime and false if the number is not prime.
     */
    private boolean checkPrime(int number){
        boolean prime = true;
        
        if (number == 1 || number == 0){
            prime = false;
        }
        
        for(int i = 2; prime && i < number; i++){
            if(number % i == 0){
                prime = false;
            }
        }
        
        return prime;
    }
    
    /**
     * Analyze if a number is Prime or not, taking into account the max_integer.
     * @param number (int) number to find if it's prime or not.
     * @return (boolean) true if the number is prime and false if the number is not prime.
     */
    public boolean isPrime(int number){
        boolean prime = false;
        
        if(number > max_integer){
            for(int i = max_integer + 1; i <= number; i++){
                if(checkPrime(i)){
                    prime_numbers.add(i);
                }
            }
            
            max_integer = number;
        }
        
        if(prime_numbers.contains(number)){
            prime = true;
        }
        
        return prime;
    }
    
    /**
     * Show on terminal how many numbers are prime between 1 and the max_integer.
     */
    public void showStats(){
        System.out.printf("Del 1 al %d hay %d números primos.\n", max_integer, prime_numbers.size());
    }
}

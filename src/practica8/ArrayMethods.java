/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

// EDITADO EN WINDOWS
import java.util.Scanner;

/**
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date December 09, 2020.
 */
public class ArrayMethods {
    
    /**
     * 
     * @param array 
     */
    public static void show(int[] array){
        for (int i = 0; i < array.length; i++){
            if ( i == 0){
                System.out.printf("{%d, ", array[i]);
            }
            else if(i + 1 == array.length){
                System.out.printf("%d}", array[i]);
            }
            else {
                System.out.printf("%d, ", array[i]);
            }
        }
    }
    
    /**
     * 
     * @param array 
     */
    public static void fill(int[] array){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < array.length; i++){
            System.out.printf("Introduzca el elemento %d: ", i);
            array[i] = scanner.nextInt();
        }
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static double average(int[] array){
        double average = 0;

        for(int i = 0; i < array.length; i++){
            average += array[i];
        }

        average /= array.length;

        return average;
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int countEvenNumbers(int[] array){
        int even_numbers = 0;

        for(int i = 0; i < array.length; i++){
            if(array[i] % 2 == 0){
                even_numbers++;
            }
        }

        return even_numbers;
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int countOddNumbers(int[] array){
        int odd_numbers = 0;

        odd_numbers = array.length - countEvenNumbers(array);

        return odd_numbers;
    }
    
    /**
     * 
     * @param array
     * @param number
     * @return 
     */
    public static boolean hasInteger(int[] array, int number){
        boolean haveIt = false;

        for(int i = 0; i < array.length && !haveIt; i++){
            if(number == array[i]){
                haveIt = true;
            }
        }

        return haveIt;
    }
    
    /**
     * 
     * @param array 
     */
    public static void reverse(int[] array){
        int[] temporal_array = new int[array.length];

        for (int i = 0; i < array.length; i++){
            temporal_array[i] = array[array.length - i - 1];
        }

        for (int i = 0; i < array.length; i++){
            array[i] = temporal_array[i];
        }
    }
    
    /**
     * 
     * @param first
     * @param second
     * @return 
     */
    public static int[] sum(int[] first, int[] second){
        int[] array;
        
        if(first.length >= second.length){
            array = new int[first.length];
            
            for(int i = 0; i < first.length; i++){
                
                if(i <= second.length - 1){
                    array[i] = first[i] + second[i];
                    
                } else {
                    array[i] = first[i];
                }
            }
            
        } else {
            array = new int[second.length];
            
            for(int i = 0; i < second.length; i++){
                
                if(i <= first.length - 1){
                    array[i] = first[i] + second[i];
                    
                } else {
                    array[i] = second[i];
                }
            }
        }
        
        return array;
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int min(int[] array){
        int minimum;
        
        minimum = array[0];
        
        for(int i = 0; i < array.length; i++){
            if(array[i] < minimum){
                minimum = array[i];
            }
        }
        
        return minimum;
    }
    
    /**
     * 
     * @param array
     * @return 
     */
    public static int max(int[] array){
        int maximum;
        
        maximum = array[0];
        
        for(int i = 0; i < array.length; i++){
            if(array[i] > maximum){
                maximum = array[i];
            }
        }
        
        return maximum;
    }
    
    public static void main(String[] args){
        int[] array = {1, 2, 3};
        int[] array2 = {1, 4};
        
        
        ArrayMethods.show(array);
    }
}

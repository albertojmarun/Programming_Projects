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
    
    // REVISA AQUI IDIOTA
    /**
     * 
     * @param matrix 
     */
    public static void show(int[][] matrix){
        System.out.println("{");
        
        for(int i = 0; i < matrix.length; i++){
            System.out.print("\t{");
            
            for(int j = 0; j < matrix[i].length; j++){
                if(j + 1 == matrix[i].length){
                    System.out.printf("%d}\n", matrix[i][j]);
                } else {
                    System.out.printf("%d, ", matrix[i][j]);
                }
            }
        }
        
        System.out.println("}");
    }
    
    /**
     * 
     * @param matrix 
     */
    public static void fill(int[][] matrix){
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < matrix.length; i++){
            
            System.out.printf("En la fila %d:\n", i);
            
            for(int j = 0; j < matrix[i].length; j++){
                System.out.printf("Introduzca el elemento %d: ", j);
                matrix[i][j] = scanner.nextInt();
            }
            
            System.out.println();
        }
    }
    
    /**
     * 
     * @param matrix
     * @return 
     */
    public static int[] diagonal(int[][] matrix){
        int[] array;
        
        if(matrix.length == matrix[0].length){
            array = new int[matrix.length];
            
            for(int i = 0; i < matrix.length; i++){
                for(int j = 0; j < matrix[i].length; j++){
                    if (i == j){
                        array[i] = matrix[i][j];
                    }
                }
            }
            
        } else{
            System.out.println("The matrix is not an Square Matrix");
            array = new int[0];
        }
        
        return array;
    }
    
    /**
     * 
     * @param matrix
     * @return 
     */
    public static int[] summatoryPerRow(int[][] matrix){
        int[] array = new int[matrix.length];
        
        for(int i = 0; i < matrix.length; i++){
           
            for(int j = 0; j < matrix[i].length; j++){
                array[i] += matrix[i][j];
            }
            
        }
        
        return array;
    }
    
    /**
     * SEE HERE
     * @param matrix
     * @return 
     */
    public static int[] summatoryPerColumn(int[][] matrix){
        int[] array = new int[matrix.length];
        int i = 0;
        
        for (int j = 0; j < matrix[i].length; j++){
            for(i = 0; i < matrix.length; i++){
                array[j] = matrix[i][j];
            }
        }
        return array;
    }
    
    /**
     * 
     * @param input
     * @return 
     */
    public static String firstCharToMayus(String input){
        String output;
        
        output = input.toUpperCase().charAt(0) + input.substring(1).toLowerCase();
        
        return output;
    }
    
    public static void main(String[] args){
        
    }
}

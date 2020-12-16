/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica8;

import java.util.Scanner;

/**
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date December 09, 2020.
 */
public class ArrayMethods {
    
    /**
     * Show the values on Terminal of an array of integers.
     * @param array It is an array of integers 
     */
    public static void show(int[] array){
        int i;
        
        System.out.print("{");
        
        for (i = 0; i < array.length - 1; i++){            
            System.out.printf("%d, ", array[i]);
        }
        
        System.out.printf("%d}\n", array[i]);
    }
    
    /**
     * Asign the values of every element of the array of int.
     * @param array It is an array of integers.
     */
    public static void fill(int[] array){
        Scanner scanner = new Scanner(System.in);

        for(int i = 0; i < array.length; i++){
            System.out.printf("Introduzca el elemento %d: ", i);
            array[i] = scanner.nextInt();
        }
    }
    
    /**
     * Return the average of the elements on the array.
     * @param array It is an array of integers.
     * @return The average all the elements inside the array.
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
     * Count how many Even numbers appears in the Array.
     * @param array An array of int.
     * @return The number of time that appears an Even Number.
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
     * Count how many Odd numbers appears in the Array.
     * @param array An array of int.
     * @return The number of time that appears an Odd Number.
     */
    public static int countOddNumbers(int[] array){
        int odd_numbers;

        odd_numbers = array.length - countEvenNumbers(array);

        return odd_numbers;
    }
    
    /**
     * Check if an exact number appears on the array.
     * @param array An array of int, to check if it has an exact number or not.
     * @param number The number to check if it is on the array.
     * @return A boolean value that is true if the number appears on the array or false in the contrary case.
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
     * Reverse the order of the values of the Elements.
     * @param array An array of int, to reverse the order of the values.
     */
    public static void reverse(int[] array){
        int[] temporal_array = new int[array.length];
        int i;
        
        for (i = 0; i < array.length; i++){
            temporal_array[i] = array[array.length - i - 1];
        }

        for (i = 0; i < array.length; i++){
            array[i] = temporal_array[i];
        }
    }
    
    /**
     * Sum the elements of two Arrays.
     * @param first Array to Sum.
     * @param second Array to Sum.
     * @return The Adittion of First and Second array.
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
     * See which is the Element with less value and return it, in an Array of Int.
     * @param array An Array of int to analyze.
     * @return The minimun value 
     */
    public static int min(int[] array){
        int minimum;
        
        minimum = 0;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] < minimum){
                minimum = array[i];
            }
        }
        
        return minimum;
    }
    
    /**
     * Find the value of the Maximum Element inside an Array
     * @param array The array of int to Analyze and find the maximum value.
     * @return The value of the Element with highest value.
     */
    public static int max(int[] array){
        int maximum;
        
        maximum = 0;
        
        for(int i = 0; i < array.length; i++){
            if(array[i] > maximum){
                maximum = array[i];
            }
        }
        
        return maximum;
    }
    
    /** 
     * Show the Rows and Columns of a Matrix.
     * @param matrix Matrix to Show each elements.
     */
    public static void show(int[][] matrix){
        System.out.println("{");
        
        for(int i = 0; i < matrix.length; i++){
            System.out.print("\t");
            show(matrix[i]);
        }
        
        System.out.println("}");
    }
    
    /**
     * Fill a Matrix with already values for column and rows.
     * @param matrix Is the Matrix to fill all the elements.
     */
    public static void fill(int[][] matrix){
        Scanner scanner = new Scanner(System.in);
        
        for(int i = 0; i < matrix.length; i++){
            
            System.out.printf("En la fila %d:\n", i);
            fill(matrix[i]);
            System.out.println();
        }
    }
    
    /**
     * Find the Diagonal of a Matrix and return in an Array its Diagonal.
     * @param matrix The Matrix to find its Diagonal.
     * @return An array with the value of the Diagonal of the Original Matrix.
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
     * Sum the values of elements inside each Row and return an Array with the corresponding Adittion.
     * @param matrix To sum each element per row.
     * @return An array with the values of each row.
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
     * Sum the value of each element in a column on the Matrix.
     * @param matrix Matrix to sum each column.
     * @return an Array with the value of each column.
     */
    public static int[] summatoryPerColumn(int[][] matrix){
        int[] array = new int[matrix.length];
        
        for(int i = 0; i < matrix.length; i++){
            
            for(int j = 0; j < matrix[i].length; j++){
                array[i] += matrix[j][i];
            }
            
        }
        
        return array;
    }
    
    /**
     * Capitalize the First letter of any String and make lowercase the rest.
     * @param input String to convert.
     * @return String converted wit the format of Capitalize first letter and the rest lowercase.
     */
    public static String firstCharToMayus(String input){
        String output;
        
        output = input.toUpperCase().charAt(0) + input.substring(1).toLowerCase();
        
        return output;
    }
    
}

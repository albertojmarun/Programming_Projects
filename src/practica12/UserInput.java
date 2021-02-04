/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is about the information of an Employee
 * @version 1.0
 * @author Alberto Marun
 */
public class UserInput {
    private final static Scanner scanner = new Scanner(System.in);
    private final static Scanner USER_INPUT_STRING = new Scanner(System.in);
    
    /**
     * This function get an Integer and if there is an Exception will repeat until is true.
     * @return (int) the number introduced by the user.
     */
    public static int getInt(){
        boolean condition;
        int variable = 0;
        
        do{
            try{
                variable = scanner.nextInt();
                condition = true;
            
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("Por favor, introduzca un número entero: ");                
                condition = false;
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * This function get a Double entered by the user inside the function without crashing if it is not a double.
     * @return (double) the number introduced by the user.
     */
    public static double getDouble(){
        boolean condition;
        double variable = 0;
        
        do{
            try{
                variable = scanner.nextDouble();
                condition = true;
            
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("Por favor, introduzca un número real: ");                
                condition = false;
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * 
     * @return 
     */
    public static boolean getBoolean(){
        boolean condition;
        boolean variable = false;
        
        do{
            try{
                variable = scanner.nextBoolean();
                condition = true;
            
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("Por favor, introduzca un booleano: ");                
                condition = false;
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * 
     * @return 
     */
    public static char getChar(){
        boolean condition;
        char variable = ' ';
        
        do{
            try{
                variable = scanner.next().charAt(0);
                condition = true;
            
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("Por favor, introduzca un caracter: ");                
                condition = false;
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * 
     * @return 
     */
    public static String getString(){
        boolean condition;
        String variable = " ";
        
        do{
            try{
                variable = USER_INPUT_STRING.nextLine();
                condition = true;
            
            } catch (InputMismatchException e){
                scanner.nextLine();
                System.out.print("Por favor, introduzca una cadena de Caracteres: ");                
                condition = false;
            }
        } while(!condition);
        
        return variable;
    }
}

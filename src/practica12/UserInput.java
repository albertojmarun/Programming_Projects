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
     * 
     * @return 
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
     * 
     * @return 
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
    
    public static void main(String[] args){
        
        System.out.println("INT");
        getInt();
        
        System.out.println("DOUBLE");
        getDouble();
        
        System.out.println("BOOLEAN");
        getBoolean();
        
        System.out.println("CHAR");
        getChar();
        
        System.out.println("STRING");
        getString();
    }
}

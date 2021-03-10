/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import practica12.*;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is about the information of an Employee
 * @version 1.0
 * @author Alberto Marun
 */
public class UserInput {
    private final static Scanner USER_INPUT = new Scanner(System.in);
    private final static Scanner USER_INPUT_STRING = new Scanner(System.in);
    
    /**
     * This function get an Integer and if there is an Exception will repeat until is true.
     * @return (int) the number introduced by the user.
     */
    public static int getInt(){
        boolean condition = false;
        int variable = 0;
        
        do{
            try{
                variable = USER_INPUT.nextInt();
                condition = true;
            
            } catch (InputMismatchException e){
                USER_INPUT.nextLine();
                System.out.print("Por favor, introduzca un número entero: ");                
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * This function get a Double entered by the user inside the function without crashing if it is not a double.
     * @return (double) the number introduced by the user.
     */
    public static double getDouble(){
        boolean condition = false;
        double variable = 0;
        
        do{
            try{
                variable = USER_INPUT.nextDouble();
                condition = true;
            
            } catch (InputMismatchException e){
                USER_INPUT.nextLine();
                System.out.print("Por favor, introduzca un número real: ");
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * This function obliges to the user to insert a boolean value (true or false)
     * @return (boolean) true or false.
     */
    public static boolean getBoolean(){
        boolean condition = false;
        boolean variable = false;
        
        do{
            try{
                variable = USER_INPUT.nextBoolean();
                condition = true;
            
            } catch (InputMismatchException e){
                USER_INPUT.nextLine();
                System.out.print("Por favor, introduzca un booleano: ");
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * This function obliges to the user to introduce a Char (Only one char).
     * @return (char) 1 character that cannot be an String or a number.
     */
    public static char getChar(){
        boolean condition = false;
        String variable;
        char uq_char = ' ';
        
        do{
            try{
                variable = USER_INPUT_STRING.nextLine();
                
                if(variable.length() > 1 || variable.isEmpty() || isNumber(variable.charAt(0))){
                    condition = false;
                    throw new InputMismatchException();
                    
                } else{
                    uq_char = variable.charAt(0);
                    condition = true;
                }
                
            } catch (InputMismatchException e){
                System.out.print("Por favor, introduzca un caracter: ");
            }
        } while(!condition);
        
        return uq_char;
    }
    
    /**
     * This function obliges to the user to introduce a String without numbers.
     * @return (String) This is a text, and can't contain a number in the whole text.
     */
    public static String getString(){
        boolean condition = false;
        String variable = "";
        
        do{
            try{
                variable = USER_INPUT_STRING.nextLine();
                condition = true;
                
                if(variable.length() <= 1 || !haveNumericCharacters(variable)){
                    condition = false;
                    throw new InputMismatchException();
                }
                
            } catch (InputMismatchException e){
                System.out.print("Por favor, introduzca una cadena de Caracteres: ");
            }
        } while(!condition);
        
        return variable;
    }
    
    /**
     * This functions check if a String have numbers or not.
     * @param cadena (String) Text to analyze.
     * @return (boolean) true (if it doesn't have number inside) or false (if it has a number inside).
     */
    private static boolean haveNumericCharacters(String characters) {
        boolean resultado;

        try {
            haveNumber(characters);
            resultado = true;
        
        } catch (NumberFormatException e) {
            resultado = false;
        }

        return resultado;
    }
    
    /**
     * Check if a character is a number or not.
     * @param digit (char) Character to check if it is a number or not.
     * @return (boolean) true (if it is a number) or false (if it is not a number).
     */
    private static boolean isNumber(char digit){
        boolean condition = false;
        
        if(digit == '1' || digit == '2' ||  digit == '3' ||  digit == '4' ||  digit == '5' ||  digit == '6' ||  digit == '7' ||  digit == '8' ||  digit == '9' ||  digit == '0'){
            condition = true;
        }
        
        return condition;
    }
    
    /**
     * Checks if a String has or not a number inside.
     * @param cadena (String) Text to Analyze.
     */
    private static void haveNumber(String characters){
        for(int i = 0; i < characters.length(); i++){
            if(isNumber(characters.charAt(i))){
                throw new NumberFormatException();
            }
        }
    }
}

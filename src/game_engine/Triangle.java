/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.Scanner;

/**
 * @version 1.0
 * @date January 26, 2021.
 * @author Alberto J. Marun I.
 */
public class Triangle extends Shape2D{
    private double base, height;
    
    /**
     * This is the constructor of the Triangle Class.
     */
    public Triangle(){
        super("triangulo");
    }
    
    /**
     * This function set the new value for the base of the Triangle.
     * @param new_value (double) new value to assign to the base of the triangle (greater or equal to zero).
     */
    public void setBase(double new_value){
        if(new_value >= 0){
            this.base = new_value;   
        }
    }
    
    /**
     * This function return the actual value of the base of the triangle.
     * @return (double) Actual value of the base of the Triangle.
     */
    public double getBase(){
        return this.base;
    }
    
    /**
     * This function set the new value to the height of the triangle.
     * @param new_value (double) new value to assign to the height of the triangle (greater or equal to zero).
     */
    public void setHeight(double new_value){
        if(new_value >= 0){
            this.height = new_value;   
        }
    }
    
    /**
     * This function return the actual value of the height of the triangle.
     * @return (double) Actual value of the height of the Triangle.
     */
    public double getHeight(){
        return this.height;
    }
    
    /**
     * Set the base and height of the Triangle.
     */
    @Override
    public void getShapeData(){
        Scanner scanner = new Scanner(System.in);
        double[] new_value = new double[2];
        
        do{
            System.out.print("¿Cuál es la longitud de la base del Triangulo? ");
            new_value[0] = scanner.nextDouble();

            if(new_value[0] < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
        } while (new_value[0] < 0);
        
        do{
            System.out.print("¿Cuál es la longitud de la altura del Triangulo? ");
            new_value[1] = scanner.nextDouble();
            
            System.out.println();
            
            if(new_value[1] < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
        } while (new_value[1] < 0);
        
        setBase(new_value[0]);
        setHeight(new_value[1]);
    }
    
    /**
     * This function returns the Area of the Triangle with the equation ((Height * Base) / 2)
     * @return (double) Area of the Triangle following the formula.
     */
    @Override
    public double getArea(){
        return ( getHeight() * getBase() ) / 2;
    }
}

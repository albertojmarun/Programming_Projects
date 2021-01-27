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
public class Square extends Shape2D{
    private double size;
    
    /**
     * Constructor of a Square Shape.
     */
    public Square(){
        super("cuadrado");
    }
    
    /**
     * This functions get the size of the four sides of the Triangle.
     */
    @Override
    public void getShapeData() {
        Scanner scanner = new Scanner(System.in);
        double new_size;
        
        do{
            System.out.print("¿Cuál es la longitud de un lado del Cuadrado? ");
            new_size = scanner.nextDouble();

            System.out.println();

            if(new_size < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
            
        } while (new_size < 0);
        
        setSize(new_size);
    }
    
    /**
     * This function returns the Area of the Square with the formula (side * side)
     * @return (double) Area of the Square (Formula: side * side).
     */
    @Override
    public double getArea(){
        return (getSize() * getSize());
    }
    
    /**
     * Assign a new value to the sides of the Square.
     * @param new_size (double) new_size to assign to the sides of the Square (Needs to be equal or greater than 0).
     */
    public void setSize(double new_size){
        if(new_size >= 0){
            this.size = new_size;
        }
    }
    
    /**
     * Returns the actual value of the sides of the Square.
     * @return (double) Value of the sides of the Square.
     */
    public double getSize(){
        return this.size;
    }
}

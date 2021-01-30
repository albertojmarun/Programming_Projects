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
public class Circle extends Shape2D{
    final double PI = 3.141592;
    private double radius;
    
    /**
     * This is the constructor of the class Circle.
     */
    public Circle(){
        super("circulo");
    }
    
    /**
     * This functions set the radius of the circle.
     * @param new_radius (double) Needs to be greater or equal to 0.
     */
    public void setRadius(double new_radius){
        if(new_radius >= 0){
            this.radius = new_radius;
        }
    }
    
    /**
     * This functions returns the actual radius of the Circle.
     * @return (double) Actual radius of the Circle.
     */
    public double getRadius(){
        return this.radius;
    }
    
    /**
     * This functions ask the user to introduce the radius of the circle, needs to be equal or greater than 0.
     */
    @Override
    public void getShapeData() {
        Scanner scanner = new Scanner(System.in);
        double new_radius;
        
        do{
            System.out.print("¿Cuál es la longitud del radio del Circulo? ");
            new_radius = scanner.nextDouble();
            
            System.out.println();
            
            if(new_radius < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
            
        } while (new_radius < 0);
        
        setRadius(new_radius);
    }
    
    /**
     * This functions returns the Area of a Circle with the formula (radius^2 * PI).
     * @return (double) Area of the Circle.
     */
    @Override
    public double getArea(){
        return (getRadius() * getRadius() * PI);
    }
}

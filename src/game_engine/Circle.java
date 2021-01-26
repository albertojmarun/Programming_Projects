/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.Scanner;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class Circle extends Shape2D{
    final double PI = 3.141592;
    private double radius;
    Scanner scanner = new Scanner(System.in);
    
    public Circle(){
        super("circulo");
    }
    
    /**
     * 
     * @param new_radius 
     */
    public void setRadius(double new_radius){
        if(new_radius >= 0){
            this.radius = new_radius;
        }
    }
    
    /**
     * 
     * @return 
     */
    public double getRadius(){
        return this.radius;
    }
    
    /**
     * 
     */
    @Override
    public void getShapeData() {
        double new_radius;
        
        do{
            System.out.print("¿Cuál es la longitud del radio del Circulo? ");
            new_radius = scanner.nextDouble();
            
            if(new_radius < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
            
        } while (new_radius < 0);
        
        setRadius(new_radius);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double getArea(){
        return (getRadius() * getRadius() * PI);
    }
}

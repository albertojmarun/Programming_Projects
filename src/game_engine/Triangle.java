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
    // PONER EN CADA FUNCION
    Scanner scanner = new Scanner(System.in);
    
    public Triangle(){
        super("triangulo");
    }
    
    public void setBase(double new_value){
        this.base = new_value;
    }
    
    public double getBase(){
        return this.base;
    }
    
    public void setHeight(double new_value){
        this.height = new_value;
    }
    
    public double getHeight(){
        return this.height;
    }
    
    /**
     * 
     */
    @Override
    public void getShapeData(){
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
            new_value[0] = scanner.nextDouble();

            if(new_value[1] < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
        } while (new_value[1] < 0);
        
        setBase(new_value[0]);
        setHeight(new_value[1]);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double getArea(){
        return ( getHeight() * getBase() ) / 2;
    }
}

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
public class Square extends Shape2D{
    private double size;
    Scanner scanner = new Scanner(System.in);
    
    /**
     * Constructor of a Square Shape.
     */
    public Square(){
        super("cuadrado");
    }
    
    /**
     * 
     */
    @Override
    public void getShapeData() {
        double new_size;
        
        do{
            System.out.print("¿Cuál es la longitud de un lado del Cuadrado? ");
            new_size = scanner.nextDouble();
            
            if(new_size < 0){
                System.out.println("Debe introducir un valor mayor o igual a 0.\n");
            }
            
        } while (new_size < 0);
        
        setSize(new_size);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public double getArea(){
        return (getSize() * getSize());
    }
    
    /**
     * 
     * @param new_size 
     */
    public void setSize(double new_size){
        if(new_size >= 0){
            this.size = new_size;
        }
    }
    
    public double getSize(){
        return this.size;
    }
    
    
}

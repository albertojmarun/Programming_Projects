/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

/**
 * @version 1.0
 * @date January 26, 2021.
 * @author Alberto J. Marun I.
 */
public abstract class Shape2D {
    private String name;
    
    /**
     * Constructor of any Bidimensional Shape.
     * @param new_name (String) Name to be set.
     */
    public Shape2D(String new_name){
       setName(new_name); 
    }
    
    /**
     * Stablish the Name 
     * @param new_name (String) Name of the new Shape.
     */
    private void setName(String new_name){
        name = new_name;
    }
    
    /**
     * Get the name of the Bidimensional Shape.
     * @return (String) Name of the Shape.
     */
    public String getName(){
        return this.name;
    }
    
    /**
     * Get the Data of Any Shape Bidimensional.
     */
    public abstract void getShapeData();
    
    /**
     * Get the Area of any Shape Bidimensional.
     * @return (double) Area of the Shape.
     */
    public abstract double getArea();
}

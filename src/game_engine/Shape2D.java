/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import static game_engine.Colorful.MAXIMUM_VALUE_OF_COLOR;
import static game_engine.Colorful.MINIMUM_VALUE_OF_COLOR;

/**
 * @version 1.0
 * @date January 26, 2021.
 * @author Alberto J. Marun I.
 */
public abstract class Shape2D implements Colorful {
    private String name;
    private int red, green, blue;
    
    /**
     * Constructor of any Bidimensional Shape.
     * @param new_name (String) Name to be set.
     */
    public Shape2D(String new_name){
       setName(new_name);
        red = 0;
        green = 0;
        blue = 0;
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
    
    
    /**
     * Function that check if the value entered is between the Minimum and Maximum.
     * @param new_value (int) Value to check if it is between the min and max (inclusive).
     * @return (int) value entered 
     */
    private int setValue(int new_value){
        if(new_value < MINIMUM_VALUE_OF_COLOR){
            new_value = MINIMUM_VALUE_OF_COLOR;
            
        } else if(new_value > MAXIMUM_VALUE_OF_COLOR ){
            new_value = MAXIMUM_VALUE_OF_COLOR;
            
        }
        
        return new_value;
    }
    
    /**
     * Assign the new value to the red parameter.
     * @param new_value (int) Assign the new value to the red parameter.
     */
    @Override
    public void setRed(int new_value){
        this.red = setValue(new_value);
    }
    
    /**
     * Returns the actual value of the red parameter.
     * @return (int) Return the actual value of the red parameter.
     */
    @Override
    public int getRed(){
        return this.red;
    }
    
    /**
     * This function set the new value for the green parameter.
     * @param new_value (int) Value to assign to the green parameter.
     */
    @Override
    public void setGreen(int new_value){        
        this.green = setValue(new_value);
    }
    
    /**
     * This function return the value of the green parameter.
     * @return (int) value of the green parameter.
     */
    @Override
    public int getGreen(){
        return this.green;
    }
    
    /**
     * This function sets the new value for the color Blue.
     * @param new_value (int) New value to assign to the color Blue.
     */
    @Override
    public void setBlue(int new_value){
        this.blue = setValue(new_value);
    }
    
    /**
     * This function returns the value of the parameter Blue.
     * @return (int) Value of the Parameter Blue.
     */
    @Override
    public int getBlue(){
        return this.blue;
    }
}

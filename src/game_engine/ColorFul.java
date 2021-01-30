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
public interface Colorful {
    
    // CONSTANTS (MINIMUM AND MAXIMUM VALUE FOR A COLOR IN THE RGB SYSTEM).
    static final int MINIMUM_VALUE_OF_COLOR = 0;
    static final int MAXIMUM_VALUE_OF_COLOR = 255;
    
    /**
     * This function set the value for the RED parameter.
     * @param new_value (Value to the Red Color).
     */
    public void setRed(int new_value);
    
    /**
     * This function return the value of the RED.
     * @return (int) Number that corresponds the value to the RED parameter.
     */
    public int getRed();
    
    /**
     * This function set the value for the GREEN parameter.
     * @param new_value (Value to the Green Color).
     */
    public void setGreen(int new_value);
    
    /**
     * This function return the value of the GREEN.
     * @return (int) Number that corresponds the value to the GREEN parameter.
     */
    public int getGreen();
    
    /**
     * This function set the value for the BLUE parameter.
     * @param new_value (Value to the Blue Color).
     */
    public void setBlue(int new_value);
    
    /**
     * This function return the value of the BLUE.
     * @return (int) Number that corresponds the value to the BLUE parameter.
     */
    public int getBlue();
}

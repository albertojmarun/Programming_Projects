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
public interface ColorFul {
    
    static final int MINIMUM_VALUE_OF_COLOR = 0;
    static final int MAXIMUM_VALUE_OF_COLOR = 255;
    
    public void setRed(int new_value);
    
    public int getRed();
    
    public void setGreen(int new_value);
    
    public int getGreen();
    
    public void setBlue(int new_value);
    
    public int getBlue();
}

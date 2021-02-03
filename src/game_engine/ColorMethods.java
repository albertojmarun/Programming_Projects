/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.Scanner;

/**
 * @version 1.0
 * @param <C> Class that implements the Interface Colorful.
 * @date January 26, 2021.
 * @author Alberto J. Marun I.
 */
public class ColorMethods<C extends Colorful>{
    
    /**
     * This function sets the value for colors Red, Green and Blue in the RGB System.
     * @param <C> Class that implements the Interface Colorful.
     * @param colors 
     */
    static public <C extends Colorful> void setColor(C colors){
        Scanner scanner = new Scanner(System.in);
        int color_value;
        
        System.out.println("Valores RGB (Entre 0 y 255).");
        
        System.out.print("Introduce el valor del color rojo: ");
        color_value = scanner.nextInt();
        colors.setRed(color_value);
        
        System.out.print("Introduce el valor del color verde: ");
        color_value = scanner.nextInt();
        colors.setGreen(color_value);
        
        System.out.print("Introduce el valor del color azul: ");
        color_value = scanner.nextInt();
        colors.setBlue(color_value);
        
        System.out.println();
    }
    
    /**
     * This function shows the value for the Red, Green and Blue at the RGB System.
     * @param <C> Class that implements the Interface Colorful.
     * @param colors 
     */
    static public <C extends Colorful> void showColor(C colors){
        System.out.printf("Color: [R: %d, G: %d, B: %d]\n\n", colors.getRed(), colors.getGreen(), colors.getBlue());
    }
    
}

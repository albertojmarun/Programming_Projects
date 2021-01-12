/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.ArrayList;

/**
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date January 08, 2021.
 */
public class Menu {
    private ArrayList<String> dishes;
    
    /**
     * Initialize the List of dishes
     */
    public Menu(){
        dishes = new ArrayList<>();
    }
    
    /**
     * Add new dishes to the list.
     * @param dish (String) Name of the new Item.
     * @param index (int) Position of the new Item.
     */
    public void addDish(String dish, int index){
        
        if(index >= 0 && index <= dishes.size()){
            dishes.add(index, dish);
        }
    }
    
    /**
     * Change the name of a Dish.
     * @param dish (String) New name of the Dish.
     * @param index (Index) Position on the List to change the name of the Dish.
     */
    public void setDish(String dish, int index){
        
        if(index >= 0 && index < dishes.size()){
            dishes.set(index, dish);
        }
    }
    
    /**
     * 
     * @param index 
     */
    public void removeDish(int index){
        
        if (index >= 0 && index < dishes.size()){
            dishes.remove(index);
        }
    }
    /**
     * 
     */
    public void showDishes(){
        
        for(String dish : dishes){
            System.out.printf("- \t %s\n", dish);
        }
    }
}

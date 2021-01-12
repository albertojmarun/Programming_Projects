/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.util.ArrayList;

/**
 *
 * @author AlbertoMarun
 */
public class Menu {
    //
    private ArrayList<String> dishes;
    
    /**
     * 
     */
    public Menu(){
        dishes = new ArrayList<>();
    }
    
    /**
     * 
     * @param dish
     * @param index 
     */
    public void addDish(String dish, int index){
        
        if(index >= 0 && index <= dishes.size()){
            dishes.add(index, dish);
        }
    }
    
    /**
     * 
     * @param dish
     * @param index 
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

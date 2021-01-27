/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.ArrayList;

/**
 * @version 1.0
 * @date January 26, 2021.
 * @author Alberto J. Marun I.
 */
public class Shape2DList implements ColorFul {
    
    private ArrayList<Shape2D> shapes;
    private int red, green, blue;
    
    public Shape2DList(){
        shapes = new ArrayList<>();
    }
    
    public void addSquare(){
        shapes.add(shapes.size(), new Square());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    public void addCircle(){
        shapes.add(shapes.size(), new Circle());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    public void addTriangle(){
        shapes.add(shapes.size(), new Triangle());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    public void modifyShape(int index){
        if(index >= 0 && index < shapes.size()){
            shapes.get(index).getShapeData();
        }
    }
    
    public void removeShape(int index){
        if(index >= 0 && index < shapes.size()){
            shapes.remove(index);
        }
    }
    
    public void showShapes(){
        for(Shape2D shape : shapes){
            if(shape instanceof Square){
                Square square_shape = (Square) shape;
                System.out.printf("- \t Un cuadrado de %.2fcm de lado\n", square_shape.getSize());
                
            } else if(shape instanceof Circle){
                Circle circle_shape = (Circle) shape;
                System.out.printf("- \t Un círculo de %.2f cm de radio.\n", circle_shape.getRadius());
                
            } else if(shape instanceof Triangle){
                Triangle triangle_shape = (Triangle) shape;
                System.out.printf("- \t Un cuadrado de %.2f cm de base y %.2f cm de altura.\n", triangle_shape.getBase(), triangle_shape.getHeight());
            
            }
        }
        
        System.out.println();
    }
    
    
    public double getTotalArea(){
        double total_area = 0;
        
        for(Shape2D shape : shapes){
            total_area += shape.getArea();
        }
        
        return total_area;
    }
    
    @Override
    public void setRed(int new_value){
        if(new_value < MINIMUM_VALUE_OF_COLOR){
            new_value = MINIMUM_VALUE_OF_COLOR;
            
        } else if(new_value > MAXIMUM_VALUE_OF_COLOR ){
            new_value = MAXIMUM_VALUE_OF_COLOR;
            
        }
        
        this.red = new_value;
    }
    
    @Override
    public int getRed(){
        return this.red;
    }
    
    @Override
    public void setGreen(int new_value){
        if(new_value < MINIMUM_VALUE_OF_COLOR){
            new_value = MINIMUM_VALUE_OF_COLOR;
            
        } else if(new_value > MAXIMUM_VALUE_OF_COLOR ){
            new_value = MAXIMUM_VALUE_OF_COLOR;
            
        }
        
        this.green = new_value;
    }
    
    @Override
    public int getGreen(){
        return this.green;
    }
    
    @Override
    public void setBlue(int new_value){
        if(new_value < MINIMUM_VALUE_OF_COLOR){
            new_value = MINIMUM_VALUE_OF_COLOR;
            
        } else if(new_value > MAXIMUM_VALUE_OF_COLOR ){
            new_value = MAXIMUM_VALUE_OF_COLOR;
            
        }
        
        this.blue = new_value;
    }
    
    @Override
    public int getBlue(){
        return this.blue;
    }
    
    public static void main(String[] args){
        Shape2DList shapes = new Shape2DList();
        
        shapes.addSquare();
        shapes.addCircle();
        shapes.addTriangle();
        
        shapes.showShapes();
        
        System.out.println(shapes.getTotalArea());
    }
}

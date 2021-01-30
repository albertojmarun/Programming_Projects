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
public class Shape2DList{
    private ArrayList<Shape2D> shapes;
    
    /**
     * Constructor of the Class Shape2DList that initialize the ArrayList<> and the value of red, green and blue to 0.
     */
    public Shape2DList(){
        shapes = new ArrayList<>();
    }
    
    /**
     * This function add a Square to the ArrayList<> at the last position.
     */
    public void addSquare(){
        shapes.add(shapes.size(), new Square());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    /**
     * This function add a Circle to the ArrayList<> at the last position.
     */
    public void addCircle(){
        shapes.add(shapes.size(), new Circle());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    /**
     * This function add a Triangle to the ArrayList<> at the last position.
     */
    public void addTriangle(){
        shapes.add(shapes.size(), new Triangle());
        shapes.get(shapes.size() - 1).getShapeData();
    }
    
    /**
     * This function modify the shape of any Figure on the ArrayList<> at the index indicated.
     * @param index (int) position of the figure to modify.
     */
    public void modifyShape(int index){
        if(index >= 0 && index < shapes.size()){
            shapes.get(index).getShapeData();
        }
    }
    
    /**
     * Function to delete a Shape at the index indicated on the ArrayList<>.
     * @param index (int) position of the figure to delete.
     */
    public void removeShape(int index){
        if(index >= 0 && index < shapes.size()){
            shapes.remove(index);
        }
    }
    
    /**
     * Function to show all the Bidimensional shapes on the ArrayList<>.
     */
    public void showShapes(){
        for(Shape2D shape : shapes){
            if(shape instanceof Square){
                Square square_shape = (Square) shape;
                System.out.printf("- \t Un %s de %.2fcm de lado\n", square_shape.getName(), square_shape.getSize());
                
            } else if(shape instanceof Circle){
                Circle circle_shape = (Circle) shape;
                System.out.printf("- \t Un %s de %.2f cm de radio.\n", circle_shape.getName(), circle_shape.getRadius());
                
            } else if(shape instanceof Triangle){
                Triangle triangle_shape = (Triangle) shape;
                System.out.printf("- \t Un %s de %.2f cm de base y %.2f cm de altura.\n", triangle_shape.getName(), triangle_shape.getBase(), triangle_shape.getHeight());
            
            }
        }
        
        System.out.println();
    }
    
    /**
     * Function that calculates the total area of the figures inserted at the ArrayList<>.
     * @return (double) Total Area of the Shapes inside the ArrayList<>.
     */
    public double getTotalArea(){
        double total_area = 0;
        
        for(Shape2D shape : shapes){
            total_area += shape.getArea();
        }
        
        return total_area;
    }
}

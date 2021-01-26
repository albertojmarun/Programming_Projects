/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game_engine;

import java.util.ArrayList;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class Shape2DList {
    private ArrayList<Shape2D> shapes;
    
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
                System.out.printf("- \t Un cuadrado de %.2fcm de lado", square_shape.getSize());
            }
        }
    }
}

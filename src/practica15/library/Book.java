/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica15.library;

import java.util.ArrayList;

/**
 * This class is about a Book.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date March 2021.
 */
public class Book {
    private String title, author, editorial, age;
    private ArrayList<String> genres;
    
    /**
     * Constructor of the Book Class.
     */
    public Book(){
        genres = new ArrayList<String>();
    }
    
    /**
     * Assign a new value to the Title of the Book.
     * @param value (String) new value to assign to the Title of the Book. 
     */
    public void setTitle(String value){
        this.title = value;
    }
    /**
     * Get the Value of the Title of the Book.
     * @return (String) Value of the Title of the Book.
     */
    public String getTitle(){
        return this.title;
    }
    
    /**
     * Assign a new value to the Author of the Book.
     * @param value (String) new value to assign to the Author of the Book. 
     */
    public void setAuthor(String value){
        this.author = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getAuthor(){
        return this.author;
    }
    
    /**
     * Assign a new value to the Editorial of the Book.
     * @param value (String) new value to assign to the Editorial of the Book. 
     */
    public void setEditorial(String value){
        this.editorial = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getEditorial(){
        return this.title;
    }
    
    /**
     * Assign a new value to the Age of the Book.
     * @param value (String) new value to assign to the Age of the Book. 
     */
    public void setAge(String value){
        this.age = value;
    }
    
    /**
     * 
     * @return 
     */
    public String getAge(){
        return this.age;
    }
    
    /**
     * Assign a new value to the Genres of the Book.
     * @param value (String) new value to assign to the Genres of the Book. 
     */
    public void setGenres(ArrayList<String> value){
        this.genres = value;
    }
    
    /**
     * 
     * @return 
     */
    public ArrayList<String> getGenres(){
        return this.genres;
    }
    
    /**
     * Convert all the information about the Book into an Array of Strings.
     * The Array have the following format:
     * array[0] will contain the Title of the Book.
     * array[1] will contain the Author of the Book.
     * array[2] will contain the Editorial of the Book.
     * array[3] will contain the Age of the Book.
     * array[4] will contain the Genres of the Book.
     * @return (String[]) Array with the Information of the Book in an Array of String.
     */
    public String[] toArray(){
        String[] information = new String[5];
        
        information[0] = getTitle();
        information[1] = getAuthor();
        information[2] = getEditorial();
        information[3] = getAge();
        information[4] = String.join("-", getGenres());
        
        return information;
    }
    
    // PRUEBA AQUI, BORRAR ANTES DE ENTREGAR LA PRACTICA.
    public static void main(String[] args){
        Book book = new Book();
        ArrayList<String> list = new ArrayList<>();
        
        list.add("Perro");
        list.add("Perro");
        list.add("Perro");
        list.add("Perro");
        list.add("Perro");
        
        book.setGenres(list);
        
        System.out.println(book.toArray()[4]);
    }
}
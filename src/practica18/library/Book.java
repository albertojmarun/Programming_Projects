/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica18.library;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class is about a Book.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date March 2021.
 */
public final class Book implements Serializable {
    private String title, author, editorial, age;
    private ArrayList<String> genres;

    /**
     * Constructor of the Book Class.
     */
    public Book() {
        this.genres = null;
        this.setTitle(null);
        this.setAuthor(null);
        this.setEditorial(null);
        this.setAge(null);
    }
    
    /**
     * Assign a new value to the Title of the Book.
     * @param value (String) new value to assign to the Title of the Book.
     */
    public void setTitle(String value) {
        this.title = value;
    }

    /**
     * Get the Value of the Title of the Book.
     * @return (String) Value of the Title of the Book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Assign a new value to the Author of the Book.
     * @param value (String) new value to assign to the Author of the Book.
     */
    public void setAuthor(String value) {
        this.author = value;
    }

    /**
     * Get the Value of the Author of the Book.
     * @return (String) Value of the Author of the Book.
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Assign a new value to the Editorial of the Book.
     * @param value (String) new value to assign to the Editorial of the Book.
     */
    public void setEditorial(String value) {
        this.editorial = value;
    }

    /**
     * Get the actual value for the Editorial of the Book selected.
     * @return (String) Name of the editorial.
     */
    public String getEditorial() {
        return this.editorial;
    }

    /**
     * Assign a new value to the Age of the Book.
     * @param value (String) new value to assign to the Age of the Book.
     */
    public void setAge(String value) {
        this.age = value;
    }

    /**
     * Get the actual value for the Age of the Book selected.
     * @return (String) Goal Audience of the book.
     */
    public String getAge() {
        return this.age;
    }

    /**
     * Assign a new value to the Genres of the Book.
     * @param value (String) new value to assign to the Genres of the Book.
     */
    public void setGenres(ArrayList<String> value) {
        this.genres = value;
    }
    
    /**
     * From a String assign an ArrayList to the Genres.
     * @param value String with the Literary Genres of the Book.
     */
    public void setGenres(String value){
        if(value.split(" - ").length > 0){
            this.genres = new ArrayList<>();
            
            for(String genre : value.split(" - ")){
                this.genres.add(genre);
            }
        }
    }
    
    /**
     * Get all the Genres of the Book with a String format (Genre - Genre...).
     * @return (String) Genres of the Book selected with String format.
     */
    public String getGenresAsString(){
        return String.join(" - ", this.genres);
    }
    
    /**
     * Get the actual value for the Genres of the Book selected.
     * @return (ArrayList) Literary Genres of the Book.
     */
    public ArrayList<String> getGenres() {
        return this.genres;
    }

    /**
     * Convert all the information about the Book into an Array of Strings. The
     * Array have the following format: array[0] will contain the Title of the
     * Book. array[1] will contain the Author of the Book. array[2] will contain
     * the Editorial of the Book. array[3] will contain the Age of the Book.
     * array[4] will contain the Genres of the Book.
     * @return (String[]) Array with the Information of the Book in an Array of
     * String.
     */
    public String[] toArray() {
        String[] information = new String[5];

        information[0] = getTitle();
        information[1] = getAuthor();

        return information;
    }
    
    /**
     * Check if the variables are valid. Needs to follow the following rules:
     * 1. Title, Author, Editorial, Age and Genres cannot be empty.
     * 2. Title and Author cannot have 100 characters or more.
     * @return (boolean)    If the variables are correct, true;
     *                      If the variables are incorrect, false.
     */
    public boolean isValid() {
        boolean valid = true;

        if (getTitle().isEmpty() || getAuthor().isEmpty() ||
                getTitle().length() >= 100 || getAuthor().length() >= 100 ||
                getEditorial().isEmpty() || getAge().isEmpty() ||
                getGenres().size() <= 0 || getGenresAsString().equals("")) {
            valid = false;
        }

        return valid;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica17.library;
import java.io.Serializable;
import java.sql.ResultSet;
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
        genres = new ArrayList<>();
        title = "";
        author = "";
        editorial  = "";
        age = "";
    }
    
    /**
     * Book Constructor that assigns a value to each attribute of the Class.
     * @param result_sql Row from a table (That is connected with MySQL) and have all the Information about a book.
     * @throws Exception Raise an excepetion if one of the functions raise an error.
     */
    public Book(ResultSet result_sql) throws Exception{
        setTitle(result_sql.getString("TITLE"));
        setAuthor(result_sql.getString("AUTHOR"));
        setEditorial(result_sql.getString("EDITORIAL"));
        setAge(result_sql.getString("AGE"));
        setGenres(result_sql.getString("GENRES"));
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
     *
     * @return
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
     *
     * @return
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
     * 
     * @param value 
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
     * 
     * @return 
     */
    public String getGenresAsString(){
        return String.join(" - ", this.genres);
    }
    
    /**
     *
     * @return
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
     *
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
                getGenres().size() <= 0) {
            valid = false;
        }

        return valid;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica17.library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * This class is about a Library of Books.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date March 2021.
 */
public class Library {
    private static Connection connection;
    
    final static String DATA_BASE = "library";
    final static String DATA_BASE_USER = "root";
    final static String DATA_BASE_PASS = "";
    final static String HOST = "localhost";
    final static String TABLE = "books";
    
    /**
     * Constructor of the Library Class.
     */
    private Library() throws Exception{}
    
    public static void connect() throws Exception{
        connection = DriverManager.getConnection(
                        "jdbc:mysql://" + HOST + "/" + DATA_BASE + "?user=" + DATA_BASE_USER
                        + "&password=" + DATA_BASE_PASS + "&useLegacyDatetimeCode=false&serverTimezone="
                        + Calendar.getInstance().getTimeZone().getID()
                );
    }
    
    public static void disconnect() throws Exception{
        
    }
    /**
     * This function adds a Book to the List.
     * @param new_book (Book) the new book to add to the books list.
     * @throws java.lang.Exception
     */
    public static void addBook(Book new_book) throws Exception{
        Statement sql_statement = connection.createStatement();
        // "INSERT INTO people (name, surname, age) VALUES ('" + user_data[0] + "', '" + user_data[1] + "', " + user_data[2] + ")";
        String insert_book = "INSERT INTO " + TABLE + " (TITLE, AUTHOR, EDITORIAL, AGE, GENRES) VALUES "
                + "('" + new_book.getTitle() + "', '" + new_book.getAuthor() + "', '" + new_book.getEditorial() + "', '" + new_book.getAge() + "', '" + new_book.getGenresAsString() +"')";
        
        sql_statement.executeUpdate(insert_book);
    }
    
    /**
     * Function to remove a book from the List.
     * @param remove_index (int) Index of the Book inside the List to be removed,
     *                      needs to be between 0 and the size of the List - 1.
     * @throws java.lang.Exception
     */
    public static void deleteBook(int remove_index) throws Exception{
        ArrayList<Integer> book_index = new ArrayList<>();
        
        Statement sql_statement = connection.createStatement();
        String sql_instructions;
        ResultSet query_result = null;
        
        sql_instructions = "SELECT * FROM " + TABLE;
        
        query_result = sql_statement.executeQuery(sql_instructions);
        
        while(query_result.next()){
            book_index.add(query_result.getInt("ID"));
        }
        
        if(remove_index >= 0 && remove_index <= book_index.size() - 1){
            sql_instructions = "DELETE FROM " + TABLE
                + " WHERE ID = " + Integer.toString(book_index.get(remove_index));
            
            sql_statement.executeUpdate(sql_instructions);
        }
    }
    
    /**
     * Function to select a Book from the List.
     * @param index index of the book inside the list (books) to get the information about it.
     * @return (Book) book from the list.
     * @throws java.lang.Exception
     */
    public static Book getBook(int index) throws Exception{
        Book index_book = new Book();
        
        if(index >= 0 && index < getBooks().size()){
            index_book = getBooks().get(index);
        }
        
        return index_book;
    }
    
    /**
     * Function to return all the Books from the List.
     * @return (ArrayList<>) The list of the class Library.
     * @throws java.lang.Exception
     */
    public static ArrayList<Book> getBooks() throws Exception{
        ArrayList<Book> books = new ArrayList<>();
        
        Statement sql_statement = connection.createStatement();
        String sql_instructions;
        ResultSet query_result;
        
        sql_instructions = "SELECT * FROM " + TABLE;
        
        query_result = sql_statement.executeQuery(sql_instructions);
        
        while(query_result.next()){
            books.add( new Book(query_result) );
        }
        
        return books;
    }
    
    /**
     * 
     * @throws Exception 
     */
    public static void deleteAll() throws Exception{
        Statement sql_statement = connection.createStatement();
        
        sql_statement.executeUpdate("DELETE from " + TABLE);
    }
    
    /**
     * Write a Binary File with all the elements inside the books List.
     * @param file_route (String) Absolute Route of the File that will be written.
     * @throws Exception If openning the file, closing it or writing it have an error
     * and the program throw an exception inside the function,
     * the function needs to throw the exception where it is implemented.
     */
    public static void writeFile(String file_route) throws Exception{
        FileOutputStream file_binary = null;
        ObjectOutputStream write_binary = null;
        
        try{
            file_binary = new FileOutputStream(file_route);
            write_binary = new ObjectOutputStream(file_binary);
            
            write_binary.writeInt(getBooks().size());
            
            for(Book new_book : getBooks()){
                write_binary.writeObject(new_book);
            }
        }
        
        finally{
            if(write_binary != null){
                write_binary.close();
            }
                
            if(file_binary != null){
                file_binary.close();
            }
            
        }
    }
    
    /**
     * Read a Binary File that contains Books to add to the Library list.
     * @param file_route (String) Absolute Route of the File that will be readed.
     * @throws Exception If openning the file, closing it or reading it have an error
     * and the program throw an exception inside the function,
     * the function needs to throw the exception where it is implemented.
     */
    public static void readFile(String file_route) throws Exception{
        Statement sql_statement = connection.createStatement();
        String sql_execute;
        
        FileInputStream file_binary = null;
        ObjectInputStream object_binary = null;
        int size;
        Book new_book;
        
        // PREGUNTAR A TOMAS
        try{
            file_binary = new FileInputStream(file_route);
            object_binary = new ObjectInputStream(file_binary);
             
            size = object_binary.readInt();
            
            if(size >= 1){
                Library.deleteAll();
            }
            
            for (int i = 0; i < size; i++){
                new_book = (Book) object_binary.readObject();
                sql_execute = "INSERT INTO " + TABLE + " (TITLE, AUTHOR, EDITORIAL, AGE, GENRES) VALUES "
                + "('" + new_book.getTitle() + "', '" + new_book.getAuthor() + "', '" + new_book.getEditorial() + "', '" + new_book.getAge() + "', '" + new_book.getGenresAsString() +"')";
                        
                sql_statement.executeUpdate(sql_execute);
            } 
        }
        
        finally{
            if(object_binary != null){
                object_binary.close();
            }
            
            if(file_binary != null){
                file_binary.close();
            }
        }
    }
}

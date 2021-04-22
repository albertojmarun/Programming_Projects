/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica19.library;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.query.Constraint;
import com.db4o.query.Query;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * This class is about a Library of Books.
 * @version 1.0
 * @author Alberto J. Marun I.
 * @date March 2021.
 */
public class Library {
    private static ObjectContainer db;
    
    /**
     * Constructor of the Library Class.
     */
    private Library() throws Exception{}
    
    /**
     * Connect the Program to the DataBase
     * @throws Exception if connecting to the DataBase makes an Error, throws an Exception.
     */
    public static void connect() throws Exception{
        db =    Db4oEmbedded.openFile(
                    Db4oEmbedded.newConfiguration(), "library_practice19.db4o"
                );
    }
    
    /**
     * Disconnect the program to the DataBase connected.
     * @throws Exception throws an Exception if the db is null and it close.
     */
    public static void disconnect() throws Exception{
        if(db != null){
            db.close();
        }
    }
    
    /**
     * This function adds a Book to the List.
     * @param new_book (Book) the new book to add to the books list.
     * @throws java.lang.Exception
     */
    public static void saveBook(Book new_book) throws Exception{
        db.store(new_book);
    }
    
    /**
     * Function to remove a book from the List.
     * @param remove_index (int) Index of the Book inside the List to be removed,
     *                      needs to be between 0 and the size of the List - 1.
     * @throws java.lang.Exception
     */
    public static void deleteBook(int remove_index) throws Exception{
        ObjectSet objects_set = db.queryByExample(new Book());
        Book book;
        
        for(int i = 0; objects_set.hasNext(); i++){
            if(i == remove_index){
                book = (Book) objects_set.next();
                db.delete(book);
            } else{
                objects_set.next();
            }
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
     * 
     * @return
     * @throws Exception 
     */
    public static ArrayList<Book> getBooks() throws Exception{
        ArrayList<Book> books = new ArrayList<>();
        Query query = db.query();
        query.descend("title").orderAscending();
        ObjectSet os = query.execute();
        
        while(os.hasNext()){
            books.add( (Book) os.next());
        }
        
        return books;
    }
    
    /**
     * Function to return all the Books from the List.
     * @return (ArrayList<>) The list of the class Library.
     * @throws java.lang.Exception If there is an error, throws the corresponding exception.
     */
    public static ArrayList<Book> getAllBooks() throws Exception{
        ArrayList<Book> books = new ArrayList<>();
        
        Query query = db.query();
        ObjectSet objects_set = query.execute();
        
        while(objects_set.hasNext()){
            books.add( (Book) objects_set.next());
        }
        
        return books;
    }
    
    /**
     * Remove all the Books from the Databases.
     * @throws Exception Throws an exception if executing the DELETE gives and ERROR.
     */
    public static void deleteAll() throws Exception{
        ObjectSet objects_set = db.queryByExample(new Book());
        
        while(objects_set.hasNext()){
            db.delete(objects_set.next());
        }
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
            
            write_binary.writeInt(getAllBooks().size());
            
            for(Book new_book : getAllBooks()){
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
        FileInputStream file_binary = null;
        ObjectInputStream object_binary = null;
        int size;
        ArrayList<Book> new_library = new ArrayList<>();
        Book new_book;
        
        try{
            file_binary = new FileInputStream(file_route);
            object_binary = new ObjectInputStream(file_binary);
             
            size = object_binary.readInt();
            
            for(int i = 0; i < size; i++){
                new_book = (Book) object_binary.readObject();
                new_library.add(new_book);
            }
            
            if(new_library.size() > 0){
                deleteAll();
            }
            
            for (Book book : new_library){
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

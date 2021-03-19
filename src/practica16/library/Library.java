/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica16.library;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
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
    private final ArrayList<Book> books;
    
    /**
     * Constructor of the Library Class.
     */
    public Library(){
        this.books = new ArrayList<>();
    }
    
    /**
     * This function adds a Book to the List.
     * @param new_book (Book) the new book to add to the books list.
     */
    public void addBook(Book new_book){
        this.books.add(new_book);
    }
    
    /**
     * Function to remove a book from the List.
     * @param remove_index (int) Index of the Book inside the List to be removed,
     *                      needs to be between 0 and the size of the List - 1.
     */
    public void removeBook(int remove_index){
        if(remove_index >= 0 && remove_index < this.getBooks().size()){
            this.books.remove(remove_index);
        }
    }
    
    /**
     * Function to select a Book from the List.
     * @param index index of the book inside the list (books) to get the information about it.
     * @return (Book) book from the list.
     */
    public Book getBooks(int index){
        Book index_book = new Book();
        
        if(index >= 0 && index < getBooks().size()){
            index_book = getBooks().get(index);
        }
        
        return index_book;
    }
    
    /**
     * Function to return all the Books from the List.
     * @return (ArrayList<Book>) The list of the class Library.
     */
    public ArrayList<Book> getBooks(){
        return this.books;
    }
   
    /**
     * Write a Binary File with all the elements inside the books List.
     * @param file_route (String) Absolute Route of the File that will be written.
     * @throws Exception If openning the file, closing it or writing it have an error
     * and the program throw an exception inside the function,
     * the function needs to throw the exception where it is implemented.
     */
    public void writeFile(String file_route) throws Exception{
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
    public void readFile(String file_route) throws Exception{
        FileInputStream file_binary = null;
        ObjectInputStream object_binary = null;
        int size;
        Book item;
        
        try{
            file_binary = new FileInputStream(file_route);
            object_binary = new ObjectInputStream(file_binary);
             
            size = object_binary.readInt();
            
            if(size >= 1){
                this.books.clear();
            }
            
            for (int i = 0; i < size; i++){
                item = (Book) object_binary.readObject();
                this.books.add(item);
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

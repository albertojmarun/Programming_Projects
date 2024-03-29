/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica19.library;

import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
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
 * @date May 2021.
 */
public class Library {
    private static ObjectContainer db;
    private static boolean title_asc;
    private static String author_filter;
    private static ArrayList<String> genres_filter;
    private static String age_filter;
    private static int current_page;
    private static int last_page;
    
    /**
     * Constructor of the Library Class.
     */
    private Library(){}
    
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
     * Initialize the Genres Filter.
     */
    public static void initializeGenresFilter(){
        Library.genres_filter = new ArrayList<>();
    }
    
    /**
     * Add a new value to the Genres Filter, if it is null, initialize and add that value.
     * @param value (String) Genre to add to the Genres Filter.
     */
    public static void setGenresFilter(String value){
        if(Library.genres_filter == null){
            Library.genres_filter = new ArrayList<>();
        }
        
        Library.genres_filter.add(value);
    }
    
    /**
     * Get the Actual Value of the Genres Filter.
     * @return (ArrayList<String>) Array List with all the Genres selected to the Filter.
     */
    public static ArrayList<String> getGenresFilter(){
        return Library.genres_filter;
    }
    
    /**
     * Remove a Genre from the Genres Filter.
     * @param genre (String) Genre to remove from the filter.
     */
    public static void removeGenreFromFilter(String genre){
        Library.genres_filter.remove(genre);
    }
    
    /**
     * Clear all the Genres that are on the Genres Filter.
     */
    public static void resetGenresFilter(){
        if(Library.genres_filter == null){
            Library.genres_filter = new ArrayList<>();
        }
        
        Library.genres_filter.clear();
    }
    
    /**
     * Assign a new value to the Age Filter.
     * @param value (String) Age to set the Age Filter.
     */
    public static void setAgeFilter(String value){
        Library.age_filter = value;
    }
    
    /**
     * Get the actual Value of the Age Filter.
     * @return (String) Actual Age of the Age Filter.
     */
    public static String getAgeFilter(){
        return Library.age_filter;
    }
    
    /**
     * Assign a value to the title_asc variable.
     * @param value (boolean) Value to assign to the title_asc variable.
     */
    public static void setTitleAsc(boolean value){
        Library.title_asc = value;
    }
    
    /**
     * Receive the actual value for title_asc variable.
     * @return (boolean) Actual value of title_asc.
     */
    public static boolean getTitleAsc(){
        return Library.title_asc;
    }
    
    /**
     * Assign the new value of the Author to show.
     * @param value (String) New value to assign.
     */
    public static void setAuthorFilter(String value){
        Library.author_filter = value;
    }
    
    /**
     * Receive the actual value of the Author to Select.
     * @return (String) Actual value of the author to filter the results.
     */
    public static String getAuthorFilter(){
        return Library.author_filter;
    }
    
    /**
     * Assign a new value to the Current Page. 
     * @param value (int) New Number of the Current Page.
     */
    public static void setCurrentPage(int value){
        Library.current_page = value;
    }
    
    /**
     * Receive the Value of the Current Page of the Library.
     * @return (int) Number of the current page.
     */
    public static int getCurrentPage(){
        return Library.current_page;
    }
    
    /**
     * Reset the atribute of the current page to the first page (0).
     */
    public static void resetCurrentPage(){
        Library.current_page = 0;
    }
    
    /**
     * If the Library is on a Page greater than zero, decrease that page.
     */       
    public static void decreasePage(){
        if(Library.current_page > 0){
            Library.current_page--;
        }
    }
    
    /**
     * If the Library is on a page smaller than the Last Page, add one to the current Page.
     */
    public static void increasePage(){
        if(Library.current_page < Library.last_page){
            Library.current_page++;
        }
    }
    
    /**
     * Assign the corresponding value to the Last Page.
     * @param value (int) New value to the LastPage.
     */
    private static void setLastPage(int value){
        Library.last_page = value;
    }
    
    /**
     * Receive the actual Last Page of the Library.
     * @return (int) Number of the Last Page of the Library.
     */
    public static int getLastPage(){
        return Library.last_page;
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
     * @throws java.lang.Exception if the 
     */
    public static void deleteBook(int remove_index) throws Exception{
        db.delete(Library.getBook(remove_index));
    }
    
    /**
     * Function to select a Book from the List.
     * @param index index of the book inside the list (books) to get the information about it.
     * @return (Book) book from the list.
     */
    public static Book getBook(int index){
        Book index_book = new Book();
        
        if(index >= 0 && index < getBooks().size()){
            index_book = getBooks().get(index);
        }
        
        return index_book;
    }
    
    /**
     * Result of a Query with a determained constraints.
     * @return (ObjectSet) A selection of elements from the Object Oriented Data Base.
     */
    private static ObjectSet queryApplyGetBookRestrictions(){
        Query query = db.query();
        
        if(title_asc){
            query.descend("title").orderAscending();
        } else{
            query.descend("title").orderDescending();
        }
        
        query.descend("author").constrain(author_filter).like();
        query.descend("age").constrain(age_filter).like();
        return query.execute();
    }
    
    /**
     * Filter the Book by the Genres Filter.
     * @param book (Book) To determine if the contains one of the genres asked by the user or no.
     * @return (boolean) True if the Genres Filter is Empty or it contains one or more of the selected genres,
     *  if the book do not contain any of the genres selected on the filter.
     */
    private static boolean filterBookByGenres(Book book){
        boolean filter = false;
        
        if(genres_filter.size() <= 0){
            filter =  true;
        }
        
        for(int i = 0; i < book.getGenres().size() && !filter; i++){
            
            for(int j = 0; j < Library.genres_filter.size() && !filter; j++ ){
                
                if(book.getGenres().get(i).equals( Library.genres_filter.get(j) )){
                    filter = true;
                }
            }
            
        }
        
        return filter;
    }
    
    /**
     * Receive a List of Books that have a certain of parameters.
     * @return (ArrayList<>) List of Books that fullfil all the constraints.
     */
    public static ArrayList<Book> getBooks(){
        // limit_book[0] = first book to read.
        // limit_book[1] = last book to read.
        int[] limits_book = new int[2];
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Book> final_books = new ArrayList<>();
        Book book;
        
        ObjectSet objects = Library.queryApplyGetBookRestrictions();
        
        while(objects.hasNext()){
            book = (Book) objects.next();
            
            if(Library.filterBookByGenres(book)){
                books.add(book);
            }
        }
        
        Library.setLastPage( ( books.size() - 1 ) / 10 );
        
        limits_book[0] = Library.getCurrentPage() * 10;
        limits_book[1] = (Library.getCurrentPage() + 1) * 10;
        
        
        for(int i = 0; i < books.size() && i < limits_book[1]; i++){
            if(i >= limits_book[0] && i < limits_book[1]){
                final_books.add(books.get(i));
            }
        }
        
        return final_books;
    }
    
    /**
     * Function to return all the Books from the List.
     * @return (ArrayList<>) The list of the class Library.
     * @throws java.lang.Exception If there is an error, throws the corresponding exception.
     */
    public static ArrayList<Book> getAllBooks() throws Exception{
        ArrayList<Book> books = new ArrayList<>();
        
        Query query = db.query();
        query.constrain(Book.class);
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
        for(Book book : getAllBooks()){
            db.delete(book);
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
                Library.saveBook(book);
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

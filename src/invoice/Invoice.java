/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package invoice;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * This class is about an Invoice.
 * @version 1.0
 * @author Alberto Marun
 * @date February 2021.
 */
public class Invoice{
    final private ArrayList<InvoiceItem> invoice_items;
    
    /**
     * Constructor of the Invoice class. Initialize the ArrayList<>.
     */
    public Invoice(){
        invoice_items = new ArrayList<>();
    }
    
    /**
     * Add to the ArrayList<> a new element (InvoiceItem)
     * Ask to the user the values of the element.
     */
    public void addInvoiceItem(){
        String name;
        int quantity, index;
        double price;
        
        index = invoice_items.size();
        invoice_items.add(index, new InvoiceItem());
        
        System.out.print("Introduce el Nombre del Producto: ");
        name = UserInput.getString();
        
        System.out.printf("Introduce la cantidad de %s disponibles: ", name);
        quantity = UserInput.getInt();
        
        
        System.out.printf("Introduce el Precio de %s: ", name);
        price = UserInput.getDouble();
        
        System.out.println();
        invoice_items.get(index).setProductName(name);
        invoice_items.get(index).setProductPrice(price);
        invoice_items.get(index).setProductQuantity(quantity);
    }
    
    /**
     * Remove an element from the ArrayList<> of the class Invoice.
     * @param index (int) Index of the element to remove.
     */
    public void removeInvoiceIteam(int index){
        if (index >= 0 && index < invoice_items.size()){
            invoice_items.remove(index);
        } else{
            System.out.printf("No se puede borrar el elemento %d debido a que no existe ese Elemento en la lista.\n", index);
            System.out.printf("Introduzca un elemento entre 0 y %d.\n", index, invoice_items.size() - 1);
        }
    }
    
    /**
     * Show all the InvoiceItems that are in the list at the moment.
     */
    public void showInvoice(){
        System.out.println("Lista de Productos: ");
        
        for(InvoiceItem item : invoice_items){
            System.out.println(item);
        }
        
        System.out.println();
    }
    
    /**
     * Write the invoice_items (ArrayList<>) in a txt file.
     * @param file_name (String) Name of the file to write the invoice_items ArrayList<>.
     */
    public void writeInvoice(String file_name){
        FileWriter file_writer = null;
        PrintWriter print_writer = null;
        
        try{
            file_writer = new FileWriter(file_name);
            print_writer = new PrintWriter(file_writer);
            
            for(InvoiceItem item : invoice_items){
                print_writer.println(item.toString());
            }
            
        } catch(IOException error){
            System.out.println("Error al abrir el Fichero con nombre: " + file_name);
        }
        
        finally{
            try{
                if(print_writer != null){
                    print_writer.close();
                }
                
                if(file_writer != null){
                    file_writer.close();
                }
            } catch(IOException error){
                System.out.println("Erro al cerrar el fichero con nombre: " + file_name);
            }
        }
    }
    
    /**
     * Read the Items inside the file and add them to the invoice_items (ArrayList<>)
     * @param file_name (String) Name of the file to read the invoice_items ArrayList<>.
     */
    public void readInvoice(String file_name){
        FileReader file_reader = null;
        BufferedReader buffered_reader = null;
        String line;
        
        try{
            file_reader = new FileReader(file_name);
            buffered_reader = new BufferedReader(file_reader);
            
            line = buffered_reader.readLine();
            
            if(line != null){
                invoice_items.clear();
            }
            
            while(line != null){
                invoice_items.add(invoice_items.size(), InvoiceItem.parseInvoiceItem(line));
                line = buffered_reader.readLine();
            }
            
        } catch(IOException error){
            System.out.println("Error al abrir el Fichero con nombre: " + file_name);
            
        } finally{
            try{
                if(buffered_reader != null){
                    buffered_reader.close();
                }
                
                if(file_reader != null){
                    file_reader.close();
                }
            } catch(IOException error){
                System.out.println("Erro al cerrar el fichero con nombre: " + file_name);
            }
        }
    }
    
    /**
     * Write the Numbr of InvoiceItems and the InvoiceItems to a Binary File from the invoice_items (ArrayList<>).
     * @param file_name (String) Name of the file to write the invoice_items ArrayList<>.
     */
    public void writeInvoiceAsBinary(String file_name){
        FileOutputStream file_binary = null;
        ObjectOutputStream write_binary = null;
        
        try{
            file_binary = new FileOutputStream(file_name);
            write_binary = new ObjectOutputStream(file_binary);
            
            write_binary.writeInt(invoice_items.size());
            
            for(InvoiceItem item : invoice_items){
                write_binary.writeObject(item);
            }
            
        } catch(IOException error){
            System.out.println("Error al abrir el fichero: " + file_name);
        }
        
        finally{
            try{
                if(write_binary != null){
                    write_binary.close();
                }
                
                if(file_binary != null){
                    file_binary.close();
                }
            } catch(IOException error){
                System.out.println("Error al cerrar el fichero: " + file_name);
            }
        }
    }
    
    /**
     * Read the InvoiceItems from a Binary File and add them to the invoice_items (ArrayList<>).
     * @param file_name (String) Name of the Binary file to read the invoice_items ArrayList<>.
     */
    public void readInvoiceFromBinary(String file_name){
        FileInputStream file_binary = null;
        ObjectInputStream object_binary = null;
        int size;
        InvoiceItem item;
        
        try{
            file_binary = new FileInputStream(file_name);
            object_binary = new ObjectInputStream(file_binary);
             
            size = object_binary.readInt();
            
            if(size >= 1){
                invoice_items.clear();
            }
            
            for (int i = 0; i < size; i++){
                item = (InvoiceItem) object_binary.readObject();
                invoice_items.add(invoice_items.size(), item);
            }
             
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Error al abrir el fichero: " + file_name);
        }
        finally{
            try{
                if(object_binary != null){
                    object_binary.close();
                }
                if(file_binary != null){
                    file_binary.close();
                }
            } catch(IOException e){
                System.out.println("Error al cerrar el fichero: " + file_name);
            }
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author AlbertoMarun
 */
public class BinaryFile {
     public static void main(String[] args) throws FileNotFoundException{
        // ESCRIBIR EN ARCHIVO BINARIO
         FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        
        
        try{
            fos = new FileOutputStream("persons.dat");
            oos = new ObjectOutputStream(fos);
             
            ArrayList<Person> people = new ArrayList<>();
             people.add(new Person("Jose", 25, "12345678A"));
             people.add(new Person("Maria", 21, "12345678B"));
             people.add(new Person("Alberto", 19, "12345678C"));
             people.add(new Person("Juan", 31, "12345678D"));
             people.add(new Person("Gabriela", 43, "12345678E"));
             
            oos.writeInt(people.size());
            
            for(Person person : people){
                oos.writeObject(person);
            }
             
        } catch(IOException e){
            System.out.println("Error al abrir el fichero");
        }
        
        finally{
            try{
                if(oos != null){
                    oos.close();
                }
                if(fos != null){
                    fos.close();
                }
            } catch(IOException e){
                System.out.println("Error al cerrar el fichero");
            }
        }
        
        // LEER FICHEROS BINARIOS.
        
        // /*
        FileInputStream fis = null;
        ObjectInputStream ois = null;
             
        try{
            fis = new FileInputStream("persons.dat");
            ois = new ObjectInputStream(fis);
             
            int size = ois.readInt();
            Person person;
             
            for (int i = 0; i < size; i++){
                 person = (Person) ois.readObject();
                 System.out.println("________________");
                 System.out.println(person);
                 System.out.println("________________");
            }
             
        } catch(IOException | ClassNotFoundException e){
            System.out.println("Error al abrir el fichero");
        }
        finally{
            try{
                if(ois != null){
                    ois.close();
                }
                if(fis != null){
                    fis.close();
                }
            } catch(IOException e){
                System.out.println("Error al cerrar el fichero");
            }
        }
        // */
     }
}

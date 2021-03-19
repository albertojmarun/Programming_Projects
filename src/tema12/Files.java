/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class Files {
    public static void main(String[] args) throws FileNotFoundException{
    FileReader file_reader = null;
    BufferedReader br = null;
    
        try{
            // OPEN THE FLUIDS.
            file_reader = new FileReader("test.txt");
            br = new BufferedReader(file_reader);
            // OPERATE WITH THE FILE.
            
            String line = br.readLine();
            while (line != null){
                System.out.println(line);
                line = br.readLine();
            }
            
        }catch (IOException e){
            // ERROR AT OPEN THE FLUID.
            System.out.println("Error al abrir el Fichero");
        }
        
        finally{
            try{
                // CLOSE THE FLUIDS.
                if(br != null){
                    br.close();
                }
                if(file_reader != null){
                    file_reader.close();
                }
            } catch(IOException e){
                // ERRORES AL CERRAR EL FLUJO.
            }
        }
        
        FileWriter fw = null;
        PrintWriter pw = null;
        
        try{
        // OPEN THE FLUIDS.
        // OPERATE WITH THE FILE.
            fw = new FileWriter("test2.txt", true);
            pw = new PrintWriter(fw);
            
            pw.println("Hola Mundo!");
            
        }catch (IOException e){
            // ERROR AT OPEN THE FLUID.
            System.out.println("Error al abrir el Archivo");
        }    
    
        finally{
            try{
                // CLOSE THE FLUIDS.
                if(pw != null){
                    pw.close();
                }
                if(fw != null){
                    fw.close();
                }
            
            } catch(IOException e){
            // ERRORES AL CERRAR EL FLUJO.
            }
        }
    }
}

/*
try{
    // OPEN THE FLUIDS.
    // OPERATE WITH THE FILE.
            
    }catch (IOException e){
        // ERROR AT OPEN THE FLUID.
    }    
    
    finally{
        try{
            // CLOSE THE FLUIDS.
        } catch(IOException e){
            // ERRORES AL CERRAR EL FLUJO.
        }
    }
*/
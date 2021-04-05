/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema17_prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class PruebaSQL {
    
    final static String BD = "people";
    final static String BD_USER = "root";
    final static String BD_PASS = "";
    final static String HOST = "localhost";
    
    private static void prueba(){
        Statement sql_statement = null;
        Connection connection = null;
        String execute_statement;
        String[] user_data =  {"Juan", "Montero", Integer.toString(18)};
        ResultSet query_result = null;
        try{
            connection  = DriverManager.getConnection(
                        "jdbc:mysql://" + HOST + "/" + BD + "?user=" + BD_USER
                        + "&password=" + BD_PASS + "&useLegacyDatetimeCode=false&serverTimezone="
                        + Calendar.getInstance().getTimeZone().getID()
                );
            
            sql_statement = connection.createStatement();
            
            // execute_statement = "INSERT INTO people (name, surname, age) VALUES ('" + user_data[0] + "', '" + user_data[1] + "', " + user_data[2] + ")";
            // execute_statement = "UPDATE people SET name='Ana' surname = 'Marulanda' WHERE ID = 2 ";
            // execute_statement = "DELETE FROM people WHERE ID = 1 ";
            execute_statement = "SELECT * FROM people";
            
            // System.out.println(execute_statement);
            // sql_statement.executeUpdate(execute_statement);
            
            query_result = sql_statement.executeQuery(execute_statement);
            
            
            while(query_result.next()){
                user_data[0] = query_result.getString("name");
                user_data[1] = query_result.getString("surname");
                user_data[2] = query_result.getString("age");
                
                
                System.out.printf("%s, %s -> %s\n", user_data[0], user_data[1], user_data[2]);
            }
            
        } catch(Exception e){
            System.out.println("ERROR: " + e.getMessage());
        }
        
        finally{
            try{
                if(connection != null){
                    connection.close();
                }
            } catch(Exception e){
                System.out.println("ERROR: " + e.getMessage());
            }
        }
        
    }
    
    public static void main(String[] args){
        PruebaSQL.prueba();
        
    }
}

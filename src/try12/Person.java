/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package try12;

import java.io.Serializable;

/**
 * This class is about the information of a Person
 * @version 1.0
 * @author Alberto Marun
 */
public class Person implements Serializable{
    // CONSTANTS FOR THE VALUES
    final private int MIN_CHARACTERS;
    final private int MAX_CHARACTERS;
    final private int MIN_AGE;
    final private int MAX_AGE;

    // ATTRIBUTES OF THE CLASS
    private String name;
    private int age;
    private String DNI;
    
    /**
     * Constructor of the Class Person without Parameters.
     */
    public Person(){
        this.MAX_AGE = 67;
        this.MIN_AGE = 18;
        this.MAX_CHARACTERS = 50;
        this.MIN_CHARACTERS = 0;
        
        try{
            setName("Alberto");
            setAge(19);
            
        } catch(Exception error){
            System.out.println(error);
        }
    }
    
    public Person(String new_name, int new_age, String new_DNI){
        this.MAX_AGE = 67;
        this.MIN_AGE = 18;
        this.MAX_CHARACTERS = 50;
        this.MIN_CHARACTERS = 0;
        
        try{
            setName(new_name);
            setAge(new_age);
            setDNI(new_DNI);   
        } catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    
    public String getDNI(){
        return this.DNI;
    }
    
    public void setDNI(String DNI){
        this.DNI = DNI;
    }
    
    /**
     * Return the name of the Person.
     * @return The value of the (String) name.
     */
    public String getName(){
        return name;
    }

    /**
     * Return the age of the Person.
     * @return The value of the (int) age.
     */
    public int getAge(){
        return age;
    }
    
    /**
     * Establishes the name of the Person if it is between 0 and 50 characters.
     * @param new_value The Name of the Person entered by the user.
     * @throws java.lang.Exception in the case that the String is empty or have more than 50 characters (inclusive).
     */
    public void setName(String new_value) throws Exception {
        if(new_value.length() > MIN_CHARACTERS && new_value.length() < MAX_CHARACTERS){
            this.name = new_value;
            
        } else if (new_value.length() >= MAX_CHARACTERS){
            throw new Exception("\n\tEl nombre es demasiado largo");
            
        } else if (new_value.length() <= MIN_CHARACTERS){
            throw new Exception("\n\tEl nombre es demasiado corto");
        }
    }

    /**
     * Establishes the Age of the Person (Always need to be between 18 and 67, inclusive).
     * @param new_value The Age of the Person entered by the user.
     * @throws java.lang.Exception in the case that the age is less than the minimun or greater than the maximum.
     */
    public void setAge(int new_value) throws Exception{
        if(new_value >= MIN_AGE && new_value <= MAX_AGE){
            this.age = new_value;
        } else if (new_value < MIN_AGE){
            throw new Exception("\n\tLa edad debe ser mayor o igual a los " + MIN_AGE +" años de edad");
            
        } else if (new_value > MAX_AGE){
            throw new Exception("\n\tLa edad debe ser menor o igual a los " + MAX_AGE +" años de edad");
        }
    }
    
    @Override
    public String toString(){
        return "Name: " + getName() + " - Age: " + getAge() + " - DNI: " + getDNI() + "\n";
    }
}

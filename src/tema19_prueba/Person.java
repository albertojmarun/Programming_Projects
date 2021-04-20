/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema19_prueba;

/**
 *
 * @author DAW_16_AlbertoMarun
 */
public class Person {
    private String name;
    private String surname;
    private int age;
    
    public Person(){
        name = null;
        surname = null;
        age = 0;
    }
    
    public Person(String new_name, String new_surname, int new_age){
        setName(new_name);
        setSurname(new_surname);
        setAge(new_age);
    } 
    
    public String getName(){
        return this.name;
    }
    
    public void setName(String new_value){
        this.name = new_value;
    }
    
    public String getSurname(){
        return this.surname;
    }
    
    public void setSurname(String new_value){
        this.surname = new_value;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int new_value){
        this.age = new_value;
    }
    
    @Override
    public String toString(){
        return getName() + " " + getSurname() + " - " + getAge();
    }
}

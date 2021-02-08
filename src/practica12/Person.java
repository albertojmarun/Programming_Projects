/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

/**
 * This class is about the information of a Person
 * @version 1.0
 * @author Alberto Marun
 */
public class Person {
    // CONSTANTS FOR THE VALUES
    final private int min_characters = 0;
    final private int max_characters = 50;
    final private int min_age = 18;
    final private int max_age = 67;

    // ATTRIBUTES OF THE CLASS
    private String name;
    private String surname_1;
    private String surname_2;
    private int age;
    private String gender;
    private String marital_status;
    
    /**
     * Constructor of the Class Person without Parameters.
     */
    public Person(){
        try{
            setName("Alberto");
            setSurname1("Marun");
            setSurname2("Indriago");
            setAge(19);
            setGender("Male");
            setMaritalStatus("Single");
            
        } catch(Exception error){
            System.out.println(error);
        }
    }
    
    /**
     * Constructor of the Class Person with Parameters.
     * @param name (String) Name of the Teacher.
     * @param surname1 (String) 1st Surname of the Teacher.
     * @param surname2 (String) 2nd Surname of the Teacher.
     * @param age (int) Age of the Teacher.
     * @param salary (int) Salary of the Teacher.
     * @param gender (String) Gender of the Teacher.
     * @param marital_status (String) Marital Status of the Teacher.
     */
    public Person(String name, String surname1, String surname2, int age, String gender, String marital_status){
        try{
            setName(name);
            setSurname1(surname1);
            setSurname2(surname2);
            setAge(age);
            setGender(gender);
            setMaritalStatus(marital_status);
        } catch (Exception error){
            System.out.println(error);
        }
    }

    // GETTERS
    /**
     * Return the name of the Person.
     * @return The value of the (String) name.
     */
    public String getName(){
        return name;
    }

    /**
     * Return the 1st surname of the Person.
     * @return The value of the (String) surname_1.
     */
    public String getSurname1(){
        return surname_1;
    }

    /**
     * Return the 2nd surname of the Person.
     * @return The value of the (String) surname_2.
     */
    public String getSurname2(){
        return surname_2;
    }

    /**
     * Return the age of the Person.
     * @return The value of the (int) age.
     */
    public int getAge(){
        return age;
    }

    /**
     * Return the gender of the Person.
     * @return The value of the (string) gender.
     */
    public String getGender(){
        return gender;
    }

    /**
     * Return the marital status of the Person.
     * @return The value of the (string) marital_status.
     */
    public String getMaritalStatus(){
        return marital_status;
    }

    /**
     * Return the Full Name of the Person.
     * @return The full name with the format (surname1 surname2, name)
     */
    public String getFullName(){
        return getSurname1() + " " + getSurname2() + ", " + getName();
    }

    // SETTERS
    /**
     * Establishes the name of the Person if it is between 0 and 50 characters.
     * @param new_value The Name of the Person entered by the user.
     * @throws java.lang.Exception in the case that the String is empty or have more than 50 characters (inclusive).
     */
    public void setName(String new_value) throws Exception {
        if(new_value.length() > min_characters && new_value.length() < max_characters){
            this.name = new_value;
            
        } else if (new_value.length() >= max_characters){
            throw new Exception("\n\tEl nombre es demasiado largo");
            
        } else if (new_value.length() <= min_characters){
            throw new Exception("\n\tEl nombre es demasiado corto");
        }
    }

    /**
     * Establishes the 1st Surname of the Person if it is between 0 and 50 characters.
     * @param new_value The 1st surname of the Person entered by the user.
     * @throws java.lang.Exception in the case that the String is empty or have more than 50 characters (inclusive).
     */
    public void setSurname1(String new_value) throws Exception{
        if(new_value.length() > min_characters && new_value.length() < max_characters){
            this.surname_1 = new_value;
        } else if (new_value.length() >= max_characters){
            throw new Exception("\n\tEl 1er Apellido es demasiado largo");
            
        } else if (new_value.length() <= min_characters){
            throw new Exception("\n\tEl 1er Apellido es demasiado corto");
        }
    }

    /**
     * Establishes the 2nd Surname of the Person if it is between 0 and 50 characters.
     * @param new_value The 2nd Surname of the Person entered by the user.
     * @throws java.lang.Exception in the case that the String is empty or have more than 50 characters (inclusive).
     */
    public void setSurname2(String new_value) throws Exception {
            if(new_value.length() > min_characters && new_value.length() < max_characters){
            this.surname_2 = new_value;
        } else if (new_value.length() >= max_characters){
            throw new Exception("\n\tEl Segundo Apellido es demasiado largo");
            
        } else if (new_value.length() <= min_characters){
            throw new Exception("\n\tEl Segundo apellido es demasiado corto");
        }
    }

    /**
     * Establishes the Age of the Person (Always need to be between 18 and 67, inclusive).
     * @param new_value The Age of the Person entered by the user.
     * @throws java.lang.Exception in the case that the age is less than the minimun or greater than the maximum.
     */
    public void setAge(int new_value) throws Exception{
        if(new_value >= min_age && new_value <= max_age){
            this.age = new_value;
        } else if (new_value < min_age){
            throw new Exception("\n\tLa edad debe ser mayor o igual a los " + min_age +" años de edad");
            
        } else if (new_value > max_age){
            throw new Exception("\n\tLa edad debe ser menor o igual a los " + max_age +" años de edad");
        }
    }

    /**
     * Establishes the gender of the Person (It needs to be Male, Female or Non-Binary)
     * @param new_value The Gender of the Person selected by the user between Male, Female or Non-Binary.
     * @throws java.lang.Exception in the case that the gender doesnt match any of the valid genders.
     */
    public void setGender(String new_value) throws Exception{
        if( new_value.equals("Male") || new_value.equals("Female") || new_value.equals("Non-Binary") ){
            this.gender = new_value;
        } else {
            throw new Exception("\n\tGenero Incorrecto (Debe ser Ingles).");
        }
    }

    /**
     * Establishes the Marital Status of the Person.
     * @param new_value Is the Marital Status of the Person selected by the user between Married, Widowed, Divorced or Single.
     * @throws java.lang.Exception in the case that the gender doesnt match any of the valid genders.
     */
    public void setMaritalStatus(String new_value) throws Exception{
        if( new_value.equals("Married") || new_value.equals("Widowed") || new_value.equals("Divorced") || new_value.equals("Single")){
            this.marital_status = new_value;
        } else {
            throw new Exception("\n\tEstado Civil Incorrecto (Debe ser Ingles).");
        }
    }
}

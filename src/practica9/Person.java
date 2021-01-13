/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica9;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.*;

/**
 *  This class is about the information of a Person
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

    public Person(String name, String surname1, String surname2, int age, String gender, String marital_status) {
        setName(name);
        setSurname1(surname1);
        setSurname2(surname2);
        setAge(age);
        setGender(gender);
        setMaritalStatus(marital_status);
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
     * @param input_name The Name of the Person entered by the user.
     */
    public void setName(String input_name){
        if(input_name.length() > min_characters && input_name.length() < max_characters){
            this.name = input_name;
        }
    }

    /**
     * Establishes the 1st Surname of the Person if it is between 0 and 50 characters.
     * @param input_surname The 1st surname of the Person entered by the user.
     */
    public void setSurname1(String input_surname){
        if(input_surname.length() > min_characters && input_surname.length() < max_characters){
            this.surname_1 = input_surname;
        }
    }

    /**
     * Establishes the 2nd Surname of the Person if it is between 0 and 50 characters.
     * @param input_surname The 2nd Surname of the Person entered by the user.
     */
    public void setSurname2(String input_surname){
        if(input_surname.length() > min_characters && input_surname.length() < max_characters){
            this.surname_2 = input_surname;
        }
    }

    /**
     * Establishes the Age of the Person (Always need to be between 18 and 67, inclusive).
     * @param input_age The Age of the Person entered by the user.
     */
    public void setAge(int input_age){
        if(input_age >= min_age && input_age <= max_age){
            this.age = input_age;
        }
    }

    /**
     * Establishes the gender of the Person (It needs to be Male, Female or Non-Binary)
     * @param input_gender The Gender of the Person selected by the user between Male, Female or Non-Binary.
     */
    public void setGender(String input_gender){
        if( input_gender.equals("Male") || input_gender.equals("Female") || input_gender.equals("Non-Binary") ){
            this.gender = input_gender;
        }
    }

    /**
     * Establishes the Marital Status of the Person
     * @param input_marital_status Is the Marital Status of the Person selected by the user between Married, Widowed, Divorced or Single
     */
    public void setMaritalStatus(String input_marital_status){
        if( input_marital_status.equals("Married") || input_marital_status.equals("Widowed") || input_marital_status.equals("Divorced") || input_marital_status.equals("Single")){
            this.marital_status = input_marital_status;
        }
    }
    
    /**
     * 
     * @param file_name 
     */
    public static void saveXML(String file_name){
        String RUTA_XML = file_name;
        
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();
            
            Element ePerson = doc.createElement("person");
            doc.appendChild(ePerson);
            
            Element eName = doc.createElement("name");
            eName.appendChild(doc.createTextNode("Alberto"));
            ePerson.appendChild(eName);
            
            Element eSurname1 = doc.createElement("surname1");
            eSurname1.appendChild(doc.createTextNode("Marun"));
            ePerson.appendChild(eSurname1);
            
            Element eSurname2 = doc.createElement("surname2");
            eSurname2.appendChild(doc.createTextNode("Indriago"));
            ePerson.appendChild(eSurname2);
            
            Element eAge = doc.createElement("age");
            eAge.appendChild(doc.createTextNode(String.valueOf(19)));
            ePerson.appendChild(eAge);
            
            Element eGender = doc.createElement("gender");
            eGender.appendChild(doc.createTextNode("Male"));
            ePerson.appendChild(eGender);
            
            Element eMaritalStatus = doc.createElement("marital_status");
            eMaritalStatus.appendChild(doc.createTextNode("Married"));
            ePerson.appendChild(eMaritalStatus);
            
            // String.valueOf(****);
            
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(RUTA_XML));
            
            transformer.transform(source, result);
            
        } catch(Exception e){
            System.out.printf("Error -> %s\n", e.toString());
        }
    }
    
    public static void main(String[] args){
        
        saveXML("ajmi.xml");
    }
}

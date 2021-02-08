/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

/**
 *  This class is about the information of a Teacher
 * @version 1.0
 * @author Alberto Marun
 */
public class Teacher extends Employee{
    private String subject;
    
    /**
     * Constructor of the teacher, without parameters.
     */
    public Teacher(){
        super();
        
        try{
            setSubject("Programming");
        } catch (Exception e){
            System.out.println(e);
        }
    }
    
    /**
     * Constructor with Parameters of Teacher Class
     * @param name (String) Name of the Teacher.
     * @param surname1 (String) 1st Surname of the Teacher.
     * @param surname2 (String) 2nd Surname of the Teacher.
     * @param age (int) Age of the Teacher.
     * @param salary (int) Salary of the Teacher.
     * @param gender (String) Gender of the Teacher.
     * @param marital_status (String) Marital Status of the Teacher.
     * @param subject (String) Subject of the Teacher.
     */
    public Teacher(String name, String surname1, String surname2, int age, int salary, String gender, String marital_status, String subject){
        super(name, surname1, surname2, age, salary, gender, marital_status);
        
        try{
            setSubject(subject);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    /**
     * This function assign the value fo the Subject of the Teacher.
     * @param subject The subject that Teacher is teaching.
     * @throws java.lang.Exception if the Subject doesn't match with any option, have an error.
     */
    public void setSubject(String subject) throws Exception{
        if(subject.equals("Programming") || subject.equals("Marked Languages") || subject.equals("Computer Systems") || subject.equals("FOL") || subject.equals("Development Enviroment") || subject.equals("Data Bases")){
            this.subject = subject;
        } else{
            throw new Exception("Asginatura no disponible (Tiene que ser en Ingles y estar dentro de la lista.)");
        }
    }
    
    /**
     * This function give the access to the subject of the Teacher.
     * @return the value of the subject that the Teacher is teaching.
     */
    public String getSubject(){
        return this.subject;
    }
    
    /**
     * Function to translate the Elements (Gender, Marital Status and Subject)from English to Spanish.
     * @param object (String) Element to translate from English to Spanish.
     * @return (String) Element translated to Spanish.
     */
    private String spanishTranslation(String object){
        String translation = "";
        
        switch(object){
            case "Male":
                translation = "Masculino";
                break;

            case "Female":
                translation = "Femenino";
                break;

            case "Non-Binary":
                translation = "No-Binario";
                break;
                
                case "Married":
                translation = "Casado";
                break;

            case "Widowed":
                translation = "Viudo";
                break;

            case "Single":
                translation = "Soltero";
                break;

            case "Divorced":
                translation = "Divorciado";
                break;

            case "Programming":
                translation = "Programación";
                break;

            case "Marked Languages":
                translation = "Lenguaje de Marcas";
                break;

            case "Computer Systems":
                translation = "Sistemas Informáticos";
                break;

            case "FOL":
                translation = "Formación y Orientación Laboral";
                break;

            case "Development Enviroment":
                translation = "Entornos de Desarrollo";
                break;

            case "Data Bases":
                translation = "Base de Datos";
                break;
        }
        
        return translation;
    }
    
    /**
     * Return a Message with all the information about the Employee.
     * @return the whole information about Employee with type String.
     */
    @Override
    public String toString(){
        String message;

        message =   "\nNombre Completo: " + super.getSurname1() + " " + super.getSurname2() + ", " + super.getName() +
                    "\nEdad: " + super.getAge() +
                    "\nSueldo: " + super.getSalary() +
                    "€\nGénero: " + spanishTranslation(getGender()) +
                    "\nEstado Civil: " + spanishTranslation(getMaritalStatus()) +
                    "\nMateria: " + spanishTranslation(getSubject());

        return message;
    }
}

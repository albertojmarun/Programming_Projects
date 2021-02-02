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
        setSubject("Programming");
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
        setSubject(subject);
    }

    /**
     * This function assign the value fo the Subject of the Teacher.
     * @param subject The subject that Teacher is teaching.
     */
    public void setSubject(String subject){
        if(subject.equals("Programming") || subject.equals("Marked Languages") || subject.equals("Computer Systems") || subject.equals("FOL") || subject.equals("Development Enviroment") || subject.equals("Data Bases")){
            this.subject = subject;
        }
    }

    /**
     * Return a Message with all the information about the Employee.
     * @return the whole information about Employee with type String.
     */
    @Override
    public String toString(){
        String es_gender = "";
        String es_marital_status = "";
        String es_subject = "";
        String message;

        switch(getGender()){
            case "Male":
                es_gender = "Masculino";
                break;

            case "Female":
                es_gender = "Femenino";
                break;

            case "Non-Binary":
                es_gender = "No-Binario";
                break;
        }

        switch(getMaritalStatus()) {
            case "Married":
                es_marital_status = "Casado";
                break;

            case "Widowed":
                es_marital_status = "Viudo";
                break;

            case "Single":
                es_marital_status = "Soltero";
                break;

            case "Divorced":
                es_marital_status = "Divorciado";
                break;
        }

        switch(getSubject()){
            case "Programming":
                es_subject = "Programación";
                break;

            case "Marked Languages":
                es_subject = "Lenguaje de Marcas";
                break;

            case "Computer Systems":
                es_subject = "Sistemas Informáticos";
                break;

            case "FOL":
                es_subject = "Formación y Orientación Laboral";
                break;

            case "Development Enviroment":
                es_subject = "Entornos de Desarrollo";
                break;

            case "Data Bases":
                es_subject = "Base de Datos";
                break;

        }

        message =   "\nNombre Completo: " + super.getSurname1() + " " + super.getSurname2() + ", " + super.getName() + "\n" +
                    "Edad: " + super.getAge() + "\n" +
                    "Sueldo: " + super.getSalary() + "€\n" +
                    "Género: " + es_gender + "\n" +
                    "Estado Civil: " + es_marital_status + "\n" +
                    "Materia: " + es_subject;

        return message;
    }

    /**
     * This function give the access to the subject of the Teacher.
     * @return the value of the subject that the Teacher is teaching.
     */
    public String getSubject(){
        return this.subject;
    }

}

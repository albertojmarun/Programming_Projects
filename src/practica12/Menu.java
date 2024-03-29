/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is about the Menu of Human Resources of MEDAC
 * @date February 9, 2021
 * @version 1.0
 * @author Alberto Marun
 */
public class Menu {
    final private ArrayList<Teacher> employees;
    private int selected_teacher_index;
    Scanner scanner;

    /**
     * This is the Constructor of the Class Menu.
     * Initialize the list employees and add the First Teacher,
     * Initialize the Scanner and a Scanner for Strings.
     */
    public Menu(){
        selected_teacher_index = 0;
        employees = new ArrayList<>();
        employees.add(selected_teacher_index, new Teacher());
        scanner = new Scanner(System.in);
    }
    
    /**
     * Select the actual Teacher.
     * @return (Teacher) The teacher selected
     */
    private Teacher getSelectedEmployee(){
        return employees.get(selected_teacher_index);
    }
    
    /**
     * This will be the execution of the whole Menu.
     */
    public void execute(){
        int option = 0;
        
        do {
            try{
            option = selectOption();
            System.out.println("\n===========================");

                switch (option){
                    case 0: // [0] SHOW INFORMATION OF EMPLOYEE.
                        showInformationOfTeacher();
                        pause();
                        break;

                    case 1: // [1] MODIFY THE WHOLE NAME OF THE EMPLOYEE.
                        modifyWholeName();
                        pause();
                        break;

                    case 2: // [2] MODIFY THE AGE OF THE EMPLOYEE.
                        modifyAge();
                        pause();
                        break;

                    case 3: // [3] INCREASE THE SALARY OF THE EMPLOYEE.
                        increaseSalary();
                        pause();
                        break;

                    case 4: // [4] DECREASE THE SALARY OF THE EMPLOYEE.
                        decreaseSalary();
                        pause();
                        break;

                    case 5: // [5] MODIFY THE GENDER OF THE EMPLOYEE.
                        modifyGender();
                        pause();
                        break;

                    case 6: // [6] MODIFY THE CIVIL STATUS OF THE EMPLOYEE.
                        modifyCivilStatus();
                        pause();
                        break;

                    case 7: // [7] MODIFY THE SUBJECT OF THE TEACHER.
                        modifySubject();
                        pause();
                        break;

                    case 8: // [8] CREATE A NEW TEACHER.
                        newTeacher();
                        pause();
                        break;

                    case 9: // [9] SELECT ANOTHER EMPLOYEE.
                        selectTeacher();
                        pause();
                        break;

                    case 10: // [10] DELETE SELECTED EMPLOYEE.
                        deleteTeacher();
                        pause();
                        break;
                    
                    case 11: // [11] FINISH THE MENU.
                        goodBye();
                        break;   
                }
            } catch(Exception e){
                System.out.println(e.getMessage());
                pause();
            }
        } while(option != 11);
    }

    /**
     * This function will print the Menu of the class Menu.
     */
    public void printMenu(){
        System.out.println("===========================\n");
        System.out.println("Gestión de RRHH MEDAC");
        System.out.printf("Empleado Seleccionado: %s\n\n", getSelectedEmployee().getFullName());
        System.out.println("===========================\n");

        System.out.println("[0] Mostrar la información de la persona contratada.");
        System.out.println("[1] Modificar el nombre completo.");
        System.out.println("[2] Modificar la edad");
        System.out.println("[3] Aumentar el sueldo.");
        System.out.println("[4] Bajar el sueldo.");
        System.out.println("[5] Modificar el género.");
        System.out.println("[6] Modificar el estado civil.");
        System.out.println("[7] Modificar la materia que imparte el Profesor.");
        System.out.println("[8] Crear un Nuevo Empleado.");
        System.out.println("[9] Seleccionar a otro Empleado.");
        System.out.println("[10] Eliminar al Empleado Seleccionado.");
        System.out.println("[11] Salir.");

        System.out.print("\nSelecciona una opción: ");
    }

    /**
     * This function will select the option to execute.
     * @return (int) that is the option selected from the Menu.
     * @throws java.lang.Exception if the option entered is greater than 11 or lower than 0.
     */
    private int selectOption() throws Exception{
        int option;
        
        printMenu();
        option = UserInput.getInt();
        
        if(option < 0 || option > 11){
            throw new Exception("\n\tDebe seleccionar una opcion entre 0 y 11");
        }
        
        return option;
    }

    /**
     * This function will show the Information of the Teacher (Option 0).
     */
    private void showInformationOfTeacher(){
        
        System.out.println(getSelectedEmployee().toString());
    }

    /**
     * This function will Modify the whole name of the Teacher (Option 1).
     */
    private void modifyWholeName(){
        String new_value;
        boolean condition = false;
        
        do{
            System.out.print("\nIntroduce el nuevo nombre del Empleado: ");
            new_value = UserInput.getString();
            
            try {
                getSelectedEmployee().setName(new_value);
                condition = true;
                
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            
        } while(!condition);

        condition = false;
        
        do{
            System.out.print("\nIntroduce el nuevo Primer Apellido del Empleado: ");
            new_value = UserInput.getString();

            try {
                getSelectedEmployee().setSurname1(new_value);
                condition = true;
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            
        } while(!condition);

        condition = false;
        
        do{
            System.out.print("\nIntroduce el nuevo Segundo Apellido del Empleado: ");
            new_value = UserInput.getString();

            try {
                getSelectedEmployee().setSurname2(new_value);
                condition = true;
                
            } catch (Exception e){
                System.out.println(e.getMessage());
            }
            
        } while(!condition);

        System.out.printf("\n\tEl Nuevo nombre del Empleado: %s.\n", getSelectedEmployee().getFullName());
    }

    /**
     * This function will Modify the age of the Teacher (Option 2).
     */
    private void modifyAge(){
        int age;
        boolean condition = false;
        
        do{
            try{
                System.out.print("\nIntroduce la nueva edad del Empleado: ");
                age = UserInput.getInt();
                
                getSelectedEmployee().setAge(age);
                condition = true;
                
            } catch (Exception e){
                System.out.println(e.getMessage());
            } 

        } while(!condition);
        
        System.out.printf("\n\tLa nueva edad de %s, es %d.\n", getSelectedEmployee().getFullName(), getSelectedEmployee().getAge());
    }

    /**
     * This function will increase the Salary of the Teacher (Option 3).
     */
    private void increaseSalary(){
        double increase;
        boolean condition = false;
        
        do{
            try{
                System.out.print("\nIntroduce el % de aumento de salario: ");
                increase = UserInput.getDouble();
                
                getSelectedEmployee().increaseSalary(increase);
                condition = true;
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(!condition);

        System.out.printf("\n\tEl nuevo salario de %s es %d luego de aplicar el aumento.\n", getSelectedEmployee().getFullName(), getSelectedEmployee().getSalary());

    }

    /**
     * This function will decrease the Salary of the Teacher (Option 4).
     * @param teacher All the information of the Teacher.
     */
    private void decreaseSalary() {
        double decrease;
        boolean condition = false;
        
        do{
            try{
                System.out.print("\nIntroduce el % de baja en el salario: ");
                decrease = UserInput.getDouble();
                
                getSelectedEmployee().reduceSalary(decrease);
                condition = true;
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        } while(!condition);

        System.out.printf("\n\tEl nuevo salario de %s es %d luego de aplicarle la baja salarial.\n", getSelectedEmployee().getFullName(), getSelectedEmployee().getSalary());
    }
    
    /**
     * Add the New Salary to the new Teacher. 
     * @param teacher (Teacher) That will have a new salary.
     */
    private void modifySalary(){
        int salary;
        boolean condition = false;
        
        do{
            try{
                System.out.print("\nIntroduce el Nuevo Salario del Empleado: ");
                salary = UserInput.getInt();
                
                getSelectedEmployee().setSalary(salary);
                condition = true;
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        } while(!condition);

        System.out.printf("\n\tEl nuevo salario de %s es %d€.\n", getSelectedEmployee().getFullName(), getSelectedEmployee().getSalary());
    }
    
    /**
     * This is the Menu of the modifyGender function.
     */
    private void genderMenu(){
        System.out.println();
        System.out.println("[H] Hombre.");
        System.out.println("[M] Mujer.");
        System.out.println("[B] No Binario.");
        System.out.print("Elige un género: ");
    }

    /**
     * This functions selects the String that correspond to an option by number for the gender.
     * @param option (int) Gender selected by number.
     * @return (String) Gender selected in String format.
     */
    private String selectGender(char option){
        String selected_option = "";
        
        switch (option){
            case 'H':
                selected_option = "Male";
                break;

            case 'M':
                selected_option = "Female";
                break;

            case 'B':
                selected_option = "Non-Binary";
                break;
        }
        
        return selected_option;
    }
    
    /**
     * This function will modify the Gender of the Teacher (Option 5).
     */
    private void modifyGender(){
        char gender_option;
        boolean condition = false;
        
        do{
            try{
                genderMenu();
                gender_option = UserInput.getChar();
            
                getSelectedEmployee().setGender(selectGender(gender_option));
                condition = true;
                
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
            
        }while(!condition);
        
        System.out.printf("\n\tEl nuevo género del Empleado %s es %s.\n", getSelectedEmployee().getFullName(), spanishTranslation(getSelectedEmployee().getGender()));
    }

    /**
     * This is the Menu of the modifyCivilStatus function.
     */
    private void civilStatusMenu(){
        System.out.println();
        System.out.println("[C] Casado.");
        System.out.println("[V] Viudo.");
        System.out.println("[D] Divorciado.");
        System.out.println("[S] Soltero.");
        System.out.print("Elige un Estado Civil: ");
    }
    
    /**
     * This function pass from a int to a String gived by a list of option.
     * @param option (int) Marital Status selected.
     * @return (String) With the Marital Status selected in String format.
     */
    private String selectMaritalStatus(char option){
        String selected_option = "";
        
        switch (option){
            case 'C':
                selected_option = "Married";
                break;

            case 'V':
                selected_option = "Widowed";
                break;

            case 'D':
                selected_option = "Divorced";
                break;

            case 'S':
                selected_option = "Single";
                break;
        }
        
        return selected_option;
    }
    
    /**
     * This function will modify the Civil Status of the Teacher (Option 6).
     */
    private void modifyCivilStatus(){
        char civil_status_option;
        boolean condition = false;

        do{
            try{
               civilStatusMenu();
               civil_status_option = UserInput.getChar();

               getSelectedEmployee().setMaritalStatus(selectMaritalStatus(civil_status_option));
               condition = true;
               
            } catch(Exception e){
               System.out.println(e.getMessage());   
            }   
        } while(!condition);
        
        System.out.printf("\n\tEl nuevo Estado Civil del Empleado %s es %s.\n", getSelectedEmployee().getFullName(), spanishTranslation(getSelectedEmployee().getMaritalStatus()));
    }
    
    /**
     * This is the Menu of the modifySubject function.
     */
    private void subjectMenu(){
        System.out.println();
        System.out.println("[0] Programación");
        System.out.println("[1] Entornos de Desarrollo");
        System.out.println("[2] Sistemas Informaticos");
        System.out.println("[3] Base de Datos");
        System.out.println("[4] Lenguaje de Marcas");
        System.out.println("[5] Formación y Orientación Laboral");
        System.out.print("Elige la Materia a Impartir: ");
    }
    
    /**
     * This function pass from a int to a String gived by a list of option.
     * @param option (int) Subject selected.
     * @return (String) With the Subject selected in String format.
     */
    private String selectSubject(int option){
        String selected_subject = "";
        
            switch(option){
                case 0:
                    selected_subject = "Programming";
                break;

                case 1:
                    selected_subject = "Development Enviroment";
                break;

                case 2:
                    selected_subject = "Computer Systems";
                break;

                case 3:
                    selected_subject = "Data Bases";
                break;

                case 4:
                    selected_subject = "Marked Languages";
                break;

                case 5:
                    selected_subject = "FOL";
                break;
            }
            
        return selected_subject;
    }
    /**
     * This function will modify the Subject of the Teacher (Option 7).
     */
    private void modifySubject(){
        int subject_option;
        boolean condition = false;
        
        do{
            try{
                subjectMenu();
                subject_option = UserInput.getInt();
                
                getSelectedEmployee().setSubject(selectSubject(subject_option));
                condition = true;
            } catch(Exception e){
                System.out.println(e.getMessage());
            }
        } while(!condition);

        System.out.printf("\n\tLa nueva materia del maestro %s es %s.\n", getSelectedEmployee().getFullName(), spanishTranslation(getSelectedEmployee().getSubject()));
    }
    
    /**
     * Add a New Teacher to the List of Employees.
     */
    private void newTeacher(){
        selected_teacher_index = employees.size();
        
        employees.add(selected_teacher_index, new Teacher());
        modifyWholeName();
        modifyAge();
        modifySalary();
        modifyGender();
        modifyCivilStatus();
        modifySubject();
    }
    
    /**
     * Menu for the Teachers that exist.
     */
    private void menuTeachers(){
        System.out.println();
        for(int i = 0; i < employees.size(); i++){
            System.out.printf("[%d] %s\n", i, employees.get(i).getFullName());
        }
        
        System.out.print("Seleccione a un Profesor: ");
    }
    
    /**
     * Select the Teacher to see his information.
     * @throws java.lang.Exception If the new selected_employee_index is negative or greater or equal to the size of the ArrayList.
     */
    private void selectTeacher() throws Exception{
        
        if(employees.size() == 1){
            System.out.println("\nTiene seleccionado el unico empleado, debe tener +1 Empleado para poder seleccionar otro.");
        } else{
            menuTeachers();
            selected_teacher_index = UserInput.getInt();
                
            if(selected_teacher_index >= 0 && selected_teacher_index < employees.size()){
                System.out.printf("\n\tEl empleado seleccionado es: %s\n", getSelectedEmployee().getFullName());
                
            } else{
                throw new Exception("Debe seleccionar un empleado dentro del indice.");
            }
        }
        
    }
    
    /**
     * Menu to delete a Teacher or not.
     */
    private void deleteTeacherMenu(){
        System.out.printf("\n[0] No deseo borrar al Profesor %s.\n", getSelectedEmployee().getFullName());
        System.out.printf("[1] Sí deseo borrar al Profesor %s.\n", getSelectedEmployee().getFullName());
        System.out.print("¿Estas Seguro? ");
    }
    
    /**
     * Option to Delete a the actual Teacher.
     * @throws java.lang.Exception if the decision is not between 1 and 0 (inclusive) make an advice.
     */
    private void deleteTeacher() throws Exception{
        boolean decision;
        
        if(employees.size() > 1){
            deleteTeacherMenu();
            decision = UserInput.getBoolean();
                
            if(decision){
                System.out.printf("\n\tEl profesor %s ha sido Eliminado.\n", getSelectedEmployee().getFullName());
                employees.remove(getSelectedEmployee());
                selected_teacher_index--;
                    
                if(selected_teacher_index < 0){
                    selected_teacher_index = 0;
                }
                
            } else if (!decision){
                System.out.printf("\n\tEl profesor %s no ha sido Eliminado.\n", getSelectedEmployee().getFullName());
            } else{
                throw new Exception("Debe seleccionar una opcion entre Eliminar(true) o No Eliminar (false) al empleado");
            }
            
        } else {
            System.out.println("\nNo puede dejar a MEDAC sin Profesores.");
        }
    }
    
    /**
     * Function to say Good Bye to the User.
     */
    private void goodBye(){
        System.out.println("\n¡Hasta Luego! Muchas Gracias.\n");
        System.out.println("===========================\n");
    }
    
    /**
     * This function will make a pause in every function executed.
     */
    private void pause(){
        scanner.nextLine();
    }
    
    /**
     * Function to translate the Elements (Gender, Marital Status and Subject) from English to Spanish.
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
}
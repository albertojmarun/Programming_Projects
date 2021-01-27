/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * This class is about the Menu of Human Resources of MEDAC
 * @version 1.0
 * @author Alberto Marun
 */
public class Menu {
    // CONSTANTS FOR THE VALUES.
    final static private int min_age = 18;
    final static private int max_age = 67;
    
    private ArrayList<Teacher> employees;
    private int selected_teacher_index = 0;
    private final Scanner scanner;
    private final Scanner scanner_string;

    /**
     * This is the Constructor of the Class Menu.
     * Initialize the list employees and add the First Teacher,
     * Initialize the Scanner and a Scanner for Strings.
     */
    public Menu(){
        employees = new ArrayList<>();
        employees.add(0, new Teacher());
        scanner = new Scanner(System.in);
        scanner_string = new Scanner(System.in);
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
        int option;

        do {
            option = selectOption();
            System.out.println("\n===========================");

            switch (option){
                case 0: // [0] SHOW INFORMATION OF EMPLOYEE.
                    showInformationOfTeacher(getSelectedEmployee());
                    pause();
                    break;

                case 1: // [1] MODIFY THE WHOLE NAME OF THE EMPLOYEE.
                    modifyWholeName(getSelectedEmployee());
                    pause();
                    break;

                case 2: // [2] MODIFY THE AGE OF THE EMPLOYEE.
                    modifyAge(getSelectedEmployee());
                    pause();
                    break;

                case 3: // [3] INCREASE THE SALARY OF THE EMPLOYEE.
                    increaseSalary(getSelectedEmployee());
                    pause();
                    break;

                case 4: // [4] DECREASE THE SALARY OF THE EMPLOYEE.
                    decreaseSalary(getSelectedEmployee());
                    pause();
                    break;

                case 5: // [5] MODIFY THE GENDER OF THE EMPLOYEE.
                    modifyGender(getSelectedEmployee());
                    pause();
                    break;

                case 6: // [6] MODIFY THE CIVIL STATUS OF THE EMPLOYEE.
                    modifyCivilStatus(getSelectedEmployee());
                    pause();
                    break;

                case 7: // [7] MODIFY THE SUBJECT OF THE TEACHER.
                    modifySubject(getSelectedEmployee());
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
                    System.out.println("\n¡Hasta Luego! Muchas Gracias.\n");
                    System.out.println("===========================\n");
                    break;

                default: // OTHER OPTIONS THAT ARE NOT REGISTERED.
                    System.out.println("Selecciona una opción correcta.");
                    System.out.println("Entre 0 y 7, inclusive.");
                    pause();
                    break;
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

        System.out.print("\tSelecciona una opción: ");
    }

    /**
     * This function will select the option to execute.
     * @return (int) that is the option selected from the Menu.
     */
    private int selectOption(){
        int option;

        printMenu();
        option = scanner.nextInt();

        return option;
    }

    /**
     * This function will show the Information of the Teacher (Option 0).
     * @param teacher All the information of the Teacher.
     */
    private void showInformationOfTeacher(Teacher teacher){
        String information;

        information = teacher.toString();

        System.out.println(information);
    }

    /**
     * This function will Modify the whole name of the Teacher (Option 1).
     * @param teacher All the information of the Teacher.
     */
    private void modifyWholeName(Teacher teacher){
        String name, surname_1, surname_2;

        do{
            System.out.print("\nIntroduce el nuevo nombre del Empleado: ");
            name = scanner_string.nextLine();

            if(name.length() == 0 || name.length() > 50){
                System.out.println("\n\tError en el nuevo nombre, debe tener entre 1 y 49 carácteres (inclusive).\n");
            }
        } while(name.length() == 0 || name.length() > 50);
        teacher.setName(name);

        do{
            System.out.print("\nIntroduce el nuevo Primer Apellido del Empleado: ");
            surname_1 = scanner_string.nextLine();

            if(surname_1.length() == 0 || surname_1.length() > 50){
                System.out.println("\n\tError en el nuevo Primer Apellido, debe tener entre 1 y 49 carácteres (inclusive).\n");
            }
        } while(surname_1.length() == 0 || surname_1.length() > 50);
        teacher.setSurname1(surname_1);

        do{
            System.out.print("\nIntroduce el nuevo Segundo Apellido del Empleado: ");
            surname_2 = scanner_string.nextLine();

            if(surname_2.length() == 0 || surname_2.length() > 50){
                System.out.println("\n\tError en el nuevo Segundo Apellido, debe tener entre 1 y 49 carácteres (inclusive).\n");
            }
        } while(surname_2.length() == 0 || surname_2.length() > 50);
        teacher.setSurname2(surname_2);

        System.out.printf("\n\tNuevo nombre del Empleado: %s.\n", teacher.getFullName());
    }

    /**
     * This function will Modify the age of the Teacher (Option 2).
     * @param teacher All the information of the Teacher.
     */
    private void modifyAge(Teacher teacher){
        int age;
        
        do{
            System.out.print("\nIntroduce la nueva edad del Empleado: ");
            age = scanner.nextInt();

            if(age < min_age || age > max_age){
                System.out.printf("\n\tLa edad introducida (%d) no es aceptada, debe tener entre 18 y 67 (inclusive).\n\n", age);
            }
        } while(age < min_age || age > max_age);

        teacher.setAge(age);
        System.out.printf("\n\tLa nueva edad de %s, es %d.\n", teacher.getFullName(), teacher.getAge());
    }

    /**
     * This function will increase the Salary of the Teacher (Option 3).
     * @param teacher All the information of the Teacher.
     */
    private void increaseSalary(Teacher teacher){
        double increase;

        do{
            System.out.print("\nIntroduce el % de aumento de salario: ");
            increase = scanner.nextDouble();

            if(increase <= 0){
                System.out.println("\n\tError en el Porcentaje Introducido, debe ser mayor a 0 (Ejemplo 0.1)");
            }
        } while(increase <= 0);
        teacher.increaseSalary(increase);

        System.out.printf("\n\tEl nuevo salario de %s es %d luego de aplicar el aumento.\n", teacher.getFullName(), teacher.getSalary());

    }

    /**
     * This function will decrease the Salary of the Teacher (Option 4).
     * @param teacher All the information of the Teacher.
     */
    private void decreaseSalary(Teacher teacher) {
        double decrease;

        do{
            System.out.print("\nIntroduce el % de baja en el salario: ");
            decrease = scanner.nextDouble();

            if (decrease <= 0 || decrease >= 1){
                System.out.println("\n\tError en el Porcentaje Introducido, debe ser mayor a 0 y menor a 1 (Ejemplo 0.1)");
            }
        } while(decrease <= 0 || decrease >= 1);
        teacher.reduceSalary(decrease);

        System.out.printf("\n\tEl nuevo salario de %s es %d luego de aplicarle la baja salarial.\n", teacher.getFullName(), teacher.getSalary());
    }
    
    /**
     * Add the New Salary to the new Teacher. 
     * @param teacher (Teacher) That will have a new salary.
     */
    private void modifySalary(Teacher teacher){
        int salary;
        do{
            System.out.print("\nIntroduce el Nuevo Salario del Empleado: ");
            salary = scanner.nextInt();
            
            if(salary < 950){
                System.out.println("\n\tEl Salario mínimo de España es 950€, porfavor Introduce un Salario acorde.");
            }
        } while(salary < 950);
        
        teacher.setSalary(salary);
        System.out.printf("\n\tEl nuevo salario de %s es %d€.\n", teacher.getFullName(), teacher.getSalary());
    }
    
    /**
     * This is the Menu of the modifyGender function.
     */
    private void genderMenu(){
        System.out.println();
        System.out.println("[0] Hombre.");
        System.out.println("[1] Mujer.");
        System.out.println("[2] No Binario.");
        System.out.print("Elige un género: ");
    }

    /**
     * This function will modify the Gender of the Teacher (Option 5).
     * @param teacher All the information of the Teacher.
     */
    private void modifyGender(Teacher teacher){
        int gender_option;

        do{
            genderMenu();
            gender_option = scanner.nextInt();

            if(gender_option < 0 || gender_option > 2){
                System.out.println("\n\tSeleccionaste una opción incorrecta.\n");
            }
        }while(gender_option < 0 || gender_option > 2);

        switch (gender_option){
            case 0:
                teacher.setGender("Male");
                break;

            case 1:
                teacher.setGender("Female");
                break;

            case 2:
                teacher.setGender("Non-Binary");
                break;
        }

        System.out.printf("\n\tEl nuevo género del Empleado %s es %s.\n", teacher.getFullName(), teacher.getGender());
    }

    /**
     * This is the Menu of the modifyCivilStatus function.
     */
    private void civilStatusMenu(){
        System.out.println();
        System.out.println("[0] Casado.");
        System.out.println("[1] Viudo.");
        System.out.println("[2] Divorciado.");
        System.out.println("[3] Soltero.");
        System.out.print("Elige un Estado Civil: ");
    }

    /**
     * This function will modify the Civil Status of the Teacher (Option 6).
     * @param teacher All the information of the Teacher.
     */
    private void modifyCivilStatus(Teacher teacher){
        int civil_status_option;
        
        do{
            civilStatusMenu();
            civil_status_option = scanner.nextInt();

            if(civil_status_option < 0 || civil_status_option > 3){
                System.out.println("\n\tSeleccionaste una opción incorrecta.\n");
            }
        } while(civil_status_option < 0 || civil_status_option > 3);

        switch (civil_status_option){
            case 0:
                teacher.setMaritalStatus("Married");
                break;

            case 1:
                teacher.setMaritalStatus("Widowed");
                break;

            case 2:
                teacher.setMaritalStatus("Divorced");
                break;

            case 3:
                teacher.setMaritalStatus("Single");
                break;
        }

        if(civil_status_option >= 0 && civil_status_option <= 3){
            System.out.printf("\n\tEl nuevo Estado Civil del Empleado %s es %s.\n", teacher.getFullName(), teacher.getMaritalStatus());
        }
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
     * This function will modify the Subject of the Teacher (Option 7).
     * @param teacher All the information of the Teacher.
     */
    private void modifySubject(Teacher teacher){
        int subject_option;
        
        do{
            subjectMenu();
            subject_option = scanner.nextInt();

            if(subject_option < 0 || subject_option > 5){
                System.out.println("\n\tSeleccionaste una opción incorrecta.\n");
            }
        } while(subject_option < 0 || subject_option > 5);

        switch(subject_option){
            case 0:
                teacher.setSubject("Programming");
                break;

            case 1:
                teacher.setSubject("Development Enviroment");
                break;

            case 2:
                teacher.setSubject("Computer Systems");
                break;

            case 3:
                teacher.setSubject("Data Bases");
                break;

            case 4:
                teacher.setSubject("Marked Languages");
                break;

            case 5:
                teacher.setSubject("FOL");
                break;
        }

        System.out.printf("\n\tLa nueva materia del maestro %s es %s.\n", teacher.getFullName(), teacher.getSubject());
    }
    
    /**
     * Add a New Teacher to the List of Employees.
     */
    private void newTeacher(){
        selected_teacher_index = employees.size();
        
        employees.add(selected_teacher_index, new Teacher());
        modifyWholeName(getSelectedEmployee());
        modifyAge(getSelectedEmployee());
        modifySalary(getSelectedEmployee());
        modifyGender(getSelectedEmployee());
        modifyCivilStatus(getSelectedEmployee());
        modifySubject(getSelectedEmployee());
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
     */
    private void selectTeacher(){
        if(employees.size() == 1){
            System.out.println("\nTiene seleccionado el unico empleado, debe tener +1 Empleado para poder seleccionar otro.");
            
        } else{
            do{
                menuTeachers();
                selected_teacher_index = scanner.nextInt();
            
                if(selected_teacher_index < 0 || selected_teacher_index >= employees.size()){
                    System.out.printf("\tPorfavor seleccione un valor entre 0 y %d\n", employees.size() - 1);
                } else{
                    System.out.printf("\n\tEl empleado seleccionado es: %s\n", getSelectedEmployee().getFullName());
                }
            } while(selected_teacher_index < 0 || selected_teacher_index >= employees.size());
        }
    }
    
    /**
     * Menu to delete a Teacher or not.
     */
    private void deleteMenu(){
        System.out.printf("\n[0] No deseo borrar al Profesor %s.\n", getSelectedEmployee().getFullName());
        System.out.printf("[1] Sí deseo borrar al Profesor %s.\n", getSelectedEmployee().getFullName());
        System.out.print("¿Estas Seguro? ");
    }
    
    /**
     * Option to Delete a the actual Teacher.
     */
    private void deleteTeacher(){
        int decision;
        
        if(employees.size() > 1){
            do{
                deleteMenu();
                decision = scanner.nextInt();

                if(decision == 1){
                    System.out.printf("\n\tEl profesor %s ha sido Eliminado.\n", getSelectedEmployee().getFullName());
                    employees.remove(getSelectedEmployee());
                    selected_teacher_index--;
                } else if(decision == 0){
                    System.out.printf("\n\tEl profesor %s no ha sido Eliminado.\n", getSelectedEmployee().getFullName());
                } else{
                    System.out.println("\n\t Porfavor seleccione una opcion entre 0 y 1");
                }
            } while(decision != 1 && decision != 0);   
        } else {
            System.out.println("\nNo puede dejar a MEDAC sin Profesores.");
        }
    }
    
    /**
     * This function will make a pause in every function executed.
     */
    private void pause(){
        scanner_string.nextLine();
    }
    
    public static void main(String[] args){
        Menu menu = new Menu();
        
        menu.execute();
                
                
    }
}

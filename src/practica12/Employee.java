/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica12;

/**
 *  This class is about the information of an Employee
 * @version 1.0
 * @author Alberto Marun
 */
public class Employee extends Person{
    // CONSTANTS FOR THE VALUES.
    final private int min_salary = 950;

    // ATTRIBUTES OF THE CLASS
    private int salary;
    
    /**
     * Constructor of the Class Employee without Parameters.
     */
    public Employee(){
        super();
        setSalary(1500);
    }
    
    /**
     * This is the constructor of the Class Employee.
     * @param name The Name of the Employee.
     * @param surname1 The 1st Surname of the Employee.
     * @param surname2 The 2nd Surname of the Employee.
     * @param age The Age of the Employee.
     * @param salary The Salary that the Employee is earning.
     * @param gender The Gender of the Employee.
     * @param marital_status The Marital Status of the Employee
     */
    public Employee(String name, String surname1, String surname2, int age, int salary, String gender, String marital_status){
        super(name, surname1, surname2, age, gender, marital_status);
        setSalary(salary);
    }

    // GETTERS:
    /**
     * Return the salary of the Employee.
     * @return The value of the (int) salary.
     */
    public int getSalary(){
        return salary;
    }

    // SETTERS
    /**
     * Establishes the salary of the Employee (It needs to be equal or greater than Minimum Salary)
     * @param input_salary The Salary of the Employee entered by the user.
     */
    public void setSalary(int input_salary){
        if(input_salary >= min_salary){
            this.salary = input_salary;
        }
    }

    /**
     * Increase the Salary of the employee by a % entered by the user.
     * @param increase The % of increase to apply to the salary.
     */
    public void increaseSalary(double increase){
        int final_salary;

        final_salary = getSalary();

        if(increase > 0){
            final_salary = (int) (getSalary() + (getSalary() * increase));
        }

        setSalary(final_salary);
    }

    /**
     * Reduce the Salary of the Employee, by a decreasing % entered by the user.
     * @param decrease The % of the decrease to apply to the salary, entered by the user.
     */
    public void reduceSalary(double decrease){
        int final_salary;

        final_salary = getSalary();
        if ( decrease > 0 && decrease < 1) {
            final_salary = (int) (getSalary() - (getSalary() * decrease));
        }

        if (final_salary < min_salary){
            final_salary = min_salary;
        }

        setSalary(final_salary);
    }
}

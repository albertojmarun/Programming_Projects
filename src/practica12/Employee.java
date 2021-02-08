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
        
        try{
            setSalary(1500);   
        } catch(Exception e){
            System.out.println(e);
        }
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
        
        try{
            setSalary(salary);   
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Return the salary of the Employee.
     * @return The value of the (int) salary.
     */
    public int getSalary(){
        return salary;
    }
    
    /**
     * Establishes the salary of the Employee (It needs to be equal or greater than Minimum Salary)
     * @param new_value The Salary of the Employee entered by the user.
     * @throws java.lang.Exception
     */
    public void setSalary(int new_value) throws Exception{
        if(new_value >= min_salary){
            this.salary = new_value;
        } else{
            throw new Exception("El salario debe ser mayor o igual salario mínimo: " + min_salary + "€.");
        }
    }

    /**
     * Increase the Salary of the employee by a % entered by the user.
     * @param increase The % of increase to apply to the salary.
     */
    public void increaseSalary(double increase) throws Exception{
        int final_salary;

        final_salary = getSalary();

        if(increase > 0){
            final_salary = (int) (getSalary() + (getSalary() * increase));
        } else{
            throw new Exception("El % de incremento debe ser superior o igual 0");
        }

        try{
            setSalary(final_salary);
        } catch(Exception e){
            System.out.println(e);
        }
    }

    /**
     * Reduce the Salary of the Employee, by a decreasing % entered by the user.
     * @param decrease The % of the decrease to apply to the salary, entered by the user.
     * @throws java.lang.Exception if the decrease % is to low (less than 0) or to high (higher than 1).
     */
    public void reduceSalary(double decrease) throws Exception{
        int final_salary = getSalary();
        
        if ( decrease > 0 && decrease < 1) {
            final_salary = (int) (getSalary() - (getSalary() * decrease));
        } else if(decrease <= 0){
            throw new Exception("El % de descuento debe ser por encima de 0 (Con el siguiente formato 0.80 == 80%.)");
        } else if(decrease > 1){
            throw new Exception("El % de descuento debe ser menor a 1 (Con el siguiente formato 0.80 = 80%.))");
        }

        if (final_salary < min_salary){
            final_salary = min_salary;
        } else{
            throw new Exception("Con el descuento, el salario queda por debajo del salario mínimo.");
        }

        try{
            setSalary(final_salary);
        } catch(Exception e){
            System.out.println(e);
        }
    }
}

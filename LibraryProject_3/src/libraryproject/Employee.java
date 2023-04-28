/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libraryproject;

/**
 *
 * @author salki
 */
public class Employee extends Person {
    private String department;
    private double salary;

    public Employee(String name, String department, double salary) {
        super(name);
        this.department = department;
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    
    @Override
    public String getName() {
        return super.getName() + " (Department: " + department + ", Salary: $" + salary + ")";
    }

}

class LibraryFullException extends Exception {
    public LibraryFullException() {
        super("The library has reached its maximum capacity");
    }
}
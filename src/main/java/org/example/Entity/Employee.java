package org.example.Entity;

public class Employee {
    private Integer id;
    private String name;
    private String position;
    private int salary;

    private Department department;

    public Employee(String name, String position, int salary, Department department) {
        this.name = name;
        this.position = position;
        this.salary = salary;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
    public Employee(){

    }
}

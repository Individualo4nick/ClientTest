package org.example;


import org.example.Config.BeanConfig;
import org.example.Entity.Department;
import org.example.Entity.Employee;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
/*
there shouldn't be any sloppy translations into entities nicely,
but I return dto to work in postman, so I have to do this
*/
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        Communication communication = context.getBean("communication", Communication.class);

        List<Employee> allEmployees = communication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employee = communication.getEmployee("202");
        System.out.println(employee.getName());

        Department department = new Department("Marketing");
        Department response = communication.addDepartment(department);
        System.out.println(response.getName());

        Employee newEmployee = new Employee("Inna", "Department manager", 120000, response);
        Employee responseE = communication.addEmployee(newEmployee);
        System.out.println(responseE.getName());

        newEmployee.setId(responseE.getId());
        newEmployee.setName("Inna A");
        Employee response2 = communication.updateEmployee(newEmployee);
        System.out.println(response2.getName());

        department.setId(response.getId());
        department.setName("New Marketing");
        String response3 = communication.updateDepartment(department);
        System.out.println(response3);

        List<Department> departments = communication.getAllDepartments();
        System.out.println(departments);

        Department department1 = communication.getDepartment(department.getId().toString());
        System.out.println(department1);

        String response5 = communication.deleteEmployee(newEmployee.getId().toString());
        System.out.println(response5);

        String response4 = communication.deleteDepartment(department.getId().toString());
        System.out.println(response4);
    }
}
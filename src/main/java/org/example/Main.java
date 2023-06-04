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
        EmployeeCommunication employeeCommunication = context.getBean("employeeCommunication", EmployeeCommunication.class);
        DepartmentCommunication departmentCommunication = context.getBean("departmentCommunication", DepartmentCommunication.class);

        List<Employee> allEmployees = employeeCommunication.getAllEmployees();
        System.out.println(allEmployees);

        Employee employee = employeeCommunication.getEmployee("202");
        System.out.println(employee.getName());

        Department department = new Department("Marketing");
        Department response = departmentCommunication.addDepartment(department);
        System.out.println(response.getName());

        Employee newEmployee = new Employee("Inna", "Department manager", 120000, response);
        Employee responseE = employeeCommunication.addEmployee(newEmployee);
        System.out.println(responseE.getName());

        newEmployee.setId(responseE.getId());
        newEmployee.setName("Inna A");
        Employee response2 = employeeCommunication.updateEmployee(newEmployee);
        System.out.println(response2.getName());

        department.setId(response.getId());
        department.setName("New Marketing");
        String response3 = departmentCommunication.updateDepartment(department);
        System.out.println(response3);

        List<Department> departments = departmentCommunication.getAllDepartments();
        System.out.println(departments);

        Department department1 = departmentCommunication.getDepartment(department.getId().toString());
        System.out.println(department1);

        String response5 = employeeCommunication.deleteEmployee(newEmployee.getId().toString());
        System.out.println(response5);

        String response4 = departmentCommunication.deleteDepartment(department.getId().toString());
        System.out.println(response4);

        context.close();
    }
}
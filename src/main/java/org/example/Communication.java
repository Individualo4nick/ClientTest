package org.example;

import org.example.Entity.Department;
import org.example.Entity.Employee;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class Communication {
    private WebClient webClient = WebClient.create("http://localhost:8080");
    private final String EMPLOYEES_URI = "/server/employees";
    private final String DEPARTMENTS_URI = "/server/departments";

    public List<Employee> getAllEmployees(){
        return webClient.get()
                .uri(EMPLOYEES_URI)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }

    public Employee getEmployee(String id){
        return webClient.get()
                .uri(EMPLOYEES_URI + "/" + id)
                .retrieve()
                .bodyToMono(Employee.class).block();
    }

    public Employee addEmployee(Employee employee){
        return webClient.post()
                .uri(EMPLOYEES_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class).block();
    }

    public Employee updateEmployee(Employee employee){
        return webClient.put()
                .uri(EMPLOYEES_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(employee), Employee.class)
                .retrieve()
                .bodyToMono(Employee.class).block();
    }

    public String deleteEmployee(String id){
        return webClient.delete()
                .uri(EMPLOYEES_URI + "/" + id)
                .retrieve()
                .bodyToMono(String.class).block();
    }

    public List<Department> getAllDepartments(){
        return webClient.get()
                .uri(DEPARTMENTS_URI)
                .retrieve()
                .bodyToFlux(Department.class)
                .collectList()
                .block();
    }

    public Department getDepartment(String id){
        return webClient.get()
                .uri(DEPARTMENTS_URI + "/" + id)
                .retrieve()
                .bodyToMono(Department.class).block();
    }

    public Department addDepartment(Department department){
        return webClient.post()
                .uri(DEPARTMENTS_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(department), Department.class)
                .retrieve()
                .bodyToMono(Department.class).block();
    }

    public String updateDepartment(Department department){
        return webClient.put()
                .uri(DEPARTMENTS_URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(Mono.just(department), Department.class)
                .retrieve()
                .bodyToMono(String.class).block();
    }

    public String deleteDepartment(String id){
        return webClient.delete()
                .uri(DEPARTMENTS_URI + "/" + id)
                .retrieve()
                .bodyToMono(String.class).block();
    }
}

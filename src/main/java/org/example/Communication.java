package org.example;

import org.example.Entity.Employee;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class Communication {
    private WebClient webClient = WebClient.create("http://localhost:8080");
    private final String EMPLOYEES_URI = "/server/employees";
    private final String DEPARTMENTS_URI = "/server/departments";
    public List<Employee> showAllEmployees(){
        webClient = WebClient.create(EMPLOYEES_URI);
        return webClient.get()
                .uri(EMPLOYEES_URI)
                .retrieve()
                .bodyToFlux(Employee.class)
                .collectList()
                .block();
    }

}

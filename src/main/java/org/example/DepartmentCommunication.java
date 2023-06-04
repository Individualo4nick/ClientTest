package org.example;

import org.example.Entity.Department;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class DepartmentCommunication {
    private WebClient webClient = WebClient.create("http://localhost:8080");
    private final String DEPARTMENTS_URI = "/server/departments";
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

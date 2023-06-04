package org.example.Entity;

import java.util.List;

public class Department {
    private Integer id;
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
    }
    public Department(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}

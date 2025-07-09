package com.employee;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

    public Department() {
    }

    public Department(String name) {
        this.name = name;
    }

    public Long getId() { return id; }
    public String getName() { return name; }
    public List<Employee> getEmployees() { return employees; }

    public void setName(String name) { this.name = name; }
    public void setEmployees(List<Employee> employees) { this.employees = employees; }
}

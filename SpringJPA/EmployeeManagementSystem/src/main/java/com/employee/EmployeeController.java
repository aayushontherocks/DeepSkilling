package com.employee;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeRepository.save(employee);
    }

    // READ ALL
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeRepository.findById(id).orElseThrow();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee updated) {
        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setName(updated.getName());
        employee.setEmail(updated.getEmail());
        employee.setDepartment(updated.getDepartment());
        return employeeRepository.save(employee);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeRepository.deleteById(id);
    }

}

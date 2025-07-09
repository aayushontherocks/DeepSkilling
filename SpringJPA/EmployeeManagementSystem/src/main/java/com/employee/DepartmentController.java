package com.employee;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    // CREATE
    @PostMapping
    public Department createDepartment(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    // READ ALL
    @GetMapping
    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    // READ ONE
    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        return departmentRepository.findById(id).orElseThrow();
    }

    // UPDATE
    @PutMapping("/{id}")
    public Department updateDepartment(@PathVariable Long id, @RequestBody Department updated) {
        Department department = departmentRepository.findById(id).orElseThrow();
        department.setName(updated.getName());
        return departmentRepository.save(department);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void deleteDepartment(@PathVariable Long id) {
        departmentRepository.deleteById(id);
    }

     @Autowired
    private EmployeeRepository employeeRepository;

    // Simple paginated fetch
    @GetMapping("/page")
    public Page<Employee> getAllPaged(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        Pageable pageable = PageRequest.of(page, size);
        return employeeRepository.findAll(pageable);
    }

    // Paginated + Sorted
    @GetMapping("/sorted")
    public Page<Employee> getAllPagedAndSorted(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findAll(pageable);
    }

    // Paginated + Search + Sort
    @GetMapping("/search")
    public Page<Employee> searchByName(
            @RequestParam String keyword,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));
        return employeeRepository.findByNameContaining(keyword, pageable);
    }
}

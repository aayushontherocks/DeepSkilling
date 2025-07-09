package com.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Find employees by name
    List<Employee> findByName(String name);

    // Find by email containing text
    List<Employee> findByEmailContaining(String keyword);

    // Find all employees in a specific department ID
    List<Employee> findByDepartmentId(Long departmentId);

     @Query("SELECT e FROM Employee e WHERE e.email LIKE %:keyword%")
    List<Employee> searchByEmailKeyword(@Param("keyword") String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.name = :deptName")
    List<Employee> findByDepartmentName(@Param("deptName") String name);

    Page<Employee> findAll(Pageable pageable);

    // You can combine with search
    Page<Employee> findByNameContaining(String keyword, Pageable pageable);

     List<EmployeeSummary> findAllBy();
}
